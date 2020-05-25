package red.htt;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import red.htt.tencent.model.*;
import red.htt.tencent.service.TencentOCRService;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

/**
 * @author mio
 */
public class TencentServiceTest {

    private final int appId = 2111359847;
    private final String appKey = "QypVbTe4cu6akL8H";

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

    private TencentOCRService getTencentOCRService() {
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
