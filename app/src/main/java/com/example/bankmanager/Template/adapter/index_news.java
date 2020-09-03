package com.example.bankmanager.Template.adapter;

//这是一个加载首页新闻栏的类
public class index_news {
    private int imageId;  //需要图片的编号
    private String title; //标题
    private String author;//作者
    private String date;//时间
    private String ori;//来源

    public  int getImageId() {
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

    public String getOri() {
        return ori;
    }

    public index_news(int imageId, String title, String author, String date, String ori) {   //构造方法
        this.imageId = imageId;
        this.title = title;
        this.author = author;
        this.date = date;
        this.ori = ori;
    }
}
