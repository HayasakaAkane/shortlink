package org.natsume.shortlink.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: UserController
 * Package: org.natsume.shortlink.admin.controller
 * Description: 用户管理控制层
 *
 * @Author natsume
 * @Create 2025/1/17 15:15
 * @Version 1.0
 */
@RestController
public class UserController {

    /**
     * 根据用户名查询用户信息
     */
    @GetMapping("/api/shortlink/v1/user/{username}")
    public String getUserByUsername(@PathVariable("username") String username) {
        return "hi " + username;
    }

}
