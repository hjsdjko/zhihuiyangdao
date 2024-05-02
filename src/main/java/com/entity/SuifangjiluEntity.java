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
 * 随访记录
 *
 * @author 
 * @email
 */
@TableName("suifangjilu")
public class SuifangjiluEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public SuifangjiluEntity() {

	}

	public SuifangjiluEntity(T t) {
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
     * 随访人员
     */
    @TableField(value = "jigoushequ_id")

    private Integer jigoushequId;


    /**
     * 随访时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 随访详情
     */
    @TableField(value = "suifangjilu_content")

    private String suifangjiluContent;


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
	 * 设置：随访人员
	 */
    public Integer getJigoushequId() {
        return jigoushequId;
    }


    /**
	 * 获取：随访人员
	 */

    public void setJigoushequId(Integer jigoushequId) {
        this.jigoushequId = jigoushequId;
    }
    /**
	 * 设置：随访时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：随访时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：随访详情
	 */
    public String getSuifangjiluContent() {
        return suifangjiluContent;
    }


    /**
	 * 获取：随访详情
	 */

    public void setSuifangjiluContent(String suifangjiluContent) {
        this.suifangjiluContent = suifangjiluContent;
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
        return "Suifangjilu{" +
            "id=" + id +
            ", laorenId=" + laorenId +
            ", jigoushequId=" + jigoushequId +
            ", insertTime=" + insertTime +
            ", suifangjiluContent=" + suifangjiluContent +
            ", createTime=" + createTime +
        "}";
    }
}
