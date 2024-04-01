package com.axiagroups.scanner.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.axiagroups.scanner.dao.ProductDao;
import com.axiagroups.scanner.database.ProductDatabase;
import com.axiagroups.scanner.model.Product;

import java.util.List;

public class ProductRepository {


    // below line is the create a variable
    // for dao and list for all courses.
    private ProductDao productDao;
    private LiveData<List<Product>> productList;

    // creating a constructor for our variables
    // and passing the variables to it.
    public ProductRepository(Application application) {
        ProductDatabase database = ProductDatabase.getInstance(application);
        productDao = database.ProductDao();
        productList = productDao.getAllProducts();
    }

    // creating a method to insert the data to our database.
    public void insert(Product product) {
        productDao.insert(product);
    }

    // creating a method to update data in database.
    public void update(Product product) {
        productDao.update(product);
    }

    // creating a method to delete the data in our database.
    public void delete(Product product) {
        productDao.delete(product);
    }

    // below is the method to delete all the courses.
    public void deleteAllProducts() {
        productDao.deleteAllProducts();
    }

    // below method is to read all the courses.
    public LiveData<List<Product>> getProductList() {
        return productList;
    }
}
