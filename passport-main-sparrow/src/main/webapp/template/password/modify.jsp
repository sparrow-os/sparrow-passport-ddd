<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.sparrowzoo.com/ui" prefix="J" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <base/>
    <title>${userLoginName}的个人档 -${website_name}</title>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="keywords" content="修改密码"/>
    <meta http-equiv="description" content="修改密码"/>
    <J:JScript src="$resource/javascript/sparrow.js"/>
    <J:JScript src="$resource/javascript/system/language/$language/user.js"/>
    <J:JStyleLink href="$resource/$website/style/global.css"/>
    <J:JStyleLink href="$resource/$website/style/user.css"/>
</head>
<body>
<jsp:include page="/template/include/top.jsp" flush="true"/>
<div class="body">
    <div class="top">
        <jsp:include page="/template/blog/include/user-menu.jsp"/>
        <div class="right">
            <div class="setmenu">
                <ul>
                    <li><a href="${rootPath}/setting">帐号设置</a></li>
                    <li class="select"><a href="${rootPath}/passowrd">密码设置</a></li>
                </ul>
            </div>
            <div class="user-info">
                <form method="post" action="${rootPath}/password/modify.do">
                    <c:choose>
                        <c:when test="${set!=true}">
                            <div class="line">
                                <label> 原始密码 </label> <input type="password"
                                                             id="txtOldPassword" name="oldPassword"
                                                             onfocus="v.showMessage(password.txtOldPassword);"
                                                             onblur="v.isNull(password.txtOldPassword)"/>

                                <J:JSpan cssClass="prompt" id="errorOldPassword"/>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="line">
                                <span class="highlight">${website_name }提醒您：</span> <br/> <br/>
                                您是通过QQ登录网站，您可以直接设置密码。 <br/> 请设置您的验证邮件，方便日后找回密码 <input
                                    type="text" id="txtEmail" name="email"
                                    onfocus="v.showMessage(password.txtEmail);"
                                    onblur="v.isNull(password.txtEmail)"/>
                            </div>
                        </c:otherwise>
                    </c:choose>
                    <div class="line">
                        <label> 新密码 </label> <input type="password"
                                                    onfocus="v.showMessage(password.txtPassword);"
                                                    onblur="v.isNull(password.txtPassword);" id="txtPassword"
                                                    name="newPassword"/>
                        <J:JSpan cssClass="prompt"
                                 id="errorPassword"/>
                    </div>
                    <div class="line">
                        <label> 确认密码 </label> <input type="password"
                                                     onfocus="v.showMessage(password.txtConfirmPassword);"
                                                     onblur="v.isEqual(password.txtConfirmPassword);"
                                                     id="txtConfirmPassword" name="newPassword2"/> <J:JSpan
                            cssClass="prompt" id="errorConfirmPassword"/>
                    </div>
                    <input type="button" onclick="v.getValidateResult(password);"
                           class="button" value="提  交"/>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/template/include/bottom.jsp" flush="true"/>
</body>
</html>
