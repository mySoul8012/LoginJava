package com.ming.Action;

import com.ming.Util.TokenUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

public class index extends ActionSupport {
    private String token = null;
    @Override
    public String execute() throws Exception{
        TokenUtil tokenUtil = TokenUtil.getTokenUtil();
        token = tokenUtil.toToken();
        // token保存进入session
        // 获取上下文
        ActionContext actionContext = ActionContext.getContext();
        Map session = actionContext.getSession();
        session.put("token", token);
        return SUCCESS;
    }
    public String getToken(){
        return this.token;
    }
    public void setToken(String token){
        this.token = token;
    }
}
