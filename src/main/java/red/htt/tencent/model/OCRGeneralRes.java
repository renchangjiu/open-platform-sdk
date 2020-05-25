package red.htt.tencent.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 参数名称	        是否必选	数据类型	描述
 * + item_list	    是	    array	识别出的所有字段信息
 * + + item	        是	    string	字段名称
 * + + itemstring	是	    string	字段识别出来的信息
 * + + itemcoord	是	    object	字段在图像中的像素坐标，包括左上角坐标x,y，以及宽、高width, height
 * + + words	    是	    array	字段识别出来的每个字的信息
 * + + + character	是	    string	识别出的单字字符
 * + + + confidence	是	    float	识别出的单字字符对应的置信度
 *
 * @author mio
 * @see "https://ai.qq.com/doc/ocrgeneralocr.shtml"
 */
@Data
@Accessors(chain = true)
public class OCRGeneralRes {

    private List<ItemListBean> item_list;

    @Data
    @Accessors(chain = true)
    public static class ItemListBean {

        private String item;
        private String itemstring;
        private List<ItemcoordBean> itemcoord;
        private List<WordsBean> words;

        @Data
        @Accessors(chain = true)
        public static class ItemcoordBean {
            private int x;
            private int y;
            private int width;
            private int height;
        }

        @Data
        @Accessors(chain = true)
        public static class WordsBean {
            private String character;
            private double confidence;

        }
    }
}
