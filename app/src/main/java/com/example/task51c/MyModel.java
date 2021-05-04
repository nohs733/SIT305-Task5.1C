package com.example.task51c;

import android.content.Context;

public class MyModel {
    Context context;
    String data1, data2;
    int images;

    public MyModel(Context context, String data1, String data2, int images) {

        this.context = context;
        this.data1 = data1;
        this.data2 = data2;
        this.images = images;
    }

    public Context getContext() {return context;}
    public void setContext(Context context) {this.context = context;}

    public int getImages() {return images;}
    public void setImages(int images) {this.images = images;}

    public String getData1() {return data1;}
    public void setData1() {this.data1 = data1;}

    public String getData2() {return data2;}
    public void setData2() {this.data2 = data2;}
}
