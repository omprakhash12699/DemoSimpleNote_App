package com.appdid.demosimplenoteapp.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Note {


//    @Expose
//    @SerializedName("id")
//    public String id;
//
//    @Expose
//    @SerializedName("title")
//    public String title;
//
//    @Expose
//    @SerializedName("message")
//    public String message;
//
//    @Expose
//    @SerializedName("date")
//    public String date;
//
//    @Expose
//    @SerializedName("success")
//    public Boolean success;
//
//    @Expose
//    @SerializedName("value")
//    public  String value;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    public Boolean getSuccess() {
//        return success;
//    }
//
//    public void setSuccess(Boolean success) {
//        this.success = success;
//    }
//
//    public String getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }

        @Expose
    @SerializedName("id") private String id;
    @Expose
    @SerializedName("title") private String title;
    @Expose
    @SerializedName("message") private String message;
    @Expose
    @SerializedName("date_on_server") private String date_on_server;
    @Expose
    @SerializedName("success") private Boolean success;
    @Expose
    @SerializedName("value") private String value;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDate_on_server() {
        return date_on_server;
    }

    public void setDate_on_server(String date_on_server) {
        this.date_on_server = date_on_server;
    }

}
