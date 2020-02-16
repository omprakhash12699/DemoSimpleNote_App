package com.appdid.demosimplenoteapp.presenter;

import androidx.annotation.NonNull;

import com.appdid.demosimplenoteapp.api.ApiClient;
import com.appdid.demosimplenoteapp.api.ApiInterface;
import com.appdid.demosimplenoteapp.model.Note;
import com.appdid.demosimplenoteapp.view.NoteView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotePresenter {

   public NoteView view;

    public NotePresenter(NoteView view) {
        this.view = view;
    }


    public void noteSavePresenter(String title,String message)
    {
        view.showProgress();

        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

        Call<Note> call = apiInterface.saveNote(title,message);

        call.enqueue(new Callback<Note>() {
            @Override
            public void onResponse(Call<Note> call, Response<Note> response)
            {
                view.hideProgress();

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
                view.hideProgress();
                view.onRequestError(t.getLocalizedMessage()
                );
            }
        });


    }

    public void updateNotePresenter(String id,String title, String message)
    {
        view.showProgress();

        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);

        Call<Note> call = apiInterface.updateNote(id,title,message);

        call.enqueue(new Callback<Note>() {
            @Override
            public void onResponse(Call<Note> call, Response<Note> response)
            {
                view.hideProgress();

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
                view.hideProgress();
                view.onRequestError(t.getLocalizedMessage()
                );
            }
        });

    }







    //    public NoteView view;
//
//    public NotePresenter(NoteView view) {
//        this.view = view;
//    }
//
//    public  void noteSavePresenter( String title,  String message) {
//
//        view.showProgress();
//
//        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
//
//        Call<Note> call = apiInterface.saveNote(title,message);
//
//        call.enqueue(new Callback<Note>() {
//            @Override
//            public void onResponse(Call<Note> call, Response<Note> response) {
//
//                view.hideProgress();
//
//                if(response.isSuccessful() && response.body() != null)
//                {
//                    if(response.body().getSuccess())
//                    {
//                        view.onRequestSuccess(response.body().getValue());
//
//                    }
//                    else
//                    {
//                        view.onRequestError(response.body().getValue());
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<Note> call, @NonNull Throwable t) {
//                view.hideProgress();
//                view.onRequestError(t.getLocalizedMessage());
//            }
//        });
//
//    }
//
//    public void noteDeletePresenter(String id)
//    {
//        view.showProgress();
//
//        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
//
//        Call<Note> call = apiInterface.deleteNote(id);
//
//        call.enqueue(new Callback<Note>() {
//            @Override
//            public void onResponse(Call<Note> call, Response<Note> response) {
//
//                view.hideProgress();
//
//                if(response.isSuccessful() && response.body() != null)
//                {
//                    if(response.body().getSuccess())
//                    {
//                        view.onRequestSuccess(response.body().getValue());
//
//                    }
//                    else
//                    {
//                        view.onRequestError(response.body().getValue());
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<Note> call, @NonNull Throwable t) {
//                view.hideProgress();
//                view.onRequestError(t.getLocalizedMessage());
//            }
//        });
//    }

}
