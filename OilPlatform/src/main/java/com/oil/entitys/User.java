package com.oil.entitys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * TODO 用户实体.<br>
 * @author Leejean <br>
 * @version 1.0.0 2017年4月9日 下午5:03:47<br>
 * @see 
 * @since JDK 1.7.0
 */
@Entity
@Table(name="t_user")
public class User {

	@Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,columnDefinition="int(11) NOT NULL DEFAULT '0'")
    private Integer age;
    
    @Column(columnDefinition="decimal(15,2) NOT NULL DEFAULT '0.00'")
    private Double height;
    
    @Column(columnDefinition = "timestamp NULL COMMENT '生日'")
    private Date birthday;
    
    @Column(name = "create_time",columnDefinition = "timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间'")
    private Date createTime; 
    
    @Column(name = "update_time",columnDefinition = "timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'")
    private Date updateTime;

    public User(){}

    public User(String name, Integer age, Double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
    
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
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
