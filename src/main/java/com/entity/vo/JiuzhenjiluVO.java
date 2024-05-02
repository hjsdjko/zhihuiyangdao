package com.entity.vo;

import com.entity.JiuzhenjiluEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 就诊记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiuzhenjilu")
public class JiuzhenjiluVO implements Serializable {
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

    @TableField(value = "insert_time")
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

}
