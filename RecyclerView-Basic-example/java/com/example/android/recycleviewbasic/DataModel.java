package com.example.android.recycleviewbasic;

/**
 * Created by @sayaMahi; www.runningnotes.info on 12/03/2018.
 */

public class DataModel {
    private String mTitle;
    private String mDescription;

    private int mImageID = NO_IMAGE;

    private static final int NO_IMAGE = -1;

    public DataModel(String mTitle) {
        this.mTitle = mTitle;
    }

    public DataModel(String mTitle, String mDescription) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
    }

    public DataModel(String mTitle, String mDescription, int iImageId) {
        this.mTitle = mTitle;
        this.mDescription = mDescription;
        this.mImageID = iImageId;
    }

    public boolean hasImage(){
        return mImageID != NO_IMAGE;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getmTitle() {
        return mTitle;
    }

    public int getiImageId() {
        return mImageID;
    }

}
