<#-- 引入头文件 -->
<#include "/header/headder.ftl">

<div class="container">

    <form class="form-signin" action="Login.action" method="post">
        <h2 class="form-signin-heading">需要登录</h2>
        <label for="uname" class="sr-only">用户名</label>
        <input type="text" id="uname" name="uname" class="form-control" placeholder="用户名" required autofocus>
        <label for="password" class="sr-only">密码</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="密码" required>
        <#-- 隐藏作用域 -->
        <input type="hidden" name="token" value="${token}"/>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> 记住我
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    </form>

</div> <!-- /container -->
<script>
    console.log("${token}");
</script>

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>

<#-- 引入页脚文件 -->
<#include "/footer/footer.ftl">