package com.appdid.demosimplenoteapp.presenter;

import androidx.annotation.NonNull;

import com.appdid.demosimplenoteapp.api.ApiClient;
import com.appdid.demosimplenoteapp.api.ApiInterface;
import com.appdid.demosimplenoteapp.model.Note;
import com.appdid.demosimplenoteapp.view.MainView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {

    public  MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public void readNotePresenter()
    {
      view.showRefresh();

      ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

      Call<List<Note>> call = apiInterface.readNote();

            call.enqueue(new Callback<List<Note>>() {
          @Override
          public void onResponse(Call<List<Note>> call, Response<List<Note>> response) {

              view.hideRefresh();

              if(response.isSuccessful())
              {
                  view.getResult(response.body());
              }

          }

          @Override
          public void onFailure(Call<List<Note>> call, Throwable t) {
              view.hideRefresh();
              view.onRequestError(t.getLocalizedMessage());
          }
      });

    }

    public void  deleteNOtePresenter(String id)
    {
        view.showRefresh();

        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

        Call<Note> call = apiInterface.deleteNote(id);

        call.enqueue(new Callback<Note>() {
            @Override
            public void onResponse(Call<Note> call, Response<Note> response)
            {
                view.hideRefresh();

                if(response.isSuccessful())
                {
                    if(response.body().getSuccess())
                    {
                        view.onRequestSuccess(response.body().getValue());
                    }
                    else
                    {
                        view.onRequestError(response.body().getValue());
                    }
                }

            }

            @Override
            public void onFailure(Call<Note> call, Throwable t) {
                view.hideRefresh();
                view.onRequestError(t.getLocalizedMessage()
                );
            }
        });
    }



    //    private MainView view;
//
//    public MainPresenter(MainView view) {
//        this.view = view;
//    }
//
//    public void getData() {
//        view.showRefresh();
//
//        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
//
//        Call<List<Note>> call = apiInterface.readNote();
//
//        call.enqueue(new Callback<List<Note>>() {
//            @Override
//            public void onResponse(@NonNull Call<List<Note>> call, @NonNull Response<List<Note>> response) {
//                view.hideRefresh();
//
//                if(response.isSuccessful() && response.body() != null)
//                {
//                    view.getResult(response.body());
//                }
//
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<List<Note>> call,@NonNull Throwable t) {
//                view.hideRefresh();
//                view.onRequestError(t.getLocalizedMessage());
//            }
//        });
//
//
//    }
}
