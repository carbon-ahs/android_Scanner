package com.axiagroups.scanner;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.axiagroups.scanner.repository.ProductRepository;

public class DashboardActivity extends AppCompatActivity {
    Button qrBtn, productBtn;
    ProductRepository productRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        productBtn = findViewById(R.id.productBtn);
        qrBtn = findViewById(R.id.qrBtn);
        productRepository = new ProductRepository((Application) getApplicationContext());

        qrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        productBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(productRepository.getProductList() == null) {
//                    Toast.makeText(DashboardActivity.this,"No data", Toast.LENGTH_SHORT);
//                }
                Intent intent = new Intent(DashboardActivity.this, ProductsActivity.class);
                startActivity(intent);
            }
        });
    }
}