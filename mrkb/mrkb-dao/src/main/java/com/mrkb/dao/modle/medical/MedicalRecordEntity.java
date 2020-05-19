package com.mrkb.dao.modle.medical;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MedicalRecordEntity extends MedicalEntity{
	private int medical_record_id;//主键
    private int user_basics_id;//用户id
	private String information_card;//用户身份证号
	private Long record_add_date;//添加时间
	
	public MedicalRecordEntity() {
		super();
	}

	public MedicalRecordEntity(MedicalEntity medicalEntity) {
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
	public int getMedical_record_id() {
		return medical_record_id;
	}
	public void setMedical_record_id(int medical_record_id) {
		this.medical_record_id = medical_record_id;
	}
	
	public String getInformation_card() {
		return information_card;
	}
	public void setInformation_card(String information_card) {
		this.information_card = information_card;
	}
	public Long getRecord_add_date() {
		return record_add_date;
	}
	public void setRecord_add_date(Long record_add_date) {
		this.record_add_date = record_add_date;
	}
	public int getUser_basics_id() {
		return user_basics_id;
	}

	public void setUser_basics_id(int user_basics_id) {
		this.user_basics_id = user_basics_id;
	}

	@Override
	public String toString() {
		return "MedicalRecordEntity [medical_record_id=" + medical_record_id
				+ ", user_basics_id=" + user_basics_id + ", information_card="
				+ information_card + ", record_add_date=" + record_add_date
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
