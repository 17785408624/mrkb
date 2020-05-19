package com.mrkb.dao.modle.exam;

/**
 * 试卷题目关联实体
 */
public class PaperProblemEntity {

    private Integer paper_problem_id;

    private Integer paper_id;

    private Integer problem_id;

    private Integer number;

    public Integer getPaper_problem_id() {
        return paper_problem_id;
    }

    public void setPaper_problem_id(Integer paper_problem_id) {
        this.paper_problem_id = paper_problem_id;
    }

    public Integer getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(Integer paper_id) {
        this.paper_id = paper_id;
    }

    public Integer getProblem_id() {
        return problem_id;
    }

    public void setProblem_id(Integer problem_id) {
        this.problem_id = problem_id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
