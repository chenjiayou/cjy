<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
	border:1px solid black ;
	text-align: center;
	font-size:15px;
	font-family:"宋体";
	width: 696px;
	height: 884px;
	border-collapse: collapse;
}

td{
	width: 116px;
	height:43px;
	border: 1px solid black;
}
</style>
</head>
<body>
	<div align="center">
		<s:iterator value="#listDock" var="dock">
			<table border="2">
				<tr>
					<td colspan="6" align="center" style="font-size: 22px;font-weight: bold;">东莞市企业能耗在线监测数据对接申请表</td>
				</tr>
				<tr>
					<td>企业名称（盖章）</td>
					<td colspan="5"><s:property value="#dock.ename"/> </td>
				</tr>
				<tr>
					<td>地址</td>
					<td colspan="5"><s:property value="#dock.eadderss"/></td>
				</tr>
				<tr>
					<td>所属镇街</td>
					<td colspan="2"><s:property value="#dock.belongTown"/></td>
					<td>所属行业</td>
					<td colspan="2"><s:property value="#dock.industry"/></td>
				</tr> 
				<tr>
					<td>企业节能负责人</td>
					<td><s:property value="#dock.emanagePeople"/></td>
					<td>手机</td>
					<td><s:property value="#dock.emanagePhone"/></td>
					<td>电子邮箱</td>
					<td><s:property value="#dock.emanageMail"/></td>
				</tr> 
				<tr>
					<td>企业联系人</td>
					<td><s:property value="#dock.econtactPeople"/></td>
					<td>手机</td>
					<td><s:property value="#dock.econtactPhone"/></td>
					<td>电子邮箱</td>
					<td><s:property value="#dock.econtactMail"/></td>
				</tr>
				<tr>
					<td rowspan="2">*服务公司名称</td>
					<td rowspan="2"><s:property value="#dock.serviceEnterprise"/></td>
					<td>联系人</td>
					<td><s:property value="#dock.serviceContact"/></td>
					<td rowspan="2">电子邮箱</td>
					<td rowspan="2"><s:property value="#dock.serviceContactMail"/></td>
				</tr>
				<tr>
					<td>手机</td>
					<td><s:property value="#dock.serviceContactPhone"/></td>
				</tr>
				<tr>
					<td colspan="6" align="center" style="font-size: 22px;font-weight: bold;">企业能源管理中心项目情况</td>
				</tr>
				<tr>
					<td>项目起止时间</td>
					<td colspan="5"><s:property value="#dock.projectStartAndStopTime"/></td>
				</tr>
				<tr>
					<td rowspan="4">项目投资额（万元）</td>
					<td rowspan="4"><s:property value="#dock.projectInvestmentTotal"/></td>
					<td colspan="2">其中：系统开发金额（万元）</td>
					<td colspan="2"><s:property value="#dock.systemAmount"/></td>
				</tr>
				<tr>
					<td colspan="2">其中：设备采购金额（万元）</td>
					<td colspan="2"><s:property value="#dock.equipmentAmount"/></td>
				</tr>
				<tr>
					<td colspan="2">其中：工程安装金额（万元）</td>
					<td colspan="2"><s:property value="#dock.fixAmount"/></td>
				</tr>
				<tr>
					<td colspan="2">其中：维护及其他金额（万元）</td>
					<td colspan="2"><s:property value="#dock.otherAmount"/></td>
				</tr>
				<tr>
					<td>进出用能单位监测点数</td>
					<td><s:property value="#dock.FirstPoint"/></td>
					<td>进出主要次级用能单位监测点数</td>
					<td><s:property value="#dock.secondPoint"/></td>
					<td>主要用能设备监测点数</td>
					<td><s:property value="#dock.equipmentPoint"/></td>
				</tr>
				<tr>
					<td>对接方式</td>
					<td colspan="5"><s:property value="#dock.dockMode"/></td>
				</tr>
				<tr>
					<td rowspan="4">3、标准WebService数据对接方式</td>
					<td>配置平台地址</td>
					<td colspan="4">详见《关于东莞市企业能源管理中心数据对接有关事项的通知》</td>
				</tr>
				<tr>
					<td>帐号</td>
					<td colspan="4"><s:property value="#dock.dockAccount"/></td>
				</tr>
				<tr>
					<td>初始密码</td>
					<td colspan="4"><s:property value="#dock.dockPassword"/></td>
				</tr>
				<tr>
					<td>Webservice地址</td>
					<td colspan="4">详见《关于东莞市企业能源管理中心数据对接有关事项的通知》</td>
				</tr>
				<tr>
					<td>市能源利用监测中心审核意见</td>
					<td colspan="5">同意</td>
				</tr>
				
			</table>
		</s:iterator>
		
	</div>
</body>
</html>