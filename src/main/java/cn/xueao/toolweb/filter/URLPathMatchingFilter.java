package cn.xueao.toolweb.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.PathMatchingFilter;

class URLPathMatchingFilter extends PathMatchingFilter{
	protected boolean onPreHandle(ServletRequest request, ServletResponse response, 
			Object mappedValue) throws Exception {
		return true;
	}
}
