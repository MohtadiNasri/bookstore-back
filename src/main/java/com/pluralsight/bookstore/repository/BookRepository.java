package com.pluralsight.bookstore.repository;

import com.pluralsight.bookstore.model.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookRepository {

    @PersistenceContext(unitName = "bookStorPU")
    private EntityManager entityManager;

    public Book find(Long id){
        entityManager.find(Book.class, id);
    }
    public Book create(Book book){
        entityManager.persist(book);
        return book;
    }
    public void delete(Long id){
        //fetch then call delete method
        entityManager.remove(entityManager.getReference(Book.class, id));
    }

    public List<Book> findAll(){
        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b ORDER BY b.title DESC", Book.class);
        return query.getResultList();
    }

    public Long countAll(){
        TypedQuery<Long> query = entityManager.createQuery("SELECT count(b) FROM Book b", Long.class);
        return query.getSingleResult();
    }


}
