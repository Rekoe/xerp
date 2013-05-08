package com.xerp.module.basic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Cnd;
import org.nutz.dao.Sqls;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.lang.Strings;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.service.IdEntityService;

import com.nutzside.common.util.DwzUtil;
import com.xerp.domain.basic.Supplier;

@At("/erp/basic/supplier")
@IocBean(fields = { "dao" })
public class SupplierModule extends IdEntityService<Supplier> {
	/**
	 * 跳转到添加页面
	 */
	@At
	@Ok("jsp:erp.basic.supplier_input")
	public void addUi() {
	}

	/**
	 * 跳转到修改页面
	 */
	@At
	@Ok("jsp:erp.basic.supplier_input")
	public Supplier editUi(@Param("..") Supplier obj) {
		return dao().fetchLinks(dao().fetch(obj), null);
	}

	/**
	 * 跳转到查看页面
	 */
	@At
	@Ok("jsp:erp.basic.supplier_view")
	public Supplier view(@Param("..") Supplier obj) {
		return dao().fetch(obj);
	}

	/**
	 * 跳转到高级查询页面
	 */
	@At
	@Ok("httl:erp.basic.supplier_query")
	public void queryUi() {
	}

	/**
	 * 分页查询
	 * 
	 * @param pageNum
	 *            第几页
	 * @param numPerPage
	 *            每页显示多少条
	 * @return
	 */
	@At
	@Ok("httl:erp.basic.supplier_list")
	public Map<String, Object> list(@Param("pageNum") int pageNum,
			@Param("numPerPage") int numPerPage, @Param("..") Supplier obj) {

		return pagerlist(pageNum, numPerPage, obj);
	}

	@At
	@Ok("httl:erp.basic.supplier_list_oneLookup")
	public Map<String, Object> listoneLookup(@Param("pageNum") int pageNum,
			@Param("numPerPage") int numPerPage, @Param("..") Supplier obj) {

		return pagerlist(pageNum, numPerPage, obj);
	}

	
	
	public Map<String, Object> pagerlist(int pageNum, int numPerPage,
			Supplier obj) {

		Map<String, Object> map = new HashMap<String, Object>();
		Pager pager = dao().createPager((pageNum < 1) ? 1 : pageNum,
				(numPerPage < 1) ? 20 : numPerPage);
		List<Supplier> uiList = dao().fetchLinks(
				query(bulidQureyCnd(obj), pager), null);
		if (pager != null) {
			pager.setRecordCount(dao()
					.count(Supplier.class, bulidQureyCnd(obj)));
			map.put("pager", pager);
		}
		map.put("o", obj);
		map.put("pagerlist", uiList);
		return map;
	}

	
	
	/**
	 * 新增-
	 * 
	 * @return
	 */
	@At
	public Object add(@Param("..") Supplier obj) {
		try {
			// 设置id

			dao().insert(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK, "Supplier");
		} catch (Throwable e) {

			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 删除-
	 * 
	 * @return
	 */
	@At
	public Object delete(@Param("..") Supplier obj) {
		try {
			dao().delete(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK);
		} catch (Throwable e) {

			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 根据ids删除数据信息
	 * 
	 * @param ids
	 * @param ioc
	 * @return
	 */
	@At
	public Object delByIds(@Param("ids") String ids) {
		try {
			Sql sql = Sqls.create("delete from ERP_Supplier where id in(" + ids
					+ ")");
			dao().execute(sql);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK);
		} catch (Throwable e) {

			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 更新-产品设置
	 * 
	 * @return
	 */
	@At
	public Object update(@Param("..") Supplier obj) {
		try {
			dao().update(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK, "Supplier");
		} catch (Throwable e) {

			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}

	/**
	 * 构建查询条件
	 * 
	 * @param obj
	 * @return
	 */
	private Cnd bulidQureyCnd(Supplier obj) {
		Cnd cnd = null;
		if (obj != null) {
			cnd = Cnd.where("1", "=", 1);
			if (!Strings.isEmpty(obj.getName()))
				cnd.and("name", "=", obj.getName());

		}
		return cnd;
	}
}