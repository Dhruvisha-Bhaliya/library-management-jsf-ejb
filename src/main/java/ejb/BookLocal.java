/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package ejb;

import entity.Bookmaster;
import entity.Branchmaster;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author DELL
 */
@Local
public interface BookLocal {

    Bookmaster addBook(String BookName, String author, String category);

    void assignBookToBranches(Bookmaster book, List<Integer> branchIds, String shelfNo);

    List<Branchmaster> getAllBranches();

    List<Bookmaster> getAllBooks();

    void deleteBook(Integer id);

    Bookmaster getBookById(Integer id);

    void updateBook(Integer id, String name, String author, String category);
}
