package com.example.groupassignment;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName="carvings")
public class Carving implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "carv_Name")
    private String carvName;

    @ColumnInfo(name = "carv_engName")
    private String carvEngName;

    @ColumnInfo(name = "carv_Desc")
    private String carvDesc;

    @ColumnInfo(name = "carv_imageName")
    private String carvImageName;

    public Carving(String carvName, String carvEngName, String carvDesc, String carvImageName){
        this.carvName = carvName;
        this.carvEngName = carvEngName;
        this.carvDesc = carvDesc;
        this.carvImageName = carvImageName;
    }

    @Ignore
    public Carving(){}

    protected Carving(Parcel in){
        id = in.readInt();
        carvName = in.readString();
        carvEngName = in.readString();
        carvDesc = in.readString();
        carvImageName = in.readString();
    }

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

    public String getCarvEngName() {
        return carvEngName;
    }

    public void setCarvEngName(String carvEngName) {
        this.carvEngName = carvEngName;
    }

    public String getCarvDesc() {
        return carvDesc;
    }

    public void setCarvDesc(String carvDesc) {
        this.carvDesc = carvDesc;
    }

    public String getCarvImageName() {
        return carvImageName;
    }

    public void setCarvImageName(String carvImageName) {
        this.carvImageName = carvImageName;
    }

    @Override
    public String toString(){
        return "Carving(" +
                "carvName='" + carvName + '\'' +
                ", carvEngName='" + carvEngName + '\'' +
                ", carvDesc='" + carvDesc + '\'' +
                ", carvImageName='" + carvImageName + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(carvName);
        parcel.writeString(carvEngName);
        parcel.writeString(carvDesc);
        parcel.writeString(carvImageName);

    }
}