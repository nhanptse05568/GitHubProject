package com.example.caula.gridlayoutwithcheckbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GirlAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Girl> girlArrayList;
    private int layout;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Girl> getGirlArrayList() {
        return girlArrayList;
    }

    public void setGirlArrayList(ArrayList<Girl> girlArrayList) {
        this.girlArrayList = girlArrayList;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public GirlAdapter() {
    }

    public GirlAdapter(Context context, ArrayList<Girl> girlArrayList, int layout) {
        this.context = context;
        this.girlArrayList = girlArrayList;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return girlArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(layout, null);
        ImageView imgImage = convertView.findViewById(R.id.imgImage);
        TextView txtName = convertView.findViewById(R.id.txtName);
        CheckBox cbChecked = convertView.findViewById(R.id.cbChecked);
        txtName.setText(girlArrayList.get(position).getName());
        imgImage.setImageResource(girlArrayList.get(position).getImageID());
        if (girlArrayList.get(position).isChecked()) {
            cbChecked.setChecked(true);
        } else {
            cbChecked.setChecked(false);
        }
        return convertView;
    }
}
