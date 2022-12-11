package com.example.onepoint_ourtree.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onepoint_ourtree.R;
import com.example.onepoint_ourtree.api.models.TreeViewModel;

import java.util.ArrayList;

public class TreeAdapter extends RecyclerView.Adapter<TreeAdapter.treeViewHolder> {

        private Context context;
        private ArrayList<TreeViewModel> treeList ;

    public TreeAdapter(Context context, ArrayList<TreeViewModel> treeList) {
        this.context = context;
        this.treeList = treeList;
    }

    @NonNull
        @Override
        public treeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(context).inflate(R.layout.item_tree,parent,false);
            return new treeViewHolder(view);
        }

        @Override
        public int getItemCount() {
            return treeList.size() ;
        }

        @Override
        public void onBindViewHolder(@NonNull treeViewHolder holder, int position) {

        TreeViewModel model = treeList.get(position);
        holder.name.setText(model.getTitre());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.goToDetail(context);
            }
        });

        }

        public class treeViewHolder extends RecyclerView.ViewHolder{

        private TextView name;

            public treeViewHolder(@NonNull View itemView) {
                super(itemView);
                name = itemView.findViewById(R.id.name_tree);


            }

        }

    }
