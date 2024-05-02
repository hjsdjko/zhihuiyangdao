package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 求助服务
 *
 * @author 
 * @email
 */
@TableName("qiuzhu")
public class QiuzhuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public QiuzhuEntity() {

	}

	public QiuzhuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 老人
     */
    @TableField(value = "laoren_id")

    private Integer laorenId;


    /**
     * 求助名字
     */
    @TableField(value = "qiuzhu_name")

    private String qiuzhuName;


    /**
     * 求助类型
     */
    @TableField(value = "qiuzhu_types")

    private Integer qiuzhuTypes;


    /**
     * 执行时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "zhixing_time",fill = FieldFill.UPDATE)

    private Date zhixingTime;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 求助详情
     */
    @TableField(value = "qiuzhu_content")

    private String qiuzhuContent;


    /**
     * 是否处理
     */
    @TableField(value = "qiuzhu_yesno_types")

    private Integer qiuzhuYesnoTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：老人
	 */
    public Integer getLaorenId() {
        return laorenId;
    }


    /**
	 * 获取：老人
	 */

    public void setLaorenId(Integer laorenId) {
        this.laorenId = laorenId;
    }
    /**
	 * 设置：求助名字
	 */
    public String getQiuzhuName() {
        return qiuzhuName;
    }


    /**
	 * 获取：求助名字
	 */

    public void setQiuzhuName(String qiuzhuName) {
        this.qiuzhuName = qiuzhuName;
    }
    /**
	 * 设置：求助类型
	 */
    public Integer getQiuzhuTypes() {
        return qiuzhuTypes;
    }


    /**
	 * 获取：求助类型
	 */

    public void setQiuzhuTypes(Integer qiuzhuTypes) {
        this.qiuzhuTypes = qiuzhuTypes;
    }
    /**
	 * 设置：执行时间
	 */
    public Date getZhixingTime() {
        return zhixingTime;
    }


    /**
	 * 获取：执行时间
	 */

    public void setZhixingTime(Date zhixingTime) {
        this.zhixingTime = zhixingTime;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：求助详情
	 */
    public String getQiuzhuContent() {
        return qiuzhuContent;
    }


    /**
	 * 获取：求助详情
	 */

    public void setQiuzhuContent(String qiuzhuContent) {
        this.qiuzhuContent = qiuzhuContent;
    }
    /**
	 * 设置：是否处理
	 */
    public Integer getQiuzhuYesnoTypes() {
        return qiuzhuYesnoTypes;
    }


    /**
	 * 获取：是否处理
	 */

    public void setQiuzhuYesnoTypes(Integer qiuzhuYesnoTypes) {
        this.qiuzhuYesnoTypes = qiuzhuYesnoTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Qiuzhu{" +
            "id=" + id +
            ", laorenId=" + laorenId +
            ", qiuzhuName=" + qiuzhuName +
            ", qiuzhuTypes=" + qiuzhuTypes +
            ", zhixingTime=" + zhixingTime +
            ", insertTime=" + insertTime +
            ", qiuzhuContent=" + qiuzhuContent +
            ", qiuzhuYesnoTypes=" + qiuzhuYesnoTypes +
            ", createTime=" + createTime +
        "}";
    }
}
