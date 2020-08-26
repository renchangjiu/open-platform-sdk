package red.htt.tencent;

import org.junit.Test;
import red.htt.tencent.v1.model.*;

/**
 * @author mugi
 */
public class TencentOCRServiceTest extends TencentServiceTest {

    @Test
    public void testIdCardOCR() throws Exception {
        String image = getImageBase64("tencent-ocr/idcard.jpg");
        TencentResult<OCRIdCardRes> res = super.getTencentOCRService().idCardOCR(image, 0);
        System.out.println(res);
    }

    @Test
    public void testDriverLicenseOCR() throws Exception {
        String image = getImageBase64("tencent-ocr/driver-license.jpg");
        TencentResult<OCRDriverLicenseRes> res = super.getTencentOCRService().driverLicenseOCR(image, 0);
        System.out.println(res);
    }

    @Test
    public void testGeneralOCR() throws Exception {
        String image = getImageBase64("tencent-ocr/general.jpg");
        TencentResult<OCRGeneralRes> res = super.getTencentOCRService().generalOCR(image);
        System.out.println(res);
    }

    @Test
    public void testBizLicenseOCR() throws Exception {
        String image = getImageBase64("tencent-ocr/biz-license.jpg");
        TencentResult<OCRBizLicenseRes> res = super.getTencentOCRService().bizLicenseOCR(image);
        System.out.println(res);
    }

    @Test
    public void testCreditCardOCR() throws Exception {
        String image = getImageBase64("tencent-ocr/credit-card.jpg");
        TencentResult<OCRCreditCardRes> res = super.getTencentOCRService().creditCardOCR(image);
        System.out.println(res);
    }

    @Test
    public void testHandwritingOCR() throws Exception {
        String image = getImageBase64("tencent-ocr/hand-writing.jpg");
        TencentResult<OCRHandwritingRes> res = super.getTencentOCRService().handwritingOCR(image, null);
        System.out.println(res);
    }

    @Test
    public void testPlateOCR() throws Exception {
        String image = getImageBase64("tencent-ocr/car-plate.jpg");
        TencentResult<OCRPlateRes> res = super.getTencentOCRService().plateOCR(image);
        System.out.println(res);
    }

    @Test
    public void testBusinessCardOCR() throws Exception {
        String image = getImageBase64("tencent-ocr/business-card.jpg");
        TencentResult<OCRBusinessCardRes> res = super.getTencentOCRService().businessCardOCR(image);
        System.out.println(res);
    }

}
