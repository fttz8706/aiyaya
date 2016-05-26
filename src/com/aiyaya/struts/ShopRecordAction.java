package com.aiyaya.struts;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.aiyaya.domain.Member;
import com.aiyaya.domain.SellRecord;
import com.aiyaya.domain.Ware;
import com.aiyaya.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;
import com.aiyaya.manager.Manager;

public class ShopRecordAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 112233L;
	private static final Logger log = Logger.getLogger(ShopRecordAction.class);
	private SellRecord sellRecord;
	private LoginService loginService;
	private String result;
	private Member member;
	private List<SellRecord> sellRecords;
	private String userId;

	public ShopRecordAction(){
		
	}
	
	public String initShopPage(){
		HttpServletRequest context = ServletActionContext.getRequest();
		String mrCardId = context.getParameter("mrCardId");
		if(mrCardId != null){
			this.member = loginService.queryMemberInfoById(mrCardId);
			this.userId = mrCardId;
		}
		
		// 获取积分
		int totalPoint = loginService.queryTotalPoint(mrCardId);
		this.member.setPoint(totalPoint);
		
		this.sellRecords = loginService.querySellRecordById(mrCardId);
		return SUCCESS;
	}
	
	public String initAddShopPage(){
		this.sellRecord = new SellRecord();
		HttpServletRequest context = ServletActionContext.getRequest();
		String mrCardId = context.getParameter("mrCardId");
		
		if(mrCardId != null){
			this.sellRecord.setMrCardId(mrCardId);
		}
		
		this.result = "";
		return SUCCESS;
	}
	
	public String deleteSellRecord(){
		int result = 0;
		HttpServletRequest context = ServletActionContext.getRequest();
		String sId = context.getParameter("sId");
		result = loginService.deleteSellRecord(sId);
		if(result > 0){
			this.userId = this.member.getMrCardId();
			return SUCCESS;
		}
		return "error";
	}
	
	public String queryShopRecord(){
		this.sellRecord = new SellRecord();
		HttpServletRequest context = ServletActionContext.getRequest();
		String mrCardId = context.getParameter("mrCardId");
		
		List<Member> memberList = null;
		try{
			memberList = loginService.queryMemberInfo(new Member(mrCardId));
		}catch(Exception e){
			log.error("mrCardId.queryShopRecord error", e);
		}
		
		this.result = "";
		return SUCCESS;
	}
	
	/**
	 * 添加购物记录
	 * @return
	 */
	public String addShopRecord(){
		this.result = "";
		Ware queryParam = new Ware();
		queryParam.setSkuId(this.sellRecord.getSkuId());
		
		List<Ware> wareInfoList = null;
		try{
			wareInfoList = loginService.queryWareInfo(queryParam);
		}catch(Exception e){
			log.error("ShopRecordAction.addShopRecord.queryWareInfo error!", e);
			this.result = "获取商品信息异常，请稍后再添加购物记录！";
			return SUCCESS;
		}
		
		if(wareInfoList == null || wareInfoList.size() < 1){
			this.result = "没有找到商品编号为【" + this.sellRecord.getSkuId() + "】的商品信息，请确认商品编号是否填写正确！";
			return SUCCESS;
		}
		
		// 设置商品单价和商品名称
		this.sellRecord.setPrice(wareInfoList.get(0).getPrice());
		this.sellRecord.setWareName(wareInfoList.get(0).getWareName());
		this.sellRecord.setTotalMoney(wareInfoList.get(0).getPrice() * this.sellRecord.getNum());
		
		// 入库
		try{
		
			loginService.insertSellRecord(this.sellRecord);
		}catch(Exception e){
			log.error("ShopRecordAction.addShopRecord.insertSellRecord error!", e);
			this.result = "添加购物记录异常，请稍后重试！";
		}
		
		return SUCCESS;
	}

	public SellRecord getSellRecord() {
		return sellRecord;
	}

	public void setSellRecord(SellRecord sellRecord) {
		this.sellRecord = sellRecord;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List<SellRecord> getSellRecords() {
		return sellRecords;
	}

	public void setSellRecords(List<SellRecord> sellRecords) {
		this.sellRecords = sellRecords;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
