package com.ts.wb.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ts.wb.enums.ResultEnum;
import com.ts.wb.exception.CoolException;
import com.ts.wb.model.dao.UserDao;
import com.ts.wb.model.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	@PersistenceContext //注入的是实体管理器,执行持久化操作
    EntityManager entityManager;
	
	public User login(String account, String password, String type) {
		if (StringUtils.isEmpty(type)) {
			type = "1";
		}
		switch (type) {
			case "1":
				return login1(account, password);
			case "2":
				return login2(account, password);
			case "3":
				return login3(account, password);
			default:
				throw new CoolException(ResultEnum.BUSS_ERROR, "登录方式");
			}
	}

	// Query
	public User login1(String account, String password) {
		return userDao.findByCondition(account, password);
	}
	
	// 自定义语句查询
	public User login2(String account, String password) {
		String sql = " SELECT u.* FROM t_User u WHERE u.account = '" + account + "' AND u.password = '" + password + "' ";
		Query query =  entityManager.createNativeQuery(sql);
		
		List objecArraytList = query.getResultList();
		if (objecArraytList.isEmpty() || objecArraytList.size() > 1) {
			return null;
		}
		Object[] obj = (Object[]) objecArraytList.get(0);
        User user = new User();
        user.setId(Long.valueOf(String.valueOf(obj[0])));
        user.setAccount(String.valueOf(obj[1]));
        user.setName(String.valueOf(obj[2]));
        user.setPassword(String.valueOf(obj[3]));
        return user;
	}
	
	// jpa形式
	public User login3(String account, String password) {
		return userDao.findByAccountAndPassword(account, password);
	}
	
	public List<User> list() {
//		userDao.save(user); // 增、改
//		userDao.deleteById(); // 删
		return userDao.findAll(); // 查
		
	}
	
}
