package red.htt.tencent.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 参数名称	        是否必选	  数据类型	    描述
 * + item_list	    是	       array	  识别出的所有字段信息
 * + + item	        是	       string	字段名称
 * + + itemstring	是	       string	字段识别出来的信息
 * + + itemcoord	是	       object	字段在图像中的像素坐标，包括左上角坐标x,y，以及宽、高width, height
 * + + itemconf	    是	       float	字段置信度
 *
 * @author Eduardo
 * @see "https://ai.qq.com/doc/plateocr.shtml"
 */
@Data
@Accessors(chain = true)
public class OCRPlateRes {

    private List<ItemListBean> item_list;

    @Data
    @Accessors(chain = true)
    public static class ItemListBean {
        private String item;
        private String itemstring;
        private double itemconf;
        private List<ItemcoordBean> itemcoord;

        @Data
        @Accessors(chain = true)
        public static class ItemcoordBean {
            private int x;
            private int y;
            private int width;
            private int height;
        }
    }
}
