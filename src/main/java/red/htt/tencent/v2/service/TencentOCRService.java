package red.htt.tencent.v2.service;

import com.fasterxml.jackson.core.type.TypeReference;
import red.htt.tencent.v1.constant.URLs;
import red.htt.tencent.v1.model.*;
import red.htt.utils.Bins;
import red.htt.utils.Hashs;
import red.htt.utils.requests.Requests;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 腾讯云文字识别大类下的能力
 *
 * @author mio
 * @see "https://cloud.tencent.com/document/api/866/33522"
 */
public class TencentOCRService extends BaseService {

    public TencentOCRService(String secretId, String secretKey) {
        super(secretId, secretKey);
    }


    public void idCardOCR(String image, int cardType) throws Exception {


    }

}
