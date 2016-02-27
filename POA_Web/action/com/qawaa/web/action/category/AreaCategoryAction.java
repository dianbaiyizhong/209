/**
 *
 */
package com.qawaa.web.action.category;

import java.util.List;

import com.qawaa.data.entity.CategoryArea;
import com.qawaa.service.CategoryAreaService;
import com.qawaa.web.action.BaseAction;

/**
 * @author Ryan  2013-10-9  下午11:15:11
 * @company 杭州千瓦通信科技有限公司
 * @address 中国杭州西溪路525号浙江大学科技园A楼西区522-523 
 * @tel 0571-87788256
 * @fax 0571-87788253
 * @home www.kw-cc.com   www.qawaa.com
 * @comment 获取地区信息
 */
public class AreaCategoryAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9028718702903632319L;
	private CategoryAreaService categoryAreaService;
	private List<CategoryArea> areas;
	private Integer total;
	private Long time;
	/**
	 * @return the categoryAreaService
	 */
	public CategoryAreaService getCategoryAreaService() {
		return categoryAreaService;
	}
	/**
	 * @param categoryAreaService the categoryAreaService to set
	 */
	public void setCategoryAreaService(CategoryAreaService categoryAreaService) {
		this.categoryAreaService = categoryAreaService;
	}
	/**
	 * @return the areas
	 */
	public List<CategoryArea> getAreas() {
		return areas;
	}
	/**
	 * @param areas the areas to set
	 */
	public void setAreas(List<CategoryArea> areas) {
		this.areas = areas;
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
		areas = categoryAreaService.loadNormal();
		total = areas.size();
		time = System.currentTimeMillis();
		return SUCCESS;
	}
	

}
