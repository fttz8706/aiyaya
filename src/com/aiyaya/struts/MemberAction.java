package com.aiyaya.struts;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.aiyaya.domain.DataType;
import com.aiyaya.domain.Member;
import com.aiyaya.service.LoginService;
import com.aiyaya.util.EncodeConvertUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import javax.servlet.ServletRequest;


/**
 * 会员信息操作
 * @author YJM
 *
 */
public class MemberAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Log log = LogFactory.getLog(MemberAction.class);
	private LoginService loginService;
	private Member member;
	private String addMemberResult; //新增会员信息结果
	private String updateMemberResult; //更新会员信息结果
	private String deleteMemberResult; //删除会员信息结果
	private List<Member> memberList; //会员信息列表
/*	private boolean goAhead; //用户是否点击下一页
	private boolean goBack; //用户是否点击上一页
	*/
	/**
	 * 新增会员
	 * @return
	 */
	public String addMember(){
		this.addMemberResult = "";
		
		int result = 0;
		try{
			result = loginService.addMember(this.member);
		} catch (Exception e) {
			if(e.getMessage().indexOf("for key 'PRIMARY") > 0){
				this.addMemberResult = "会员卡号【" + this.member.getMrCardId() + "】已经存在，请勿重复添加！";
				return SUCCESS;
			}
			log.error("MemberAction.addMember.error", e);
			this.addMemberResult = "添加会员信息时异常，请稍后重试！";
			return SUCCESS;
		}
		if(result > 0){
			this.addMemberResult = "成功添加" + result + "条会员信息。";
		}
			
		return SUCCESS;
	}
	
	/**
	 * 更新会员
	 * @return
	 */
	public String updateMember(){
		return SUCCESS;
	}
	
	/**
	 * 删除会员
	 * @return
	 */
	public String deleteMember(){
		String mrCardId_del = ServletActionContext.getRequest().getParameter("mrCardId");
		int result = 0;
		try{
			result = loginService.deleteMember(mrCardId_del);
		} catch(Exception e) {
			log.error("MemberAction.deleteMember::error", e);
		}
		
		if(result > 0){
			for(int i = 0; i < this.memberList.size(); i++){
				if(mrCardId_del.equals(this.memberList.get(i).getMrCardId())){
					this.memberList.remove(i);
					break;
				}
			}
		}
		
		return SUCCESS;
	}
	
	/**
	 * 查询会员信息
	 * @return
	 */
	public String queryMember(){
		if(this.member == null){
			this.member = new Member();
			this.member.setObjCount(0);
		}
		
		// 查询的是有效的数据
		this.member.setYn(DataType.EFFECTIVE.getDataType());
		
		// name熟悉从前台传到后台的时候乱码，需要转码
		// 生产环境注释
		/*if(!"".equals(this.member.getName())){
			this.member.setName(EncodeConvertUtil.ISOToUTF(this.member.getName()));
		}*/
		
		int memberCount = 0;
		try{
			memberCount = loginService.queryMemberCount(this.member);
		} catch(Exception e) {
			log.error("MemberAction.queryMemberCount.error", e);
			return SUCCESS;
		}
		
		// 设置总记录数
		this.member.setObjCount(memberCount);
		
		// 初始化分页参数
		this.member.reset();
		
		// mySql使用limit分页时索引是从0开始的，所以把member的pageIndx值减一
		this.member.setBeginIdex(this.member.getBeginIdex() - 1);
		
		try{
			this.memberList = loginService.queryMemberInfo(this.member);
		}catch(Exception e){
			log.error("MemberAction.queryMember.error", e);
		}finally{
			this.member.setBeginIdex(this.member.getBeginIdex() + 1);
		}

		return SUCCESS;
	}
	
	/**
	 * 查询会员，为分页查询用
	 * @return
	 */
	public String queryMemberForPagination(){
		
		// 查询的是有效的数据
		/*this.member.setYn(DataType.EFFECTIVE.getDataType());
		
		int memberCount = 0;
		try{
			memberCount = loginService.queryMemberCount(this.member);
		} catch(Exception e) {
			log.error("MemberAction.queryMemberCount.error", e);
			return SUCCESS;
		}
		
		// 设置总记录数
		this.member.setObjCount(memberCount);*/
		
		// 获取用户是选择“上一页”还是“下一页”
		boolean goAhead = "true".equals(ServletActionContext.getRequest().getParameter("goAhead"));;
		boolean goBack = "true".equals(ServletActionContext.getRequest().getParameter("goBack"));;
		
		// 设置页面大小，需要判断用户是点击“上一页”还是“下一页”
		if(goAhead && !this.member.isLastPage()){
			this.member.setPageIndex(this.member.getPageIndex() + 1);
		}
		if(goBack && !this.member.isFirstPage()){
			this.member.setPageIndex(this.member.getPageIndex() - 1);
		}
		
		// mySql使用limit分页时索引是从0开始的，所以把member的pageIndx值减一
		this.member.setBeginIdex(this.member.getBeginIdex() - 1);
		
		try{
			this.memberList = loginService.queryMemberInfo(this.member);
		}catch(Exception e){
			log.error("MemberAction.queryMember.error", e);
		}finally{
			this.member.setBeginIdex(this.member.getBeginIdex() + 1);
		}

		return SUCCESS;
	}
	
	
	public String initPage(){
		this.memberList = null;
		this.member = null;
		return SUCCESS;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getAddMemberResult() {
		return addMemberResult;
	}

	public void setAddMemberResult(String addMemberResult) {
		this.addMemberResult = addMemberResult;
	}

	public String getUpdateMemberResult() {
		return updateMemberResult;
	}

	public void setUpdateMemberResult(String updateMemberResult) {
		this.updateMemberResult = updateMemberResult;
	}

	public String getDeleteMemberResult() {
		return deleteMemberResult;
	}

	public void setDeleteMemberResult(String deleteMemberResult) {
		this.deleteMemberResult = deleteMemberResult;
	}

	public void setLoginService(LoginService service) {
		this.loginService = service;
	}

	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}

	/*public boolean isGoAhead() {
		return goAhead;
	}

	public void setGoAhead(boolean goAhead) {
		this.goAhead = goAhead;
	}

	public boolean isGoBack() {
		return goBack;
	}

	public void setGoBack(boolean goBack) {
		this.goBack = goBack;
	}*/



}
