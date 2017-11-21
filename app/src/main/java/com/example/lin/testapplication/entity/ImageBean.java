package com.example.lin.testapplication.entity;

import android.media.Image;

/**
 * Created by 101912 on 2017/8/1.
 */

public class ImageBean {

    private String imageDes;
    private Image image;

    public void setImageDes(String imageDes) {
        this.imageDes = imageDes;
    }

    public String getImageDes() {
        return imageDes;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }


}
