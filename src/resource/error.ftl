<#include "/header/headder.ftl">

<div class="alert alert-warning alert-dismissible" role="alert">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
    <strong>警告!</strong> 用户名密码错误,请重新输入页面3秒后跳转
</div>

    <#-- 页面跳转-->
<script>
    setTimeout(() => {
        window.location.href = "/";
    }, 3000)
</script>

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>

<#-- 引入页脚文件 -->
<#include "/footer/footer.ftl">