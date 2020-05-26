package red.htt.tencent.model;

import lombok.Data;

import java.util.List;

/**
 * 参数名称	        是否必选	数据类型	描述
 * + image_width	是	int	请求图片的宽度
 * + image_height	是	int	请求图片的高度
 * + face_list	    是	array	被检测出的人脸列表
 * + + face_id	    是	string	人脸（Face）ID
 * + + x	        是	int	人脸框左上角x
 * + + y	        是	int	人脸框左上角y
 * + + width	    是	int	人脸框宽度
 * + + height	    是	int	人脸框高度
 * + + gender	    是	int	性别 [0~100]（越接近0越倾向为女性，越接近100越倾向为男性）
 * + + age	        是	int	年龄 [0~100]
 * + + expression	是	int	微笑[0~100] （0-没有笑容，50-微笑，100-大笑）
 * + + beauty	    是	int	魅力 [0~100]
 * + + glass	    是	int	是否有眼镜 [0, 1]
 * + + pitch	    是	int	上下偏移[-30,30]
 * + + yaw	        是	int	左右偏移[-30,30]
 * + + roll     	是	int	平面旋转[-180,180]
 * + + face_shape	是	object	人脸配准坐标
 * <p>
 * face_shape 说明
 * <p>
 * 字段	            类型	说明
 * face_profile	    array	描述脸型轮廓的21点（每点为一个对象{x, y}）
 * left_eye	        array	描述左眼轮廓的8点（每点为一个对象{x, y}）
 * right_eye	    array	描述右眼轮廓的8点（每点为一个对象{x, y}）
 * left_eyebrow 	array	描述左眉轮廓的8点（每点为一个对象{x, y}）
 * right_eyebrow	array	描述右眉轮廓的8点（每点为一个对象{x, y}）
 * mouth	        array	描述嘴巴轮廓的22点（每点为一个对象{x, y}）
 * nose	            array	描述鼻子轮廓的13点（每点为一个对象{x, y}）
 *
 * @author mio
 * @see "https://ai.qq.com/doc/detectface.shtml"
 */
@Data
public class FaceDetectRes {
    private Integer image_width;
    private Integer image_height;
    private List<FaceListBean> face_list;


    @Data
    public static class FaceListBean {
        private String face_id;
        private Integer x;
        private Integer y;
        private Integer width;
        private Integer height;
        private Integer gender;
        private Integer age;
        private Integer expression;
        private Integer beauty;
        private Integer glass;
        private Integer pitch;
        private Integer yaw;
        private Integer roll;
        private FaceShapeBean face_shape;


        @Data
        public static class FaceShapeBean {
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
}
