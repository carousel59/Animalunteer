package org.techtown.animalunteer;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class RecruitFragment extends Fragment {
    private static final String TAG = "RecruitFragment";

    RecyclerView recyclerView;
    MemoAdapter adapter;

    Context context;
    OnButtonSelectedListener listener;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        if (context instanceof OnButtonSelectedListener) {
            listener = (OnButtonSelectedListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (context != null) {
            context = null;
            listener = null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_recruit,
                container, false);
        initUI(rootView);
        loadMemoListData();
        return rootView;
    }

    private void initUI(ViewGroup rootView) {
        Button todayWriteButton = rootView.findViewById(R.id.todayWriteButton);
        todayWriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onButtonSelected(1);
                }

            }
        });

        recyclerView = rootView.findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MemoAdapter();

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnMemoItemClickListener() {
            @Override
            public void onItemClick(MemoAdapter.ViewHolder holder, View view, int position) {
                Memo item = adapter.getItem(position);
                Log.d(TAG, "아이템 선택됨 : " + item.get_id());
                if(listener != null){
                    listener.showMemoFragment(item);
                }
            }
        });
    }

    public int loadMemoListData() {
        AppConstants.println("loadMemoListData called.");
        String sql = "select _id, DATE, SHELTER, CONTENTS from " +
                MemoDatabase.TABLE_MEMO;

        int recordCount = -1;
        MemoDatabase database = MemoDatabase.getInstance(context);
        if (database != null) {
            Cursor outCursor = database.rawQuery(sql);
            recordCount = outCursor.getCount();
            AppConstants.println("record count : " + recordCount + "\n");
            ArrayList<Memo> items = new ArrayList<Memo>();

            for (int i = 0; i < recordCount; i++) {
                outCursor.moveToNext();
                int _id = outCursor.getInt(0);
                String date = outCursor.getString(1);
                String shelter = outCursor.getString(2);
                String contents = outCursor.getString(3);
                AppConstants.println("#" + i + " -> " + _id + ", " + date + ", "+  shelter + ", " + contents);
                items.add(new Memo(_id, date, shelter, contents));
            }
            outCursor.close();
            adapter.setItems(items);
            adapter.notifyDataSetChanged();
        }
        return recordCount;
    }
}