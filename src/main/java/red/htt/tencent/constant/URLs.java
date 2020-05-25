package red.htt.tencent.constant;

/**
 * @author mio
 */
public interface URLs {

    /**
     * 身份证OCR
     */
    String OCR_ID_CARD = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_idcardocr";

    /**
     * 行驶证驾驶证OCR
     */
    String OCR_DRIVER_LICENSE = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_driverlicenseocr";

    /**
     * 通用OCR
     */
    String OCR_GENERAL = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_generalocr";

    /**
     * 营业执照OCR
     */
    String OCR_BIZ_LICENSE = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_bizlicenseocr";

    /**
     * 银行卡OCR
     */
    String OCR_CREDIT_CARD = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_creditcardocr";

    /**
     * 手写体OCR
     */
    String OCR_HANDWRITING = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_handwritingocr";

    /**
     * 车牌OCR
     */
    String OCR_CAR_PLATE = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_plateocr";

    /**
     * 名片OCR
     */
    String OCR_BUSINESS_CARD = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_bcocr";


    /**
     * 人脸检测与分析
     */
    String FACE_DETECT = "https://api.ai.qq.com/fcgi-bin/face/face_detectface";

    /**
     * 多人脸检测
     */
    String FACE_DETECT_MULTI = "https://api.ai.qq.com/fcgi-bin/face/face_detectmultiface";

    /**
     * 跨年龄人脸识别
     */
    String FACE_DETECT_CROSS_AGE = "https://api.ai.qq.com/fcgi-bin/face/face_detectcrossageface";

    /**
     * 五官定位
     */
    String FACE_SHAPE = "https://api.ai.qq.com/fcgi-bin/face/face_faceshape";

    /**
     * 人脸对比
     */
    String FACE_COMPARE = "https://api.ai.qq.com/fcgi-bin/face/face_facecompare";

    /**
     * 人脸验证	对请求图片进行人脸验证
     */
    String FACE_VERIFY = "https://api.ai.qq.com/fcgi-bin/face/face_faceverify";

}
