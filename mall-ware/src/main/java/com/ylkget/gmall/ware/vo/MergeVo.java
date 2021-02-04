package com.ylkget.gmall.ware.vo;

import lombok.Data;

import java.util.List;

/**
 * @author joe 2021-02-04 17
 */
@Data
public class MergeVo {
    private Long purchaseId; //整单id
    private List<Long> items;//[1,2,3,4] //合并项集合
}
