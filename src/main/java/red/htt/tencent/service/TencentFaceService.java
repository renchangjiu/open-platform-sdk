package red.htt.tencent.service;

import com.fasterxml.jackson.core.type.TypeReference;
import red.htt.tencent.constant.URLs;
import red.htt.tencent.model.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 腾讯AI开放平台人脸与人体识别大类下的能力
 *
 * @author mio
 * @see "https://ai.qq.com/product/face.shtml#detect"
 */
public class TencentFaceService extends BaseService {

    public TencentFaceService(int appId, String appKey) {
        super(appId, appKey);
    }

    /**
     * 人脸检测与分析
     * <p>
     * 检测给定图片（Image）中的所有人脸（Face）的位置和相应的面部属性。位置包括（x, y, w, h），面部属性包括性别（gender）, 年龄（age）, 表情（expression）, 魅力（beauty）, 眼镜（glass）和姿态（pitch，roll，yaw）。
     *
     * @param image 原始图片的base64编码数据（原图大小上限1MB，支持JPG、PNG、BMP格式）
     * @param mode  检测模式，0-正常，1-大脸模式（默认1）
     * @return res
     * @see "https://ai.qq.com/doc/detectface.shtml"
     */
    public TencentResult<FaceDetectRes> faceDetect(String image, int mode) throws IOException {
        Map<String, Object> data = new HashMap<>(2);
        data.put("image", image);
        data.put("mode", mode);
        return super.request(data, URLs.FACE_DETECT, new TypeReference<TencentResult<FaceDetectRes>>() {
        });
    }


}
