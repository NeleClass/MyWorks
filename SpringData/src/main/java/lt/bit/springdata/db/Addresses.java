/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.bit.springdata.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author NeleN
 */
@Entity
@Table(name = "addresses")
@NamedQueries({
    @NamedQuery(name = "Addresses.findAll", query = "SELECT a FROM Addresses a")
    , @NamedQuery(name = "Addresses.findById", query = "SELECT a FROM Addresses a WHERE a.id = :id")
    , @NamedQuery(name = "Addresses.findByAddresses", query = "SELECT a FROM Addresses a WHERE a.addresses = :addresses")
    , @NamedQuery(name = "Addresses.findByCity", query = "SELECT a FROM Addresses a WHERE a.city = :city")
    , @NamedQuery(name = "Addresses.findByPostalCode", query = "SELECT a FROM Addresses a WHERE a.postalCode = :postalCode")})
public class Addresses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "addresses")
    private String addresses;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "postal_code")
    private String postalCode;
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Persons personId;

    public Addresses() {
    }

    public Addresses(Integer id) {
        this.id = id;
    }

    public Addresses(Integer id, String addresses, String city, String postalCode) {
        this.id = id;
        this.addresses = addresses;
        this.city = city;
        this.postalCode = postalCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddresses() {
        return addresses;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Persons getPersonId() {
        return personId;
    }

    public void setPersonId(Persons personId) {
        this.personId = personId;
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
        if (!(object instanceof Addresses)) {
            return false;
        }
        Addresses other = (Addresses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Addresses{" + "id=" + id + ", addresses=" + addresses + ", city=" + city + ", postalCode=" + postalCode + ", personId=" + personId + '}';
    }

    
}
