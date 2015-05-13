package com.example.yumatakahashi.test;

/**
 * Created by yuma.takahashi on 2015/05/04.
 */

public class ModelClass {


    //private String titleToDisplay;
    //private ArrayList<String> imageUrl;
    private String[] imageUrl;



    //public ModelClass(ArrayList<String> imageUrl) {
    public ModelClass(String[] imageUrl) {
        super();
        this.imageUrl = imageUrl;
    }

    //public ArrayList<String> getImageUrl() {
    public String[] getImageUrl() {
        return this.imageUrl;
    }

    //public void setTitleToDisplay(String titleToDisplay) {
    //    this.titleToDisplay = titleToDisplay;
    //}
}