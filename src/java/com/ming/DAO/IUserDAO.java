package com.ming.DAO;

import com.ming.vo.User;

// 用户接口类
public interface IUserDAO {
    public boolean findLogin(User user) throws Exception;
}
