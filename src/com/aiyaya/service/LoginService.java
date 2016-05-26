package com.aiyaya.service;

import java.util.List;

import com.aiyaya.domain.Member;
import com.aiyaya.domain.Point;
import com.aiyaya.domain.SellRecord;
import com.aiyaya.domain.Ware;

public interface LoginService {
	
	public String queryPasswordByUsername(String username);
	
	public Integer insertWare(Ware ware);
	
	public List<Ware> queryWareInfo(Ware ware);
	
	public Integer deleteWare(String skuId);
	
	public Integer addMember(Member member);
	
	public Integer updateWare(Ware ware);
	
	public List<Member> queryMemberInfo(Member member);
	
	public Integer deleteMember(String mrCardId);
	
	public int queryMemberCount(Member member);
	
	public void insertSellRecord(SellRecord sellRecord);
	
	public Member queryMemberInfoById(String mrCardId);
	
	public List<SellRecord> querySellRecordById(String mrCardId);
	
	public int queryTotalPoint(String mrCardId);
	
	public int deleteSellRecord(String sId);
	
	public int insertPoint(Point point);
	
	

}
