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
@Table(name = "branchmaster")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Branchmaster.findAll", query = "SELECT b FROM Branchmaster b"),
    @NamedQuery(name = "Branchmaster.findByBranchId", query = "SELECT b FROM Branchmaster b WHERE b.branchId = :branchId"),
    @NamedQuery(name = "Branchmaster.findByBranchName", query = "SELECT b FROM Branchmaster b WHERE b.branchName = :branchName"),
    @NamedQuery(name = "Branchmaster.findByCity", query = "SELECT b FROM Branchmaster b WHERE b.city = :city"),
    @NamedQuery(name = "Branchmaster.findByState", query = "SELECT b FROM Branchmaster b WHERE b.state = :state")})
public class Branchmaster implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "branchName")
    private String branchName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "state")
    private String state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "branchId")
    private Collection<BranchBooks> branchBooksCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "branchId")
    private Integer branchId;

    public Branchmaster() {
    }

    public Branchmaster(Integer branchId) {
        this.branchId = branchId;
    }

    public Branchmaster(Integer branchId, String branchName, String city, String state) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.city = city;
        this.state = state;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (branchId != null ? branchId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Branchmaster)) {
            return false;
        }
        Branchmaster other = (Branchmaster) object;
        if ((this.branchId == null && other.branchId != null) || (this.branchId != null && !this.branchId.equals(other.branchId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Branchmaster[ branchId=" + branchId + " ]";
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @XmlTransient
    public Collection<BranchBooks> getBranchBooksCollection() {
        return branchBooksCollection;
    }

    public void setBranchBooksCollection(Collection<BranchBooks> branchBooksCollection) {
        this.branchBooksCollection = branchBooksCollection;
    }
    
}
