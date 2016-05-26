package com.aiyaya.domain;

import java.util.Date;

/**
 * 会员积分兑换明细
 * @author YJM
 *
 */

public class PointDetail {
	
	/**
	 * 积分表自增主键
	 */
	private int pId;
	
	/**
	 * 兑换的积分数量
	 */
	private int exchangePoint;
	
	/**
	 * 兑换日期
	 */
	private Date exchangeDate;

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getExchangePoint() {
		return exchangePoint;
	}

	public void setExchangePoint(int exchangePoint) {
		this.exchangePoint = exchangePoint;
	}

	public Date getExchangeDate() {
		return exchangeDate;
	}

	public void setExchangeDate(Date exchangeDate) {
		this.exchangeDate = exchangeDate;
	}

}
