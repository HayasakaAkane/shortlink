package org.natsume.shortlink.admin.common.enums;

import org.natsume.shortlink.admin.common.convention.errorcode.IErrorCode;

/**
 * ClassName: UserErrorCodeEnum
 * Package: org.natsume.shortlink.admin.common.enums
 * Description: 用户错误异常码枚举
 *
 * @Author natsume
 * @Create 2025/1/21 19:02
 * @Version 1.0
 */
public enum UserErrorCodeEnum implements IErrorCode {

    USER_NULL("B000200", "用户记录不存在"),
    USER_EXIST("B000201", "用户记录已存在");

    private final String code;

    private final String message;

    UserErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
