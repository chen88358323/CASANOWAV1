package com.jshop.action.interceptor.impl;

import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringBufferInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.StrutsStatics;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Controller;

import com.jshop.action.UserTAction;
import com.jshop.action.interceptor.UserRolemoduleInterecptor;
import com.jshop.action.tools.BaseTools;
import com.jshop.entity.FunctionM;
import com.jshop.entity.UserT;
import com.jshop.service.UsertService;
import com.jshop.service.impl.UsertServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

@ParentPackage("jshop")
@Controller("authorityLogininterceptor")
public class AuthorityLogininterceptor extends MethodFilterInterceptor {

	public static final String COOKIE_REMEMBER_KEY = "cookieadminid";
	public static final String GOING_TO_URL_KEY = "going_to";
	public boolean authority;
	private UsertService usertService;
	private UserRolemoduleInterecptor userRolemoduleInterecptor;
	private UserTAction userTAction;
	
	public UserTAction getUserTAction() {
		return userTAction;
	}

	public void setUserTAction(UserTAction userTAction) {
		this.userTAction = userTAction;
	}

	public UsertService getUsertService() {
		return usertService;
	}

	public void setUsertService(UsertService usertService) {
		this.usertService = usertService;
	}

	public UserRolemoduleInterecptor getUserRolemoduleInterecptor() {
		return userRolemoduleInterecptor;
	}

	public void setUserRolemoduleInterecptor(UserRolemoduleInterecptor userRolemoduleInterecptor) {
		this.userRolemoduleInterecptor = userRolemoduleInterecptor;
	}


	public boolean isAuthority() {
		return authority;
	}

	public void setAuthority(boolean authority) {
		this.authority = authority;
	}

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		ActionContext actionContext = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST);
		HttpServletResponse response=(HttpServletResponse) actionContext.get(StrutsStatics.HTTP_RESPONSE);
		Map session = actionContext.getSession();
		if ((session != null) && (session.get(BaseTools.BACK_USER_SESSION_KEY) != null)) {
//			String userid=(String) ActionContext.getContext().getSession().get(BaseTools.BACK_USER_SESSION_KEY);
//			if("120100721001".equals(userid)){
//				return invocation.invoke();
//			}
//			//获取post过来的url和actionname
//			
//			String actionname = invocation.getInvocationContext().getName();
//			String referer = request.getHeader("Referer");
//			String ref=referer.substring(referer.lastIndexOf("/")+1);
//			String spref[]=StringUtils.split(ref, "?");
//			
//			//去读取内存中的权限信息和上下文在url和action上做判断
//			List<FunctionM> userfunctionlist = (List<FunctionM>) ActionContext.getContext().getSession().get(BaseTools.USERROLEFUNCTION);
//			for (Iterator it = userfunctionlist.iterator(); it.hasNext();) {
//				FunctionM fm = (FunctionM) it.next();
//				if(fm.getVisiturl().length()>0){
//					if(spref[0].toString().equals(fm.getVisiturl().trim())){
//						return invocation.invoke();
//					}
//				}else{
//					if(fm.getVisitmethodname().length()>0){
//						if(fm.getVisitmethodname().equals(actionname)){
//							return invocation.invoke();
//						}
//					}
//				}
//			}
//			ActionContext.getContext().getSession().put(BaseTools.KEYFORAUTHORITY, "1");
			return invocation.invoke();
		} else {
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (COOKIE_REMEMBER_KEY.equals(cookie.getName())) {
						String value = cookie.getValue();
						if (StringUtils.isNotEmpty(value)) {
							String[] split = value.split("==");
							String userName = split[0];
							String password = split[1];
							try {
								UserT user = new UserT();
								user.setUsername(userName);
								user.setPassword(password);
								user.setState("3");
								user = this.getUsertService().login(user);
								if (user != null) {
									session.put(BaseTools.BACK_USER_SESSION_KEY, user.getUserid());
								} else {
									//setGoingToUrl(session,invocation);
									return "adminlogin";
								}
							} catch (Exception e) {
								//setGoingToUrl(session,invocation);
								return "adminlogin";
							}
						}
					}
				}
			}

		}
		//setGoingToUrl(session,invocation);
		return "adminlogin";
	}

	//	private void setGoingToUrl(Map session,ActionInvocation invocation){
	//		String url="";
	//		String namespace=invocation.getProxy().getNamespace();
	//		if(StringUtils.isNotEmpty(namespace)&&!namespace.equals("/")){
	//			url=url+namespace;
	//		}
	//		String actionName=invocation.getProxy().getActionName();
	//		if(StringUtils.isNotEmpty(actionName)){
	//			url=url+"/"+actionName+".action";
	//		}
	//		session.put(GOING_TO_URL_KEY, url);
	//	}

}
