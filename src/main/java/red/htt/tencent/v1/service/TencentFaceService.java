package red.htt.tencent.v1.service;

import com.fasterxml.jackson.core.type.TypeReference;
import red.htt.tencent.v1.constant.URLs;
import red.htt.tencent.v1.model.*;

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
     * 人脸检测与分析<p>
     * 检测给定图片（Image）中的所有人脸（Face）的位置和相应的面部属性。位置包括（x, y, w, h），
     * 面部属性包括性别（gender）, 年龄（age）, 表情（expression）, 魅力（beauty）, 眼镜（glass）和姿态（pitch，roll，yaw）。
     *
     * @param image 原始图片的base64编码数据（原图大小上限1MB，支持JPG、PNG、BMP格式）
     * @param mode  检测模式，0-正常，1-大脸模式（默认1）
     * @return res
     * @see "https://ai.qq.com/doc/detectface.shtml"
     */
    public TencentResult<FaceDetectRes> faceDetect(String image, int mode) throws IOException {
        Map<String, Object> data = new HashMap<>(6);
        data.put("image", image);
        data.put("mode", mode);
        return super.request(data, URLs.FACE_DETECT, new TypeReference<TencentResult<FaceDetectRes>>() {
        });
    }

    /**
     * 多人脸检测<p>
     * 检测图片中的人脸位置，可以识别出一张图片上的多个人脸。
     *
     * @param image 原始图片的base64编码数据（原图大小上限1MB，支持JPG、PNG、BMP格式）
     * @return res
     * @see "https://ai.qq.com/doc/detectmultiface.shtml"
     */
    public TencentResult<FaceDetectMultiRes> faceDetectMulti(String image) throws IOException {
        Map<String, Object> data = new HashMap<>(5);
        data.put("image", image);
        return super.request(data, URLs.FACE_DETECT_MULTI, new TypeReference<TencentResult<FaceDetectMultiRes>>() {
        });
    }

    /**
     * 跨年龄人脸识别<p>
     * 对比两张图片，并找出相似度最高的两张人脸；支持多人合照、两张图片中的人处于不同年龄段的情况。
     *
     * @param sourceImage 原始图片的base64编码数据（原图大小上限1MB）, 待比较图片
     * @param targetImage 原始图片的base64编码数据（原图大小上限1MB）, 待比较图片
     * @return res
     * @see "https://ai.qq.com/doc/detectcrossageface.shtml"
     */
    public TencentResult<FaceDetectCrossAgeRes> faceDetectCrossAge(String sourceImage, String targetImage) throws IOException {
        Map<String, Object> data = new HashMap<>(6);
        data.put("source_image", sourceImage);
        data.put("target_image", targetImage);
        return super.request(data, URLs.FACE_DETECT_CROSS_AGE, new TypeReference<TencentResult<FaceDetectCrossAgeRes>>() {
        });
    }

    /**
     * 五官定位<p>
     * 对请求图片进行五官定位，计算构成人脸轮廓的88个点，包括眉毛（左右各8点）、眼睛（左右各8点）、鼻子（13点）、嘴巴（22点）、脸型轮廓（21点）。
     *
     * @param image 原始图片的base64编码数据（原图大小上限1MB，支持JPG、PNG、BMP格式）
     * @param mode  检测模式，0-正常，1-大脸模式（默认1）
     * @return res
     * @see "https://ai.qq.com/doc/faceshape.shtml"
     */
    public TencentResult<FaceShapeRes> faceShape(String image, int mode) throws IOException {
        Map<String, Object> data = new HashMap<>(6);
        data.put("image", image);
        data.put("mode", mode);
        return super.request(data, URLs.FACE_SHAPE, new TypeReference<TencentResult<FaceShapeRes>>() {
        });
    }

    /**
     * 人脸对比<p>
     * 对请求图片的两个人脸进行对比，计算相似性以及五官相似度。
     *
     * @param image1 原始图片的base64编码数据（原图大小上限1MB）, 待对比人脸图片A
     * @param image2 原始图片的base64编码数据（原图大小上限1MB）, 待对比人脸图片B
     * @return res
     * @see "https://ai.qq.com/doc/facecompare.shtml"
     */
    public TencentResult<FaceCompareRes> faceCompare(String image1, String image2) throws IOException {
        Map<String, Object> data = new HashMap<>(6);
        data.put("image_a", image1);
        data.put("image_b", image2);
        return super.request(data, URLs.FACE_COMPARE, new TypeReference<TencentResult<FaceCompareRes>>() {
        });
    }
}
