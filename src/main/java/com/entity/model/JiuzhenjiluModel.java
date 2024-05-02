package com.entity.model;

import com.entity.JiuzhenjiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 就诊记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiuzhenjiluModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 老人
     */
    private Integer laorenId;


    /**
     * 就诊类型
     */
    private Integer jiuzhenjiluTypes;


    /**
     * 就诊医院
     */
    private String yiyuan;


    /**
     * 就诊医生
     */
    private String yisheng;


    /**
     * 医生手机号
     */
    private String yishengPhone;


    /**
     * 就诊时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 就诊详情
     */
    private String jiuzhenjiluContent;


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
	 * 获取：就诊类型
	 */
    public Integer getJiuzhenjiluTypes() {
        return jiuzhenjiluTypes;
    }


    /**
	 * 设置：就诊类型
	 */
    public void setJiuzhenjiluTypes(Integer jiuzhenjiluTypes) {
        this.jiuzhenjiluTypes = jiuzhenjiluTypes;
    }
    /**
	 * 获取：就诊医院
	 */
    public String getYiyuan() {
        return yiyuan;
    }


    /**
	 * 设置：就诊医院
	 */
    public void setYiyuan(String yiyuan) {
        this.yiyuan = yiyuan;
    }
    /**
	 * 获取：就诊医生
	 */
    public String getYisheng() {
        return yisheng;
    }


    /**
	 * 设置：就诊医生
	 */
    public void setYisheng(String yisheng) {
        this.yisheng = yisheng;
    }
    /**
	 * 获取：医生手机号
	 */
    public String getYishengPhone() {
        return yishengPhone;
    }


    /**
	 * 设置：医生手机号
	 */
    public void setYishengPhone(String yishengPhone) {
        this.yishengPhone = yishengPhone;
    }
    /**
	 * 获取：就诊时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：就诊时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：就诊详情
	 */
    public String getJiuzhenjiluContent() {
        return jiuzhenjiluContent;
    }


    /**
	 * 设置：就诊详情
	 */
    public void setJiuzhenjiluContent(String jiuzhenjiluContent) {
        this.jiuzhenjiluContent = jiuzhenjiluContent;
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
