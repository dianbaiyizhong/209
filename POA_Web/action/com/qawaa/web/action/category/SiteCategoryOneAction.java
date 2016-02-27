/**
 *
 */
package com.qawaa.web.action.category;

import java.util.List;

import com.qawaa.data.entity.CategorySiteOne;
import com.qawaa.service.CategorySiteOneService;
import com.qawaa.web.action.BaseAction;

/**
 * @author Ryan  2013-10-7  下午8:10:08
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 
 */
public class SiteCategoryOneAction extends BaseAction {
	private CategorySiteOneService categorySiteOneService;
	private List<CategorySiteOne> class1es;
	private Integer total;
	private Long time;
	/**
	 * @return the categorySiteOneService
	 */
	public CategorySiteOneService getCategorySiteOneService() {
		return categorySiteOneService;
	}

	/**
	 * @param categorySiteOneService the categorySiteOneService to set
	 */
	public void setCategorySiteOneService(CategorySiteOneService categorySiteOneService) {
		this.categorySiteOneService = categorySiteOneService;
	}


	/**
	 * @return the class1es
	 */
	public List<CategorySiteOne> getClass1es() {
		return class1es;
	}

	/**
	 * @param class1es the class1es to set
	 */
	public void setClass1es(List<CategorySiteOne> class1es) {
		this.class1es = class1es;
	}

	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return the time
	 */
	public Long getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Long time) {
		this.time = time;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 7976754678934826507L;

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		this.class1es = categorySiteOneService.loadAll();
		this.total = class1es.size();
		time = System.currentTimeMillis();
		return SUCCESS;
	}
	

}
