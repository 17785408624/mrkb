package com.mrkb.dao.modle.exam;

/**
 * 考试答题实体
 */
public class MemberAnswerEntity {

    private Integer member_answer_id;

    private Integer problem_id;

    private Integer paper_id;

    private Integer member_id;

    private String answer;

    private Double grade;

    public Integer getMember_answer_id() {
        return member_answer_id;
    }

    public void setMember_answer_id(Integer member_answer_id) {
        this.member_answer_id = member_answer_id;
    }

    public Integer getProblem_id() {
        return problem_id;
    }

    public void setProblem_id(Integer problem_id) {
        this.problem_id = problem_id;
    }

    public Integer getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(Integer paper_id) {
        this.paper_id = paper_id;
    }

    public Integer getMember_id() {
        return member_id;
    }

    public void setMember_id(Integer member_id) {
        this.member_id = member_id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
