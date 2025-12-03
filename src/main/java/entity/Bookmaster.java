/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "bookmaster")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bookmaster.findAll", query = "SELECT b FROM Bookmaster b"),
    @NamedQuery(name = "Bookmaster.findByBookId", query = "SELECT b FROM Bookmaster b WHERE b.bookId = :bookId"),
    @NamedQuery(name = "Bookmaster.findByBookName", query = "SELECT b FROM Bookmaster b WHERE b.bookName = :bookName"),
    @NamedQuery(name = "Bookmaster.findByAuthor", query = "SELECT b FROM Bookmaster b WHERE b.author = :author"),
    @NamedQuery(name = "Bookmaster.findByCategory", query = "SELECT b FROM Bookmaster b WHERE b.category = :category")})
public class Bookmaster implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "bookName")
    private String bookName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "author")
    private String author;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "category")
    private String category;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookId")
    private Collection<BranchBooks> branchBooksCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bookId")
    private Integer bookId;

    public Bookmaster() {
    }

    public Bookmaster(Integer bookId) {
        this.bookId = bookId;
    }

    public Bookmaster(Integer bookId, String bookName, String author, String category) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.category = category;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookId != null ? bookId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bookmaster)) {
            return false;
        }
        Bookmaster other = (Bookmaster) object;
        if ((this.bookId == null && other.bookId != null) || (this.bookId != null && !this.bookId.equals(other.bookId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Bookmaster[ bookId=" + bookId + " ]";
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @XmlTransient
    public Collection<BranchBooks> getBranchBooksCollection() {
        return branchBooksCollection;
    }

    public void setBranchBooksCollection(Collection<BranchBooks> branchBooksCollection) {
        this.branchBooksCollection = branchBooksCollection;
    }
    
}
