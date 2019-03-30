package com.ming.DAO;

import com.ming.dbc.DBConnection;
import com.ming.vo.User;

import java.sql.Connection;

public class UserDAOProxy implements IUserDAO{
    private Connection connection = null;
    private User user = null;
    public UserDAOProxy(){
        try{
            this.connection = new DBConnection().getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public boolean findLogin(User user) throws Exception {
        this.user = user;
        UserDAOImpl userDAOImpl = new UserDAOImpl(this.connection);
        return userDAOImpl.findLogin(this.user);
    }

}
