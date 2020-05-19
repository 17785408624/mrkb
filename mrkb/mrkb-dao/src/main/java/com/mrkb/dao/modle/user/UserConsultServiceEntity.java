package com.mrkb.dao.modle.user;
/**
 *  我的顾问实体
 * @author ly
 *
 */
public class UserConsultServiceEntity {
    private Integer consult_service_id;	//我的顾问(咨询服务客户id)
    private Integer user_basics_id;//被服务的客户id
    //private  String   advisor_name	;//	顾问姓名
    private  String senior_manager_name	;		//我的高级经理姓名
    private Integer advisor_user_basics_id;//乐唐顾问id
    private Integer seniorManager_user_basics_id;//高级经理id
    //private  String letang_advisor_phone	;	//顾问的联系方式
    private  String senior_manager_phone	;		//高级经理的联系方式
    private String consult_picture;//顾问图片
    private String consult_view;//顾问视频
    public Integer getConsult_service_id() {
        return consult_service_id;
    }
    public Integer getAdvisor_user_basics_id() {
        return advisor_user_basics_id;
    }
    public void setAdvisor_user_basics_id(Integer advisor_user_basics_id) {
        this.advisor_user_basics_id = advisor_user_basics_id;
    }
    public Integer getSeniorManager_user_basics_id() {
        return seniorManager_user_basics_id;
    }
    public void setSeniorManager_user_basics_id(Integer seniorManager_user_basics_id) {
        this.seniorManager_user_basics_id = seniorManager_user_basics_id;
    }
    public void setConsult_service_id(Integer consult_service_id) {
        this.consult_service_id = consult_service_id;
    }
    public Integer getUser_basics_id() {
        return user_basics_id;
    }
    public void setUser_basics_id(Integer user_basics_id) {
        this.user_basics_id = user_basics_id;
    }
    public String getConsult_picture() {
        return consult_picture;
    }
    public void setConsult_picture(String consult_picture) {
        this.consult_picture = consult_picture;
    }
    public String getConsult_view() {
        return consult_view;
    }
    public void setConsult_view(String consult_view) {
        this.consult_view = consult_view;
    }

    public String getSenior_manager_name() {
        return senior_manager_name;
    }

    public void setSenior_manager_name(String senior_manager_name) {
        this.senior_manager_name = senior_manager_name;
    }

    public String getSenior_manager_phone() {
        return senior_manager_phone;
    }

    public void setSenior_manager_phone(String senior_manager_phone) {
        this.senior_manager_phone = senior_manager_phone;
    }

    @Override
    public String toString() {
        return "UserConsultServiceEntity{" +
                "consult_service_id=" + consult_service_id +
                ", user_basics_id=" + user_basics_id +
                ", senior_manager_name='" + senior_manager_name + '\'' +
                ", advisor_user_basics_id=" + advisor_user_basics_id +
                ", seniorManager_user_basics_id=" + seniorManager_user_basics_id +
                ", senior_manager_phone='" + senior_manager_phone + '\'' +
                ", consult_picture='" + consult_picture + '\'' +
                ", consult_view='" + consult_view + '\'' +
                '}';
    }
}
