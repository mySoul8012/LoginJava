package com.ming.factory;

import com.ming.dbc.DBConnection;

// 获得连接工厂
public class DAOFactory {
    public static DBConnection getDBConnection() throws Exception{
        return new DBConnection();
    }
}
