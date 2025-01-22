package org.natsume.shortlink.admin.common.convention.exception;

import org.natsume.shortlink.admin.common.convention.errorcode.BaseErrorCode;
import org.natsume.shortlink.admin.common.convention.errorcode.IErrorCode;

/**
 * ClassName: ClientException
 * Package: org.natsume.shortlink.admin.common.convention.exception
 * Description: 客户端异常
 *
 * @Author natsume
 * @Create 2025/1/21 20:19
 * @Version 1.0
 */
public class ClientException extends AbstractException {

    public ClientException(IErrorCode errorCode) {
        this(null, null, errorCode);
    }

    public ClientException(String message) {
        this(message, null, BaseErrorCode.CLIENT_ERROR);
    }

    public ClientException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public ClientException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "ClientException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}
