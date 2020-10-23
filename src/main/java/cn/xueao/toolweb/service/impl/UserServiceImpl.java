package cn.xueao.toolweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xueao.toolweb.mapper.UserMapper;
import cn.xueao.toolweb.pojo.User;
import cn.xueao.toolweb.pojo.UserExample;
import cn.xueao.toolweb.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userMapper;

	@Override
	public void add(User user) {
		userMapper.insert(user);
	}

	@Override
	public void delete(User user) {
		userMapper.deleteByPrimaryKey(user.getId());
	}

	@Override
	public void update(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public List<User> list() {
		UserExample example = new UserExample();
		example.setOrderByClause("id desc");
		return userMapper.selectByExample(example);
	}
	@Override
	public User get(long id) {
		
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public User get(String account, String password) {
		UserExample example = new UserExample();
		example.createCriteria().andAccount_numberEqualTo(account).andPasswordEqualTo(password);
		return userMapper.selectByExample(example).get(0);
	}

	@Override
	public boolean isNameExist(String name) {
		UserExample example = new UserExample();
		example.createCriteria().andNameEqualTo(name);
		List<User> user = userMapper.selectByExample(example);
		if (user.isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public boolean isAccountExist(String account) {
		UserExample example = new UserExample();
		example.createCriteria().andAccount_numberEqualTo(account);
		List<User> user = userMapper.selectByExample(example);
		if (user.isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public User getByAccount(String account) {
		UserExample example = new UserExample();
		example.createCriteria().andAccount_numberEqualTo(account);
		return userMapper.selectByExample(example).get(0);
	}


	
}
