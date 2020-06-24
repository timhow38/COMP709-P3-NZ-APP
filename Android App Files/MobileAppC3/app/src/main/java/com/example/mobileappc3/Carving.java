package com.example.mobileappc3;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName="carvings")
public class Carving implements Parcelable {

    //Creates database variables
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "carv_Name")
    private String carvName;

    @ColumnInfo(name = "carv_Desc")
    private String carvDesc;

    @ColumnInfo(name = "carv_imageName")
    private int carvImageName;

    //Carving class constructor to collect carving information
    public Carving(String carvName, String carvDesc, int carvImageName){
        this.carvName = carvName;
        this.carvDesc = carvDesc;
        this.carvImageName = carvImageName;
    }

    //Ignores empty Carving constructor
    @Ignore
    public Carving(){}

    //Creates Carving parcel
    protected Carving(Parcel in){
        id = in.readInt();
        carvName = in.readString();
        carvDesc = in.readString();
        carvImageName = in.readInt();
    }

    //Creates Carving parcelable
    public static final Parcelable.Creator<Carving> CREATOR = new Creator<Carving>(){
        @Override
        public Carving createFromParcel(Parcel in) {
            return new Carving(in);
        }

        @Override
        public Carving[] newArray(int size) {
            return new Carving[size];
        }
    };

    //Creates carving getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarvName() {
        return carvName;
    }

    public void setCarvName(String carvName) {
        this.carvName = carvName;
    }

    public String getCarvDesc() {
        return carvDesc;
    }

    public void setCarvDesc(String carvDesc) {
        this.carvDesc = carvDesc;
    }

    public int getCarvImageName() {
        return carvImageName;
    }

    public void setCarvImageName(int carvImageName) {
        this.carvImageName = carvImageName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    //Writes to parcel to create parcelable
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(carvName);
        dest.writeString(carvDesc);
        dest.writeInt(carvImageName);

    }
}