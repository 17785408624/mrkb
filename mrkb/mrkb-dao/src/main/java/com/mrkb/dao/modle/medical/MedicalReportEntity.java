package com.mrkb.dao.modle.medical;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MedicalReportEntity extends MedicalEntity{
	private int medical_report_id;//主键
	private int user_basics_id;//用户id
	private Long report_add_date;//添加时间 
	private Long report_edit_date;//修改时间
	
	public MedicalReportEntity() {
		super();
	}
	public MedicalReportEntity(MedicalEntity medicalEntity) {
		super();
		Class thisClz=this.getClass();
		Class<? extends MedicalEntity> medicalEntityClz=medicalEntity.getClass();
		Field[] fields = medicalEntityClz.getDeclaredFields();//得到加载对象的所有属性
		Field[] fieldsThis = thisClz.getDeclaredFields();
		for(Field f:fields){
			StringBuffer methodNameGet=new StringBuffer("get"+f.getName()).replace(3, 4,String.valueOf(f.getName().charAt(0)).toUpperCase());
			Method meGet = null;
			try {
				meGet=medicalEntityClz.getMethod(methodNameGet.toString());
			} catch (SecurityException | NoSuchMethodException 
					|IllegalArgumentException  e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(meGet==null){
				continue;
			}
			Object result = null;
			try {
			     result=meGet.invoke(medicalEntity);
			} catch (IllegalArgumentException | IllegalAccessException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String a=f.getName();
			if(result!=null){
			            Method meSet = null;
						StringBuffer methodNameSet=new StringBuffer("set"+f.getName()).replace(3, 4,String.valueOf(f.getName().charAt(0)).toUpperCase());
						try {
							meSet=thisClz.getMethod(methodNameSet.toString(),f.getType());
							meSet.invoke(this, result);
						} catch (SecurityException | NoSuchMethodException 
								|IllegalArgumentException | IllegalAccessException
								| InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				
		
	}
	public int getMedical_report_id() {
		return medical_report_id;
	}
	public void setMedical_report_id(int medical_report_id) {
		this.medical_report_id = medical_report_id;
	}
	public int getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(int user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Long getReport_add_date() {
		return report_add_date;
	}
	public void setReport_add_date(Long report_add_date) {
		this.report_add_date = report_add_date;
	}
	public Long getReport_edit_date() {
		return report_edit_date;
	}
	public void setReport_edit_date(Long report_edit_date) {
		this.report_edit_date = report_edit_date;
	}
	@Override
	public String toString() {
		return "MedicalReportEntity [medical_report_id=" + medical_report_id
				+ ", user_basics_id=" + user_basics_id + ", report_add_date="
				+ report_add_date + ", report_edit_date=" + report_edit_date
				+ ", idcard=" + idcard + ", type=" + type + ", dtype=" + dtype
				+ ", did=" + did + ", time=" + time + ", endTime=" + endTime
				+ ", height=" + height + ", weight=" + weight + ", systolic="
				+ systolic + ", diastolic=" + diastolic + ", pulse=" + pulse
				+ ", moisture=" + moisture + ", adiposerate=" + adiposerate
				+ ", bone=" + bone + ", basalMetabolism=" + basalMetabolism
				+ ", bmi=" + bmi + ", muscle=" + muscle + ", visceralfat="
				+ visceralfat + ", temperature=" + temperature + ", ecg=" + ecg
				+ ", ecgPng=" + ecgPng + ", result=" + result
				+ ", bloodoxygen=" + bloodoxygen + ", hb=" + hb
				+ ", bloodsugar=" + bloodsugar + ", uricacid=" + uricacid
				+ ", chol=" + chol + ", LEU=" + LEU + ", NIT=" + NIT + ", UBG="
				+ UBG + ", PRO=" + PRO + ", PH=" + PH + ", SG=" + SG + ", BLD="
				+ BLD + ", KET=" + KET + ", BIL=" + BIL + ", GLU=" + GLU
				+ ", VC=" + VC + "]";
	}
	
	
	
	

}
