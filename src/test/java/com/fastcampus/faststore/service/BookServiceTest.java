package com.fastcampus.faststore.service;

import com.fastcampus.faststore.entity.Book;
import com.fastcampus.faststore.repository.BookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
public class BookServiceTest {

    @Autowired
    private BookRepository bookRepository;

    private BookService bookService;

    @BeforeEach
    public void setup() {
        bookService = new BookService(bookRepository);
    }

    @AfterEach
    public void tearDown() {
        bookRepository.deleteAll();
    }

    // TODO: getOrThrow 테스트 코드를 작성하세요.
    @Test
    public void getOrThrow() {
        try{
            Book book = bookService.getOrThrow("자바의 정석");

            System.out.println("book >>>" + book);
        }catch(RuntimeException e) {
            System.out.println(">>> " + e.getMessage());
        }

    }

    @Test
    public void registerBook() {
        bookService.registerBook("자바의 정석", "남궁성", 30000L);

        assertThat(bookRepository.findByTitle("자바의 정석")).isNotNull();

//        bookService.registerBook("수학의 정석", "홍성대", 30000L);
//        assertThat(bookRepository.findByTitle("수학의 정석")).isNotNull();


    }
}
