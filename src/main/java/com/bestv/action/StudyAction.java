package com.bestv.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created with IntelliJ IDEA.
 * User: henry
 * Date: 13-10-27
 * Time: 下午3:18
 * To change this template use File | Settings | File Templates.
 */
public class StudyAction extends ActionSupport {
    private String yield;

    public String index() {
        yield = "/views/study/index.jsp";
        return SUCCESS;
    }

    public String datetime() {
        yield = "/views/study/datetime.jsp";
        return SUCCESS;
    }

    public String el() {
        yield = "/views/study/el.jsp";
        return SUCCESS;
    }

    public String getYield() {
        return yield;
    }

    public void setYield(String yield) {
        this.yield = yield;
    }
}
