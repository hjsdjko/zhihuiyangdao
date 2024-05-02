package com.entity.vo;

import com.entity.SuifangjiluEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 随访记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("suifangjilu")
public class SuifangjiluVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
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

    @TableField(value = "create_time")
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

}
