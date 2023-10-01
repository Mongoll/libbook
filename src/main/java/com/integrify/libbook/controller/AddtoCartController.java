package com.integrify.libbook.controller;

import com.integrify.libbook.bean.AddtoCart;
import com.integrify.libbook.bean.Book;
import com.integrify.libbook.repository.AddtoCartRepository;
import com.integrify.libbook.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/addtocart")
public class AddtoCartController {

    private AddtoCartRepository addToCartRepository;
    private BookRepository bookRepository;

    public AddtoCartController(AddtoCartRepository addToCartRepository, BookRepository bookRepository) {
        this.addToCartRepository = addToCartRepository;
        this.bookRepository = bookRepository;
    }

    @PostMapping("/add/{userId}/{qty}")
    public void addToCart(@PathVariable Long userId, @PathVariable int qty, @RequestBody Book request) {
        // get book by ID
        Book book = bookRepository.findById(request.getId()).orElse(null);
        Optional<AddtoCart> existBook = addToCartRepository.findCartItemByUserIdAndBookId(userId,book.getId());
        if (existBook.isPresent()){
            updateCartItemQty(existBook.get().getId(), existBook.get().getQty()+qty);
            System.out.println(existBook.get().getId());
            System.out.println(qty);
        }else {
        AddtoCart cartItem = new AddtoCart();
        cartItem.setBook(book);
        cartItem.setUserId(userId);
        cartItem.setQty(qty);
        cartItem.setAddedDate(LocalDateTime.now());
        // Save the cart item
        addToCartRepository.save(cartItem);}
    }

    @DeleteMapping("/remove/{cartItemId}")
    public void removeFromCart(@PathVariable Long cartItemId) {
        // Implement logic to remove a book from the cart
        addToCartRepository.deleteById(cartItemId);
    }

    @DeleteMapping("/delete/{user_Id}")
    public void removeCart(@PathVariable Long user_Id) {
        // Implement logic to remove a book from the cart
        addToCartRepository.deleteByUserId(user_Id);
    }

    @GetMapping("/list/{userId}")
    public List<AddtoCart> getCartItems(@PathVariable Long userId) {
        // Retrieve the cart items for the user along with book information
        return addToCartRepository.findCartItemsByUserId(userId);
    }

    @PutMapping("/update/{cartItemId}/{qty}")
    public void updateCartItemQty(@PathVariable Long cartItemId, @PathVariable int qty) {
        // Retrieve the cart item by ID and update the quantity
        Optional<AddtoCart> cartItemOptional = addToCartRepository.findById(cartItemId);
        if (cartItemOptional.isPresent()) {
            AddtoCart cartItem = cartItemOptional.get();
            cartItem.setQty(qty);
            addToCartRepository.save(cartItem);
        }else{
            System.out.println("something went wrong");}
    }
}
