package com.aiyaya.struts;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.aiyaya.domain.Ware;
import com.aiyaya.service.LoginService;
import com.aiyaya.util.EncodeConvertUtil;

public class WareAction extends ActionSupport{
	
	private Log log = LogFactory.getLog(WareAction.class);
	private Ware ware;
	private LoginService loginService;
	private String FORWARD = null;
	private String result;
	private String queryWareCondition;
	private List<Ware> wareList;
	private String updateResult; //用于更新表单的结果返回
	private String updatePrice; //用于存储编辑价格时的值
	private String addPrice; //用于存储新增商品时的价格值
	
	/**
	 * 用于新增商品信息操作
	 * @return
	 */
	public String doTask(){
		int result = 0;
		
		if(null == ware){
			return SUCCESS;
		}
		
		//参数校验
		if("".equals(ware.getSkuId()) || "".equals(ware.getWareName()) || "".equals(this.addPrice)){
			this.result = "商品编号、名称和价格不能为空！";
			return SUCCESS;
		}
		
		//校验价格字段
		try{
			this.ware.setPrice(Float.valueOf(this.addPrice));
		} catch(NumberFormatException e){
			this.result = "商品价格输入有误，不能为  " + this.addPrice + " ！请重新输入.";
			this.ware.setPrice(null);
			return SUCCESS;
		}
		
		//价格不能小于零
		if(this.ware.getPrice() < 0){
			this.result = "价格不能小于零！请重新输入。";
			this.ware.setPrice(null);
			return SUCCESS;
		}
		
		//执行插入数据库操作
		try{
			result = loginService.insertWare(ware);
		}catch(Exception e){
			//重复插入操作
			if(e.getMessage().indexOf("for key 'PRIMARY") > 0){
				this.result = "商品编号【" + ware.getSkuId() + "】已经存在，请勿重复添加！";
			}else{
				this.result = "保存商品信息时发生异常，请稍后重试！";
			}

			return SUCCESS;
		}finally{
			FORWARD = "success";
		}
		
		this.result = "成功保存" + result + "条商品记录！";
		
		return FORWARD;
	}
	
	/**
	 * 查询商品信息
	 * @return
	 */
	public String queryWare(){
		
		if(null == ware){
			return SUCCESS;
		}
		
		//查询商品信息
		try{
			this.wareList = loginService.queryWareInfo(ware);
		} catch (Exception e){
			this.result = "查询商品信息时发生异常，请稍后重试！";
		} finally{
			this.FORWARD = SUCCESS;
		}
		
		return FORWARD;
	} 
	
	/**
	 * 删除商品记录
	 * @return
	 */
	public String deleteWare(){
		int result;
		int index = -1;
		String deleteSkuId = ServletActionContext.getRequest().getParameter("deleteSkuId");
		try{
			result = loginService.deleteWare(deleteSkuId);
			
			//获取当前删除的sku对应skuList列表的索引
			for(int i = 0; i < this.wareList.size(); i++){
				if(deleteSkuId.equals(this.wareList.get(i).getSkuId().toString())){
					index = i;
					break;
				}
			}
			this.result = "成功删除商品编号为" + deleteSkuId + "的商品记录！";
		}catch(Exception ex){
			this.result = "删除商品编号为" + deleteSkuId + "的商品时发生异常，请稍后再试！";
			return SUCCESS;
		}
		
		//从skuList中移除当前删除了的sku，页面不再显示删除了的sku
		this.wareList.remove(index);
		
		return SUCCESS;
	}
	
	//编辑商品之前的页面初始化
	public String initEditWare(){
		
		//从url中获取参数值
		String editSkuId = ServletActionContext.getRequest().getParameter("editSkuId");		
		String editWareName = ServletActionContext.getRequest().getParameter("editWareName");		
		String editPrice = ServletActionContext.getRequest().getParameter("editPrice");
		String editRemark = ServletActionContext.getRequest().getParameter("editRemark");	
		
		/**
		 * 编码转换
		 * TODO
		 * 开发环境取消注释
		 * 生产环境注释掉
		 */
		editSkuId = EncodeConvertUtil.ISOToUTF(editSkuId);
		editWareName = EncodeConvertUtil.ISOToUTF(editWareName);
		editPrice = EncodeConvertUtil.ISOToUTF(editPrice);
		editRemark = EncodeConvertUtil.ISOToUTF(editRemark);
		
		//参数值set到ware对象中
		this.ware.setSkuId(editSkuId);
		this.ware.setWareName(editWareName);
		this.ware.setPrice(Float.valueOf(editPrice));
		this.ware.setRemark(editRemark);
		
		return SUCCESS;
	}
	
	
	public String editWare(){
		int result;
		
		//校验价格字段输入是否合法
		try{
			this.ware.setPrice(Float.valueOf(updatePrice));
		} catch(NumberFormatException e) {
			this.updateResult = "单价设置有误，不能为 " + updatePrice +" ！请重新输入。";
			this.ware.setPrice(null);
			return SUCCESS;
		}
		
		//价格不能小于零
		if(Float.valueOf(this.updatePrice) < 0){
			this.updateResult = "单价不能小于零！请重新输入。";
			this.ware.setPrice(null);
			return SUCCESS;
		}
		
		try{
			result = loginService.updateWare(this.ware);
		} catch(Exception e) {
			this.updateResult = "更新商品编号为" + ware.getSkuId() + "的商品异常，请稍后再试！";
			e.printStackTrace();
			return SUCCESS;
		}
		
		this.updateResult = "成功更新商品编号为" + ware.getSkuId() + "的商品信息！";
		
		return SUCCESS;
	}

	public Ware getWare() {
		return ware;
	}

	public void setWare(Ware ware) {
		this.ware = ware;
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

	public String getQueryWareCondition() {
		return queryWareCondition;
	}

	public void setQueryWareCondition(String queryWareCondition) {
		this.queryWareCondition = queryWareCondition;
	}

	public List<Ware> getWareList() {
		return wareList;
	}

	public void setWareList(List<Ware> wareList) {
		this.wareList = wareList;
	}

	public String getUpdateResult() {
		return updateResult;
	}

	public void setUpdateResult(String updateResult) {
		this.updateResult = updateResult;
	}

	public String getUpdatePrice() {
		return updatePrice;
	}

	public void setUpdatePrice(String updatePrice) {
		this.updatePrice = updatePrice;
	}

	public String getAddPrice() {
		return addPrice;
	}

	public void setAddPrice(String addPrice) {
		this.addPrice = addPrice;
	}
}
