package com.aiyaya.domain;

import java.util.Date;


/**
 * 会员信息实体类
 * @author YJM
 *
 */
public class Member extends PaginationBase {
	
	/**
	 * 会员卡号
	 */
	private String mrCardId;
	
	/**
	 * 手机号
	 */
	private String phone;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 级别
	 */
	private String grade;
	
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 生日
	 */
	private Date birthday;
	
	/**
	 * 皮肤类型
	 */
	private String skinType;
	
	/**
	 * QQ号码
	 */
	private String qq;
	
	/**
	 * 电子邮件
	 */
	private String email;
	
	/**
	 * 推荐人
	 */
	private String recommender;
	
	/**
	 * 推荐人手机号码
	 */
	private String recommenderPhone;
	
	/**
	 * 建议
	 */
	private String suggest;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 有效性标志
	 */
	private int yn;
	
	/**
	 * 积分
	 */
	private int point;
	
	public Member(){
		
	}
	
	public Member(String mrCardId){
		this.mrCardId = mrCardId;
	}


	public String getMrCardId() {
		return mrCardId;
	}

	public void setMrCardId(String mrCardId) {
		this.mrCardId = mrCardId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		/*SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		this.birthday = format.format(birthday);*/
		this.birthday = birthday;
	}

	public String getSkinType() {
		return skinType;
	}

	public void setSkinType(String skinType) {
		this.skinType = skinType;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRecommender() {
		return recommender;
	}

	public void setRecommender(String recommender) {
		this.recommender = recommender;
	}

	public String getRecommenderPhone() {
		return recommenderPhone;
	}

	public void setRecommenderPhone(String recommenderPhone) {
		this.recommenderPhone = recommenderPhone;
	}

	public String getSuggest() {
		return suggest;
	}

	public void setSuggest(String suggest) {
		this.suggest = suggest;
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

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

}
