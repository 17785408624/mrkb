package com.mrkb.web.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin_exam")
public class ExamController {

    @RequestMapping("/member")
    public String member() {
        return "sys/exam/member";
    }

    @RequestMapping("/paper")
    public String paper() {
        return "sys/exam/paper";
    }
}
