<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="erp/apply/applyproductdetail/list" class="pageForm" onsubmit="return navTabSearch(this, 'product');">
				<div class="pageFormContent" layoutH="58">
				<div>
				<label>产品名称：</label>
			    <input name="product.id"  value="${obj.product.id}"  type="hidden"/>
				<input class="required" name="product.name" value="${obj.product.name}"  type="text" class="required" readonly/>
				<a class="btnLook" href="${base}/erp/basic/product/list_oneLookup" lookupGroup="product">查找带回</a>	
			</div>

			</div>

			<div class="formBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">开始检索</button></div></div></li>
					<li><div class="button"><div class="buttonContent"><button type="reset">清空重输</button></div></div></li>
				</ul>
			</div>
		</form>
	</div>
</div>