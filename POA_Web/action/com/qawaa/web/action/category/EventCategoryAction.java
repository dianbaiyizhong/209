/**
 *
 */
package com.qawaa.web.action.category;

import java.util.List;

import com.qawaa.data.entity.CategoryEvent;
import com.qawaa.service.CategoryEventService;
import com.qawaa.web.action.BaseAction;

/**
 * @author Ryan  2013-10-9  下午9:48:55
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 舆情事件分类
 */
public class EventCategoryAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 986360437350888621L;
	private CategoryEventService categoryEventService;
	private List<CategoryEvent> categories;
	private Integer total;
	private Long time;
	/**
	 * @return the categoryEventService
	 */
	public CategoryEventService getCategoryEventService() {
		return categoryEventService;
	}
	/**
	 * @param categoryEventService the categoryEventService to set
	 */
	public void setCategoryEventService(CategoryEventService categoryEventService) {
		this.categoryEventService = categoryEventService;
	}
	/**
	 * @return the categories
	 */
	public List<CategoryEvent> getCategories() {
		return categories;
	}
	/**
	 * @param categories the categories to set
	 */
	public void setCategories(List<CategoryEvent> categories) {
		this.categories = categories;
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
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	@Override
	public String execute() throws Exception {
		categories = categoryEventService.loadNormal();
		total = categories.size();
		time = System.currentTimeMillis();
		return super.execute();
	}
	

}
