<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sx:head/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传Excel</title>
</head>
<body>
<table border="0" cellpadding="0" cellspacing="5" align="center">
  	<s:form action="excel_upload" method="post" namespace="/excel" enctype="multipart/form-data">
  	<tr>
  		<td colspan="5"><font><s:property value="#message"/></font></td>
  	</tr>
  	<tr>
  		<td><s:label value="课件名："></s:label></td>
  		<td><s:textfield name="name" value="%{#form.name}"></s:textfield></td>
  		<td><font><s:property value="#error.name"/> </font></td>
  	</tr>
  	<tr>
  		<td><s:label value="上传时间："></s:label></td>
  		<td><sx:datetimepicker name="date" value="%{'today'}" ></sx:datetimepicker></td>
  		<td><font><s:property value="#error.date"/> </font></td>
  	</tr>
  	<tr>
  		<td><s:label value="课件："></s:label></td>
  		<td><s:file name="excel" ></s:file></td>
  		<td><font><s:property value="#error.path"/> </font></td>
  	</tr>
 	
  	<tr>
  		<td><s:submit value="添加"></s:submit></td>
  		<td><s:reset value="取消"></s:reset></td>
  	</tr>		 
   	</s:form>
   
  </table>
</body>
</html>