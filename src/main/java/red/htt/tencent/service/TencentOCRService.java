package red.htt.tencent.service;

import com.fasterxml.jackson.core.type.TypeReference;
import red.htt.tencent.constant.URLs;
import red.htt.tencent.model.DriverLicenseOCRRes;
import red.htt.tencent.model.IdCardOCRRes;
import red.htt.tencent.model.TencentResult;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 腾讯AI开放平台OCR大类下的能力
 *
 * @author mio
 * @see "https://ai.qq.com/product/ocr.shtml#identify"
 */
public class TencentOCRService extends BaseService {

    public TencentOCRService(int appId, String appKey) {
        super(appId, appKey);
    }

    /**
     * 身份证OCR
     *
     * @param image    原始图片的base64编码数据（原图大小上限1MB，支持JPG、PNG、BMP格式）
     * @param cardType 身份证图片类型，0-人像面，1-国徽面
     * @return res
     * @see "https://ai.qq.com/doc/ocridcardocr.shtml"
     */
    public TencentResult<IdCardOCRRes> idCardOCR(String image, int cardType) throws IOException {
        Map<String, Object> data = new HashMap<>(2);
        data.put("image", image);
        data.put("card_type", cardType);
        return super.request(data, URLs.OCR_ID_CARD, new TypeReference<TencentResult<IdCardOCRRes>>() {
        });
    }

    /**
     * 行驶证驾驶证OCR
     *
     * @param image 原始图片的base64编码数据（原图大小上限1MB，支持JPG、PNG、BMP格式）
     * @param type  识别类型，0-行驶证识别，1-驾驶证识别
     * @return res
     * @see "https://ai.qq.com/doc/ocrdriverlicenseocr.shtml"
     */
    public TencentResult<DriverLicenseOCRRes> driverLicenseOCR(String image, int type) throws IOException {
        Map<String, Object> data = new HashMap<>(2);
        data.put("image", image);
        data.put("type", type);
        return super.request(data, URLs.OCR_DRIVER_LICENSE, new TypeReference<TencentResult<DriverLicenseOCRRes>>() {
        });
    }


}
