package com.helios.main.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.helios.main.bean.Result;
import com.helios.user.bean.User;
import com.helios.user.service.UserService;

/**
 * 首页控制器
 * 
 * @author liyu
 */
@Controller
public class MainController extends ApplicationController {
	
	@Autowired
	public UserService userService;
	
	/**
	 * 管理端首页. 
	 */
	@RequestMapping(value = {"/", "index.html"})
	public ModelAndView toIndex(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("main/index");
		modelAndView.addObject("admin", request.getSession().getAttribute("KEY_AUTHOR_SESSION"));
		return modelAndView;
	}
	
	/**
	 * 设置界面 .
	 */
	@RequestMapping(value = "setting.html")
	public ModelAndView toSetting(){
		ModelAndView modelAndView = new ModelAndView("main/setting");
		return modelAndView;
	}
	
	/**
	 * 管理端管理员界面[暂时隐藏].
	 */
	@RequestMapping(value = "manager.html")
	public ModelAndView toManager(){
		ModelAndView modelAndView = new ModelAndView("main/manager");
		return modelAndView;
	}
	
	/**
	 * 管理端开发日志界面.
	 */
	@RequestMapping(value = "logs.html")
	public ModelAndView toLogs(){
		ModelAndView modelAndView = new ModelAndView("main/logs");
		return modelAndView;
	}
	
	/**
	 * 管理端登陆界面.
	 */
	@RequestMapping(value = "login.html")
	public ModelAndView toLogin(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("main/login");
		if(request.getSession().getAttribute("KEY_AUTHOR_SESSION") != null)
			return toIndex(request);
		return modelAndView;
	}
	
	/**
	 * 管理员个人设置页面. 
	 */
	@RequestMapping(value = "profile.html")
	public ModelAndView toProfile(HttpServletRequest request){
		ModelAndView modelAndView = new ModelAndView("main/profile");
		modelAndView.addObject("admin", request.getSession().getAttribute("KEY_AUTHOR_SESSION"));
		return modelAndView;
	}
	
	/**
	 * 检测是否登陆理端.
	 */
	@ResponseBody
	@RequestMapping(value = "islogin.json")
	public Result islogin(HttpServletRequest request){
		Result result = new Result();
		Object obj = request.getSession().getAttribute("KEY_AUTHOR_SESSION");
		if(obj != null && obj instanceof User){
			result.setCode(0);
			result.setMessage(System.currentTimeMillis() + "");
		}else{
			result.setCode(-1);
			result.setMessage("未登录");
		}
		return result;
	}
	
	/**
	 * 登陆管理端.
	 * 
	 * 参数:
	 * username 用户名
	 * password 密码
	 */
	@ResponseBody
	@RequestMapping(value = "login.json")
	public Result login(HttpServletRequest request){
		Result result = new Result();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = userService.get(username, password);
		if(user == null) {
			result.setCode(-1);
			result.setMessage("用户名或密码错误!");
		} else{
			request.getSession().setAttribute("KEY_AUTHOR_SESSION", user);
			result.setCode(0);
			result.setMessage("");
		}
		return result;
	}
	
	/**
	 * 退出管理端.
	 */
	@ResponseBody
	@RequestMapping(value = "logout.json")
	public Result logout(HttpServletRequest request){
		request.getSession().removeAttribute("KEY_AUTHOR_SESSION");
		Result result = new Result();
		result.setCode(0);
		result.setMessage("");
		return result;
	}
	
	/**
	 * 修改管理员信息. 
	 * 
	 * 参数:
	 * username 用户名
	 * realname 姓名
	 * password 密码
	 * image    头像
	 */
	@ResponseBody
	@RequestMapping(value = "update_manager.json")
	public Result update(HttpServletRequest request){
		Result result = new Result();
		
		/* 获取当前登陆的用户*/
		User user = (User) request.getSession().getAttribute("KEY_AUTHOR_SESSION");
		if(user == null){
			result.setCode(-1);
			result.setMessage("登陆失效,请刷新页面!");
			return result;
		}
		
		String username = request.getParameter("username");
		String realname = request.getParameter("realname");
		String password = request.getParameter("password");
		String picture = request.getParameter("picture");
		
		if(StringUtils.trimToNull(username) == null){
			result.setCode(-1);
			result.setMessage("用户名不能为空!");
			return result;
		}
		
		if(StringUtils.trimToNull(realname) == null){
			result.setCode(-1);
			result.setMessage("真实姓名不能为空!");
			return result;
		}
		
		if(StringUtils.trimToNull(password) != null){
			user.setPassword(password);
		}
		
		user.setUsername(username);
		user.setRealname(realname);
		user.setPicture(picture);
		
		boolean bol = userService.update(user);
		if(bol){
			result.setCode(0);
			result.setMessage("");
		}else{
			result.setCode(-1);
			result.setMessage("提交失败");
		}
		return result;
	}
}
