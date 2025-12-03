/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdi;

import ejb.BookLocal;
import entity.Bookmaster;
import entity.Branchmaster;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author DELL
 */
@Named(value = "BookManagedBean")
@SessionScoped
public class BookManagedBean implements Serializable {

    @EJB
    BookLocal bl;
    private Integer editId;
    private String bname;
    private String bauthor;
    private String bcategory;
    private Integer selectedBranches;
    private String shelfNo;

    /**
     * Creates a new instance of BookManagedBean
     */
    public BookManagedBean() {
    }

    public String addBook() {
        Bookmaster savedbook = bl.addBook(bname, bauthor, bcategory);
        bl.assignBookToBranches(savedbook, List.of(selectedBranches), shelfNo);
        return "AllBooks?faces-redirect=true";
    }

    public List<Branchmaster> getAllBranches() {
        return bl.getAllBranches();
    }

    public List<Bookmaster> getAllBooks() {
        return bl.getAllBooks();
    }

    public String deleteBook(Integer id) {
        bl.deleteBook(id);
        return "AllBooks?faces-redirect=true";
    }

    public String loadEdit(Integer id) {
        Bookmaster bm = bl.getBookById(id);

        this.editId = id;
        this.bname = bm.getBookName();
        this.bauthor = bm.getAuthor();
        this.bcategory = bm.getCategory();

        return "Edit.xhtml?faces-redirect=true";
    }

    public String updateBook() {
        bl.updateBook(editId, bname, bauthor, bcategory);
        return "AllBooks?faces-redirect=true";
    }

    public BookLocal getBl() {
        return bl;
    }

    public void setBl(BookLocal bl) {
        this.bl = bl;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBauthor() {
        return bauthor;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public String getBcategory() {
        return bcategory;
    }

    public void setBcategory(String bcategory) {
        this.bcategory = bcategory;
    }

    public Integer getSelectedBranches() {
        return selectedBranches;
    }

    public void setSelectedBranches(Integer selectedBranches) {
        this.selectedBranches = selectedBranches;
    }

    public String getShelfNo() {
        return shelfNo;
    }

    public void setShelfNo(String shelfNo) {
        this.shelfNo = shelfNo;
    }

    public Integer getEditId() {
        return editId;
    }

    public void setEditId(Integer editId) {
        this.editId = editId;
    }

}
