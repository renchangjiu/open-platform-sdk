package red.htt.tencent.service;

import com.fasterxml.jackson.core.type.TypeReference;
import red.htt.utils.Hashs;
import red.htt.utils.Jsons;
import red.htt.utils.Strings;
import red.htt.utils.requests.Requests;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author mio
 */
public class BaseService {

    private final int appId;

    private final String appKey;

    public BaseService(int appId, String appKey) {
        this.appId = appId;
        this.appKey = appKey;
    }

    protected <T> T request(Map<String, Object> data, String url, TypeReference<T> resTypeRef) throws IOException {
        data.put("app_id", this.appId);
        data.put("time_stamp", System.currentTimeMillis() / 1000);
        data.put("nonce_str", "abc");
        String sign = this.getReqSign(data, this.appKey);
        data.put("sign", sign);
        Map<String, String> params = new HashMap<>(data.size());
        data.forEach((key, val) -> {
            params.put(key, val.toString());
        });
        String resStr = Requests.post(url, params, null).execute().body().string();
        return Jsons.json2Bean(resStr, resTypeRef);
    }

    /**
     * 计算签名
     *
     * @param data   data
     * @param appKey appKey
     * @return sign
     * @see "https://ai.qq.com/doc/auth.shtml"
     */
    private String getReqSign(Map<String, Object> data, String appKey) {
        StringBuilder sb = null;
        try {
            Object[] keys = data.keySet().toArray();
            Arrays.sort(keys);
            sb = new StringBuilder();
            for (Object key : keys) {
                Object val = data.get(key);
                if (val != null && Strings.isNotEmpty(val.toString())) {
                    sb.append(key)
                            .append("=")
                            .append(URLEncoder.encode(val.toString(), StandardCharsets.UTF_8.displayName()))
                            .append("&");
                }
            }
            sb.append("app_key=")
                    .append(URLEncoder.encode(appKey, StandardCharsets.UTF_8.displayName()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return Hashs.md5(sb.toString()).toUpperCase();
    }

}
