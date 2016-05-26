package com.aiyaya.dao.impl;

import com.aiyaya.dao.LoginDao;
import com.aiyaya.domain.Member;
import com.aiyaya.domain.Point;
import com.aiyaya.domain.PointDetail;
import com.aiyaya.domain.SellRecord;
import com.aiyaya.domain.Ware;
import com.jd.common.dao.BaseDao;
import java.util.List;
import java.util.Map;

public class LoginDaoImpl extends BaseDao implements LoginDao {

	@Override
	public String queryPasswordByUsername(String username) {
		String password;
		password = (String)queryForObject("aiyaya.queryPasswordByUsername",username);
		return password;
	}
	
	@Override
	public Integer insertWare(Ware ware){
		Integer result;
		result = (Integer)update("aiyaya.insertWare", ware);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Ware> queryWareInfo(Ware ware){
		return (List<Ware>)queryForList("aiyaya.queryWareInfo", ware);
	}
	
	public Integer deleteWare(String skuId){
		return (Integer)update("aiyaya.deleteWare", skuId);
	}
	
	public Integer updateWare(Ware ware){
		return (Integer)update("aiyaya.updateWare", ware);
	}
	
	public Integer addMember(Member member){
		return (Integer)update("aiyaya.addMember", member);
	}
	
	public Integer deleteMember(String mrCardId){
		return (Integer)update("aiyaya.deleteMember", mrCardId);
	}
	
	public int queryMemberCount(Member member){
		return (Integer)queryForObject("aiyaya.queryMemberCount", member);
	}
	
	public Integer insertSellRecord(SellRecord sellRecord){
		return (Integer)update("aiyaya.insertSellRecord", sellRecord);
	}
	
	@SuppressWarnings("unchecked")
	public List<Member> queryMemberInfo(Member member){
		return (List<Member>)queryForList("aiyaya.queryMemberInfo", member);
	}
	
	public Member queryMemberInfoById(String mrCardId){
		return (Member)queryForObject("aiyaya.queryMemberInfoById", mrCardId);
	}
	
	@SuppressWarnings("unchecked")
	public List<SellRecord> querySellRecordById(String mrCardId){
		return (List<SellRecord>)queryForList("aiyaya.querySellRecordById", mrCardId);
	}
	
	public Integer queryTotalPoint(String mrCardId){
		return (Integer)queryForObject("aiyaya.queryTotalPoint", mrCardId);
	}
	
	public int deleteSellRecord(String sId){
		Integer result = null;
		result = (Integer)update("aiyaya.deleteSellRecord", sId);
		return result == null ? 0 : result;
	}
	
	public int insertPoint(Point point){
		Integer pId = null;
		pId = (Integer)insert("aiyaya.insertPoint", point);
		return pId == null ? 0 : pId;
	}
	
	public int insertPointDetail(PointDetail pointDetail){
		Integer result = null;
		result = (Integer)update("aiyaya.insertPointDetail", pointDetail);
		return result == null ? 0 : result;
	}
	
	public int updatePoint(Map map){
		Integer result = null;
		result = (Integer)update("aiyaya.updatePoint", map);
		return result;
	}

}
