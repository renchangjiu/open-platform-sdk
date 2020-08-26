package red.htt.tencent.v2.service;

import red.htt.utils.Bins;
import red.htt.utils.Hashs;
import red.htt.utils.requests.Requests;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.TreeMap;

/**
 * @author mio
 */
public abstract class BaseService {

    private String secretId;

    private String secretKey;

    private final static Charset CHARSET = StandardCharsets.UTF_8;

    private final static String CT_JSON = "application/json; charset=utf-8";

    public BaseService(String secretId, String secretKey) {
        this.secretId = secretId;
        this.secretKey = secretKey;
    }


    protected void request(String action, String version,String region) throws Exception {
        String service = "cvm";
        String host = "cvm.tencentcloudapi.com";
        // String region = "ap-guangzhou";
        // String action = "DescribeInstances";
        // String version = "2017-03-12";
        String algorithm = "TC3-HMAC-SHA256";
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 注意时区，否则容易出错
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String date = sdf.format(new Date(Long.parseLong(timestamp + "000")));

        // ************* 步骤 1：拼接规范请求串 *************
        String httpRequestMethod = "POST";
        String canonicalUri = "/";
        String canonicalQueryString = "";
        String canonicalHeaders = "content-type:application/json; charset=utf-8\n" + "host:" + host + "\n";
        String signedHeaders = "content-type;host";

        String payload = "{\"Limit\": 1, \"Filters\": [{\"Values\": [\"\\u672a\\u547d\\u540d\"], \"Name\": \"instance-name\"}]}";
        String hashedRequestPayload = Hashs.sha256(payload).toLowerCase();
        String canonicalRequest = httpRequestMethod + "\n" + canonicalUri + "\n" + canonicalQueryString + "\n"
                + canonicalHeaders + "\n" + signedHeaders + "\n" + hashedRequestPayload;

        // ************* 步骤 2：拼接待签名字符串 *************
        String credentialScope = date + "/" + service + "/" + "tc3_request";
        String hashedCanonicalRequest = Hashs.sha256(canonicalRequest).toLowerCase();
        String stringToSign = algorithm + "\n" + timestamp + "\n" + credentialScope + "\n" + hashedCanonicalRequest;

        // ************* 步骤 3：计算签名 *************
        byte[] secretDate = Hashs.hmacSha256(date, ("TC3" + this.secretKey).getBytes(CHARSET));
        byte[] secretService = Hashs.hmacSha256(service, secretDate);
        byte[] secretSigning = Hashs.hmacSha256("tc3_request", secretService);
        String signature = Bins.binToHex(Hashs.hmacSha256(stringToSign, secretSigning)).toLowerCase();

        // ************* 步骤 4：拼接 Authorization *************
        String authorization = algorithm + " " + "Credential=" + this.secretId + "/" + credentialScope + ", "
                + "SignedHeaders=" + signedHeaders + ", " + "Signature=" + signature;

        TreeMap<String, String> headers = new TreeMap<>();
        headers.put("Authorization", authorization);
        headers.put("Content-Type", CT_JSON);
        headers.put("Host", host);
        headers.put("X-TC-Action", action);
        headers.put("X-TC-Timestamp", timestamp);
        headers.put("X-TC-Version", version);
        headers.put("X-TC-Region", region);

        String string = Requests.post4json("https://" + host, payload, headers).execute().body().string();
        System.out.println(string);
    }

}
