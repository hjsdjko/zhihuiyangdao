package com.entity.model;

import com.entity.LaorenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 老人
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LaorenModel implements Serializable {
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
     * 老人姓名
     */
    private String laorenName;


    /**
     * 老人手机号
     */
    private String laorenPhone;


    /**
     * 老人身份证号
     */
    private String laorenIdNumber;


    /**
     * 照片
     */
    private String yonghuPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 是否独居
     */
    private Integer dujuTypes;


    /**
     * 是否残疾
     */
    private Integer canjiTypes;


    /**
     * 养老方式类型
     */
    private Integer yanglaofanghsiTypes;


    /**
     * 慢性疾病
     */
    private String jibingContent;


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
	 * 获取：老人姓名
	 */
    public String getLaorenName() {
        return laorenName;
    }


    /**
	 * 设置：老人姓名
	 */
    public void setLaorenName(String laorenName) {
        this.laorenName = laorenName;
    }
    /**
	 * 获取：老人手机号
	 */
    public String getLaorenPhone() {
        return laorenPhone;
    }


    /**
	 * 设置：老人手机号
	 */
    public void setLaorenPhone(String laorenPhone) {
        this.laorenPhone = laorenPhone;
    }
    /**
	 * 获取：老人身份证号
	 */
    public String getLaorenIdNumber() {
        return laorenIdNumber;
    }


    /**
	 * 设置：老人身份证号
	 */
    public void setLaorenIdNumber(String laorenIdNumber) {
        this.laorenIdNumber = laorenIdNumber;
    }
    /**
	 * 获取：照片
	 */
    public String getYonghuPhoto() {
        return yonghuPhoto;
    }


    /**
	 * 设置：照片
	 */
    public void setYonghuPhoto(String yonghuPhoto) {
        this.yonghuPhoto = yonghuPhoto;
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
	 * 获取：是否独居
	 */
    public Integer getDujuTypes() {
        return dujuTypes;
    }


    /**
	 * 设置：是否独居
	 */
    public void setDujuTypes(Integer dujuTypes) {
        this.dujuTypes = dujuTypes;
    }
    /**
	 * 获取：是否残疾
	 */
    public Integer getCanjiTypes() {
        return canjiTypes;
    }


    /**
	 * 设置：是否残疾
	 */
    public void setCanjiTypes(Integer canjiTypes) {
        this.canjiTypes = canjiTypes;
    }
    /**
	 * 获取：养老方式类型
	 */
    public Integer getYanglaofanghsiTypes() {
        return yanglaofanghsiTypes;
    }


    /**
	 * 设置：养老方式类型
	 */
    public void setYanglaofanghsiTypes(Integer yanglaofanghsiTypes) {
        this.yanglaofanghsiTypes = yanglaofanghsiTypes;
    }
    /**
	 * 获取：慢性疾病
	 */
    public String getJibingContent() {
        return jibingContent;
    }


    /**
	 * 设置：慢性疾病
	 */
    public void setJibingContent(String jibingContent) {
        this.jibingContent = jibingContent;
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
