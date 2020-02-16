package com.appdid.demosimplenoteapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.appdid.demosimplenoteapp.R;
import com.appdid.demosimplenoteapp.model.Note;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyRecyclerAdapter> {

    private Context context;
    private List<Note> notes;
    private ItemClick itemClick;
    private ItemClickLong itemClickLong;

    public NoteAdapter(Context context, List<Note> notes, ItemClick itemClick, ItemClickLong itemClickLong) {
        this.context = context;
        this.notes = notes;
        this.itemClick = itemClick;
        this.itemClickLong = itemClickLong;
    }

    @NonNull
    @Override
    public MyRecyclerAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_list,parent,false);

        return new MyRecyclerAdapter(view,itemClick,itemClickLong);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerAdapter holder, int position) {

        Note noteList = notes.get(position);

        holder.date_text.setText(noteList.getDate_on_server());
        holder.title_text.setText(noteList.getTitle());
        holder.message_text.setText(noteList.getMessage());


    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class MyRecyclerAdapter extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        TextView date_text,title_text,message_text;
        CardView cardView;

        public MyRecyclerAdapter(@NonNull View itemView, ItemClick itemClick, ItemClickLong itemClickLong) {
            super(itemView);

            date_text = itemView.findViewById(R.id.date);
            title_text = itemView.findViewById(R.id.title);
            message_text = itemView.findViewById(R.id.message);
            cardView = itemView.findViewById(R.id.card_item);


            cardView.setOnClickListener(this);

            cardView.setOnLongClickListener(this);

        }


        @Override
        public void onClick(View view) {
            itemClick.onItemClick(view, getAdapterPosition());

        }

        @Override
        public boolean onLongClick(View view) {
            itemClickLong.onItemClickLong(view,getAdapterPosition());

            return false;
        }
    }

    public interface ItemClick {
        void onItemClick(View view, int position);
    }

    public interface ItemClickLong {
        void onItemClickLong(View view, int position);
    }


}
