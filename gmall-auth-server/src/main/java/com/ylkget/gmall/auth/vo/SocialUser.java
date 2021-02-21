package com.ylkget.gmall.auth.vo;

import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author joe 2021/2/21 21:02
 */
@Data
public class SocialUser {
    private String access_token;
    private String remind_in;
    private long expires_in;
    private String uid;
    private String isRealName;
}
