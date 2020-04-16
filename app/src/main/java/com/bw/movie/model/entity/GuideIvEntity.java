package com.bw.movie.model.entity;

import com.stx.xhb.androidx.entity.SimpleBannerInfo;

/**
 * data:2020/3/19
 * author:王江伟(DJ慢羊羊)
 * function:
 */
public class GuideIvEntity extends SimpleBannerInfo {
    Integer rouse;

    public Integer getRouse() {
        return rouse;
    }

    public void setRouse(Integer rouse) {
        this.rouse = rouse;
    }

    @Override
    public Object getXBannerUrl() {
        return null;
    }

    public GuideIvEntity(Integer rouse) {
        this.rouse = rouse;
    }
}
