package com.cloud.badminton.framework.common.result;

import lombok.Data;
import lombok.ToString;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/1 14:07
 */
@Data
@ToString
public class PageResultVo extends ResultVo{
    private Long current;
    private Long size;
    private Long total;

    public PageResultVo() {
    }

    public PageResultVo(Object data, Long current, Long size, Long total) {
        super(data);
        this.current = current;
        this.size = size;
        this.total = total;
    }
}
