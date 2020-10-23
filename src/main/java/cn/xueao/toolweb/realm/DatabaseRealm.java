package cn.xueao.toolweb.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import cn.xueao.toolweb.pojo.User;
import cn.xueao.toolweb.service.UserService;

public class DatabaseRealm extends AuthorizingRealm{
	
	@Autowired
	UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		UsernamePasswordToken t = (UsernamePasswordToken) token;
		String account = t.getPrincipal().toString();
		
		User user = userService.getByAccount(account);
		String passwordInDB = user.getPassword();
		String salt = user.getSalt();
		
		SimpleAuthenticationInfo a = new SimpleAuthenticationInfo(account, passwordInDB,
				ByteSource.Util.bytes(salt), getName());
		return a;
	}
	
}
