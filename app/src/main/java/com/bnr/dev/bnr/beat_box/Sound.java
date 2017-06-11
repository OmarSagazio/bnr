package com.bnr.dev.bnr.beat_box;

/**
 * Created by dev-w8-12 on 10-Jun-17.
 */
public class Sound {

    // members
    private String mAssetPath;
    private String mName;


    public Sound(String assetPath) {
        mAssetPath = assetPath;
        String[] components = assetPath.split("/");
        String fileName = components[components.length-1];
        mName = fileName.replace(".wav", "");
    }

    public String getAssetPath() {
        return mAssetPath;
    }

    public void setAssetPath(String assetPath) {
        this.mAssetPath = assetPath;
    }


    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }


}
