package com.mrkb.dao.modle.exam;

/**
 * 试卷选项实体
 */
public class OptionEntity {

    private Integer option_id;

    private Integer problem_id;

    private String subject;

    private String content;

    private Integer if_true;

    public Integer getOption_id() {
        return option_id;
    }

    public void setOption_id(Integer option_id) {
        this.option_id = option_id;
    }

    public Integer getProblem_id() {
        return problem_id;
    }

    public void setProblem_id(Integer problem_id) {
        this.problem_id = problem_id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIf_true() {
        return if_true;
    }

    public void setIf_true(Integer if_true) {
        this.if_true = if_true;
    }
}
