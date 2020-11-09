package com.tetravalstartups.oranzebird.modules.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tetravalstartups.oranzebird.R;
import com.tetravalstartups.oranzebird.modules.fragment.model.GetUserOrder;

import java.util.List;

public class GetUserOrderAdapter extends RecyclerView.Adapter<GetUserOrderAdapter.GetUserOderViewHolder> {
    private Context context;
    private List<GetUserOrder.Order> orderList;

    public GetUserOrderAdapter(Context context, List<GetUserOrder.Order> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public GetUserOrderAdapter.GetUserOderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.get_user_order_list_item, parent, false);
        return new GetUserOderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GetUserOrderAdapter.GetUserOderViewHolder holder, int position) {
        holder.created_at.setText("" + orderList.get(position).getCreatedAt());
        holder.transaction_id.setText("" + orderList.get(position).getTransactionId());
        holder.tvOrderTotal.setText("" + orderList.get(position).getOrderTotal());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class GetUserOderViewHolder extends RecyclerView.ViewHolder {
        private TextView created_at;
        private TextView transaction_id;
        private TextView tvOrderTotal;

        public GetUserOderViewHolder(@NonNull View itemView) {
            super(itemView);

            created_at = itemView.findViewById(R.id.created_at);
            transaction_id = itemView.findViewById(R.id.transaction_id);
            tvOrderTotal = itemView.findViewById(R.id.tvOrderTotal);
        }
    }
}
