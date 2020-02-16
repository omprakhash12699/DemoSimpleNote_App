package com.appdid.demosimplenoteapp.view;

import com.appdid.demosimplenoteapp.model.Note;

public interface NoteView {

    void showProgress();
    void hideProgress();
    void onRequestSuccess(String value);
    void onRequestError(String value);


}
