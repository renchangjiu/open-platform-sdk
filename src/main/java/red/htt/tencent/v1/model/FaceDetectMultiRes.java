package red.htt.tencent.v1.model;

import lombok.Data;

import java.util.List;

/**
 * 参数名称	    是否必选	数据类型	描述
 * + face_list	是	array	被检测出的人脸列表
 * + + x1	    是	float	人脸框左上角x
 * + + y1	    是	float	人脸框左上角y
 * + + x2	    是	float	人脸框右下角x
 * + + y2	    是	float	人脸框右下角y
 *
 * @author mio
 * @see "https://ai.qq.com/doc/detectmultiface.shtml"
 */
@Data
public class FaceDetectMultiRes {

    private List<FaceListBean> face_list;

    @Data
    public static class FaceListBean {
        private Double x1;
        private Double y1;
        private Double x2;
        private Double y2;
    }
}
