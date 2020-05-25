package red.htt.tencent.service;

import com.fasterxml.jackson.core.type.TypeReference;
import red.htt.tencent.constant.URLs;
import red.htt.tencent.model.*;

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
     * 身份证OCR, 识别身份证图像上面的详细身份信息
     *
     * @param image    原始图片的base64编码数据（原图大小上限1MB，支持JPG、PNG、BMP格式）
     * @param cardType 身份证图片类型，0-人像面，1-国徽面
     * @return res
     * @see "https://ai.qq.com/doc/ocridcardocr.shtml"
     */
    public TencentResult<OCRIdCardRes> idCardOCR(String image, int cardType) throws IOException {
        Map<String, Object> data = new HashMap<>(6);
        data.put("image", image);
        data.put("card_type", cardType);
        return super.request(data, URLs.OCR_ID_CARD, new TypeReference<TencentResult<OCRIdCardRes>>() {
        });
    }

    /**
     * 行驶证驾驶证OCR, 识别行驶证或驾驶证图像上面的字段信息
     *
     * @param image 原始图片的base64编码数据（原图大小上限1MB，支持JPG、PNG、BMP格式）
     * @param type  识别类型，0-行驶证识别，1-驾驶证识别
     * @return res
     * @see "https://ai.qq.com/doc/ocrdriverlicenseocr.shtml"
     */
    public TencentResult<OCRDriverLicenseRes> driverLicenseOCR(String image, int type) throws IOException {
        Map<String, Object> data = new HashMap<>(6);
        data.put("image", image);
        data.put("type", type);
        return super.request(data, URLs.OCR_DRIVER_LICENSE, new TypeReference<TencentResult<OCRDriverLicenseRes>>() {
        });
    }

    /**
     * 通用OCR, 识别上传图像上面的字段信息
     *
     * @param image 原始图片的base64编码数据（原图大小上限1MB，支持JPG、PNG、BMP格式）
     * @return res
     * @see "https://ai.qq.com/doc/ocrgeneralocr.shtml"
     */
    public TencentResult<OCRGeneralRes> generalOCR(String image) throws IOException {
        Map<String, Object> data = new HashMap<>(5);
        data.put("image", image);
        return super.request(data, URLs.OCR_GENERAL, new TypeReference<TencentResult<OCRGeneralRes>>() {
        });
    }

    /**
     * 营业执照OCR, 识别营业执照上面的字段信息
     *
     * @param image 原始图片的base64编码数据（原图大小上限1MB，支持JPG、PNG、BMP格式）
     * @return res
     * @see "https://ai.qq.com/doc/ocrbizlicenseocr.shtml"
     */
    public TencentResult<OCRBizLicenseRes> bizLicenseOCR(String image) throws IOException {
        Map<String, Object> data = new HashMap<>(5);
        data.put("image", image);
        return super.request(data, URLs.OCR_BIZ_LICENSE, new TypeReference<TencentResult<OCRBizLicenseRes>>() {
        });
    }

    /**
     * 银行卡OCR, 识别银行卡上面的字段信息
     *
     * @param image 原始图片的base64编码数据（原图大小上限1MB，支持JPG、PNG、BMP格式）
     * @return res
     * @see "https://ai.qq.com/doc/ocrcreditcardocr.shtml"
     */
    public TencentResult<OCRCreditCardRes> creditCardOCR(String image) throws IOException {
        Map<String, Object> data = new HashMap<>(5);
        data.put("image", image);
        return super.request(data, URLs.OCR_CREDIT_CARD, new TypeReference<TencentResult<OCRCreditCardRes>>() {
        });
    }

    /**
     * 车牌OCR, 识别车牌上面的信息
     *
     * @param image 原始图片的base64编码数据（原图大小上限1MB，支持JPG、PNG、BMP格式）
     * @return res
     * @see "https://ai.qq.com/doc/plateocr.shtml"
     */
    public TencentResult<OCRPlateRes> plateOCR(String image) throws IOException {
        Map<String, Object> data = new HashMap<>(5);
        data.put("image", image);
        return super.request(data, URLs.OCR_CAR_PLATE, new TypeReference<TencentResult<OCRPlateRes>>() {
        });
    }

    /**
     * 名片OCR, 识别名片的字段信息
     *
     * @param image 原始图片的base64编码数据（原图大小上限1MB，支持JPG、PNG、BMP格式）
     * @return res
     * @see "https://ai.qq.com/doc/ocrbcocr.shtml"
     */
    public TencentResult<OCRBusinessCardRes> businessCardOCR(String image) throws IOException {
        Map<String, Object> data = new HashMap<>(6);
        data.put("image", image);
        return super.request(data, URLs.OCR_BUSINESS_CARD, new TypeReference<TencentResult<OCRBusinessCardRes>>() {
        });
    }
}
