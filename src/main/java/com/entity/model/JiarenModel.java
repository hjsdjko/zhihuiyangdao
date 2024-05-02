package com.entity.model;

import com.entity.JiarenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 家人
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiarenModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 老人
     */
    private Integer laorenId;


    /**
     * 家人姓名
     */
    private String jiarenName;


    /**
     * 家人手机号
     */
    private String jiarenPhone;


    /**
     * 家人身份证号
     */
    private String jiarenIdNumber;


    /**
     * 照片
     */
    private String jiarenPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：老人
	 */
    public Integer getLaorenId() {
        return laorenId;
    }


    /**
	 * 设置：老人
	 */
    public void setLaorenId(Integer laorenId) {
        this.laorenId = laorenId;
    }
    /**
	 * 获取：家人姓名
	 */
    public String getJiarenName() {
        return jiarenName;
    }


    /**
	 * 设置：家人姓名
	 */
    public void setJiarenName(String jiarenName) {
        this.jiarenName = jiarenName;
    }
    /**
	 * 获取：家人手机号
	 */
    public String getJiarenPhone() {
        return jiarenPhone;
    }


    /**
	 * 设置：家人手机号
	 */
    public void setJiarenPhone(String jiarenPhone) {
        this.jiarenPhone = jiarenPhone;
    }
    /**
	 * 获取：家人身份证号
	 */
    public String getJiarenIdNumber() {
        return jiarenIdNumber;
    }


    /**
	 * 设置：家人身份证号
	 */
    public void setJiarenIdNumber(String jiarenIdNumber) {
        this.jiarenIdNumber = jiarenIdNumber;
    }
    /**
	 * 获取：照片
	 */
    public String getJiarenPhoto() {
        return jiarenPhoto;
    }


    /**
	 * 设置：照片
	 */
    public void setJiarenPhoto(String jiarenPhoto) {
        this.jiarenPhoto = jiarenPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
