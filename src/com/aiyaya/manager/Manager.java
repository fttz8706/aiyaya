package com.aiyaya.manager;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.aiyaya.dao.LoginDao;
import com.aiyaya.domain.Point;
import com.aiyaya.domain.SellRecord;
import com.jd.common.manager.BaseManager;

public class Manager extends BaseManager {
	
	private final static Log log = LogFactory.getLog(Manager.class);
	private LoginDao loginDao;
	
	public void insertSellRecord(final SellRecord sellRecord){
		
		TransactionTemplate template = getDataSourceTransactionManager();
		try{
			template.execute(new TransactionCallbackWithoutResult(){
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					loginDao.insertSellRecord(sellRecord);
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("mrCardId", sellRecord.getMrCardId());
					map.put("totalPoint", (int)Float.parseFloat(String.valueOf((sellRecord.getTotalMoney()))));
					Point point = bulidPointBean(sellRecord);
					if(loginDao.updatePoint(map) < 1){
						loginDao.insertPoint(point);
					}
				}
			});
		}catch(Exception e){
			log.error("manager.insertSellRecord is error!", e);
		}
	}
	
	private Point bulidPointBean(SellRecord sellRecord){
		Point point = new Point();
		point.setMrCardId(sellRecord.getMrCardId());
		point.setTotalPoint((int)Float.parseFloat(String.valueOf((sellRecord.getTotalMoney()))));
		return point;
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

}
