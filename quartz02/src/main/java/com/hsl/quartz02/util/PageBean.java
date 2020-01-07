package com.hsl.quartz02.util;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 分页工具类
 *
 */
public class PageBean {

	private int page = 1;// 页码

	private int rows = 5;// 页大小

	private int total = 0;// 总记录数

	// 保留上一的请求地址
	private String url;
	// 保留上一次请求所携带的参数
	private Map<String, String[]> paMap = new HashMap<>();

	/**
	 * pageBean初始化方法
	 *
	 * @param req
	 */
	public void setRequest(HttpServletRequest req) {
		this.setPage(req.getParameter("page"));
		this.setRows(req.getParameter("rows"));
		this.setPagination(req.getParameter("pagination"));

		this.setUrl(req.getRequestURL().toString());
		this.setPaMap(req.getParameterMap());
	}

	public void setPagination(String pagination) {
		if ("false".equals(pagination)) {
			this.setPagination(false);
		}
	}

	public void setRows(String rows) {
		if (StringUtils.isNotBlank(rows)) {
			this.setRows(Integer.valueOf(rows));
		}
	}

	public void setPage(String page) {
		if (StringUtils.isNotBlank(page)) {
			this.setPage(Integer.valueOf(page));
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, String[]> getPaMap() {
		return paMap;
	}

	public void setPaMap(Map<String, String[]> paMap) {
		this.paMap = paMap;
	}

	private boolean pagination = true;// 是否分页

	public PageBean() {
		super();
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setTotal(String total) {
		this.total = Integer.parseInt(total);
	}

	public boolean isPagination() {
		return pagination;
	}

	public void setPagination(boolean pagination) {
		this.pagination = pagination;
	}

	/**
	 * 获得起始记录的下标
	 *
	 * @return
	 */
	public int getStartIndex() {
		// 1 limit 0,10
		// 2 limit 10,10
		// 3 limit 20,10
		return (this.page - 1) * this.rows;
	}

	@Override
	public String toString() {
		return "PageBean [page=" + page + ", rows=" + rows + ", total=" + total + ", pagination=" + pagination + "]";
	}

	/**
	 * 最大页码
	 *
	 * @return
	 */
	public int getMaxPage() {
		return this.total % this.rows == 0 ? this.total / this.rows : this.total / this.rows + 1;
	}

	/**
	 * 获取下一页
	 *
	 * @return
	 */
	public int getNextPage() {
		return this.page < this.getMaxPage() ? this.page + 1 : this.page;
	}

	/**
	 * 获取上一页
	 *
	 * @return
	 */
	public int getPreviousPage() {
		return this.page > 1 ? this.page - 1 : this.page;
	}

}
