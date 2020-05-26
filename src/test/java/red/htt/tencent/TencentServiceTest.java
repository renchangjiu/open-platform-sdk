package red.htt.tencent;

import org.apache.commons.io.IOUtils;
import red.htt.tencent.service.BaseService;
import red.htt.tencent.service.TencentFaceService;
import red.htt.tencent.service.TencentOCRService;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.Base64;
import java.util.Properties;

/**
 * @author mugi
 */
public class TencentServiceTest {


    protected TencentOCRService getTencentOCRService() throws Exception {
        return this.getTencentService(TencentOCRService.class);
    }

    protected TencentFaceService getTencentFaceService() throws Exception {
        return this.getTencentService(TencentFaceService.class);
    }

    protected String getImageBase64(String path) throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream(path);
        assert in != null;
        String base64 = new String(Base64.getEncoder().encode(IOUtils.toByteArray(in)));
        in.close();
        return base64;
    }


    private <T> T getTencentService(Class<T> clazz) throws Exception {
        InputStream in = getClass().getClassLoader().getResourceAsStream("config.properties");
        Properties prop = new Properties();
        prop.load(in);
        int appId = Integer.parseInt(prop.getProperty("tencent.appId"));
        String appKey = prop.getProperty("tencent.appKey");
        Constructor<T> constructor = clazz.getConstructor(int.class, String.class);
        return constructor.newInstance(appId, appKey);
    }
}
