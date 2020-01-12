package com.example.xiaoming.myexpress;

public class Data {
    private String context;
    private String time;
    private String fitme;

    public void setContext(String context) {
        this.context = context;
    }

    public String getContext() {
        return context;
    }

    public void setFitme(String fitme) {
        this.fitme = fitme;
    }

    public String getFitme() {
        return fitme;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        String res=context+"\n"+"时间:"+time+"\n"+""+"\n";
        return res;
    }
}
