package com.example.sqlitedemo.Model;

import java.util.Date;

public class Height {
    private int mId;
    private int mValue;
    private Date mDate;

    public Height(int mValue, Date mDate) {
        this.mValue = mValue;
        this.mDate = mDate;
    }

    public Height() {
        this.mId = mId;
        this.mValue = mValue;
        this.mDate = mDate;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getmValue() {
        return mValue;
    }

    public void setmValue(int mValue) {
        this.mValue = mValue;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }
}
