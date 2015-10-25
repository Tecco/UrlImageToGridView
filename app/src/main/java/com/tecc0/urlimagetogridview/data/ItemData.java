package com.tecc0.urlimagetogridview.data;

/**
 * Created by makotonishimoto on 2015/10/24.
 */
public class ItemData {

    private String name;
    private String photo;
    private String like;
    private String comment;
    private String price;

    public ItemData(String price, String comment, String like, String photo, String name) {
        this.price = price;
        this.comment = comment;
        this.like = like;
        this.photo = photo;
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public String getComment() {
        return comment;
    }

    public String getLike() {
        return like;
    }

    public String getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

}
