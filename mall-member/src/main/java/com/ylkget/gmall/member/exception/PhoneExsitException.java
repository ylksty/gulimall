package com.ylkget.gmall.member.exception;

/**
 * <p>
 *
 * </p>
 *
 * @author joe 2021/2/23 17:02
 */
public class PhoneExsitException extends Exception {
    public PhoneExsitException() {
        super("手机号存在");
    }
}
