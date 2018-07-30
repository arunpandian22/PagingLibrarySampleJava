
package me.arun.paginglibrarysample.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;


@Entity(tableName = "player")
public class Player {

    @ColumnInfo(name = "battingStyle")
    @SerializedName("battingStyle")
    private String mBattingStyle;

    @ColumnInfo(name = "born")
    @SerializedName("born")
    private String mBorn;

    @ColumnInfo(name = "bowlingStyle")
    @SerializedName("bowlingStyle")
    private String mBowlingStyle;

    @ColumnInfo(name = "country")
    @SerializedName("country")
    private String mCountry;

    @ColumnInfo(name = "currentAge")
    @SerializedName("currentAge")
    private String mCurrentAge;

    @ColumnInfo(name = "fullName")
    @SerializedName("fullName")
    private String mFullName;

    @ColumnInfo(name = "imageURL")
    @SerializedName("imageURL")
    private String mImageURL;

    @ColumnInfo(name = "majorTeams")
    @SerializedName("majorTeams")
    private String mMajorTeams;

    @ColumnInfo(name = "name")
    @SerializedName("name")
    private String mName;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "pid")
    @SerializedName("pid")
    private Long mPid;

    @ColumnInfo(name = "playingRole")
    @SerializedName("playingRole")
    private String mPlayingRole;

    public String getBattingStyle() {
        return mBattingStyle;
    }

    public void setBattingStyle(String battingStyle) {
        mBattingStyle = battingStyle;
    }

    public String getBorn() {
        return mBorn;
    }

    public void setBorn(String born) {
        mBorn = born;
    }

    public String getBowlingStyle() {
        return mBowlingStyle;
    }

    public void setBowlingStyle(String bowlingStyle) {
        mBowlingStyle = bowlingStyle;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public String getCurrentAge() {
        return mCurrentAge;
    }

    public void setCurrentAge(String currentAge) {
        mCurrentAge = currentAge;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public String getImageURL() {
        return mImageURL;
    }

    public void setImageURL(String imageURL) {
        mImageURL = imageURL;
    }

    public String getMajorTeams() {
        return mMajorTeams;
    }

    public void setMajorTeams(String majorTeams) {
        mMajorTeams = majorTeams;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Long getPid() {
        return mPid;
    }

    public void setPid(Long pid) {
        mPid = pid;
    }

    public String getPlayingRole() {
        return mPlayingRole;
    }

    public void setPlayingRole(String playingRole) {
        mPlayingRole = playingRole;
    }



}
