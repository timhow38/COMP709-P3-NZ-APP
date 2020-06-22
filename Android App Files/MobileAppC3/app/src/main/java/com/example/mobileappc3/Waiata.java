package com.example.mobileappc3;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "waiata")
public class Waiata implements Parcelable {
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

    @ColumnInfo(name = "waiata_VideoName1")
    private int waiataVideoName1;

    @ColumnInfo(name = "waiata_VideoName2")
    private int waiataVideoName2;

    @ColumnInfo(name = "waiata_VideoName3")
    private int waiataVideoName3;

    public Waiata(String waiataName, String waiataDesc, String waiataMaoriLyrics, String waiataEngLyrics, int waiataImage, int waiataVideoName1, int waiataVideoName2, int waiataVideoName3) {
        this.waiataName = waiataName;
        this.waiataDesc = waiataDesc;
        this.waiataMaoriLyrics = waiataMaoriLyrics;
        this.waiataEngLyrics = waiataEngLyrics;
        this.waiataImage = waiataImage;
        this.waiataVideoName1 = waiataVideoName1;
        this.waiataVideoName2 = waiataVideoName2;
        this.waiataVideoName3 = waiataVideoName3;
    }

    @Ignore
    public Waiata() {
    }

    protected Waiata(Parcel in) {
        id = in.readInt();
        waiataName = in.readString();
        waiataDesc = in.readString();
        waiataMaoriLyrics = in.readString();
        waiataEngLyrics = in.readString();
        waiataVideoName1 = in.readInt();
        waiataVideoName2 = in.readInt();
        waiataVideoName3 = in.readInt();
    }

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

    public int getWaiataImage() { return waiataImage; }

    public void setWaiataImage(int waiataImage) {
        this.waiataImage = waiataImage;
    }

    public int getWaiataVideoName1() {
        return waiataVideoName1;
    }

    public void setWaiataVideoName1(int waiataVideoName) {
        this.waiataVideoName1 = waiataVideoName;
    }

    public int getWaiataVideoName2() { return waiataVideoName2; }

    public void setWaiataVideoName2(int waiataVideoName2) {
        this.waiataVideoName2 = waiataVideoName2;
    }

    public int getWaiataVideoName3() { return waiataVideoName3; }

    public void setWaiataVideoName3(int waiataVideoName3) {
        this.waiataVideoName3 = waiataVideoName3;
    }

    @Override
    public String toString() {
        return "Waiata(" +
                "waiataName='" + waiataName + '\'' +
                ", waiataDesc='" + waiataDesc + '\'' +
                ", waiataMaoriLyrics='" + waiataMaoriLyrics + '\'' +
                ", waiataEngLyrics='" + waiataEngLyrics + '\'' +
                ", waiataImage='" + waiataImage + '\'' +
                ", waiataVideoName1='" + waiataVideoName1 + '\'' +
                ", waiataVideoName2='" + waiataVideoName2 + '\'' +
                ", waiataVideoName3='" + waiataVideoName3 + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(waiataName);
        parcel.writeString(waiataDesc);
        parcel.writeString(waiataMaoriLyrics);
        parcel.writeString(waiataEngLyrics);
        parcel.writeInt(waiataVideoName1);
    }
}
