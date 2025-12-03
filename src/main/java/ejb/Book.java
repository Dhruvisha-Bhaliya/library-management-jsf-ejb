/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Bookmaster;
import entity.BranchBooks;
import entity.Branchmaster;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author DELL
 */
@Stateless
public class Book implements BookLocal {

    @PersistenceContext(unitName = "my_persistence_unit")
    EntityManager em;

    @Override
    public Bookmaster addBook(String BookName, String author, String category) {
        Bookmaster book = new Bookmaster();
        book.setBookName(BookName);
        book.setCategory(category);
        book.setAuthor(author);
        em.persist(book);
        em.flush();
        return book;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void assignBookToBranches(Bookmaster book, List<Integer> branchIds, String shelfNo) {
        for (Integer id : branchIds) {
            Branchmaster bm = em.find(Branchmaster.class, id);
            BranchBooks bom = new BranchBooks();
            bom.setBookId(book);
            bom.setBranchId(bm);
            bom.setShelfNo(shelfNo);
            em.persist(bom);
        }
    }

    @Override
    public List<Branchmaster> getAllBranches() {
        return em.createQuery("SELECT b FROM Branchmaster b", Branchmaster.class).getResultList();
    }

    @Override
    public List<Bookmaster> getAllBooks() {
        return em.createQuery("SELECT b FROM Bookmaster b", Bookmaster.class).getResultList();
    }

    @Override
    public void deleteBook(Integer id) {
        if (id == null) {
            return;
        }
        Bookmaster b = em.find(Bookmaster.class, id);
        if (b != null) {
            em.remove(b);
        }
    }

    @Override
    public Bookmaster getBookById(Integer id) {
        return em.find(Bookmaster.class, id);
    }

    @Override
    public void updateBook(Integer id, String name, String author, String category) {
        Bookmaster bm = em.find(Bookmaster.class, id);
        bm.setBookName(name);
        bm.setAuthor(author);
        bm.setCategory(category);
        em.flush();
    }
}
