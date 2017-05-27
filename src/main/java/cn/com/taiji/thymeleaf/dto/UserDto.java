package cn.com.taiji.thymeleaf.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserDto
 * @author SunJingyan
 * @date 2014年10月14日
 *
 */
public class UserDto implements Serializable{

	private static final long serialVersionUID = -4071716718067394168L;

	/*用户id*/
	private String id;
	
	/*用户名*/
	private String userName;
	
	/*密码*/
	private String password;
	
	/*邮箱*/
	private String email;
	
	/*单位*/
	private String company;
	
	/*是否为管理员*/
	private Boolean isAdmin;
	
	/*兴趣list集合*/
	private List<InterestDto> interests = new ArrayList<InterestDto>();
	
	private String interestIds;
	
	/*Map集合*/
	private Map<String,String> maps = new HashMap<String, String>();


	/** get/set方法 Start*/
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public List<InterestDto> getInterests() {
		return interests;
	}

	public void setInterests(List<InterestDto> interests) {
		this.interests = interests;
	}

	public Map<String, String> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, String> maps) {
		this.maps = maps;
	}
	
	public String getInterestIds() {
		return interestIds;
	}

	public void setInterestIds(String interestIds) {
		this.interestIds = interestIds;
	}
	/** get/set方法 End*/
	

	/**不同的构造方法 Start*/
	public UserDto() {
		super();
	}

	public UserDto(String id, String userName, String email,
			Boolean isAdmin) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.isAdmin = isAdmin;
	}

	public UserDto(String id, String userName, String email, String company,
				Boolean isAdmin, List<InterestDto> interests,
				Map<String, String> maps) 
	{
			super();
			this.id = id;
			this.userName = userName;
			this.email = email;
			this.company = company;
			this.isAdmin = isAdmin;
			this.interests = interests;
			this.maps = maps;
     }
	
	public UserDto(String id, String company) 
	{
			super();
			this.id = id;
			this.company = company;
	}
	/**不同的构造方法 End*/
	
	/**
	 * 是否为管理员
	 * @return
	 */
	public Boolean isAdmin()
	{
		   return this.isAdmin;
	}
	
	
}
