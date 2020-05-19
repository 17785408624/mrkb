package com.mrkb.dao.modle.exam;

/**
 * 考生试卷报名实体
 */
public class SignEntity {

    private Integer sign_id;

    private Integer member_id;

    private Integer paper_id;

    private Integer if_exam;

    public Integer getSign_id() {
        return sign_id;
    }

    public void setSign_id(Integer sign_id) {
        this.sign_id = sign_id;
    }

    public Integer getMember_id() {
        return member_id;
    }

    public void setMember_id(Integer member_id) {
        this.member_id = member_id;
    }

    public Integer getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(Integer paper_id) {
        this.paper_id = paper_id;
    }

    public Integer getIf_exam() {
        return if_exam;
    }

    public void setIf_exam(Integer if_exam) {
        this.if_exam = if_exam;
    }
}
