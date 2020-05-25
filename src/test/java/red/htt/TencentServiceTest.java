package red.htt;

import org.apache.commons.io.IOUtils;
import org.junit.Test;
import red.htt.tencent.model.DriverLicenseOCRRes;
import red.htt.tencent.model.IdCardOCRRes;
import red.htt.tencent.model.TencentResult;
import red.htt.tencent.service.TencentOCRService;

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
        InputStream in = getClass().getClassLoader().getResourceAsStream("tencent-ocr/idcard.jpg");
        assert in != null;
        String image = new String(Base64.getEncoder().encode(IOUtils.toByteArray(in)));
        TencentResult<IdCardOCRRes> res = new TencentOCRService(appId, appKey).idCardOCR(image, 0);
        System.out.println(res);
    }

    @Test
    public void testDriverLicenseOCR() throws Exception {
        InputStream in = getClass().getClassLoader().getResourceAsStream("tencent-ocr/driver-license-ocr.jpg");
        assert in != null;
        String image = new String(Base64.getEncoder().encode(IOUtils.toByteArray(in)));
        TencentResult<DriverLicenseOCRRes> res = new TencentOCRService(appId, appKey).driverLicenseOCR(image, 0);
        System.out.println(res);
    }
}
