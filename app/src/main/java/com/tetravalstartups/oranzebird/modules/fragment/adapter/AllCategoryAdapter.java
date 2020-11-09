package com.tetravalstartups.oranzebird.modules.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tetravalstartups.oranzebird.R;
import com.tetravalstartups.oranzebird.modules.fragment.model.AllCategoryData;

import java.util.List;

public class AllCategoryAdapter extends RecyclerView.Adapter<AllCategoryAdapter.AllCategoryViewHOlder> {
    private Context context;
    private List<AllCategoryData> allCategoryDataList;

    public AllCategoryAdapter(Context context, List<AllCategoryData> allCategoryDataList) {
        this.context = context;
        this.allCategoryDataList = allCategoryDataList;
    }

    @NonNull
    @Override
    public AllCategoryAdapter.AllCategoryViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_category, parent, false);
        return new AllCategoryViewHOlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllCategoryAdapter.AllCategoryViewHOlder holder, int position) {
        AllCategoryData allCategory = allCategoryDataList.get(position);
        Glide.with(context).load("http://103.145.50.28/Ashish_dubey/orangebird/uploads/category-Images" + "/" + allCategory.getImage()).into(holder.ivCat);
        holder.tvCat.setText(allCategory.getCategory());

    }

    @Override
    public int getItemCount() {
        return allCategoryDataList.size();
    }

    public class AllCategoryViewHOlder extends RecyclerView.ViewHolder {
        private ImageView ivCat;
        private TextView tvCat;

        public AllCategoryViewHOlder(@NonNull View itemView) {
            super(itemView);

            tvCat = itemView.findViewById(R.id.tvCat);
            ivCat = itemView.findViewById(R.id.ivCat);
        }
    }
}
