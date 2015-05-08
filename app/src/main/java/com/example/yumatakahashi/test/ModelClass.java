package com.example.yumatakahashi.test;

/**
 * Created by yuma.takahashi on 2015/05/04.
 */

public class ModelClass {


    private String titleToDisplay;



    public ModelClass(String question) {
        super();
        this.titleToDisplay = question;
    }

    public String getTitleToDisplay() {
        return titleToDisplay;
    }

    public void setTitleToDisplay(String titleToDisplay) {
        this.titleToDisplay = titleToDisplay;
    }
}