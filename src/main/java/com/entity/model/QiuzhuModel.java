package com.entity.model;

import com.entity.QiuzhuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 求助服务
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QiuzhuModel implements Serializable {
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
     * 求助名字
     */
    private String qiuzhuName;


    /**
     * 求助类型
     */
    private Integer qiuzhuTypes;


    /**
     * 执行时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date zhixingTime;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 求助详情
     */
    private String qiuzhuContent;


    /**
     * 是否处理
     */
    private Integer qiuzhuYesnoTypes;


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
	 * 获取：求助名字
	 */
    public String getQiuzhuName() {
        return qiuzhuName;
    }


    /**
	 * 设置：求助名字
	 */
    public void setQiuzhuName(String qiuzhuName) {
        this.qiuzhuName = qiuzhuName;
    }
    /**
	 * 获取：求助类型
	 */
    public Integer getQiuzhuTypes() {
        return qiuzhuTypes;
    }


    /**
	 * 设置：求助类型
	 */
    public void setQiuzhuTypes(Integer qiuzhuTypes) {
        this.qiuzhuTypes = qiuzhuTypes;
    }
    /**
	 * 获取：执行时间
	 */
    public Date getZhixingTime() {
        return zhixingTime;
    }


    /**
	 * 设置：执行时间
	 */
    public void setZhixingTime(Date zhixingTime) {
        this.zhixingTime = zhixingTime;
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
	 * 获取：求助详情
	 */
    public String getQiuzhuContent() {
        return qiuzhuContent;
    }


    /**
	 * 设置：求助详情
	 */
    public void setQiuzhuContent(String qiuzhuContent) {
        this.qiuzhuContent = qiuzhuContent;
    }
    /**
	 * 获取：是否处理
	 */
    public Integer getQiuzhuYesnoTypes() {
        return qiuzhuYesnoTypes;
    }


    /**
	 * 设置：是否处理
	 */
    public void setQiuzhuYesnoTypes(Integer qiuzhuYesnoTypes) {
        this.qiuzhuYesnoTypes = qiuzhuYesnoTypes;
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
