package org.natsume.shortlink.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.natsume.shortlink.admin.common.convention.exception.ClientException;
import org.natsume.shortlink.admin.common.enums.UserErrorCodeEnum;
import org.natsume.shortlink.admin.dao.entity.UserDO;
import org.natsume.shortlink.admin.dao.mapper.UserMapper;
import org.natsume.shortlink.admin.dto.resp.UserRespDto;
import org.natsume.shortlink.admin.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserServiceImpl
 * Package: org.natsume.shortlink.admin.service.impl
 * Description: 用户接口实现层
 *
 * @Author natsume
 * @Create 2025/1/18 19:18
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {
    @Override
    public UserRespDto getUserByUsername(String username) {
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, username);
        UserDO userDO = baseMapper.selectOne(queryWrapper);

        if(userDO == null) {
            throw new ClientException(UserErrorCodeEnum.USER_NULL);
        }

        UserRespDto result = new UserRespDto();
        BeanUtils.copyProperties(userDO, result);
        return result;
    }
}
