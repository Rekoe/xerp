<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<form action="${base}/erp/buy/buyorderdetail/add" method="post" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
<div class="pageContent">
	<div class="pageFormContent" layoutH="100">
	
		<h3 class="contentTitle">填写采购产品</h3>
		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li class="selected"><a href="javascript:void(0)"><span>申请单明细</span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent" style="height: 100%;">
				
				<div>
					<table class="list nowrap itemDetail" addButton="新建" width="100%">
						<thead>
							<tr>
								<th type="number" name="items[#index#].amount"  fieldClass="required">商品数量</th>
								<th type="number" name="items[#index#].price" >参考价格</th>
								<th type="lookup" id="items[#index#].supplier.id"  name="items[#index#].supplier.name" lookupGroup="items[#index#].supplier" lookupUrl="${base}/erp/basic/supplier/listoneLookup"  size="12" fieldClass="required">供应商</th>
                                <th type="lookup" id="items[#index#].product.id"  name="items[#index#].product.name" lookupGroup="items[#index#].product" lookupUrl="${base}/erp/basic/product/list_oneLookup"  size="12" fieldClass="required">产品名称</th>
                                <th type="del" width="60">操作</th>
							</tr>
						</thead>
						<tbody></tbody>
					</table>
				</div>
				
			</div>
			<div class="tabsFooter">
				<div class="tabsFooterContent"></div>
			</div>
		</div>
		
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button class="close" type="button">关闭</button></div></div></li>
		</ul>
	</div>
</div>
</form>
