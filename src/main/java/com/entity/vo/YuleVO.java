package com.entity.vo;

import com.entity.YuleEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 娱乐活动
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yule")
public class YuleVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 活动名称
     */

    @TableField(value = "yule_name")
    private String yuleName;


    /**
     * 活动类型
     */

    @TableField(value = "yule_types")
    private Integer yuleTypes;


    /**
     * 通知时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 活动详情
     */

    @TableField(value = "yule_content")
    private String yuleContent;


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
	 * 设置：活动名称
	 */
    public String getYuleName() {
        return yuleName;
    }


    /**
	 * 获取：活动名称
	 */

    public void setYuleName(String yuleName) {
        this.yuleName = yuleName;
    }
    /**
	 * 设置：活动类型
	 */
    public Integer getYuleTypes() {
        return yuleTypes;
    }


    /**
	 * 获取：活动类型
	 */

    public void setYuleTypes(Integer yuleTypes) {
        this.yuleTypes = yuleTypes;
    }
    /**
	 * 设置：通知时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：通知时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：活动详情
	 */
    public String getYuleContent() {
        return yuleContent;
    }


    /**
	 * 获取：活动详情
	 */

    public void setYuleContent(String yuleContent) {
        this.yuleContent = yuleContent;
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
