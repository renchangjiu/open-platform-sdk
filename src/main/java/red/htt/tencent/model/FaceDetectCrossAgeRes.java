package red.htt.tencent.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 参数名称	        是否必选	数据类型	描述
 * + source_face	是	object	相似度最高的一组人脸在source_image中的人脸框
 * + + x1	        是	float	人脸框左上角x
 * + + y1	        是	float	人脸框左上角y
 * + + x2	        是	float	人脸框右下角x
 * + + y2	        是	float	人脸框右下角y
 * + target_face	是	object	相似度最高的一组人脸在target_image中的人脸框
 * + + x1	        是	float	人脸框左上角x
 * + + y1       	是	float	人脸框左上角y
 * + + x2	        是	float	人脸框右下角x
 * + + y2	        是	float	人脸框右下角y
 * + score	        是	float	框出的一组人脸的相似度
 * + fail_flag	    是	int	标志失败图片，0-没有失败，1-源图片，2-目标图片
 *
 * @author mio
 * @see "https://ai.qq.com/doc/detectcrossageface.shtml"
 */
@Data
public class FaceDetectCrossAgeRes {

    private SourceFaceBean source_face;
    private TargetFaceBean target_face;
    private String score;
    private String fail_flag;

    @Data
    public static class SourceFaceBean {
        private Double x1;
        private Double y1;
        private Double x2;
        private Double y2;
    }

    @Data
    public static class TargetFaceBean {
        private Double x1;
        private Double y1;
        private Double x2;
        private Double y2;
    }
}
