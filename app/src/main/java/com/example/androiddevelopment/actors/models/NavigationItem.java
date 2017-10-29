package com.example.androiddevelopment.actors.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Luke Skywalker on 29.10.2017.
 */

public class NavigationItem implements Parcelable {

    private String title;
    private int icon;

    public NavigationItem(String title, int icon) {
        this.title = title;
        this.icon = icon;
    }

    private NavigationItem(Parcel in) {
        title = in.readString();
        icon = in.readInt();
    }

    public static final Creator<NavigationItem> CREATOR = new Creator<NavigationItem>() {
        @Override
        public NavigationItem createFromParcel(Parcel in) {
            return new NavigationItem(in);
        }

        @Override
        public NavigationItem[] newArray(int size) {
            return new NavigationItem[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "NavigationItem{" +
                "title='" + title + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeInt(icon);
    }
}
