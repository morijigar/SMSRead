package com.example.apifetch.models;

public class Sms {
    private String _id;
    private String _address;
    private String _msg;
    private String _readState; //"0" for have not read sms and "1" for have read sms
    private String _time;
    private String _folderName;
    private String _amount;
    private Double amountD;

    public String getId() {
        return _id;
    }

    public String getAddress() {
        return _address;
    }

    public String getMsg() {
        return _msg;
    }

    public String getReadState() {
        return _readState;
    }

    public String getTime() {
        return _time;
    }

    public String getFolderName() {
        return _folderName;
    }


    public void setId(String id) {
        _id = id;
    }

    public void setAddress(String address) {
        _address = address;
    }

    public void setMsg(String msg) {
        _msg = msg;
    }

    public void setReadState(String readState) {
        _readState = readState;
    }

    public void setTime(String time) {
        _time = time;
    }

    public void setFolderName(String folderName) {
        _folderName = folderName;
    }

    public String get_amount() {
        return _amount;
    }

    public void set_amount(String _amount) {
        this._amount = _amount;
    }

    public void setAmountD(Double amountD) {
        this.amountD = amountD;
    }

    public Double getAmountD() {
        return amountD;
    }
}