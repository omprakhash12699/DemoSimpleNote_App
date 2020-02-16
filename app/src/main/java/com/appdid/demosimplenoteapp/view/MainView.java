package com.appdid.demosimplenoteapp.view;

import com.appdid.demosimplenoteapp.model.Note;

import java.util.List;

public interface MainView {

    void showRefresh();
    void hideRefresh();
    void getResult(List<Note> notes);
    void onRequestSuccess(String value);
    void onRequestError(String value);

}
