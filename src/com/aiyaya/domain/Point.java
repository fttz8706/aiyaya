package com.aiyaya.domain;

import java.util.List;

/**
 * 会员积分
 * @author YJM
 *
 */

public class Point {
	
	/**
	 * 积分表自增主键ID
	 */
	private int pId;
	
	/**
	 * 会员卡号
	 */
	private String mrCardId;
	
	/**
	 * 总积分
	 */
	private int totalPoint;
	
	/**
	 * 积分兑换明细
	 */
	private List<PointDetail> pointDetails;

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getMrCardId() {
		return mrCardId;
	}

	public void setMrCardId(String mrCardId) {
		this.mrCardId = mrCardId;
	}

	public int getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(int totalPoint) {
		this.totalPoint = totalPoint;
	}

	public List<PointDetail> getPointDetails() {
		return pointDetails;
	}

	public void setPointDetails(List<PointDetail> pointDetails) {
		this.pointDetails = pointDetails;
	}
}
