package org.natsume.shortlink.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.natsume.shortlink.admin.common.convention.exception.ClientException;
import org.natsume.shortlink.admin.common.enums.UserErrorCodeEnum;
import org.natsume.shortlink.admin.dao.entity.UserDO;
import org.natsume.shortlink.admin.dao.mapper.UserMapper;
import org.natsume.shortlink.admin.dto.req.UserRegisterReqDTO;
import org.natsume.shortlink.admin.dto.resp.UserRespDto;
import org.natsume.shortlink.admin.service.UserService;
import org.redisson.api.RBloomFilter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import static org.natsume.shortlink.admin.common.enums.UserErrorCodeEnum.USER_NAME_EXIST;
import static org.natsume.shortlink.admin.common.enums.UserErrorCodeEnum.USER_SAVE_ERROR;

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
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    private final RBloomFilter<String> userRegisterCachePenetrationBloomFilter;

    @Override
    public UserRespDto getUserByUsername(String username) {
        // 直接根据用户名查询用户信息
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, username);
        UserDO userDO = baseMapper.selectOne(queryWrapper);
        // 如果userDO为空，就抛用户记录不存在异常
        if(userDO == null) {
            throw new ClientException(UserErrorCodeEnum.USER_NULL);
        }
        // 否则将获取的数据封装成UserRespDto的格式返回
        UserRespDto result = new UserRespDto();
        BeanUtils.copyProperties(userDO, result);
        return result;
    }

    @Override
    public Boolean hasUsername(String username) {
        // // 直接从数据库中查询该用户
        // LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class).eq(UserDO::getUsername, username);
        // UserDO userDO = baseMapper.selectOne(queryWrapper);
        // // 如果userDO不为空，返回true，表示该用户名已存在，否则就是不存在
        // return userDO != null;

        // 改成使用布隆过滤器后只需要判断布隆过滤器中是否存在该用户名即可
        return !userRegisterCachePenetrationBloomFilter.contains(username);
    }

    @Override
    public void register(UserRegisterReqDTO requestParam) {
        // 如果注册的用户名已经存在，就抛用户名已存在异常
        if(hasUsername(requestParam.getUsername())) {
            throw new ClientException(USER_NAME_EXIST);
        }
        // 向数据库中插入数据，影响行数保存在inserted
        int inserted = baseMapper.insert(BeanUtil.toBean(requestParam, UserDO.class));
        if(inserted < 1) { // inserted小于1，表示插入失败，抛出用户保存失败异常
            throw new ClientException(USER_SAVE_ERROR);
        }
        // 数据库插完之后也要往布隆过滤器中插入
        userRegisterCachePenetrationBloomFilter.add(requestParam.getUsername());
    }
}
