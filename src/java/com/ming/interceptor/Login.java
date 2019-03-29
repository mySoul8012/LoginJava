package com.ming.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

// 判断用户是否已经登录
public class Login extends AbstractInterceptor {
    private Map session = null;
    /**
     * Override to handle interception
     *
     * @param invocation
     */
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        // 判断是否已经登录
        Map session = ActionContext.getContext().getSession();
        if("true".equals(session.get("flag"))){
            return invocation.invoke();
        }
        // 返回正常
        return "input";
    }
}
