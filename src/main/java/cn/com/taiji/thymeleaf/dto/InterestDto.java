package cn.com.taiji.thymeleaf.dto;

import java.io.Serializable;

/**
 * InterestDto
 * @author SunJingyan
 * @date 2014年10月23日
 *
 */
public class InterestDto implements  Serializable{
	
	private static final long serialVersionUID = -1289990949847255595L;

	/*兴趣id*/
	private String id;
	
	/*兴趣名称*/
	private String interestName;

	/** get/set方法 Start*/
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInterestName() {
		return interestName;
	}

	public void setInterestName(String interestName) {
		this.interestName = interestName;
	}
	/** get/set方法 End*/
	
	/**不同的构造方法 Start*/
	public InterestDto() {
		super();
	}
	public InterestDto(String id, String interestName) {
		super();
		this.id = id;
		this.interestName = interestName;
	}
	/**不同的构造方法 End*/

	
	
	

}
