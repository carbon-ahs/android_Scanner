package com.axiagroups.scanner;

import android.app.Application;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.axiagroups.scanner.adapter.ProductAdapter;
import com.axiagroups.scanner.model.Product;
import com.axiagroups.scanner.repository.ProductRepository;
import com.axiagroups.scanner.viewModel.ProductViewModel;

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

        ProductViewModel productViewModel = new ViewModelProvider.AndroidViewModelFactory(
                ProductsActivity.this.getApplication())
                .create(ProductViewModel.class);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        INSERT INTO product_table (create_date, qr_data) VALUES ("value2", "value3");
        productViewModel.getAllProducts().observe(this, products -> {
            productAdapter = new ProductAdapter(products);
            recyclerView.setAdapter(productAdapter);
        });
//        productRepository = new ProductRepository((Application) getApplicationContext());
//        productAdapter = new ProductAdapter(demoProducts);
//
//        recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(productAdapter);



    }
}