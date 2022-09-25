<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.sparrowzoo.com/ui" prefix="j" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>用户登录-${website_name}</title>
    <meta content="${websiteConfig.keywords} " name="keywords"/>
    <meta content="${websiteConfig.description}" name="description"/>
    <meta name="application-name" content="${website_name}"/>
    <meta name="msapplication-tooltip" content="${website_name}"/>
    <j:style href="$resource/styles/pure-css/pure-min.css"/>

    <!--[if lte IE 8]>
    <j:style href="$resource/styles/layouts-old-ie.css"/>
    <![endif]-->
    <!--[if gt IE 8]><!-->
    <j:style href="$resource/styles/layouts.css"/>
    <!--<![endif]-->
    <j:style href="$resource/styles/sparrow.css"/>
    <j:script src="$resource/scripts/sparrow.js"/>
    <j:script src="$resource/ext/scripts/system/language/$language/user.js"/>
</head>
<body>
<j:script src="$resource/scripts/baidu.js"/>
<div class="body">

    <div class="header">
        <h1>${website_name}用户登录</h1>
        <h2>
            还没有帐号?
            <a href="${root_path}/register">立即注册</a>
        </h2>
    </div>

    <div class="content">
        <br/>
        <form action="login.do" method="post" class="pure-form pure-form-aligned">
            <fieldset>
                <div class="pure-control-group">
                    <label for="txtUserName">
                        用户名
                    </label>
                    <j:text_box cssClass="input" id="txtUserName" name="userName"
                                events="onfocus='$.v.showMessage(loginInfo,this);' onblur='$.v.isNull(loginInfo,this);'"/>
                    <j:span id="errorUserName" name="login_user_name" cssClass="error"/>
                </div>
                <div class="pure-control-group">
                    <label>
                        密 码
                    </label>

                    <input class="input" type="password"
                           onfocus="$.v.showMessage(loginInfo,this);"
                           onblur="$.v.isNull(loginInfo,this);" id="txtPassword"
                           name="password"/>
                    <j:span id="errorPassword" name="login_password" cssClass="error"/>
                </div>
                <div class="pure-control-group">
                    <label>
                        验证码
                    </label>
                    <input class="input" onfocus="$.v.showMessage(loginInfo,this);"
                           onblur="$.v.isNull(loginInfo,this);" type="text"
                           maxlength="4" name="validateCode" id="txtValidateCode"/>

                    <img id="imgLoginValidateCode"
                         onclick="$(this).fresh()" src="${rootPath}/ValidateCode"/>
                    <a href="javascript:$('#imgLoginValidateCode').fresh();"> 看不清 换一张</a>
                    <j:span id="errorValidateCode" name="login_validate_code" cssClass="error"/>
                </div>

                <div class="pure-controls">
                    <label for="chbLoginDays" class="pure-checkbox">
                        <input id="chbLoginDays" value="14" name="loginDays" type="checkbox"> 两周直接登录(家庭登录模式)<a
                            href="${root_path}/password/find-by-email">忘记密码</a><br/>
                        <span class="highlight">温馨提示</span>为了您的密码安全,如果您在网吧等公共场所请不要勾选此项
                    </label>

                    <button onenter="true" type="button" onclick="$.v.getValidateResult(loginInfo);"
                            class="pure-button pure-button-primary">登录
                    </button>
                </div>
            </fieldset>
            <input type="hidden" name="redirectUrl" value="${pageContext.request.queryString}"/>
        </form>
    </div>
</div>

</body>
</html>