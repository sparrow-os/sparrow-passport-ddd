<%@ page language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.sparrowzoo.com/ui" prefix="j" %>
<%@taglib uri="http://www.sparrowzoo.com/ui/extend" prefix="E" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>用户中心-${website_name}</title>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <jsp:include page="/template/include/header.jsp"/>
    <j:script src="$resource/ext/scripts/system/language/$language/user.js"/>
    <j:script src="$resource/ext/scripts/system/user/user.js"/>
    <j:style href="$resource/ext/$website/style/system/user.css"/>
</head>
<body>
<form method="post" action="${rootPath}/administrator/modify.do">
    <div class="body">
        <%--<E:JNavigationMenu currentForum="004001"/>--%>
        <j:hidden name="administrator.userId" id="hdnUserId"/>
        <j:hidden name="option" id="hldOption"/>
        <div class="frame">
            <div class="title">
                注: <span class="highlight">*</span>为必添项
            </div>
            <div class="content">
                <div class="userName" id="userName">
                    <j:span id="userName">${administrator.userLoginName}</j:span><a class="updateTime" id="updateTime">
                    上次更新${administrator.updateTime}</a>
                </div>

                <div class="userTitle">
                    <span>基本信息</span>
                </div>
                <table cellspacing="0" cellpadding="4">
                    <tr>
                        <th>昵称:</th>
                        <td class="td-input"><j:text_box events="onfocus='$.v.showMessage(userInfo.txtUserName);'
                        onblur='$.v.isNull(userInfo.txtUserName);'" name="administrator.userName" maxLength="8"
                                                         id="txtUserName"/></td>
                        <td class="td-message"><span id="errorUserName" class="prompt"></span></td>
                        <td rowspan="8" valign="top" align="center" class="userHead">
                            <img id="imgUserHead" style="width: 150px; height: 150px;"
                                 src="${administrator.headImg}"/> <br/>
                            <input type="button"
                                   value="选择头像" class="button"
                                   onclick="$.window({url:'${rootPath}/administrator/change_head.jsp?userId=${madministrator.userId}',showHead:false});"/>
                        </td>
                    </tr>

                    <tr>
                        <th>出生日期:</th>
                        <td class="td-input"><j:text_box readonly="readonly" name="administrator.birthday"
                                                         id="txtBirthday"/></td>
                        <td class="td-message"><span id="errorBirthday" class="prompt"></span></td>
                    </tr>
                    <tr>
                        <th>性别:</th>
                        <td><j:drop_down_list name="administrator.sex" id="ddlSex"
                                              keyValues="0:女,1:男"/></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>Email:</th>
                        <td class="td-input"><j:text_box events="onfocus='$.v.showMessage(userInfo,this);'
                        onblur='$.v.isEmail(userInfo,this);'" name="administrator.email" id="txtEmail"/>
                        </td>
                        <td class="td-message"><span id="errorEmail" class="prompt"></span></td>
                    </tr>
                    <tr>
                        <th>手机:</th>
                        <td class="td-input"><j:text_box events="onfocus='v.showMessage(userInfo,this);'
                        onblur='$.v.isMobile(userInfo,this);'" name="administrator.mobile" id="txtTel"/></td>
                        <td class="td-message"><span id="errorTel" class="prompt"></span></td>
                    </tr>

                    <tr>
                        <th>注册时间:</th>
                        <td>${administrator.createTime}</td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>最后登录时间:</th>
                        <td>${administrator.lastLoginTime}</td>
                        <td></td>
                    </tr>

                    <tr>
                        <th>个性签名:</th>
                        <td colspan="3">
                            <j:text_area cols="50" rows="3"
                                         name="administrator.personalSignature" id="txtpersonalSignature"
                                         events='onkeyup="$.v.updateTxtCount(this,userInfo.txtPersonalSignature.spanTxtCount,100);"'></j:text_area>
                            <br/> 您还可以输入： <j:span cssClass="highlight"
                                                  id="spanPersonalSignatureTxtCount">100</j:span> 个字符/100
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <input type="button" onclick="$.submit();" class="button"
           value="提  交"/>
</form>
</body>
</html>
