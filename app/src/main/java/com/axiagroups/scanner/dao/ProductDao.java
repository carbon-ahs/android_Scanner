package com.axiagroups.scanner.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.axiagroups.scanner.model.Product;

import java.util.List;

@Dao
public interface ProductDao {

    // below method is use to
    // add data to database.

    @Insert
    void insert(Product product);

    // below method is use to update
    // the data in our database.
    @Update
    void update(Product product);

    // below line is use to delete a
    // specific course in our database.
    @Delete
    void delete(Product product);

    // on below line we are making query to
    // delete all courses from our database.
    @Query("DELETE FROM product_table")
    void deleteAllProducts();

    // below line is to read all the courses from our database.
    // in this we are ordering our courses in ascending order
    // with our course name.
    @Query("SELECT * FROM product_table")
    LiveData<List<Product>> getAllProducts();
}
