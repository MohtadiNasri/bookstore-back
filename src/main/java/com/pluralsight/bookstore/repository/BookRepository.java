package com.pluralsight.bookstore.repository;

import com.pluralsight.bookstore.model.Book;
import com.pluralsight.bookstore.util.NumberGenerator;
import com.pluralsight.bookstore.util.TextUtil;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

/*
* @Transactional
* REQUIRED always starts a new transaction
* SUPPORTS inherit from caller transaction .. perfect for read only
* */

//Select BookRepository and Press Alt + Enter to generate Test Class
@Transactional(SUPPORTS)
public class BookRepository {

    @PersistenceContext(unitName = "bookStorePU")
    private EntityManager entityManager;

    @Inject
    private NumberGenerator generator;

    @Inject
    private TextUtil textUtil;

    @Transactional(SUPPORTS)
    public Book find(@NotNull Long id){
        return entityManager.find(Book.class, id);
    }

    @Transactional(SUPPORTS)
    public List<Book> findAll(){
        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b ORDER BY b.title DESC", Book.class);
        return query.getResultList();
    }

    @Transactional(SUPPORTS)
    public Long countAll(){
        TypedQuery<Long> query = entityManager.createQuery("SELECT count(b) FROM Book b", Long.class);
        return query.getSingleResult();
    }

    @Transactional(REQUIRED)
    public Book create(@NotNull Book book){
        entityManager.persist(book);
        return book;
    }

    @Transactional(REQUIRED)
    public void delete(@NotNull Long id){
        //fetch then call delete method
        entityManager.remove(entityManager.getReference(Book.class, id));
    }

}
