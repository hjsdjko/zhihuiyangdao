package com.entity.vo;

import com.entity.JiarenEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 家人
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiaren")
public class JiarenVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 老人
     */

    @TableField(value = "laoren_id")
    private Integer laorenId;


    /**
     * 家人姓名
     */

    @TableField(value = "jiaren_name")
    private String jiarenName;


    /**
     * 家人手机号
     */

    @TableField(value = "jiaren_phone")
    private String jiarenPhone;


    /**
     * 家人身份证号
     */

    @TableField(value = "jiaren_id_number")
    private String jiarenIdNumber;


    /**
     * 照片
     */

    @TableField(value = "jiaren_photo")
    private String jiarenPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
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
	 * 设置：家人姓名
	 */
    public String getJiarenName() {
        return jiarenName;
    }


    /**
	 * 获取：家人姓名
	 */

    public void setJiarenName(String jiarenName) {
        this.jiarenName = jiarenName;
    }
    /**
	 * 设置：家人手机号
	 */
    public String getJiarenPhone() {
        return jiarenPhone;
    }


    /**
	 * 获取：家人手机号
	 */

    public void setJiarenPhone(String jiarenPhone) {
        this.jiarenPhone = jiarenPhone;
    }
    /**
	 * 设置：家人身份证号
	 */
    public String getJiarenIdNumber() {
        return jiarenIdNumber;
    }


    /**
	 * 获取：家人身份证号
	 */

    public void setJiarenIdNumber(String jiarenIdNumber) {
        this.jiarenIdNumber = jiarenIdNumber;
    }
    /**
	 * 设置：照片
	 */
    public String getJiarenPhoto() {
        return jiarenPhoto;
    }


    /**
	 * 获取：照片
	 */

    public void setJiarenPhoto(String jiarenPhoto) {
        this.jiarenPhoto = jiarenPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
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
