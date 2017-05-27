package cn.com.taiji.thymeleaf.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.com.taiji.thymeleaf.dto.InterestDto;
import cn.com.taiji.thymeleaf.dto.UserDto;

/**
 * thymeleaf 样例控制器
 * @author SunJingyan
 * @date 2014年10月13日
 *
 */
@Controller
public class ThymeleafController {
	
	@Inject
	private ObjectMapper objectMapper;
	
	/**
	 * 主页
	 * @return
	 */
	@RequestMapping("/")
	public String homePage(Model model)
	{
		model.addAttribute("welcome", "thymeleaf样例");
		return "thymeleaf/home";
	}
	
	/**
	 * ${  }变量表达式样例
	 * @return
	 */
	@RequestMapping("/var-page")
	public String varPage(Model model,HttpSession session,HttpServletRequest request,
			HttpServletResponse response)
	{
		model.addAttribute("title", "变量表达式样例");
		List<String> testList = new ArrayList<String>();
		String str1 = "1";
		String str2 = "2";
		String str3 = "3";
		testList.add(str1);
		testList.add(str2);
		testList.add(str3);
		model.addAttribute("testList", testList);
		Calendar cal = Calendar.getInstance();
		model.addAttribute("today", cal);
		session.setAttribute("sessionStr", "string in session!");
		request.setAttribute("requestStr", "string request!");
		Locale locale = Locale.getDefault();
		model.addAttribute("locale", locale);
		return "thymeleaf/var";
	}
	
	/**
	 *   *{  }星号表达式样例
	 * @return
	 */
	@RequestMapping("/star-page")
	public String starPage(Model model,HttpSession session)
	{
		model.addAttribute("title", "星号表达式样例");
		UserDto user = new UserDto("1", "xiaoming", "xiaoming@mail.com",null);
		model.addAttribute("user", user);
		session.setAttribute("user", user);
		return "thymeleaf/star";
	}
	
	/**
	 * @{  }链接表达式样例
	 * @return
	 */
	@RequestMapping("/link-page")
	public String linkPage(Model model)
	{
		model.addAttribute("title", "链接表达式样例");
		UserDto user = new UserDto("1", "xiaoming", "xiaoming@mail.com",null);
		model.addAttribute("user", user);
		return "thymeleaf/link";
	}
	
	/**
	 * #{  }消息表达式样例
	 * @return
	 */
	@RequestMapping("/message-page")
	public String messagePage(Model model)
	{
		model.addAttribute("title", "消息表达式样例");
		return "thymeleaf/message";
	}
	
	/**
	 * 跳转至用户详细信息页面
	 * @param id
	 * @param userName
	 * @param email
	 * @param model
	 * @return
	 */
	@RequestMapping("/user-detail-page")
	public String userDetailPage(@RequestParam("id") String id,@RequestParam("userName") String userName,@RequestParam("email") String email, Model model)
	{
		model.addAttribute("title", "用户信息");
		model.addAttribute("id", id);
		model.addAttribute("userName", userName);
		model.addAttribute("email", email);
		return "thymeleaf/user-detail";
	}
	
	/**
	 * th:text/th:utext样例
	 * @return
	 */
	@RequestMapping("/text-page")
	public String textPage(Model model)
	{
		model.addAttribute("title", "th:text/th:utext样例");
		UserDto user = new UserDto("1", "xiaoming", "xiaoming@mail.com",false);
		model.addAttribute("user", user);
		model.addAttribute("onevar", "one");
		model.addAttribute("twovar", "two");
		model.addAttribute("threevar", "three");
		model.addAttribute("textWelcome", "<br>Welcome</br> to our grocery store!");
		return "thymeleaf/text";
	}
	
	/**
	 * 算术运算符样例
	 * @return
	 */
	@RequestMapping("/operator-page")
	public String operatorPage(Model model)
	{
		model.addAttribute("title", "算术运算符样例");
		return "thymeleaf/operator";
	}
	
	/**
	 * 不等运算符样例
	 * @return
	 */
	@RequestMapping("/operator-equal-page")
	public String operatorEqualPage(Model model)
	{
		model.addAttribute("title", "不等运算符样例");
		List<String> testList = new ArrayList<String>();
		String str1 = "str1";
		String str2 = "str2";
		String str3 = "str3";
		testList.add(str1);
		testList.add(str2);
		testList.add(str2);
		testList.add(str3);
		model.addAttribute("list", testList);
		model.addAttribute("execMode", "dev");
		return "thymeleaf/operator-equal";
	}
	/**
	 * 布尔运算符样例
	 * @return
	 */
	@RequestMapping("/operator-boolean-page")
	public String operatorBooleanPage(Model model)
	{
		model.addAttribute("title", "布尔运算符样例");
		List<UserDto> list = new ArrayList<UserDto>();
		UserDto user1 = new UserDto("1", "admin", "admin@test.com.cn", true);
		list.add(user1);
		model.addAttribute("list", list);
		return "thymeleaf/operator-boolean";
	}
	
	/**
	 * 条件表达式样例
	 * @return
	 */
	@RequestMapping("/condition-express-page")
	public String conditionExpressPage(Model model)
	{
		model.addAttribute("title", "条件表达式样例");
		return "thymeleaf/condition-express";
	}
	
	/**
	 * 条件判断样例
	 * @return
	 */
	@RequestMapping("/condition-page")
	public String conditionPage(Model model)
	{
		model.addAttribute("title", "条件判断样例");
		List<String> testList = new ArrayList<String>();
		String str1 = "1";
		String str2 = "2";
		String str3 = "3";
		testList.add(str1);
		testList.add(str2);
		testList.add(str3);
		model.addAttribute("testList", testList);
		return "thymeleaf/condition";
	}
	
	/**
	 * 循环样例
	 * @return
	 */
	@RequestMapping("/iter-page")
	public String iterPage(Model model)
	{
		model.addAttribute("title", "循环样例");
		List<UserDto> list = new ArrayList<UserDto>();
		UserDto user1 = new UserDto("1", "admin", "admin@test.com.cn", true);
		UserDto user2 = new UserDto("2", "test1", "test1@test.com.cn", false);
		UserDto user3 = new UserDto("3", "test2", "test2@test.com.cn", false);
		UserDto user4 = new UserDto("4", "test3", "test3@test.com.cn", false);
		list.add(user1);
		list.add(user2);
		list.add(user3);
		list.add(user4);
		model.addAttribute("list", list);
		Map<String,String> map = new HashMap<String,String>();
		map.put("one", "string1");
		map.put("two", "string2");
		map.put("three", "string3");
		model.addAttribute("map", map);
		String[] array = new String[3];
		array[0]="1";
		array[1]="2";
		array[2]="3";
		model.addAttribute("arrays", array);
		return "thymeleaf/iter";
	}
	
	/**
	 * 设置属性值
	 * @return
	 */
	@RequestMapping("/attr-page")
	public String attrPage(Model model)
	{
		model.addAttribute("title", "设置属性值");
		model.addAttribute("cssStyle", "red");
		return "thymeleaf/attr";
	}
	
	/**
	 * 模板布局
	 * @return
	 */
	@RequestMapping("/layout-page")
	public String layoutPage(Model model)
	{
		model.addAttribute("title", "模板布局样例");
		List<UserDto> list = new ArrayList<UserDto>();
		UserDto user1 = new UserDto("1", "admin", "admin@test.com.cn", true);
		UserDto user2 = new UserDto("2", "test1", "test1@test.com.cn", false);
		UserDto user3 = new UserDto("3", "test2", "test2@test.com.cn", false);
		UserDto user4 = new UserDto("4", "test3", "test3@test.com.cn", false);
		list.add(user1);
		list.add(user2);
		list.add(user3);
		list.add(user4);
		model.addAttribute("list", list);
//		model.addAttribute("condition", );
		return "thymeleaf/layout";
	}
	
	/**
	 * th:with
	 * @return
	 */
	@RequestMapping("/with-page")
	public String withPage(Model model)
	{
		model.addAttribute("title", "th:with");
		List<UserDto> list = new ArrayList<UserDto>();
		UserDto user1 = new UserDto("1", "admin", "admin@test.com.cn", true);
		UserDto user2 = new UserDto("2", "test1", "test1@test.com.cn", false);
		UserDto user3 = new UserDto("3", "test2", "test2@test.com.cn", false);
		UserDto user4 = new UserDto("4", "test3", "test3@test.com.cn", false);
		list.add(user1);
		list.add(user2);
		list.add(user3);
		list.add(user4);
		model.addAttribute("list", list);
		UserDto user = new UserDto("a","0");
		model.addAttribute("user", user);
		List<String> accounts = new ArrayList<String>();
		String a1 = "taiji";
		String a2 = "baidu";
		accounts.add(a1);
		accounts.add(a2);
		model.addAttribute("accounts", accounts);
		return "thymeleaf/with";
	}
	
	/**
	 * 注释
	 * @return
	 */
	@RequestMapping("/comment-page")
	public String commentPage(Model model)
	{
		model.addAttribute("title", "注释样例");
		List<UserDto> list = new ArrayList<UserDto>();
		UserDto user1 = new UserDto("1", "admin", "admin@test.com.cn", true);
		UserDto user2 = new UserDto("2", "test1", "test1@test.com.cn", false);
		UserDto user3 = new UserDto("3", "test2", "test2@test.com.cn", false);
		UserDto user4 = new UserDto("4", "test3", "test3@test.com.cn", false);
		list.add(user1);
		list.add(user2);
		list.add(user3);
		list.add(user4);
		model.addAttribute("list", list);
		return "thymeleaf/comment";
	}
	
	/**
	 * form表单
	 * @return
	 */
	@RequestMapping("/form-list-page")
	public String formListPage(Model model)
	{
		model.addAttribute("title", "用户列表");
		List<UserDto> userList = new ArrayList<UserDto>();
		List<InterestDto> interests1 = new ArrayList<InterestDto>();
		List<InterestDto> interests2 = new ArrayList<InterestDto>();
		List<InterestDto> interests3 = new ArrayList<InterestDto>();
		InterestDto interestDto1 = new InterestDto("1", "跑步");
		InterestDto interestDto2 = new InterestDto("2", "看书");
		InterestDto interestDto3 = new InterestDto("3", "唱歌");
		InterestDto interestDto4 = new InterestDto("4", "跳舞");
		interests1.add(interestDto1);
		interests1.add(interestDto2);
		interests2.add(interestDto3);
		interests2.add(interestDto4);
		interests3.add(interestDto2);
		interests3.add(interestDto3);
		interests3.add(interestDto4);
		Map<String,String> maps1 = new HashMap<String, String>();
		Map<String,String> maps2 = new HashMap<String, String>();
		Map<String,String> maps3 = new HashMap<String, String>();
		maps1.put("maps1_1", "maps1_1");
		maps1.put("maps1_1", "maps1_1");
		maps2.put("maps2_1", "maps2_1");
		maps2.put("maps2_1", "maps2_1");
		maps3.put("maps3_1", "maps3_1");
		maps3.put("maps3_2", "maps3_2");
		maps3.put("maps3_3", "maps3_3");
		UserDto user1 = new UserDto("1", "admin", "admin@test.com.cn", "单位名",true,interests1,maps1);
		UserDto user2 = new UserDto("2", "test1", "test1@test.com.cn","单位名", false,interests2,maps2);
		UserDto user3 = new UserDto("3", "test2", "test2@test.com.cn", "单位名",false,interests3,maps3);
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		model.addAttribute("userList", userList);
		return "thymeleaf/form-list";
	}
	
	/**
	 * 跳转至增加页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/form-add-page")
	public String formAddPage(Model model)
	{
		List<InterestDto> interests = new ArrayList<InterestDto>();
		InterestDto interestDto1 = new InterestDto("10001", "跑步");
		InterestDto interestDto2 = new InterestDto("10002", "看书");
		InterestDto interestDto3 = new InterestDto("10003", "唱歌");
		InterestDto interestDto4 = new InterestDto("10004", "跳舞");
		interests.add(interestDto1);
		interests.add(interestDto2);
		interests.add(interestDto3);
		interests.add(interestDto4);
		model.addAttribute("interests", interests);
		model.addAttribute("dto", new UserDto());
		return "thymeleaf/form-edit";
	}
	
	/**
	 * 新增和修改
	 * @param userDto
	 * @return
	 */
	@RequestMapping("/form-edit")
	public String formEdit(@ModelAttribute("dto") UserDto userDto
//			,@RequestParam("interestIds") String interestIds
			)
	{
		try {
			String userStr = objectMapper.writeValueAsString(userDto);
			System.out.println("userDto:"+userStr);
		} catch (JsonProcessingException e) {
		}
//		System.out.println("interestIds:"+interestIds);
		//调用service方法
		return "form-edit";
	}
	
	/**
	 * 跳转至用户详细（表单）
	 * @param model
	 * @param id
	 * @param userName
	 * @param email
	 * @param company
	 * @return
	 */
	@RequestMapping("/form-detail-page")
	public String formDetailPage(Model model,@RequestParam("id") String id,@RequestParam("userName") String userName,
			@RequestParam("email") String email,@RequestParam("company") String company)
	{
		model.addAttribute("id", id);
		model.addAttribute("userName", userName);
		model.addAttribute("email", email);
		model.addAttribute("company",company);
		return "thymeleaf/form-detail";
	}
	
	

}
