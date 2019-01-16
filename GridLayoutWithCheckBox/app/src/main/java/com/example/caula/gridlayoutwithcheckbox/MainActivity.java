package com.example.caula.gridlayoutwithcheckbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridViewMain;
    ArrayList<Girl> girlArrayList;
    GirlAdapter girlAdapter;
    boolean isChoosing = false;
    boolean nothingChoosen = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        girlAdapter = new GirlAdapter(this, girlArrayList, R.layout.girl_row);
        gridViewMain.setAdapter(girlAdapter);
        gridViewMain.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if (!isChoosing) {
                    for (int i = 0; i < girlArrayList.size(); i++) {
                        CheckBox cbChecked = girlAdapter.getView(i, view, null).findViewById(R.id.cbChecked);
                        cbChecked.setVisibility(View.VISIBLE);
                        //cai comment o duoi de check
//                        TextView txtName = girlAdapter.getView(i, view, null).findViewById(R.id.txtName);
//                        Log.d("aaa", txtName.getText().toString());
                    }
                    isChoosing = true;
                    nothingChoosen = false;
                    girlArrayList.get(position).setChecked(true);
                    girlAdapter.notifyDataSetChanged();
                    return true;
                }
                return false;
            }
        });
        gridViewMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (!isChoosing) {
                    //Show image
                } else {
                    if (girlArrayList.get(position).isChecked()) {
                        girlArrayList.get(position).setChecked(false);
                        girlAdapter.notifyDataSetChanged();
                    } else {
                        girlArrayList.get(position).setChecked(true);
                        girlAdapter.notifyDataSetChanged();
                    }
                }
                nothingChoosen = true;
                for (int i = 0; i < girlArrayList.size(); i++) {
                    if (girlArrayList.get(i).isChecked()) {
                        nothingChoosen = false;
                    }
                }
                if (nothingChoosen) {
                    isChoosing = false;
                }
            }
        });
    }

    void anhXa() {
        gridViewMain = findViewById(R.id.gridViewMain);
        girlArrayList = new ArrayList<>();
        girlArrayList.add(new Girl("Girl 1", R.drawable.jav1, false));
        girlArrayList.add(new Girl("Girl 2", R.drawable.jav2, false));
        girlArrayList.add(new Girl("Girl 3", R.drawable.jav3, false));
    }

}
