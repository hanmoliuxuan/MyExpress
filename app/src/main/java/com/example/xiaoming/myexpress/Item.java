package com.example.xiaoming.myexpress;

import java.util.ArrayList;
import java.util.List;

public class Item
{
    private String message;
    private String state;
    private String status;
    private  String condition;
    private String ischeck;
    private String com;
    private String nu;
    private List<Data> datas=new ArrayList<>();

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getIscheck() {
        return ischeck;
    }

    public void setIscheck(String ischeck) {
        this.ischeck = ischeck;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNu() {
        return nu;
    }

    public void setNu(String nu) {
        this.nu = nu;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {

        return state;
    }
    public List<Data> getData() {
        return datas;
    }

    public void setData(List<Data> datas) {
        this.datas = datas;
    }
    public void addData(Data data)
    {
        datas.add(data);
    }

    @Override
    public String toString() {
        String replay = "单号不存在";
        if (message.equals("ok")) {
            String i = null;
            switch (state) {
                case "0":
                    i = "在途中";
                    break;

                case "1":
                    i = "已揽收";
                    break;

                case "2":
                    i = "疑难";
                    break;

                case "3":
                    i = "已签收";
                    break;

                case "4":
                    i = "退签";
                    break;

                case "5":
                    i = "同城派送中";
                    break;

                case "6":
                    i = "退回";
                    break;
                case "7":
                    i = "转单";
                    break;
            }
            replay="\n"+datas;
        }
        return replay;
    }
}
