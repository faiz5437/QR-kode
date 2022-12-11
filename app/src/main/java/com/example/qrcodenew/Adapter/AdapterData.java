package com.example.qrcodenew.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qrcodenew.Model.ModelData;
import com.example.qrcodenew.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterData extends RecyclerView.Adapter<AdapterData.HolderViewSaya>{
    private List<ModelData> listData;
    private Context ctx;

    public AdapterData(List<ModelData> listData, Context ctx) {
        this.listData = listData;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public AdapterData.HolderViewSaya onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data, parent, false);
        HolderViewSaya vh =new HolderViewSaya(layout);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterData.HolderViewSaya holder, int position) {
        ModelData md =listData.get(position);


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class HolderViewSaya extends RecyclerView.ViewHolder{
        private TextView idt, desct, titlet;

        public HolderViewSaya(@NonNull View itemView) {
            super(itemView);
            idt = itemView.findViewById(R.id.tv_id);
            titlet = itemView.findViewById(R.id.titleTextView);
            desct = itemView.findViewById(R.id.descTextView);

        }
    }
}
