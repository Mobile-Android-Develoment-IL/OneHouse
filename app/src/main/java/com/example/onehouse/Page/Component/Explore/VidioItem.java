package com.example.onehouse.page.component.explore;

import android.content.Context;

public class VidioItem {
    private String videoUrl, videoTitle, videoDesc;

    public VidioItem(int videoUrl, Context context, String videoTitle, String videoDesc) {
        this.videoUrl = "android.resource://" + context.getPackageName() + "/" + videoUrl;
        this.videoTitle = videoTitle;
        this.videoDesc = videoDesc;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getVideoDesc() {
        return videoDesc;
    }

    public void setVideoDesc(String videoDesc) {
        this.videoDesc = videoDesc;
    }
}
