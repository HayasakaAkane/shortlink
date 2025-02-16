package org.natsume.shortlink.admin.dto.req;

import lombok.Data;

/**
 * ClassName: UserRegisterReqDTO
 * Package: org.natsume.shortlink.admin.dto.req
 * Description: 用户注册请求参数
 *
 * @Author natsume
 * @Create 2025/2/16 22:30
 * @Version 1.0
 */
@Data
public class UserRegisterReqDTO {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

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
