package red.htt.tencent.v1.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 参数名称	  是否必选	数据类型	描述
 * name	        是	    string	证件姓名
 * sex	        是	    string	性别
 * nation	    是	    string	民族
 * birth	    是	    string	出生日期
 * address  	是	    string	地址
 * id	        是	    string	身份证号
 * frontimage	是	    string	OCR的身份证正面base64编码照片
 * valid_date	是	    string	证件的有效期
 * authority	是	    string	发证机关
 * backimage	是	    string	OCR的证件身份证反面base64编码照片
 *
 * @author mio
 * @see "https://ai.qq.com/doc/ocridcardocr.shtml"
 */
@Data
@Accessors(chain = true)
public class OCRIdCardRes {

    private String name;
    private String sex;
    private String nation;
    private String birth;
    private String address;
    private String id;
    private String frontimage;
    private String authority;
    private String valid_date;
    private String backimage;

}
