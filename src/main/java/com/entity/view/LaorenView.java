package com.entity.view;

import com.entity.LaorenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 老人
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("laoren")
public class LaorenView extends LaorenEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 性别的值
		*/
		private String sexValue;
		/**
		* 是否独居的值
		*/
		private String dujuValue;
		/**
		* 是否残疾的值
		*/
		private String canjiValue;
		/**
		* 养老方式类型的值
		*/
		private String yanglaofanghsiValue;



	public LaorenView() {

	}

	public LaorenView(LaorenEntity laorenEntity) {
		try {
			BeanUtils.copyProperties(this, laorenEntity);
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














}
