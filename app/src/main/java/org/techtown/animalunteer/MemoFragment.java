package org.techtown.animalunteer;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class MemoFragment extends Fragment {
    private static final String TAG = "MemoFragment";

    Context context;
    OnButtonSelectedListener listener;

    EditText dateInput;
    EditText shelterInput;
    EditText contentsInput;


    int mMode = AppConstants.MODE_INSERT;
    int _id = -1;
    Memo item;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_memo, container, false);
        initUI(rootView);
        applyItem();

        return rootView;
    }

    private void initUI(ViewGroup rootView) {
        dateInput = rootView.findViewById(R.id.dateInput);
        shelterInput = rootView.findViewById(R.id.shelterInput);
        contentsInput = rootView.findViewById(R.id.contentsInput);


        Button saveButton = rootView.findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mMode == AppConstants.MODE_INSERT){
                    saveMemo();
                } else if(mMode == AppConstants.MODE_MODIFY){
                    modifyMemo();
                }
                if(listener != null){
                    listener.onButtonSelected(0);
                }
            }
        });

        Button deleteButton = rootView.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteMemo();
                if (listener != null) {
                    listener.onButtonSelected(0);
                }
            }
        });

        Button closeButton = rootView.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onButtonSelected(0);
                }
            }
        });
    }

    public void setDate(String data) {
        dateInput.setText(data);
    }
    public void setShelter(String data) {
        shelterInput.setText(data);
    }
    public void setContents(String data) {
        contentsInput.setText(data);
    }

    public void setItem(Memo item) {
        this.item = item;
    }

    public void applyItem() {
        AppConstants.println("applyItem called.");

        if (item != null) {
            mMode = AppConstants.MODE_MODIFY;
            setDate(item.getDate());
            setShelter(item.getShelter());
            setContents(item.getContents());



        } else {
            mMode = AppConstants.MODE_INSERT;
            dateInput.setText("");
            shelterInput.setText("");
            contentsInput.setText("");
        }

    }

    private void saveMemo() {
        String date = dateInput.getText().toString();
        String shelter = shelterInput.getText().toString();
        String contents = contentsInput.getText().toString();
        String sql = "insert into " + MemoDatabase.TABLE_MEMO +
                "(DATE, SHELTER, CONTENTS) values(" +
                "'"+ date + "', " +
                "'"+ shelter + "', " +
                "'"+ contents + "')";

        Log.d(TAG, "sql : " + sql);
        MemoDatabase database = MemoDatabase.getInstance(context);
        database.execSQL(sql);
    }

    private void modifyMemo() {
        if (item != null) {
            String date = dateInput.getText().toString();
            String shelter = shelterInput.getText().toString();
            String contents = contentsInput.getText().toString();
            String sql = "update " + MemoDatabase.TABLE_MEMO +
                    " set " +
                    "   DATE = '" + date + "'" +
                    "   ,SHELTER = '" + shelter + "'" +
                    "   ,CONTENTS = '" + contents + "'" +
                    " where " +
                    "   _id = " + item._id;

            Log.d(TAG, "sql : " + sql);
            MemoDatabase database = MemoDatabase.getInstance(context);
            database.execSQL(sql);
        }
    }

    private void deleteMemo() {
        AppConstants.println("deleteMemo called.");
        if (item != null) {
            // delete memo
            String sql = "delete from " + MemoDatabase.TABLE_MEMO +
                    " where " +
                    "   _id = " + item._id;
            Log.d(TAG, "sql : " + sql);
            item = null;
            MemoDatabase database = MemoDatabase.getInstance(context);
            database.execSQL(sql);
        }
    }

}