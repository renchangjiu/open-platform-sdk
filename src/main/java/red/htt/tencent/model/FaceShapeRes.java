package red.htt.tencent.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 参数名称	            是否必选	数据类型	描述
 * + image_width	    是	Integer	请求图片的宽度
 * + image_height	    是	Integer	请求图片的高度
 * + face_shape_list	是	array	每个人脸的配准坐标
 * + + face_profile	    是	array	描述脸型轮廓的21点（每点为一个对象{x, y}）
 * + + left_eye	        是	array	描述左眼轮廓的8点（每点为一个对象{x, y}）
 * + + right_eye	    是	array	描述右眼轮廓的8点（每点为一个对象{x, y}）
 * + + left_eyebrow	    是	array	描述左眉轮廓的8点（每点为一个对象{x, y}）
 * + + right_eyebrow	是	array	描述右眉轮廓的8点（每点为一个对象{x, y}）
 * + + mouth	         是	array	描述嘴巴轮廓的22点（每点为一个对象{x, y}）
 * + + nose	             是	array	描述鼻子轮廓的13点（每点为一个对象{x, y}）
 *
 * @author mio
 * @see "https://ai.qq.com/doc/faceshape.shtml"
 */

@Data
public class FaceShapeRes {

    private Integer image_width;
    private Integer image_height;
    private List<FaceShapeListBean> face_shape_list;


    @Data
    public static class FaceShapeListBean {
        private List<FaceProfileBean> face_profile;
        private List<LeftEyeBean> left_eye;
        private List<RightEyeBean> right_eye;
        private List<LeftEyebrowBean> left_eyebrow;
        private List<RightEyebrowBean> right_eyebrow;
        private List<MouthBean> mouth;
        private List<NoseBean> nose;


        @Data
        public static class FaceProfileBean {
            private Integer x;
            private Integer y;
        }


        @Data
        public static class LeftEyeBean {
            private Integer x;
            private Integer y;
        }


        @Data
        public static class RightEyeBean {
            private Integer x;
            private Integer y;
        }


        @Data
        public static class LeftEyebrowBean {
            private Integer x;
            private Integer y;
        }


        @Data
        public static class RightEyebrowBean {
            private Integer x;
            private Integer y;
        }


        @Data
        public static class MouthBean {
            private Integer x;
            private Integer y;
        }


        @Data
        public static class NoseBean {
            private Integer x;
            private Integer y;
        }
    }
}
