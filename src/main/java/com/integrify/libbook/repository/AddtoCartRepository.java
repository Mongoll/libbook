package com.integrify.libbook.repository;

import com.integrify.libbook.bean.AddtoCart;
import com.integrify.libbook.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface AddtoCartRepository extends JpaRepository<AddtoCart, Long> {
    @Query("SELECT addToCart FROM AddtoCart addToCart WHERE addToCart.userId =:userId")
    List<AddtoCart>findCartItemsByUserId(@Param("userId") Long userId);

    @Query("SELECT addToCart FROM AddtoCart addToCart WHERE addToCart.userId =:userId AND addToCart.book.id =:bookId")
    Optional<AddtoCart> findCartItemByUserIdAndBookId(@Param("userId")Long userId, @Param("bookId") Long bookId);
    @Modifying
    @Transactional
    @Query("DELETE FROM AddtoCart addToCart WHERE addToCart.userId =:user_Id")
    void deleteByUserId(@Param("user_Id") Long user_Id);
}
