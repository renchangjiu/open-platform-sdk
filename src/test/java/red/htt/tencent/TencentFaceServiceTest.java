package red.htt.tencent;

import org.junit.Test;
import red.htt.tencent.v1.model.*;

/**
 *
 * @author mugi
 */
public class TencentFaceServiceTest extends TencentServiceTest {

    @Test
    public void testFaceDetect() throws Exception {
        String image = getImageBase64("tencent-face/detect.jpg");
        TencentResult<FaceDetectRes> res = super.getTencentFaceService().faceDetect(image, 1);
        System.out.println(res);
    }

    @Test
    public void testFaceDetectMulti() throws Exception {
        String image = getImageBase64("tencent-face/multi-detect.jpg");
        TencentResult<FaceDetectMultiRes> res = super.getTencentFaceService().faceDetectMulti(image);
        System.out.println(res);
    }

    @Test
    public void testFaceDetectCrossAge() throws Exception {
        String image1 = getImageBase64("tencent-face/detect-cross-age-1.jpg");
        String image2 = getImageBase64("tencent-face/detect-cross-age-2.jpg");
        TencentResult<FaceDetectCrossAgeRes> res = super.getTencentFaceService().faceDetectCrossAge(image1, image2);
        System.out.println(res);
    }

    @Test
    public void testFaceShape() throws Exception {
        String image = getImageBase64("tencent-face/shape.jpg");
        TencentResult<FaceShapeRes> res = super.getTencentFaceService().faceShape(image, 1);
        System.out.println(res);
    }

    @Test
    public void testFaceCompare() throws Exception {
        String image1 = getImageBase64("tencent-face/image1.jpg");
        String image2 = getImageBase64("tencent-face/image2.jpg");
        TencentResult<FaceCompareRes> res = super.getTencentFaceService().faceCompare(image1, image2);
        System.out.println(res);
    }
}
