package com.appdid.demosimplenoteapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.appdid.demosimplenoteapp.R;
import com.appdid.demosimplenoteapp.presenter.NotePresenter;
import com.appdid.demosimplenoteapp.view.NoteView;

public class AddNote extends AppCompatActivity implements NoteView {

    EditText mTitleEdt,mMessageEdt;
    Button mSaveBtn;
    NotePresenter notePresenter;
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        mTitleEdt = findViewById(R.id.edt_title);
        mMessageEdt = findViewById(R.id.edt_message);

        mSaveBtn = findViewById(R.id.btn_save);

        notePresenter = new NotePresenter(this);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Wait..");


        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mStrTitle = mTitleEdt.getText().toString();
                String mStrMessage = mMessageEdt.getText().toString();

                notePresenter.noteSavePresenter(mStrTitle,mStrMessage);


            }
        });




    }

    @Override
    public void showProgress() {
     mProgressDialog.show();
    }

    @Override
    public void hideProgress() {
        mProgressDialog.dismiss();
    }


    @Override
    public void onRequestSuccess(String value) {
        Toast.makeText(this,value,Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onRequestError(String value) {
        Toast.makeText(this,value,Toast.LENGTH_SHORT).show();
    }
}
