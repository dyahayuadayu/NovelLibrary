package co.xomodo.novellibrary;

import android.os.Parcel;
import android.os.Parcelable;

public class Novel implements Parcelable {
    private int mNovelPhoto;
    private String mNovelTitle;
    private String mNovelWriter;
    private String mJudulResensi;
    private String mResensiPg1;
    private String mResensiPg2;
    private String mResensiPg3;

    public Novel(int novelPhoto, String novelTitle, String novelWriter, String judulRensensi,
                 String resensiPg1,String resensiPg2, String resensiPg3) {
        mNovelPhoto = novelPhoto;
        mNovelTitle = novelTitle;
        mNovelWriter = novelWriter;
        mJudulResensi = judulRensensi;
        mResensiPg1 = resensiPg1;
        mResensiPg2 = resensiPg2;
        mResensiPg3 = resensiPg3;
    }

    protected Novel(Parcel in) {
        mNovelPhoto = in.readInt();
        mNovelTitle = in.readString();
        mNovelWriter = in.readString();
        mJudulResensi = in.readString();
        mResensiPg1 = in.readString();
        mResensiPg2 = in.readString();
        mResensiPg3 = in.readString();
    }

    public static final Creator<Novel> CREATOR = new Creator<Novel>() {
        @Override
        public Novel createFromParcel(Parcel in) {
            return new Novel(in);
        }

        @Override
        public Novel[] newArray(int size) {
            return new Novel[size];
        }
    };

    public int getNovelPhoto() {
        return mNovelPhoto;
    }

    public String getNovelTitle() {
        return mNovelTitle;
    }

    public String getNovelWriter() {
        return mNovelWriter;
    }

    public String getJudulResensi() {
        return mJudulResensi;
    }

    public String getResensiPg1() {
        return mResensiPg1;
    }

    public String getResensiPg2() {
        return mResensiPg2;
    }

    public String getResensiPg3() {
        return mResensiPg3;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mNovelPhoto);
        parcel.writeString(mNovelTitle);
        parcel.writeString(mNovelWriter);
        parcel.writeString(mJudulResensi);
        parcel.writeString(mResensiPg1);
        parcel.writeString(mResensiPg2);
        parcel.writeString(mResensiPg3);
    }
}