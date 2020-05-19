package com.mrkb.dao.modle.medical;
/**
 * 体检数据
 *@param
 *@return
 * @author Administrator
 *
 */
public class MedicalEntity {
	String idcard;//用户身份证号
	Integer type;//数据功能码
	Integer dtype;//设备类型
	String did;//设备编码
	String time;//测量时间(yyyy-MM-dd HH:mm:ss)
	String endTime;//检测结束时间
	Float height;//身高(cm)
	Float weight;//体重(kg)
	Integer systolic;//收缩压(mmHg)
	Integer diastolic;//舒张压(mmHg)
	Integer pulse;//脉搏(次/min)
	Float moisture;//人体水分(%)
	Float adiposerate;//脂肪率(%)
	Float bone;//骨量(kg)
	Double basalMetabolism;//基础代谢(kcal)
	Float bmi;//BMI 健康指数(kg/㎡)
	Float muscle;//肌肉量(kg)
	Integer visceralfat;//内脏脂肪(等级)
	Float temperature;//体温(℃)
	String ecg;//心电波形数据（Base64编码）
	String ecgPng;//心电波形数据转图片(Base64编码)
	String result;//心电测量结论
	Float bloodoxygen;//血氧(%)
	Float hb;//血红蛋白(% g/dL)
	Float bloodsugar;//血糖(mmol/L)
	Float uricacid;//尿酸(mmoi/L)
	Float chol;//总胆固醇(mmol/L)
	Integer LEU;//白细胞(+-Cells/uL)
	Integer NIT;//亚硝酸盐(+)
	Integer UBG;//尿胆原(-umol/L)
	Integer PRO;//蛋白质(-mg/dL)
	Float PH;//PH(+)
	Float SG;//比重
	Integer BLD;//潜血(+-Cells/uL)
	Integer KET;//酮体(+mmol/L)
	Integer BIL;//胆红素(-mg/dL)
	Integer GLU;//+葡萄糖(mmol/L)
	String VC;//维生素C(mg/dL)
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getDtype() {
		return dtype;
	}
	public void setDtype(Integer dtype) {
		this.dtype = dtype;
	}
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Float getHeight() {
		return height;
	}
	public void setHeight(Float height) {
		this.height = height;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	public Integer getSystolic() {
		return systolic;
	}
	public void setSystolic(Integer systolic) {
		this.systolic = systolic;
	}
	public Integer getDiastolic() {
		return diastolic;
	}
	public void setDiastolic(Integer diastolic) {
		this.diastolic = diastolic;
	}
	public Integer getPulse() {
		return pulse;
	}
	public void setPulse(Integer pulse) {
		this.pulse = pulse;
	}
	public Float getMoisture() {
		return moisture;
	}
	public void setMoisture(Float moisture) {
		this.moisture = moisture;
	}
	public Float getAdiposerate() {
		return adiposerate;
	}
	public void setAdiposerate(Float adiposerate) {
		this.adiposerate = adiposerate;
	}
	public Float getBone() {
		return bone;
	}
	public void setBone(Float bone) {
		this.bone = bone;
	}
	public Double getBasalMetabolism() {
		return basalMetabolism;
	}
	public void setBasalMetabolism(Double basalMetabolism) {
		this.basalMetabolism = basalMetabolism;
	}
	public Float getBmi() {
		return bmi;
	}
	public void setBmi(Float bmi) {
		this.bmi = bmi;
	}
	public Float getMuscle() {
		return muscle;
	}
	public void setMuscle(Float muscle) {
		this.muscle = muscle;
	}
	public Integer getVisceralfat() {
		return visceralfat;
	}
	public void setVisceralfat(Integer visceralfat) {
		this.visceralfat = visceralfat;
	}
	public Float getTemperature() {
		return temperature;
	}
	public void setTemperature(Float temperature) {
		this.temperature = temperature;
	}
	public String getEcg() {
		return ecg;
	}
	public void setEcg(String ecg) {
		this.ecg = ecg;
	}
	public String getEcgPng() {
		return ecgPng;
	}
	public void setEcgPng(String ecgPng) {
		this.ecgPng = ecgPng;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Float getBloodoxygen() {
		return bloodoxygen;
	}
	public void setBloodoxygen(Float bloodoxygen) {
		this.bloodoxygen = bloodoxygen;
	}
	public Float getHb() {
		return hb;
	}
	public void setHb(Float hb) {
		this.hb = hb;
	}
	public Float getBloodsugar() {
		return bloodsugar;
	}
	public void setBloodsugar(Float bloodsugar) {
		this.bloodsugar = bloodsugar;
	}
	public Float getUricacid() {
		return uricacid;
	}
	public void setUricacid(Float uricacid) {
		this.uricacid = uricacid;
	}
	public Float getChol() {
		return chol;
	}
	public void setChol(Float chol) {
		this.chol = chol;
	}
	public Integer getLEU() {
		return LEU;
	}
	public void setLEU(Integer lEU) {
		LEU = lEU;
	}
	public Integer getNIT() {
		return NIT;
	}
	public void setNIT(Integer nIT) {
		NIT = nIT;
	}
	public Integer getUBG() {
		return UBG;
	}
	public void setUBG(Integer uBG) {
		UBG = uBG;
	}
	public Integer getPRO() {
		return PRO;
	}
	public void setPRO(Integer pRO) {
		PRO = pRO;
	}
	public Float getPH() {
		return PH;
	}
	public void setPH(Float pH) {
		PH = pH;
	}
	public Float getSG() {
		return SG;
	}
	public void setSG(Float sG) {
		SG = sG;
	}
	public Integer getBLD() {
		return BLD;
	}
	public void setBLD(Integer bLD) {
		BLD = bLD;
	}
	public Integer getKET() {
		return KET;
	}
	public void setKET(Integer kET) {
		KET = kET;
	}
	public Integer getBIL() {
		return BIL;
	}
	public void setBIL(Integer bIL) {
		BIL = bIL;
	}
	public Integer getGLU() {
		return GLU;
	}
	public void setGLU(Integer gLU) {
		GLU = gLU;
	}
	public String getVC() {
		return VC;
	}
	public void setVC(String vC) {
		VC = vC;
	}
	@Override
	public String toString() {
		return "MedicalEntity [idcard=" + idcard + ", type=" + type
				+ ", dtype=" + dtype + ", did=" + did + ", time=" + time
				+ ", endTime=" + endTime + ", height=" + height + ", weight="
				+ weight + ", systolic=" + systolic + ", diastolic="
				+ diastolic + ", pulse=" + pulse + ", moisture=" + moisture
				+ ", adiposerate=" + adiposerate + ", bone=" + bone
				+ ", basalMetabolism=" + basalMetabolism + ", bmi=" + bmi
				+ ", muscle=" + muscle + ", visceralfat=" + visceralfat
				+ ", temperature=" + temperature + ", ecg=" + ecg + ", ecgPng="
				+ ecgPng + ", result=" + result + ", bloodoxygen="
				+ bloodoxygen + ", hb=" + hb + ", bloodsugar=" + bloodsugar
				+ ", uricacid=" + uricacid + ", chol=" + chol + ", LEU=" + LEU
				+ ", NIT=" + NIT + ", UBG=" + UBG + ", PRO=" + PRO + ", PH="
				+ PH + ", SG=" + SG + ", BLD=" + BLD + ", KET=" + KET
				+ ", BIL=" + BIL + ", GLU=" + GLU + ", VC=" + VC + "]";
	}
	

}
