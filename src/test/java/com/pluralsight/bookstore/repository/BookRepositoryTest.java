package com.pluralsight.bookstore.repository;

import com.pluralsight.bookstore.model.Book;
import com.pluralsight.bookstore.model.Language;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class BookRepositoryTest {

    @Inject
    private BookRepository bookRepository;

    @Test
    public void create() {
        //Test counting book
        assertEquals(Long.valueOf(0), bookRepository.countAll());
        assertEquals(0, bookRepository.findAll().size());

        // Creates a book
        Book book = new Book("a title", "descriptioon", 12F, "isbn", new Date(), 123,"imageURL", Language.ENGLISH);
        bookRepository.create(book);
        Long bookId = book.getId();

        //Check created book
        assertNotNull(bookId);

        //Find Created Book
        Book bookFound = bookRepository.find(bookId);

        //Check the found book
        assertEquals("a title",bookFound.getTitle());


    }

    /* to avoid error WELD-001474: ..BookRepository is on the classpath, but was ignored because a class it references was not found: com.pluralsight.bookstore.model.Book
     * you have to add Book Class to ShrinWrap
     */
    /*@Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addAsManifestResource("META-INF/test-persistence.xml", "persistence.xml")
                .addClass(BookRepository.class)
                .addClass(Book.class)
                .addClass(Language.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }*/
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addAsManifestResource("META-INF/test-persistence.xml", "persistence.xml")
                .addClass(BookRepository.class)
                .addClass(Book.class)
                .addClass(Language.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

}
