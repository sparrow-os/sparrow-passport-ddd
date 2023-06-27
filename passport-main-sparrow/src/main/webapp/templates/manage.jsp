<%@ page language="java" pageEncoding="utf-8" %>
<%@taglib uri="http://www.sparrowzoo.com/ui" prefix="j" %>
<%--<%@taglib uri="http://www.sparrowzoo.com/ui/extend" prefix="E" %>--%>
<%@taglib uri="http://www.sparrowzoo.com/el" prefix="e" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
    <jsp:include page="/template/include/header.jsp"/>
    <j:script src="$resource/javascript/system/language/$language/user.js"/>
    <title>${website_name}</title>
</head>
<body>
<div id="layout">
    <div id="main">
        <div class="navigation">
            aafsd>>sss
        </div>
        <div class="content">
            <form method="post" class="pure-form pure-form-aligned">
                <fieldset>
                    <legend>组管理</legend>
                    <div class="pure-control-group">
                        <input type="hidden" id="hdnGridResult" gridViewId="grvAdministratorList" name="administratorId"
                               keyType="int"/>

                        <label>用户昵称</label>
                        <j:text_box name="muser.userName" id="txtUserName"/>
                        <input type="button" class="pure-button pure-button-primary" onclick="$.submit();"
                               value="${e:i18n('control_text_search')}"/><br/>

                        <input type="button" class="pure-button" value="${e:i18n('control_text_new')}"
                               onclick="window.location.href='new.jsp';"/>
                        <input type="button" class="pure-button"
                               onclick="gridView.action('enable.do',l.message.enable);"
                               title="${e:i18n('control_text_enable')}" value="${e:i18n('control_text_enable')}"/>
                        <input type="button" class="pure-button" title="e:i18n('control_text_disable')"
                               value="${e:i18n('control_text_disable')}"
                               onclick="gridView.action('disable.do',l.message.disable);"/>
                        <input type="button" class="pure-button" title="${e:i18n('control_text_delete')}"
                               value="${e:i18n('control_text_delete')}"
                               onclick="gridView.action('delete.do',l.message.del);"/>

                        <input type="button" class="pure-button"
                               title="从Excel导入用户基本信息"
                               onclick="window.location.href='excel-import.jsp'" value="Excel导入"/>

                    </div>
                </fieldset>
            </form>
            <div class="pure-form pure-form-aligned">
                <fieldset>
                    <legend>
                        用户列表 共
                        <j:span cssClass="highlight" id="spanRecordCount"
                                name="recordCount"/>
                        位注册
                    </legend>

                    <j:grid_view pageFormat="javascript:page.action($pageIndex);"
                                 name="userList" id="grvAdministratorList" indent="9"
                                 headTitles="checkBox|用户名|性别|Email|注册日期|最后登陆|状态|积分|角色$2"
                                 fields="
						checkBox#userId#grvAdministratorList$20px$left|
						text#userLoginName$left|
						text#sex#enum:GENDER$30px$center|
						text#email$80px$center|
						text#createTime#date:yyyy-MM-dd HH:mm:ss$180px$center|
						text#lastLoginTime#date:yyyy-MM-dd HH:mm$180px$center|
						text#status#enum:STATUS_RECORD$30px$center|
						text#cent$30px$center|
						text#groupNames$120px$left|
						button#userId#control_text_set#Sparrow.window({url:'/administrator/group/set.jsp?userId={0}'})#button"/>,
                </fieldset>
            </div>
        </div>
    </div>
</div>
</body>
</html>