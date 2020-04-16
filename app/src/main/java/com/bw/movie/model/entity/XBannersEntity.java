package com.bw.movie.model.entity;

import com.stx.xhb.androidx.entity.SimpleBannerInfo;

/**
 * data:2020/3/22
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class XBannersEntity extends SimpleBannerInfo {

    String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public Object getXBannerUrl() {
        return null;
    }

    public XBannersEntity(String image) {
        this.image = image;
    }
}
