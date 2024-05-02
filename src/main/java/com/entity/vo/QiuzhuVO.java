package com.entity.vo;

import com.entity.QiuzhuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 求助服务
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("qiuzhu")
public class QiuzhuVO implements Serializable {
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

    @TableField(value = "zhixing_time")
    private Date zhixingTime;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
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

}
