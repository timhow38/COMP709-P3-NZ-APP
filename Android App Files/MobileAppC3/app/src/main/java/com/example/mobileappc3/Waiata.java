package com.example.mobileappc3;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "waiata")
public class Waiata implements Parcelable {

    //Creates
    @PrimaryKey(autoGenerate = true)
    protected int id;

    @ColumnInfo(name = "waiata_Name")
    private String waiataName;

    @ColumnInfo(name = "waiata_Desc")
    private String waiataDesc;

    @ColumnInfo(name = "waiata_MaoriLyrics")
    private String waiataMaoriLyrics;

    @ColumnInfo(name = "waiata_EngLyrics")
    private String waiataEngLyrics;

    @ColumnInfo(name = "waiata_Image")
    private int waiataImage;

    @ColumnInfo(name = "waiataMP3")
    private int waiataMP3;

    @ColumnInfo(name = "waiata_VideoName1")
    private int waiataVideoName1;

    @ColumnInfo(name = "waiata_VideoName2")
    private int waiataVideoName2;

    @ColumnInfo(name = "waiata_VideoName3")
    private int waiataVideoName3;


    //Waiata class constructor to collect waiata information
    public Waiata(String waiataName, String waiataDesc, String waiataMaoriLyrics, String waiataEngLyrics, int waiataImage, int waiataMP3, int waiataVideoName1, int waiataVideoName2, int waiataVideoName3) {
        this.waiataName = waiataName;
        this.waiataDesc = waiataDesc;
        this.waiataMaoriLyrics = waiataMaoriLyrics;
        this.waiataEngLyrics = waiataEngLyrics;
        this.waiataImage = waiataImage;
        this.waiataMP3 = waiataMP3;
        this.waiataVideoName1 = waiataVideoName1;
        this.waiataVideoName2 = waiataVideoName2;
        this.waiataVideoName3 = waiataVideoName3;
    }

    //Ignores empty Waiata constructor
    @Ignore
    public Waiata() {
    }

    //Creates Waiata parcel
    protected Waiata(Parcel in) {
        id = in.readInt();
        waiataName = in.readString();
        waiataDesc = in.readString();
        waiataMaoriLyrics = in.readString();
        waiataEngLyrics = in.readString();
        waiataMP3 = in.readInt();
        waiataVideoName1 = in.readInt();
        waiataVideoName2 = in.readInt();
        waiataVideoName3 = in.readInt();
    }

    //Creates Waiata parcelable
    public static final Creator<Waiata> CREATOR = new Creator<Waiata>() {
        @Override
        public Waiata createFromParcel(Parcel in) {
            return new Waiata(in);
        }

        @Override
        public Waiata[] newArray(int size) {
            return new Waiata[size];
        }
    };


    //Creates Waiata getters and setters
    public String getWaiataName() {
        return waiataName;
    }

    public void setWaiataName(String waiataName) {
        this.waiataName = waiataName;
    }

    public String getWaiataDesc() {
        return waiataDesc;
    }

    public void setWaiataDesc(String waiataDesc) {
        this.waiataDesc = waiataDesc;
    }

    public String getWaiataMaoriLyrics() {
        return waiataMaoriLyrics;
    }

    public void setWaiataMaoriLyrics(String waiataMaoriLyrics) {
        this.waiataMaoriLyrics = waiataMaoriLyrics;
    }

    public String getWaiataEngLyrics() {
        return waiataEngLyrics;
    }

    public void setWaiataEngLyrics(String waiataEngLyrics) {
        this.waiataEngLyrics = waiataEngLyrics;
    }

    public int getWaiataImage() {
        return waiataImage;
    }

    public void setWaiataImage(int waiataImage) {
        this.waiataImage = waiataImage;
    }

    public int getWaiataMP3() {
        return waiataMP3;
    }

    public void setWaiataMP3(int waiataMP3) {
        this.waiataMP3 = waiataMP3;
    }

    public int getWaiataVideoName1() {
        return waiataVideoName1;
    }

    public void setWaiataVideoName1(int waiataVideoName) {
        this.waiataVideoName1 = waiataVideoName;
    }

    public int getWaiataVideoName2() {
        return waiataVideoName2;
    }

    public void setWaiataVideoName2(int waiataVideoName2) {
        this.waiataVideoName2 = waiataVideoName2;
    }

    public int getWaiataVideoName3() {
        return waiataVideoName3;
    }

    public void setWaiataVideoName3(int waiataVideoName3) {
        this.waiataVideoName3 = waiataVideoName3;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    //Writes to parcel to create parcelable
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(waiataName);
        parcel.writeString(waiataDesc);
        parcel.writeString(waiataMaoriLyrics);
        parcel.writeString(waiataEngLyrics);
        parcel.writeInt(waiataImage);
        parcel.writeInt(waiataMP3);
        parcel.writeInt(waiataVideoName1);
        parcel.writeInt(waiataVideoName2);
        parcel.writeInt(waiataVideoName3);
    }
}
