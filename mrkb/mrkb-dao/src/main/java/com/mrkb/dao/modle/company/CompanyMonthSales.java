package com.mrkb.dao.modle.company;

public class CompanyMonthSales {
	private Integer month_id;//月销售编号
	private Integer company_id;//公司编号
	private String month_date;//销售时间（月份）
	private Double month_money_timely=0.00;//月销售金额（及时）
	private Double low_month_money_timely=0.00;//下属公司月销售量(及时)
	private Double month_money_untimely=0.00;//月销售金额（非及时）
	private Double low_month_money_untimely=0.00;//下属公司月销售量(非及时)
	private Double green_kaba=0.00;//绿卡巴奖金池
	private Double indigo_kaba=0.00;//青卡巴奖金池
	private Double purple_kaba=0.00;//紫卡巴奖金池
	private Double blue_violet_kaba=0.00;//蓝卡巴奖金池
	private Long start_time;//开始销售时间
	private Long end_time;//结束销售时间
	private Integer if_settlement;//是否已结算奖金池(0未结算.1已结算)
	private Double old_green_kaba=0.00;//绿卡巴奖金池上月结余
	private Double old_indigo_kaba=0.00;//青卡巴奖金池上月结余
	private Double old_blue_violet_kaba=0.00;//蓝卡巴奖金池上月结余
	private Double old_purple_kaba=0.00;//紫卡巴奖金池上月结余
	private Integer green_kaba_num=0;//绿卡巴人数
	private Integer indigo_kaba_num=0;//青卡巴人数
	private Integer blue_violet_kaba_num=0;//蓝卡巴人数
	private Integer purple_kaba_num=0;//紫卡巴人数
	
	/*统计各个奖金池的人数*/
	private Integer greenKabaCount=0;//绿卡巴总人数
	private Integer indigoKabaCount=0;//青卡巴总人数
	private Integer blueVioletKabaCount=0;//蓝卡巴总人数
	private Integer purpleKabaCount=0;//紫卡巴总人数
	public Integer getMonth_id() {
		return month_id;
	}
	public void setMonth_id(Integer month_id) {
		this.month_id = month_id;
	}
	public Integer getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}
	public String getMonth_date() {
		return month_date;
	}
	public void setMonth_date(String month_date) {
		this.month_date = month_date;
	}
	public Double getMonth_money_timely() {
		return month_money_timely;
	}
	public void setMonth_money_timely(Double month_money_timely) {
		this.month_money_timely = month_money_timely;
	}
	public Double getMonth_money_untimely() {
		return month_money_untimely;
	}
	public void setMonth_money_untimely(Double month_money_untimely) {
		this.month_money_untimely = month_money_untimely;
	}
	public Long getStart_time() {
		return start_time;
	}
	public void setStart_time(Long start_time) {
		this.start_time = start_time;
	}
	public Long getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Long end_time) {
		this.end_time = end_time;
	}
	public Double getGreen_kaba() {
		return green_kaba;
	}
	public void setGreen_kaba(Double green_kaba) {
		this.green_kaba = green_kaba;
	}
	public Double getIndigo_kaba() {
		return indigo_kaba;
	}
	public void setIndigo_kaba(Double indigo_kaba) {
		this.indigo_kaba = indigo_kaba;
	}
	public Double getBlue_violet_kaba() {
		return blue_violet_kaba;
	}
	public void setBlue_violet_kaba(Double blue_violet_kaba) {
		this.blue_violet_kaba = blue_violet_kaba;
	}
	public Double getPurple_kaba() {
		return purple_kaba;
	}
	public void setPurple_kaba(Double purple_kaba) {
		this.purple_kaba = purple_kaba;
	}
	public Integer getIf_settlement() {
		return if_settlement;
	}
	public void setIf_settlement(Integer if_settlement) {
		this.if_settlement = if_settlement;
	}
	public Integer getIndigoKabaCount() {
		return indigoKabaCount;
	}
	public void setIndigoKabaCount(Integer indigoKabaCount) {
		this.indigoKabaCount = indigoKabaCount;
	}
	public Integer getBlueVioletKabaCount() {
		return blueVioletKabaCount;
	}
	public void setBlueVioletKabaCount(Integer blueVioletKabaCount) {
		this.blueVioletKabaCount = blueVioletKabaCount;
	}
	public Integer getPurpleKabaCount() {
		return purpleKabaCount;
	}
	public void setPurpleKabaCount(Integer purpleKabaCount) {
		this.purpleKabaCount = purpleKabaCount;
	}
	public Double getOld_green_kaba() {
		return old_green_kaba;
	}
	public void setOld_green_kaba(Double old_green_kaba) {
		this.old_green_kaba = old_green_kaba;
	}
	public Double getOld_indigo_kaba() {
		return old_indigo_kaba;
	}
	public void setOld_indigo_kaba(Double old_indigo_kaba) {
		this.old_indigo_kaba = old_indigo_kaba;
	}
	public Double getOld_blue_violet_kaba() {
		return old_blue_violet_kaba;
	}
	public void setOld_blue_violet_kaba(Double old_blue_violet_kaba) {
		this.old_blue_violet_kaba = old_blue_violet_kaba;
	}
	public Double getOld_purple_kaba() {
		return old_purple_kaba;
	}
	public void setOld_purple_kaba(Double old_purple_kaba) {
		this.old_purple_kaba = old_purple_kaba;
	}
	public Double getLow_month_money_timely() {
		return low_month_money_timely;
	}
	public void setLow_month_money_timely(Double low_month_money_timely) {
		this.low_month_money_timely = low_month_money_timely;
	}
	public Double getLow_month_money_untimely() {
		return low_month_money_untimely;
	}
	public void setLow_month_money_untimely(Double low_month_money_untimely) {
		this.low_month_money_untimely = low_month_money_untimely;
	}
	public Integer getIndigo_kaba_num() {
		return indigo_kaba_num;
	}
	public void setIndigo_kaba_num(Integer indigo_kaba_num) {
		this.indigo_kaba_num = indigo_kaba_num;
	}
	public Integer getBlue_violet_kaba_num() {
		return blue_violet_kaba_num;
	}
	public void setBlue_violet_kaba_num(Integer blue_violet_kaba_num) {
		this.blue_violet_kaba_num = blue_violet_kaba_num;
	}
	public Integer getPurple_kaba_num() {
		return purple_kaba_num;
	}
	public void setPurple_kaba_num(Integer purple_kaba_num) {
		this.purple_kaba_num = purple_kaba_num;
	}
	public Integer getGreen_kaba_num() {
		return green_kaba_num;
	}
	public void setGreen_kaba_num(Integer green_kaba_num) {
		this.green_kaba_num = green_kaba_num;
	}
	
	public Integer getGreenKabaCount() {
		return greenKabaCount;
	}
	public void setGreenKabaCount(Integer greenKabaCount) {
		this.greenKabaCount = greenKabaCount;
	}
	@Override
	public String toString() {
		return "CompanyMonthSales [month_id=" + month_id + ", company_id="
				+ company_id + ", month_date=" + month_date
				+ ", month_money_timely=" + month_money_timely
				+ ", low_month_money_timely=" + low_month_money_timely
				+ ", month_money_untimely=" + month_money_untimely
				+ ", low_month_money_untimely=" + low_month_money_untimely
				+ ", green_kaba=" + green_kaba + ", indigo_kaba=" + indigo_kaba
				+ ", purple_kaba=" + purple_kaba + ", blue_violet_kaba="
				+ blue_violet_kaba + ", start_time=" + start_time
				+ ", end_time=" + end_time + ", if_settlement=" + if_settlement
				+ ", old_green_kaba=" + old_green_kaba + ", old_indigo_kaba="
				+ old_indigo_kaba + ", old_blue_violet_kaba="
				+ old_blue_violet_kaba + ", old_purple_kaba=" + old_purple_kaba
				+ ", green_kaba_num=" + green_kaba_num + ", indigo_kaba_num="
				+ indigo_kaba_num + ", blue_violet_kaba_num="
				+ blue_violet_kaba_num + ", purple_kaba_num=" + purple_kaba_num
				+ ", greenKabaCount=" + greenKabaCount + ", indigoKabaCount="
				+ indigoKabaCount + ", blueVioletKabaCount="
				+ blueVioletKabaCount + ", purpleKabaCount=" + purpleKabaCount
				+ "]";
	}
	
	

	
	
}
