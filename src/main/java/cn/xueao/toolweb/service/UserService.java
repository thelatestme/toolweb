package cn.xueao.toolweb.service;

import java.util.List;

import cn.xueao.toolweb.pojo.User;

public interface UserService {
	
	public void add(User user);
	
	public void delete(User user);
	
	public void update(User user);
	
	public List<User> list();
	
	public User get(long id);
	
	public User getByAccount(String account);
	
	public User get(String account,String password);
	
	public boolean isNameExist(String name);
	
	public boolean isAccountExist(String account);
}
