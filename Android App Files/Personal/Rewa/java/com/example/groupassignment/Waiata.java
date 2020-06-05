package com.example.groupassignment;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "waiata")
public class Waiata implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "waiata_Name")
    private String waiataName;

    @ColumnInfo(name ="waiata_Desc")
    private String waiataDesc;

    @ColumnInfo(name = "waiata_MaoriLyrics")
    private String waiataMaoriLyrics;

    @ColumnInfo(name = "waiata_EngLyrics")
    private String waiataEngLyrics;

    @ColumnInfo(name = "waiata_VideoName")
    private String waiataVideoName;

    public Waiata(String waiataName, String waiataDesc, String waiataMaoriLyrics, String waiataEngLyrics, String waiataVideoName){
        this.waiataName = waiataName;
        this.waiataDesc = waiataDesc;
        this.waiataMaoriLyrics = waiataMaoriLyrics;
        this.waiataEngLyrics = waiataEngLyrics;
        this.waiataVideoName = waiataVideoName;
    }

    @Ignore
    public Waiata(){}

    protected Waiata(Parcel in){
        id = in.readInt();
        waiataName = in.readString();
        waiataDesc = in.readString();
        waiataMaoriLyrics = in.readString();
        waiataEngLyrics = in.readString();
        waiataVideoName = in.readString();
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

    public String getWaiataVideoName() {
        return waiataVideoName;
    }

    public void setWaiataVideoName(String waiataVideoName) {
        this.waiataVideoName = waiataVideoName;
    }

    @Override
    public String toString(){
        return "Waiata(" +
                "waiataName='" + waiataName + '\'' +
                ", waiataDesc='" + waiataDesc + '\'' +
                ", waiataMaoriLyrics='" + waiataMaoriLyrics + '\'' +
                ", waiataEngLyrics='" + waiataEngLyrics + '\'' +
                ", waiataVideoName='" + waiataVideoName + '\'' +
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
        parcel.writeString(waiataVideoName);
    }
}
