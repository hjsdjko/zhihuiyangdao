package com.entity.model;

import com.entity.FuwujiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 服务记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FuwujiluModel implements Serializable {
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
     * 服务人员
     */
    private Integer jigoushequId;


    /**
     * 服务时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date fuwuTime;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 服务详情
     */
    private String fuwujiluContent;


    /**
     * 评价星级类型
     */
    private Integer fuwujiluTypes;


    /**
     * 评价详情
     */
    private String pingjiaContent;


    /**
     * 评价时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date updateTime;


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
	 * 获取：服务人员
	 */
    public Integer getJigoushequId() {
        return jigoushequId;
    }


    /**
	 * 设置：服务人员
	 */
    public void setJigoushequId(Integer jigoushequId) {
        this.jigoushequId = jigoushequId;
    }
    /**
	 * 获取：服务时间
	 */
    public Date getFuwuTime() {
        return fuwuTime;
    }


    /**
	 * 设置：服务时间
	 */
    public void setFuwuTime(Date fuwuTime) {
        this.fuwuTime = fuwuTime;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：服务详情
	 */
    public String getFuwujiluContent() {
        return fuwujiluContent;
    }


    /**
	 * 设置：服务详情
	 */
    public void setFuwujiluContent(String fuwujiluContent) {
        this.fuwujiluContent = fuwujiluContent;
    }
    /**
	 * 获取：评价星级类型
	 */
    public Integer getFuwujiluTypes() {
        return fuwujiluTypes;
    }


    /**
	 * 设置：评价星级类型
	 */
    public void setFuwujiluTypes(Integer fuwujiluTypes) {
        this.fuwujiluTypes = fuwujiluTypes;
    }
    /**
	 * 获取：评价详情
	 */
    public String getPingjiaContent() {
        return pingjiaContent;
    }


    /**
	 * 设置：评价详情
	 */
    public void setPingjiaContent(String pingjiaContent) {
        this.pingjiaContent = pingjiaContent;
    }
    /**
	 * 获取：评价时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 设置：评价时间
	 */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
