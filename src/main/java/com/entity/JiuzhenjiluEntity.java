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
 * 就诊记录
 *
 * @author 
 * @email
 */
@TableName("jiuzhenjilu")
public class JiuzhenjiluEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiuzhenjiluEntity() {

	}

	public JiuzhenjiluEntity(T t) {
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
     * 就诊类型
     */
    @TableField(value = "jiuzhenjilu_types")

    private Integer jiuzhenjiluTypes;


    /**
     * 就诊医院
     */
    @TableField(value = "yiyuan")

    private String yiyuan;


    /**
     * 就诊医生
     */
    @TableField(value = "yisheng")

    private String yisheng;


    /**
     * 医生手机号
     */
    @TableField(value = "yisheng_phone")

    private String yishengPhone;


    /**
     * 就诊时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 就诊详情
     */
    @TableField(value = "jiuzhenjilu_content")

    private String jiuzhenjiluContent;


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
	 * 设置：就诊类型
	 */
    public Integer getJiuzhenjiluTypes() {
        return jiuzhenjiluTypes;
    }


    /**
	 * 获取：就诊类型
	 */

    public void setJiuzhenjiluTypes(Integer jiuzhenjiluTypes) {
        this.jiuzhenjiluTypes = jiuzhenjiluTypes;
    }
    /**
	 * 设置：就诊医院
	 */
    public String getYiyuan() {
        return yiyuan;
    }


    /**
	 * 获取：就诊医院
	 */

    public void setYiyuan(String yiyuan) {
        this.yiyuan = yiyuan;
    }
    /**
	 * 设置：就诊医生
	 */
    public String getYisheng() {
        return yisheng;
    }


    /**
	 * 获取：就诊医生
	 */

    public void setYisheng(String yisheng) {
        this.yisheng = yisheng;
    }
    /**
	 * 设置：医生手机号
	 */
    public String getYishengPhone() {
        return yishengPhone;
    }


    /**
	 * 获取：医生手机号
	 */

    public void setYishengPhone(String yishengPhone) {
        this.yishengPhone = yishengPhone;
    }
    /**
	 * 设置：就诊时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：就诊时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：就诊详情
	 */
    public String getJiuzhenjiluContent() {
        return jiuzhenjiluContent;
    }


    /**
	 * 获取：就诊详情
	 */

    public void setJiuzhenjiluContent(String jiuzhenjiluContent) {
        this.jiuzhenjiluContent = jiuzhenjiluContent;
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
        return "Jiuzhenjilu{" +
            "id=" + id +
            ", laorenId=" + laorenId +
            ", jiuzhenjiluTypes=" + jiuzhenjiluTypes +
            ", yiyuan=" + yiyuan +
            ", yisheng=" + yisheng +
            ", yishengPhone=" + yishengPhone +
            ", insertTime=" + insertTime +
            ", jiuzhenjiluContent=" + jiuzhenjiluContent +
            ", createTime=" + createTime +
        "}";
    }
}
