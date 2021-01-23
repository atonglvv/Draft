package framework.rpc.service;

import framework.rpc.domain.entity.User;

/**
 * @program: draft
 * @description: UserService Interface
 * @author: atong
 * @create: 2021-01-23 21:06
 */
public interface UserService {
    User getUser(Long id);
}
