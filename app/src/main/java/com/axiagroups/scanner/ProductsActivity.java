package com.axiagroups.scanner;

import android.app.Application;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.axiagroups.scanner.adapter.ProductAdapter;
import com.axiagroups.scanner.model.Product;
import com.axiagroups.scanner.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProductAdapter productAdapter;
    ProductRepository productRepository;

    List<Product>  demoProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_products);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        demoProducts = new ArrayList<>();
        demoProducts.add(new Product(1, "testDate", "testQR"));
        demoProducts.add(new Product(2, "testDate", "testQR"));
        demoProducts.add(new Product(3, "testDate", "testQR"));

        recyclerView = findViewById(R.id.recyclerView);
        productRepository = new ProductRepository((Application) getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productAdapter = new ProductAdapter(demoProducts);
        recyclerView.setAdapter(productAdapter);
    }
}