package com.ylkget.mallcart.vo;

import lombok.Data;
import lombok.ToString;

/**
 * <p>
 * UserInfoTo
 * </p>
 *
 * @author joe 2021/2/25 17:26
 */
@ToString
@Data
public class UserInfoTo {
    private Long userId;
    private String userKey; //一定封装

    private boolean tempUser = false;
}
