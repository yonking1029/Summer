package com.oil.models;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * TODO UserVo.<br>
 * @author Leejean <br>
 * @version 1.0.0 2017年4月9日 下午5:03:35<br>
 * @see 
 * @since JDK 1.7.0
 */
public class UserVo {

    @ApiModelProperty("用户id")  
    private Long id;

    @ApiModelProperty("姓名") 
    private String name;
    
    @ApiModelProperty("年龄")
    private Integer age;
    
    @ApiModelProperty("用户身高") 
    private Double height;
    
    @ApiModelProperty("用户生日") 
    private Date birthday;
    
    @ApiModelProperty("创建") 
    private Date createTime; 
    
    @ApiModelProperty("最后修改时间")
    private Date updateTime;

    public UserVo(){}

    public UserVo(String name, Integer age, Double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
    

    public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString() {
    	return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
