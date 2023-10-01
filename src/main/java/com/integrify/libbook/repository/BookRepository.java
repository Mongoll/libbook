package com.integrify.libbook.repository;

import com.integrify.libbook.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("Select pro FROM Book pro WHERE pro.categoryId=:cat_id")
    List<Book> getByCategoryId(@Param("cat_id")String cat_id);
    @Query("SELECT userBooks FROM Book userBooks WHERE userBooks.id IN " +
            "(Select addCart.book.id FROM AddtoCart addCart WHERE addCart.userId=:userId)")
    List<Object[]> getBooksById(@Param("userId") Long userId);
}
