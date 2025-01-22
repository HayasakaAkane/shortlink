package org.natsume.shortlink.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.natsume.shortlink.admin.common.convention.result.Result;
import org.natsume.shortlink.admin.common.convention.result.Results;
import org.natsume.shortlink.admin.dto.resp.UserActualRespDto;
import org.natsume.shortlink.admin.dto.resp.UserRespDto;
import org.natsume.shortlink.admin.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 根据用户名查询用户信息
     */
    @GetMapping("/api/shortlink/v1/user/{username}")
    public Result<UserRespDto> getUserByUsername(@PathVariable("username") String username) {
        return Results.success(userService.getUserByUsername(username));
    }

    /**
     * 根据用户名查询用户无脱敏信息
     */
    @GetMapping("/api/shortlink/v1/actual/user/{username}")
    public Result<UserActualRespDto> getActualUserByUsername(@PathVariable("username") String username) {
        return Results.success(BeanUtil.toBean(userService.getUserByUsername(username), UserActualRespDto.class));
    }

    /**
     * 查询用户名是否存在
     */
    @GetMapping("/api/shortlink/v1/user/has-username")
    public Result<Boolean> hasUsername(@RequestParam("username") String username) {
        return Results.success(userService.hasUsername(username));
    }

}
