package com.entity.view;

import com.entity.JiarenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 家人
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jiaren")
public class JiarenView extends JiarenEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 性别的值
		*/
		private String sexValue;



		//级联表 laoren
			/**
			* 老人姓名
			*/
			private String laorenName;
			/**
			* 老人手机号
			*/
			private String laorenPhone;
			/**
			* 老人身份证号
			*/
			private String laorenIdNumber;
			/**
			* 照片
			*/
			private String yonghuPhoto;
			/**
			* 是否独居
			*/
			private Integer dujuTypes;
				/**
				* 是否独居的值
				*/
				private String dujuValue;
			/**
			* 是否残疾
			*/
			private Integer canjiTypes;
				/**
				* 是否残疾的值
				*/
				private String canjiValue;
			/**
			* 养老方式类型
			*/
			private Integer yanglaofanghsiTypes;
				/**
				* 养老方式类型的值
				*/
				private String yanglaofanghsiValue;
			/**
			* 慢性疾病
			*/
			private String jibingContent;

	public JiarenView() {

	}

	public JiarenView(JiarenEntity jiarenEntity) {
		try {
			BeanUtils.copyProperties(this, jiarenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 性别的值
			*/
			public String getSexValue() {
				return sexValue;
			}
			/**
			* 设置： 性别的值
			*/
			public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
			}
















				//级联表的get和set laoren
					/**
					* 获取： 老人姓名
					*/
					public String getLaorenName() {
						return laorenName;
					}
					/**
					* 设置： 老人姓名
					*/
					public void setLaorenName(String laorenName) {
						this.laorenName = laorenName;
					}
					/**
					* 获取： 老人手机号
					*/
					public String getLaorenPhone() {
						return laorenPhone;
					}
					/**
					* 设置： 老人手机号
					*/
					public void setLaorenPhone(String laorenPhone) {
						this.laorenPhone = laorenPhone;
					}
					/**
					* 获取： 老人身份证号
					*/
					public String getLaorenIdNumber() {
						return laorenIdNumber;
					}
					/**
					* 设置： 老人身份证号
					*/
					public void setLaorenIdNumber(String laorenIdNumber) {
						this.laorenIdNumber = laorenIdNumber;
					}
					/**
					* 获取： 照片
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 照片
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 是否独居
					*/
					public Integer getDujuTypes() {
						return dujuTypes;
					}
					/**
					* 设置： 是否独居
					*/
					public void setDujuTypes(Integer dujuTypes) {
						this.dujuTypes = dujuTypes;
					}


						/**
						* 获取： 是否独居的值
						*/
						public String getDujuValue() {
							return dujuValue;
						}
						/**
						* 设置： 是否独居的值
						*/
						public void setDujuValue(String dujuValue) {
							this.dujuValue = dujuValue;
						}
					/**
					* 获取： 是否残疾
					*/
					public Integer getCanjiTypes() {
						return canjiTypes;
					}
					/**
					* 设置： 是否残疾
					*/
					public void setCanjiTypes(Integer canjiTypes) {
						this.canjiTypes = canjiTypes;
					}


						/**
						* 获取： 是否残疾的值
						*/
						public String getCanjiValue() {
							return canjiValue;
						}
						/**
						* 设置： 是否残疾的值
						*/
						public void setCanjiValue(String canjiValue) {
							this.canjiValue = canjiValue;
						}
					/**
					* 获取： 养老方式类型
					*/
					public Integer getYanglaofanghsiTypes() {
						return yanglaofanghsiTypes;
					}
					/**
					* 设置： 养老方式类型
					*/
					public void setYanglaofanghsiTypes(Integer yanglaofanghsiTypes) {
						this.yanglaofanghsiTypes = yanglaofanghsiTypes;
					}


						/**
						* 获取： 养老方式类型的值
						*/
						public String getYanglaofanghsiValue() {
							return yanglaofanghsiValue;
						}
						/**
						* 设置： 养老方式类型的值
						*/
						public void setYanglaofanghsiValue(String yanglaofanghsiValue) {
							this.yanglaofanghsiValue = yanglaofanghsiValue;
						}
					/**
					* 获取： 慢性疾病
					*/
					public String getJibingContent() {
						return jibingContent;
					}
					/**
					* 设置： 慢性疾病
					*/
					public void setJibingContent(String jibingContent) {
						this.jibingContent = jibingContent;
					}










}
