package org.natsume.shortlink.admin.common.convention.exception;

import org.natsume.shortlink.admin.common.convention.errorcode.BaseErrorCode;
import org.natsume.shortlink.admin.common.convention.errorcode.IErrorCode;

/**
 * ClassName: RemoteException
 * Package: org.natsume.shortlink.admin.common.convention.exception
 * Description: 远程服务调用异常
 *
 * @Author natsume
 * @Create 2025/1/21 20:20
 * @Version 1.0
 */
public class RemoteException extends AbstractException {

    public RemoteException(String message) {
        this(message, null, BaseErrorCode.REMOTE_ERROR);
    }

    public RemoteException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public RemoteException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "RemoteException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}
