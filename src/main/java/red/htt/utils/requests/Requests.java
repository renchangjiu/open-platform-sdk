package red.htt.utils.requests;

import okhttp3.*;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author su
 */
public class Requests {
    /**
     * 构造client
     */
    private static final OkHttpClient.Builder BUILDER = new OkHttpClient.Builder();
    private static final OkHttpClient CLIENT = BUILDER.retryOnConnectionFailure(true)
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(new RetryAndFollowUpInterceptor(BUILDER.build()))
            .build();

    private Requests() {
    }

    public static Call get(String url) {
        return get(url, null, null);
    }

    public static Call get(String url, Map<String, String> params, Map<String, String> headers) {
        // 构造请求
        Request.Builder builder = new Request.Builder();
        StringBuilder sb = new StringBuilder(url).append("?");
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            url = StringUtils.strip(sb.toString(), "&");
        }

        builder.url(url);
        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builder.header(entry.getKey(), entry.getValue());
            }
        }
        builder.get();
        Request request = builder.build();
        return CLIENT.newCall(request);
    }

    public static Call post(String url) {
        return post(url, null, null);
    }

    public static Call post(String url, Map<String, String> params, Map<String, String> headers) {
        Request.Builder builder = new Request.Builder();
        // 构造请求体
        FormBody.Builder bodyBuilder = new FormBody.Builder();
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                bodyBuilder.add(entry.getKey(), entry.getValue());
            }
        }
        FormBody body = bodyBuilder.build();
        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builder.header(entry.getKey(), entry.getValue());
            }
        }
        Request request = builder.url(url).post(body).build();
        return CLIENT.newCall(request);
    }

    public static Call post4json(String url, String json) {
        return post4json(url, json, null);
    }

    /**
     * 以 json 数据提交请求
     *
     * @param json    not null
     * @param headers nullable
     */
    public static Call post4json(String url, String json, Map<String, String> headers) {
        MediaType mediaType = MediaType.parse(MediaTypes.APPLICATION_JSON);
        // 构造请求体
        RequestBody requestBody = RequestBody.create(json, mediaType);
        Request.Builder builder = new Request.Builder();
        if (headers != null && !headers.isEmpty()) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builder.header(entry.getKey(), entry.getValue());
            }
        }
        Request request = builder.url(url).post(requestBody).build();
        return CLIENT.newCall(request);
    }
}
