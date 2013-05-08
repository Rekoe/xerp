package com.nutzside.common.domain.grid;

import java.util.List;

import org.nutz.json.Json;

/**
 * @author Administrator
 * 标准格式的Grid所需的后台响应数据
 */
public class StandardgridResData extends GridResData {
	/**
	* 记录
	*/
	private List<StandardgridResDataRow> rows;

	/**
	 * 获取指定字段的值的数组
	 * @param columnIndex
	 * @return
	 */
	public String[] getArrValueOfTheColumn(int columnIndex) {
		if (rows == null || rows.size() == 0) {
			return null;
		}
		int length = rows.size();
		String[] arrValue = new String[length];
		for (int i = 0; i < length; i++) {
			arrValue[i] = rows.get(i).getCell().get(columnIndex);
		}
		return arrValue;
	}

	public String toString() {
		return Json.toJson(this);
	}

	public List<StandardgridResDataRow> getRows() {
		return rows;
	}

	public void setRows(List<StandardgridResDataRow> rows) {
		this.rows = rows;
	}
}