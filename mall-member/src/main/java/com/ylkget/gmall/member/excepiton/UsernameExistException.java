package com.ylkget.gmall.member.excepiton;

/**
 * <p>
 *
 * </p>
 *
 * @author joe 2021/2/23 17:04
 */
public class UsernameExistException extends Exception {
    public UsernameExistException() {
        super("用户名存在");
    }
}
