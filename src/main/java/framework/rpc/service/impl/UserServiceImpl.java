package framework.rpc.service.impl;

import framework.rpc.domain.entity.User;
import framework.rpc.service.UserService;

/**
 * @program: draft
 * @description: User Service
 * @author: atong
 * @create: 2021-01-23 21:08
 */
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(Long id) {
        User user = new User();
        user.setId(1L);
        user.setName("atong");
        user.setAge(23);
        return user;
    }
}
