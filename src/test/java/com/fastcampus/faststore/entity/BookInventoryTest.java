package com.fastcampus.faststore.entity;

import com.fastcampus.faststore.repository.BookRepository;
import com.fastcampus.faststore.type.DiscountType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class BookInventoryTest {
    @Autowired //
    BookRepository bookRepository;  //

    @Test
    public void addBook() {
        Book book = new Book("자바의 정석", "남궁성", 30000L);
        DiscountPolicy discountPolicy = new DiscountPolicy(DiscountType.PERCENT, 10L);
        BookSale bookSale = new BookSale(book, discountPolicy);

        BookInventory bookInventory = BookInventory.empty(book);
        bookInventory.addBook(bookSale);

        System.out.println("getIncome>>> " + bookInventory.getIncome()); //
        System.out.println("getPrice >>> " + bookSale.getPrice()); //
        System.out.println("getCount >>> " + bookInventory.getCount()); //

        assertThat(bookInventory.getIncome()).isEqualTo(bookSale.getPrice());
        assertThat(bookInventory.getCount()).isEqualTo(1L);
    }

    @Test
    public void minusBook() {
        Book book = new Book("자바의 정석", "남궁성", 30000L);
        DiscountPolicy discountPolicy = new DiscountPolicy(DiscountType.PERCENT, 10L);
        BookSale bookSale = new BookSale(book, discountPolicy);

        BookInventory bookInventory = BookInventory.empty(book);
        bookInventory.setCount(1L);
        bookInventory.setIncome(bookSale.getPrice());
        bookInventory.minusBook(bookSale);

        System.out.println("getIncome>>> " + bookInventory.getIncome()); //
        System.out.println("getCount >>> " + bookInventory.getCount()); //

        assertThat(bookInventory.getIncome()).isEqualTo(0L);
        assertThat(bookInventory.getCount()).isEqualTo(0L);
    }
}
