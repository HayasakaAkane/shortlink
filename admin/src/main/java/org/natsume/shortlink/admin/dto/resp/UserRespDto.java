package org.natsume.shortlink.admin.dto.resp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.natsume.shortlink.admin.common.serialize.PhoneDesensitizationSerializer;

/**
 * ClassName: UserRespDto
 * Package: org.natsume.shortlink.admin.dto.resp
 * Description: 用户返回参数响应
 *
 * @Author natsume
 * @Create 2025/1/18 19:25
 * @Version 1.0
 */
@Data
public class UserRespDto {

    /**
     * ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    @JsonSerialize(using = PhoneDesensitizationSerializer.class)
    private String phone;

    /**
     * 邮箱
     */
    private String mail;
}
