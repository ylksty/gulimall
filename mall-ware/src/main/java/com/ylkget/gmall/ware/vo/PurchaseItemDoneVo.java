package com.ylkget.gmall.ware.vo;

import lombok.Data;

/**
 * @author joe 2021-02-04 20
 */
@Data
public class PurchaseItemDoneVo {
    //{itemId:1,status:4,reason:""}
    private Long itemId;
    private Integer status;
    private String reason;
}
