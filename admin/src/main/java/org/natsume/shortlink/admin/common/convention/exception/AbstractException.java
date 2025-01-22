package org.natsume.shortlink.admin.common.convention.exception;

import lombok.Getter;
import org.natsume.shortlink.admin.common.convention.errorcode.IErrorCode;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * ClassName: AbstractException
 * Package: org.natsume.shortlink.admin.common.convention.exception
 * Description: 抽象项目中三类异常体系，客户端异常、服务端异常以及远程服务调用异常
 *
 * @Author natsume
 * @Create 2025/1/21 20:19
 * @Version 1.0
 */
@Getter
public abstract class AbstractException extends RuntimeException {

    // 异常码
    public final String errorCode;

    // 异常信息
    public final String errorMessage;

    public AbstractException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable);
        this.errorCode = errorCode.code();
        this.errorMessage = Optional.ofNullable(StringUtils.hasLength(message) ? message : null).orElse(errorCode.message());
    }
}
