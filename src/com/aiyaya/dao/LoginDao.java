package com.aiyaya.dao;

import com.aiyaya.domain.Member;
import com.aiyaya.domain.Point;
import com.aiyaya.domain.PointDetail;
import com.aiyaya.domain.SellRecord;
import com.aiyaya.domain.Ware;
import java.util.List;
import java.util.Map;

public interface LoginDao {
	
	public String queryPasswordByUsername(String username);
	
	public Integer insertWare(Ware ware);
	
	public List<Ware> queryWareInfo(Ware ware);
	
	public Integer deleteWare(String skuId);
	
	public Integer updateWare(Ware ware);
	
	public Integer addMember(Member member);
	
	public List<Member> queryMemberInfo(Member member);
	
	public Integer deleteMember(String mrCardId);
	
	public int queryMemberCount(Member member);
	
	public Integer insertSellRecord(SellRecord sellRecord);
	
	public Member queryMemberInfoById(String mrCardId);
	
	public List<SellRecord> querySellRecordById(String mrCardId);
	
	public Integer queryTotalPoint(String mrCardId);
	
	public int deleteSellRecord(String sId);
	
	public int insertPoint(Point point);
	
	public int insertPointDetail(PointDetail pointDetail);
	
	public int updatePoint(Map map);
}
