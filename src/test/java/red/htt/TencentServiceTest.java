package red.htt;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import red.htt.tencent.model.*;
import red.htt.tencent.service.TencentOCRService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Properties;

/**
 * @author mio
 */
public class TencentServiceTest {

    @Test
    public void testIdCardOCR() throws Exception {
        String image = getImageBase64("tencent-ocr/idcard.jpg");
        TencentResult<OCRIdCardRes> res = this.getTencentOCRService().idCardOCR(image, 0);
        System.out.println(res);
    }

    @Test
    public void testDriverLicenseOCR() throws Exception {
        String image = getImageBase64("tencent-ocr/driver-license.jpg");
        TencentResult<OCRDriverLicenseRes> res = this.getTencentOCRService().driverLicenseOCR(image, 0);
        System.out.println(res);
    }

    @Test
    public void testGeneralOCR() throws Exception {
        String image = getImageBase64("tencent-ocr/general.jpg");
        TencentResult<OCRGeneralRes> res = this.getTencentOCRService().generalOCR(image);
        System.out.println(res);
    }

    @Test
    public void testBizLicenseOCR() throws Exception {
        String image = getImageBase64("tencent-ocr/biz-license.jpg");
        TencentResult<OCRBizLicenseRes> res = this.getTencentOCRService().bizLicenseOCR(image);
        System.out.println(res);
    }

    @Test
    public void testCreditCardOCR() throws Exception {
        String image = getImageBase64("tencent-ocr/credit-card.jpg");
        TencentResult<OCRCreditCardRes> res = this.getTencentOCRService().creditCardOCR(image);
        System.out.println(res);
    }

    @Test
    public void testPlateOCR() throws Exception {
        String image = getImageBase64("tencent-ocr/car-plate.jpg");
        TencentResult<OCRPlateRes> res = this.getTencentOCRService().plateOCR(image);
        System.out.println(res);
    }

    @Test
    public void testBusinessCardOCR() throws Exception {
        String image = getImageBase64("tencent-ocr/business-card.jpg");
        TencentResult<OCRBusinessCardRes> res = this.getTencentOCRService().businessCardOCR(image);
        System.out.println(res);
    }


    private TencentOCRService getTencentOCRService() throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream("config.properties");
        Properties prop = new Properties();
        prop.load(in);
        int appId = Integer.parseInt(prop.getProperty("tencent.appId"));
        String appKey = prop.getProperty("tencent.appKey");
        return new TencentOCRService(appId, appKey);
    }

    private String getImageBase64(String path) throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream(path);
        assert in != null;
        String base64 = new String(Base64.getEncoder().encode(IOUtils.toByteArray(in)));
        in.close();
        return base64;
    }
}
