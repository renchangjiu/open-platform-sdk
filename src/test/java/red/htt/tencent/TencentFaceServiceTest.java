package red.htt.tencent;

import org.junit.Test;
import red.htt.tencent.model.*;

/**
 * @author mugi
 */
public class TencentFaceServiceTest extends TencentServiceTest {

    @Test
    public void testIdCardOCR() throws Exception {
        String image = getImageBase64("tencent-face/detect.jpg");
        TencentResult<FaceDetectRes> res = super.getTencentFaceService().faceDetect(image, 1);
        System.out.println(res);
    }


}
