package com.example.bankmanager.DayliReading;

public class read_class {
    private int imageId;  //需要图片的编号
    private String title; //标题
    private String author;//作者
    private String date;//时间
    private String leixing;//类型

    public read_class(int imageId, String title, String author, String date, String leixing) {
        this.imageId = imageId;
        this.title = title;
        this.author = author;
        this.date = date;
        this.leixing = leixing;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getLeixing() {
        return leixing;
    }
}
