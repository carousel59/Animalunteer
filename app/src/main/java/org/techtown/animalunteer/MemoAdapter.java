package org.techtown.animalunteer;

import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MemoAdapter extends RecyclerView.Adapter<MemoAdapter.ViewHolder>
        implements OnMemoItemClickListener {
    ArrayList<Memo> items = new ArrayList<Memo>();
    OnMemoItemClickListener listener;
    int layoutType = 0;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.memo_item, viewGroup, false);
        return new ViewHolder(itemView, this, layoutType);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Memo item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(Memo item) {
        items.add(item);
    }

    public void setItems(ArrayList<Memo> items) {
        this.items = items;
    }

    public Memo getItem(int position) {
        return items.get(position);
    }

    public void setOnItemClickListener(OnMemoItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if (listener != null) {
            listener.onItemClick(holder, view, position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout layout1;
        TextView dateTextView;
        TextView shelterTextView;
        TextView contentsTextView;

        public ViewHolder(final View itemView, final OnMemoItemClickListener listener, int layoutType) {
            super(itemView);

            layout1 = itemView.findViewById(R.id.layout1);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            shelterTextView = itemView.findViewById(R.id.shelterTextView);
            contentsTextView = itemView.findViewById(R.id.contentsTextView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });
        }

        public void setItem(Memo item){
            dateTextView.setText(item.getDate());
            shelterTextView.setText(item.getShelter());
            contentsTextView.setText(item.getContents());
        }
    }
}
