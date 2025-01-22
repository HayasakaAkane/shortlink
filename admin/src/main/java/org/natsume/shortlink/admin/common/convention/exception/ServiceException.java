package org.natsume.shortlink.admin.common.convention.exception;

import org.natsume.shortlink.admin.common.convention.errorcode.BaseErrorCode;
import org.natsume.shortlink.admin.common.convention.errorcode.IErrorCode;

import java.util.Optional;

/**
 * ClassName: ServiceException
 * Package: org.natsume.shortlink.admin.common.convention.exception
 * Description: 服务端异常
 *
 * @Author natsume
 * @Create 2025/1/21 20:20
 * @Version 1.0
 */
public class ServiceException extends AbstractException {

    public ServiceException(String message) {
        this(message, null, BaseErrorCode.SERVICE_ERROR);
    }

    public ServiceException(IErrorCode errorCode) {
        this(null, errorCode);
    }

    public ServiceException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public ServiceException(String message, Throwable throwable, IErrorCode errorCode) {
        super(Optional.ofNullable(message).orElse(errorCode.message()), throwable, errorCode);
    }

    @Override
    public String toString() {
        return "ServiceException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}
