package org.natsume.shortlink.admin.common.convention.errorcode;

/**
 * ClassName: IErrorCode
 * Package: org.natsume.shortlink.admin.common.convention.errorcode
 * Description: 平台错误码
 *
 * @Author natsume
 * @Create 2025/1/21 18:49
 * @Version 1.0
 */
public interface IErrorCode {
    /**
     * 错误码
     */
    String code();

    /**
     * 错误信息
     */
    String message();
}
