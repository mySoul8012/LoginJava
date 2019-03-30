package com.ming.Action;

import com.ming.DAO.UserDAOProxy;
import com.ming.vo.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

// 登录Action类
public class Login extends ActionSupport {
    private String uname = null;
    private String password = null;
    private String token = null;
    // 处理业务逻辑
    @Override
    public String execute() throws Exception{
        User user = new User();
        user.setUsername(this.uname);
        user.setUnpassword(this.password);
        user.setUid(0);
        UserDAOProxy userDAOProxy = new UserDAOProxy();
        // 获得session
        Map session = ActionContext.getContext().getSession();
        // 检查session中的token是否一致,若一致,则进行处理,否则不处理
        if (session.get("token").equals(token)) {
            // 数据一致,则进行处理
            if (userDAOProxy.findLogin(user)) {
                // session保存
                session.put("flag", "true");
                // token清除
                session.put("token", "0");
                return SUCCESS;
            } else {
                return ERROR;
            }
        } else {
            // 判断是否已经登录
            if ("true".equals(session.get("flag"))){
                return SUCCESS;
            }
            // 结果不一致 直接返回登录页面
            return ERROR;
        }
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUname() {
        return uname;
    }

    public String getPassword() {
        return password;
    }

    public String getToken(){
        return this.token;
    }

    public void setToken(String token){
        this.token = token;
    }
}
