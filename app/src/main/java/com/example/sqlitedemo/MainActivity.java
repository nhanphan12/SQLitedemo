package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.sqlitedemo.Model.Account;
import com.example.sqlitedemo.Model.BMI;
import com.example.sqlitedemo.Model.Height;
import com.example.sqlitedemo.Model.Journey;
import com.example.sqlitedemo.Model.Location;
import com.example.sqlitedemo.Model.Top;
import com.example.sqlitedemo.Model.User;
import com.example.sqlitedemo.Model.Weight;
import com.example.sqlitedemo.data.AccountUtil;
import com.example.sqlitedemo.data.BmiUtil;
import com.example.sqlitedemo.data.HeightUtil;
import com.example.sqlitedemo.data.JourneyUtil;
import com.example.sqlitedemo.data.LocationUtil;
import com.example.sqlitedemo.data.TopUtil;
import com.example.sqlitedemo.data.UserUtil;
import com.example.sqlitedemo.data.WeightUtil;
import com.example.sqlitedemo.data.dbHeathHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class MainActivity extends AppCompatActivity {

    private dbHeathHelper db;
    JourneyUtil mJUU;
    UserUtil mUU;
    AccountUtil mAU;
    LocationUtil mLU;
    HeightUtil mHU;
    WeightUtil mWU;
    BmiUtil mBU;
    TopUtil mTU;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get util
        mJUU = new JourneyUtil(this.getApplicationContext());
        mUU = new UserUtil(this.getApplicationContext());
        mAU = new AccountUtil(this.getApplicationContext());
        mLU = new LocationUtil(this.getApplicationContext());
        mHU = new HeightUtil(this.getApplicationContext());
        mWU = new WeightUtil(this.getApplicationContext());
        mBU = new BmiUtil(this.getApplicationContext());
        mTU = new TopUtil(this.getApplicationContext());

        //Insert // sua distance thanh float
        Date date = new Date();
        mJUU.add(1234, 12.5f,date,"Nhan",2,"MeoMeo","nul");
        mUU.add("PhanNhan",21,"Nam","nhanphan.03@gmail","079846967");
        mAU.add("MeoMeo","hchaa");
        mLU.add(1,12.45,14.7,10.78);
        mHU.add(170,date);
        mWU.add(62,date);
        mBU.add(date,56,60);
        mTU.add("PhanNhan",12,date,date,"helo");

        //Get
        List<Journey> mJourneys = mJUU.getAllJourney();
        Log.d("ListTest:", ""+mJourneys.get(0).getmDate());
        List<User> mUsers = mUU.getAllUser();
        Log.d("ListTest:", ""+mUsers.get(0).getmName());
        List<Account> mAccounts = mAU.getAllAccount();
        Log.d("ListTest:", ""+mAccounts.get(0).getmUsername());
        List<Location> mLocations = mLU.getAll();
        Log.d("ListTest:", ""+mLocations.get(0).getmLocationId());
        List<Height> mHeights = mHU.getAllHeight();
        Log.d("ListTest:", ""+mHeights.get(0).getmDate());
        List<Weight> mWeights = mWU.getAllWeight();
        Log.d("ListTest:", ""+mWeights.get(0).getmDate());
        List<BMI> mBmis = mBU.getAllBMI();
        Log.d("ListTest:", ""+mBmis.get(0).getmDate());
        List<Top> mTops = mTU.getAllTop();
        Log.d("ListTest:", ""+mTops.get(0).getmStart_day());

        //Update
        Journey mJourney = mJourneys.get(0);
        mJourney.setmImage("update image");
        mJUU.update(mJourney);
        User mUser = mUsers.get(0);
        mUser.setmName("update name");
        mUU.update(mUser);
        Account mAccount = mAccounts.get(0);
        mAccount.setmUsername("Update");
        mAU.update(mAccount);
        Location mLocation = mLocations.get(0);
        mLocation.setmAltitude(11111111);
        mLU.update(mLocation);
        Height mHeight = mHeights.get(0);
        mHeight.setmValue(111111111);
        mHU.update(mHeight);
        Weight mWeight = mWeights.get(0);
        mWeight.setmValue(111111111);
        mWU.update(mWeight);
        BMI mBmi = mBmis.get(0);
        mBmi.setmTarge_tweight(111111111);
        mBU.update(mBmi);
        Top mTop = mTops.get(0);
        mTop.setmUsername("Update name");
        mTU.update(mTop);

        //Delete
        mJUU.delete(mJourney.getmJourneyId());
        mUU.delete(mUser.getmId());
        mAU.delete(mAccount.getmId());
        mLU.delete(mLocation.getmLocationId());
        mHU.delete(mHeight.getmId());
        mWU.delete(mWeight.getmId());
        mBU.delete(mBmi.getmId());
        mTU.delete(mTop.getmId());
    }
}