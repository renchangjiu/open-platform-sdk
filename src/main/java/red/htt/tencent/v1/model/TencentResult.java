package red.htt.tencent.v1.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author mio
 */
@Data
@Accessors(chain = true)
public class TencentResult<T> {

    /**
     * 返回码； 0表示成功，非0表示出错
     */
    private Integer ret;

    /**
     * 返回信息；ret非0时表示出错时错误原因
     */
    private String msg;

    /**
     * 返回数据；ret为0时有意义
     */
    private T data;
}
