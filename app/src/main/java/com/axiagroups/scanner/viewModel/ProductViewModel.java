package com.axiagroups.scanner.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.axiagroups.scanner.model.Product;
import com.axiagroups.scanner.repository.ProductRepository;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {
    // creating a new variable for product repository.
    private ProductRepository productRepository;

    // below line is to create a variable for live
    // data where all the courses are present.
    private LiveData<List<Product>> allProducts;
    public ProductViewModel(@NonNull Application application) {
        super(application);
        productRepository = new ProductRepository(application);
        allProducts = productRepository.getProductList();
    }


    // below method is use to insert the data to our repository.
    public void insert(Product product) {
        productRepository.insert(product);
    }

    // below line is to update data in our repository.
    public void update(Product product) {
        productRepository.insert(product);
    }

    // below line is to delete the data in our repository.
    public void delete(Product product) {
        productRepository.insert(product);
    }

    // below method is to delete all the courses in our list.
    public void deleteAllCourses() {
        productRepository.deleteAllProducts();
    }

    // below method is to get all the courses in our list.
    public LiveData<List<Product>> getAllProducts() {
        return allProducts;
    }
}
