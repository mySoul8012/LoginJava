package com.ming.DAO;

import com.ming.vo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 数据库查找
public class UserDAOImpl implements IUserDAO{
    // 数据库连接对象
    private Connection connection = null;
    // 操作对象
    private PreparedStatement preparedStatement = null;
    // 初始化数据库连接
    public UserDAOImpl(Connection _connection){
        this.connection = _connection;
    }

    @Override
    public boolean findLogin(User user) throws Exception {
        boolean flag = false;
        try{
            String sql = "SELECT uid FROM User WHERE username = ? AND unpassword = ?";
            // 获得对象
            this.preparedStatement = this.connection.prepareStatement(sql);
            // 设置id
            this.preparedStatement.setString(1, user.getUsername());
            this.preparedStatement.setString(2, user.getUnpassword());
            ResultSet resultSet = this.preparedStatement.executeQuery();
            if(resultSet.next()){
                user.setUid(Integer.parseInt(resultSet.getString(1)));
                flag = true;
            }
        }catch (Exception e){
            throw  e;
        }finally {
            if(this.preparedStatement != null){
                try{
                    this.preparedStatement.close();
                }catch (Exception e){
                    throw  e;
                }
            }
        }
        return flag;
    }
}
