package com.axiagroups.scanner.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.axiagroups.scanner.R;
import com.axiagroups.scanner.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<Product> productList;

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_row, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);

        holder.idTV.setText(String.valueOf( product.getProductId()));
        holder.qrDataTV.setText(product.getQrData());
        holder.createDate.setText(product.getCreateDate());

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView idTV, qrDataTV, createDate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idTV = itemView.findViewById(R.id.row_idTV);
            qrDataTV = itemView.findViewById(R.id.row_qrData);
            createDate = itemView.findViewById(R.id.row_createDate);
        }
    }

}