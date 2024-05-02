package com.entity.model;

import com.entity.SuifangjiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 随访记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SuifangjiluModel implements Serializable {
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
     * 随访人员
     */
    private Integer jigoushequId;


    /**
     * 随访时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 随访详情
     */
    private String suifangjiluContent;


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
	 * 获取：随访人员
	 */
    public Integer getJigoushequId() {
        return jigoushequId;
    }


    /**
	 * 设置：随访人员
	 */
    public void setJigoushequId(Integer jigoushequId) {
        this.jigoushequId = jigoushequId;
    }
    /**
	 * 获取：随访时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：随访时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：随访详情
	 */
    public String getSuifangjiluContent() {
        return suifangjiluContent;
    }


    /**
	 * 设置：随访详情
	 */
    public void setSuifangjiluContent(String suifangjiluContent) {
        this.suifangjiluContent = suifangjiluContent;
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
