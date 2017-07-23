package com.tgb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tgb.model.Result;
import com.tgb.model.User;
import com.tgb.service.UserService;

@Controller
@RequestMapping("/user")
@SuppressWarnings("deprecation")
public class UserController {
	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(value = "/getAll", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object getAll(HttpServletRequest request) {
		Result result = new Result();
		try {
			List<User> list = userService.getAll();
			result.setErrorCode(0);
			result.setErrorInfo("获取列表成功");
			result.setResult(list);
		} catch (Exception e) {
			result.setErrorCode(100);
			result.setErrorInfo("获取列表失败");
			result.setResult(e.getMessage());
		}

		return result;
	}

	@ResponseBody
	@RequestMapping(value = "/getById", method = { RequestMethod.GET,
			RequestMethod.POST })
	public Object getById(HttpServletRequest request) {
		Result result = new Result();
		try {
			String id = request.getParameter("id");
			Assert.notNull(id);
			User user = userService.getById(id);
			result.setErrorCode(0);
			result.setErrorInfo("获取成功");
			if (user != null)
				result.setResult(user);
			else
				result.setResult("查无此对象");
		} catch (Exception e) {
			result.setErrorCode(101);
			result.setErrorInfo("获取失败");
			result.setResult(e.getMessage());
		}

		return result;
	}

	@RequestMapping(value = "/add", method = { RequestMethod.POST })
	@ResponseBody
	public Object add(HttpServletRequest request) {

		Result result = new Result();
		try {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			Assert.notNull(name);
			Assert.notNull(address);
			User user = new User();
			user.setName(name);
			user.setAddress(address);
			userService.save(user);

			result.setErrorCode(0);
			result.setErrorInfo("添加成功");
			result.setResult(user);
		} catch (Exception e) {
			result.setErrorCode(103);
			result.setErrorInfo("添加失败");
			result.setResult(e.getMessage());
		}

		return result;
	}

	@RequestMapping(value = "/update", method = { RequestMethod.PUT })
	@ResponseBody
	public Object update(HttpServletRequest request) {

		Result result = new Result();
		try {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			Assert.notNull(id);
			Assert.notNull(name);
			Assert.notNull(address);

			User user = new User();
			user.setId(Integer.parseInt(id));
			user.setName(name);
			user.setAddress(address);
			userService.update(user);

			result.setErrorCode(0);
			result.setErrorInfo("修改成功");
			result.setResult(user);
		} catch (Exception e) {
			result.setErrorCode(104);
			result.setErrorInfo("修改失败");
			result.setResult(e.getMessage());
		}

		return result;
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE })
	@ResponseBody
	public Object delete(HttpServletRequest request) {

		Result result = new Result();
		try {
			String id = request.getParameter("id");
			Assert.notNull(id);
			userService.delete(id);
			result.setErrorCode(0);
			result.setErrorInfo("删除成功");
			result.setResult(id);
		} catch (Exception e) {
			result.setErrorCode(105);
			result.setErrorInfo("删除失败");
			result.setResult(e.getMessage());
		}

		return result;
	}

}
