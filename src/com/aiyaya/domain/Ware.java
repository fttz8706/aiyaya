package com.aiyaya.domain;

import java.util.Date;

/**
 * 商品信息实体类
 * @author YJM
 *
 */
public class Ware {

	/**
	 * 商品编号
	 */
	private String skuId;
	
	/**
	 * 商品名称
	 */
	private String wareName;
	
	/**
	 * 商品价格
	 */
	private Float price;
	
	/**
	 * 商品备注
	 */
	private String remark;
	
	/**
	 * 创建时间
	 */
	private Date created;
	
	/**
	 * 最后修改时间
	 */
	private Date modified;
	
	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getWareName() {
		return wareName;
	}

	public void setWareName(String wareName) {
		this.wareName = wareName;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

}
