/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "branch_books")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BranchBooks.findAll", query = "SELECT b FROM BranchBooks b"),
    @NamedQuery(name = "BranchBooks.findById", query = "SELECT b FROM BranchBooks b WHERE b.id = :id"),
    @NamedQuery(name = "BranchBooks.findByShelfNo", query = "SELECT b FROM BranchBooks b WHERE b.shelfNo = :shelfNo")})
public class BranchBooks implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "shelfNo")
    private String shelfNo;
    @JoinColumn(name = "bookId", referencedColumnName = "bookId")
    @ManyToOne(optional = false)
    private Bookmaster bookId;
    @JoinColumn(name = "branchId", referencedColumnName = "branchId")
    @ManyToOne(optional = false)
    private Branchmaster branchId;

    public BranchBooks() {
    }

    public BranchBooks(Integer id) {
        this.id = id;
    }

    public BranchBooks(Integer id, String shelfNo) {
        this.id = id;
        this.shelfNo = shelfNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShelfNo() {
        return shelfNo;
    }

    public void setShelfNo(String shelfNo) {
        this.shelfNo = shelfNo;
    }

    public Bookmaster getBookId() {
        return bookId;
    }

    public void setBookId(Bookmaster bookId) {
        this.bookId = bookId;
    }

    public Branchmaster getBranchId() {
        return branchId;
    }

    public void setBranchId(Branchmaster branchId) {
        this.branchId = branchId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BranchBooks)) {
            return false;
        }
        BranchBooks other = (BranchBooks) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BranchBooks[ id=" + id + " ]";
    }
    
}
