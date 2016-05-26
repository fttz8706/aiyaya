package com.aiyaya.domain;

/**
 * 销售记录实体类
 * @author YJM
 *
 */
public class SellRecord {
	
	/**
	 * id,自增列
	 */
	private int sId;
	
	/**
	 * 会员卡号
	 */
	private String mrCardId;
	
	/**
	 * 商品编号
	 */
	private String skuId;
	
	/**
	 * 商品名称
	 */
	private String wareName;
	
	/**
	 * 价格
	 */
	private float price;
	
	/**
	 * 数量
	 */
	private int num;
	
	/**
	 * 总金额
	 */
	private float totalMoney;
	
	/**
	 * 购买日期
	 */
	private String date;
	
	private int yn;
	
	/**
	 * 备注
	 */
	private String remark;

	public int getsId() {
		return sId;
	}
	
	public int getSId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}
	
	public void setSId(int sId) {
		this.sId = sId;
	}

	public String getMrCardId() {
		return mrCardId;
	}

	public void setMrCardId(String mrCardId) {
		this.mrCardId = mrCardId;
	}

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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public float getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(float totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getYn() {
		return yn;
	}

	public void setYn(int yn) {
		this.yn = yn;
	}
	
}
