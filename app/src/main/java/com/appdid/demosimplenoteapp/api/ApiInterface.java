package com.appdid.demosimplenoteapp.api;

import com.appdid.demosimplenoteapp.model.Note;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("save.php")
    Call<Note> saveNote(@Field("title") String title,
                  @Field("message") String message);
    @GET("read.php")
    Call<List<Note>> readNote();

    @FormUrlEncoded
    @POST("delete.php")
    Call<Note> deleteNote(@Field("id") String id );

    @FormUrlEncoded
    @POST("update.php")
    Call<Note> updateNote(@Field("id") String id,
                    @Field("title") String title,
                    @Field("message") String message);










//
//
//    @FormUrlEncoded
//    @POST("save.php")
//    Call<Note> saveNote(@Field("title") String title, @Field("message") String message);
//
//    @GET("read.php")
//    Call<List<Note>> readNote();
//
//    @FormUrlEncoded
//    @POST("delete.php")
//    Call<Note> deleteNote(@Field("id") String id);



}
