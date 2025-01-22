package org.natsume.shortlink.admin.dto.resp;

import lombok.Data;

/**
 * ClassName: UserRespDto
 * Package: org.natsume.shortlink.admin.dto.resp
 * Description: 用户返回参数响应，无脱敏
 *
 * @Author natsume
 * @Create 2025/1/18 19:25
 * @Version 1.0
 */
@Data
public class UserActualRespDto {

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
    private String phone;

    /**
     * 邮箱
     */
    private String mail;
}
