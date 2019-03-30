package com.ming.dbc;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

// 数据库连接
public class DBConnection {
    // 定义查找名称
    private static final String DSNAME = "java:comp/env/jdbc/ming";
    private Connection connection = null;
    public DBConnection() throws Exception{
        // 获取上下文
        Context context = new InitialContext();
        DataSource dataSource = (DataSource)context.lookup(DSNAME);
        this.connection = dataSource.getConnection();
    }
    public Connection getConnection(){
        return this.connection;
    }
    public void close() throws Exception {
        if(this.connection != null){
           try {
               this.connection.close();
           }catch (Exception e){
               throw e;
           }
        }
    }
}
