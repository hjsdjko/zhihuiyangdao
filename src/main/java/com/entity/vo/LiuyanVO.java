package com.entity.vo;

import com.entity.LiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 留言
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("liuyan")
public class LiuyanVO implements Serializable {
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
     * 留言名称
     */

    @TableField(value = "liuyan_name")
    private String liuyanName;


    /**
     * 留言类型
     */

    @TableField(value = "liuyan_types")
    private Integer liuyanTypes;


    /**
     * 留言时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 留言详情
     */

    @TableField(value = "liuyan_content")
    private String liuyanContent;


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
	 * 设置：留言名称
	 */
    public String getLiuyanName() {
        return liuyanName;
    }


    /**
	 * 获取：留言名称
	 */

    public void setLiuyanName(String liuyanName) {
        this.liuyanName = liuyanName;
    }
    /**
	 * 设置：留言类型
	 */
    public Integer getLiuyanTypes() {
        return liuyanTypes;
    }


    /**
	 * 获取：留言类型
	 */

    public void setLiuyanTypes(Integer liuyanTypes) {
        this.liuyanTypes = liuyanTypes;
    }
    /**
	 * 设置：留言时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：留言时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：留言详情
	 */
    public String getLiuyanContent() {
        return liuyanContent;
    }


    /**
	 * 获取：留言详情
	 */

    public void setLiuyanContent(String liuyanContent) {
        this.liuyanContent = liuyanContent;
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
