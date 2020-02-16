package com.appdid.demosimplenoteapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.appdid.demosimplenoteapp.R;
import com.appdid.demosimplenoteapp.adapter.NoteAdapter;
import com.appdid.demosimplenoteapp.model.Note;
import com.appdid.demosimplenoteapp.presenter.MainPresenter;
import com.appdid.demosimplenoteapp.presenter.NotePresenter;
import com.appdid.demosimplenoteapp.view.MainView;
import com.appdid.demosimplenoteapp.view.NoteView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class MainActivity extends AppCompatActivity implements MainView, NoteView {

    FloatingActionButton mFabBtn;
    SwipeRefreshLayout swipeRefreshLayout;
    MainPresenter mainPresenter;
    NotePresenter notePresenter;
    NoteAdapter noteAdapter;
    NoteAdapter.ItemClick itemClick;
    NoteAdapter.ItemClickLong itemClickLong;
    RecyclerView recyclerView;
    List<Note> noteList;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = findViewById(R.id.swipe_refresh);

        mainPresenter = new MainPresenter(this);
        notePresenter = new NotePresenter(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("wait");

        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mainPresenter.readNotePresenter();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                mainPresenter.readNotePresenter();

            }
        });


        itemClick = new NoteAdapter.ItemClick() {
            @Override
            public void onItemClick(View view, final int position) {

                Toast.makeText(MainActivity.this,"delete",Toast.LENGTH_SHORT).show();

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Confirm !");
                alertDialog.setMessage("Do you want to delete?");
                alertDialog.setCancelable(false);

                alertDialog.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mainPresenter.deleteNOtePresenter(noteList.get(position).getId());
                    }
                });

                alertDialog.setPositiveButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        progressDialog.dismiss();                 }
                });




                alertDialog.show();

            }
        };

        itemClickLong = new NoteAdapter.ItemClickLong() {
            @Override
            public void onItemClickLong(View view, int position) {

                Toast.makeText(MainActivity.this,"Update",Toast.LENGTH_SHORT).show();

            }
        };


        mFabBtn = findViewById(R.id.add_note);

        mFabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AddNote.class));
            }
        });

    }

    @Override
    public void showRefresh() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideRefresh() {
        swipeRefreshLayout.setRefreshing(false);

    }

    @Override
    public void getResult(List<Note> notes) {
        noteAdapter = new NoteAdapter(this, notes, itemClick,itemClickLong);
        noteAdapter.notifyDataSetChanged();
        recyclerView.setAdapter(noteAdapter);
        noteList =  notes;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void onRequestSuccess(String value) {
        Toast.makeText(this,value,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestError(String value) {
        Toast.makeText(this,value,Toast.LENGTH_SHORT).show();

    }
}
