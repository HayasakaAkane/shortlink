package org.natsume.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.natsume.shortlink.admin.dao.entity.UserDO;
import org.natsume.shortlink.admin.dto.resp.UserRespDto;

/**
 * ClassName: UserService
 * Package: org.natsume.shortlink.admin.service
 * Description: 用户接口层
 *
 * @Author natsume
 * @Create 2025/1/18 19:17
 * @Version 1.0
 */
public interface UserService extends IService<UserDO> {

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 用户返回实体
     */
    UserRespDto getUserByUsername(String username);
}
