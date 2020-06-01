package red.htt.tencent.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 参数名称	    是否必选	数据类型	描述
 * + similarity	是	    float	两个人脸的相似度
 * + fail_flag	是	    int	    标志失败图片，0-没有失败，1-第一张，2-第二张
 *
 * @author mio
 * @see "https://ai.qq.com/doc/facecompare.shtml"
 */

@NoArgsConstructor
@Data
public class FaceCompareRes {

    private Integer similarity;
    private Integer fail_flag;

}
