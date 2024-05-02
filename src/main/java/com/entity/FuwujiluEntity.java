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
 * 服务记录
 *
 * @author 
 * @email
 */
@TableName("fuwujilu")
public class FuwujiluEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public FuwujiluEntity() {

	}

	public FuwujiluEntity(T t) {
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
     * 服务人员
     */
    @TableField(value = "jigoushequ_id")

    private Integer jigoushequId;


    /**
     * 服务时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "fuwu_time",fill = FieldFill.UPDATE)

    private Date fuwuTime;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 服务详情
     */
    @TableField(value = "fuwujilu_content")

    private String fuwujiluContent;


    /**
     * 评价星级类型
     */
    @TableField(value = "fuwujilu_types")

    private Integer fuwujiluTypes;


    /**
     * 评价详情
     */
    @TableField(value = "pingjia_content")

    private String pingjiaContent;


    /**
     * 评价时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "update_time",fill = FieldFill.UPDATE)

    private Date updateTime;


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
	 * 设置：服务人员
	 */
    public Integer getJigoushequId() {
        return jigoushequId;
    }


    /**
	 * 获取：服务人员
	 */

    public void setJigoushequId(Integer jigoushequId) {
        this.jigoushequId = jigoushequId;
    }
    /**
	 * 设置：服务时间
	 */
    public Date getFuwuTime() {
        return fuwuTime;
    }


    /**
	 * 获取：服务时间
	 */

    public void setFuwuTime(Date fuwuTime) {
        this.fuwuTime = fuwuTime;
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
	 * 设置：服务详情
	 */
    public String getFuwujiluContent() {
        return fuwujiluContent;
    }


    /**
	 * 获取：服务详情
	 */

    public void setFuwujiluContent(String fuwujiluContent) {
        this.fuwujiluContent = fuwujiluContent;
    }
    /**
	 * 设置：评价星级类型
	 */
    public Integer getFuwujiluTypes() {
        return fuwujiluTypes;
    }


    /**
	 * 获取：评价星级类型
	 */

    public void setFuwujiluTypes(Integer fuwujiluTypes) {
        this.fuwujiluTypes = fuwujiluTypes;
    }
    /**
	 * 设置：评价详情
	 */
    public String getPingjiaContent() {
        return pingjiaContent;
    }


    /**
	 * 获取：评价详情
	 */

    public void setPingjiaContent(String pingjiaContent) {
        this.pingjiaContent = pingjiaContent;
    }
    /**
	 * 设置：评价时间
	 */
    public Date getUpdateTime() {
        return updateTime;
    }


    /**
	 * 获取：评价时间
	 */

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        return "Fuwujilu{" +
            "id=" + id +
            ", laorenId=" + laorenId +
            ", jigoushequId=" + jigoushequId +
            ", fuwuTime=" + fuwuTime +
            ", insertTime=" + insertTime +
            ", fuwujiluContent=" + fuwujiluContent +
            ", fuwujiluTypes=" + fuwujiluTypes +
            ", pingjiaContent=" + pingjiaContent +
            ", updateTime=" + updateTime +
            ", createTime=" + createTime +
        "}";
    }
}
