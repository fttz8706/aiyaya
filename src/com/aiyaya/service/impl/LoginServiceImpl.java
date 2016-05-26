package com.aiyaya.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.aiyaya.dao.LoginDao;
import com.aiyaya.domain.Member;
import com.aiyaya.domain.Point;
import com.aiyaya.domain.SellRecord;
import com.aiyaya.domain.Ware;
import com.aiyaya.manager.Manager;
import com.aiyaya.service.LoginService;

public class LoginServiceImpl implements LoginService {

	private Manager manager;
	private LoginDao loginDao;
	private Log log = LogFactory.getLog(LoginServiceImpl.class);
	
	@Override
	public String queryPasswordByUsername(String username) {
		return loginDao.queryPasswordByUsername(username);
	}
	
	@Override
	public Integer insertWare(Ware ware){
		return loginDao.insertWare(ware);
	}
	
	public List<Ware> queryWareInfo(Ware ware){
		return loginDao.queryWareInfo(ware);
	}
	
	public Integer deleteWare(String skuId){
		return loginDao.deleteWare(skuId);
	}
	
	public Integer updateWare(Ware ware){
		return loginDao.updateWare(ware);
	}
	
	public Integer addMember(Member member){
		return loginDao.addMember(member);
	}
	
	public List<Member> queryMemberInfo(Member member){
		List<Member> members = null;
		try{
			members = loginDao.queryMemberInfo(member);
		}catch(Exception e){
			log.error("LoginServiceImpl.queryMemberInfo is error!", e);
		}
		return members;
	}
	
	public Member queryMemberInfoById(String mrCardId){
		Member member = null;
		try{
			member = loginDao.queryMemberInfoById(mrCardId);
		}catch(Exception e){
			log.error("LoginServiceImpl.queryMemberInfoById is error!", e);
		}
		return member;
	}
	
	public List<SellRecord> querySellRecordById(String mrCardId){
		List<SellRecord> result = null;
		try{
			result = loginDao.querySellRecordById(mrCardId);
		}catch(Exception e){
			log.error("LoginServiceImpl.querySellRecordById is error!", e);
		}
		return result;
	}
	
	public int queryTotalPoint(String mrCardId){
		Integer result = null;
		try{
			result = loginDao.queryTotalPoint(mrCardId);
		}catch(Exception e){
			log.error("LoginServiceImpl.queryTotalPoint is error!", e);
		}
		return result == null ? 0 : result;
	}
	
	public int deleteSellRecord(String sId){
		int result = 0;
		try{
			result = loginDao.deleteSellRecord(sId);
		}catch(Exception e){
			log.error("LoginServiceImpl.deleteSellRecord is error!", e);
		}
		return result;
	}
	
	public int insertPoint(Point point){
		int pId = 0;
		try{
			pId = loginDao.insertPoint(point);
		}catch(Exception e){
			log.error("LoginServiceImpl.insertPoint is error!", e);
		}
		return pId;
	}

	public Integer deleteMember(String mrCardId){
		return loginDao.deleteMember(mrCardId);
	}
	
	public int queryMemberCount(Member member){
		return loginDao.queryMemberCount(member);
	}
	
	public void insertSellRecord(SellRecord sellRecord){
		//return loginDao.insertSellRecord(sellRecord);
		manager.insertSellRecord(sellRecord);
	}
	
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

}
