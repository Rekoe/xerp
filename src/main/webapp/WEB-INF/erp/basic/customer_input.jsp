<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post" action="${base}/erp/basic/customer/<c:choose><c:when test="${obj==null}">add</c:when><c:otherwise>update</c:otherwise></c:choose>" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<input type="hidden" name="id" value="${obj.id}">
		
			<p>
				<label>名称：</label>
				<input name="name" type="text" size="30" value="${obj.name}" class="required" maxlength="150"/>
			</p>
			<p>
				<label>地址：</label>
				<input name="Address" type="text" size="30" value="${obj.address}"  maxlength="150"/>
			</p>
			
			<p>
				<label>联系人：</label>
				<input name="ConstactPerson" type="text" size="30" value="${obj.constactPerson}"  maxlength="150"/>
			</p>
			
			
			<p>
				<label>电话：</label>
				<input name="Phone" type="text" size="30" value="${obj.phone}"  maxlength="150"/>
			</p>
	
		
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
