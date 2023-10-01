package com.integrify.libbook.service.productService;


import com.integrify.libbook.bean.Book;
import com.integrify.libbook.bean.Category;
import com.integrify.libbook.repository.BookRepository;
import com.integrify.libbook.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServices {

    BookRepository productRepo;

    CategoryRepository cateRepo;

    public List<Book> getAllProducts(){
        return productRepo.findAll();
    }
    public List<Book>getProductsByCategory(String product_id){
        return productRepo.getByCategoryId(product_id);
    }

    public List<Category>getAllCategory(){
        return cateRepo.findAll();
    }

    public Book getProductsById(long productId) throws Exception {
        return productRepo.findById(productId).orElseThrow(() ->new Exception("Product is not found"));
    }
}