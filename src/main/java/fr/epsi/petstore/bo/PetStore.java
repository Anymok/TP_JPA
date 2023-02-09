package fr.epsi.petstore.bo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "PETSTORE")
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "MANAGERNAME")
    private String managerName;
    @OneToOne
    private Address address;
    @OneToMany(mappedBy = "petStore")
    private Set<Animal> animals;
    @ManyToMany
    @JoinTable(name = "STO_PRO",
        joinColumns = @JoinColumn(name = "ID_STO", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "ID_PRO", referencedColumnName = "ID"))
    private Set<Product> products;

    {
        animals = new HashSet<>();
        products = new HashSet<>();
    }
    public PetStore() {
    }

    public PetStore(String name, String managerName, Address address) {
        this.name = name;
        this.managerName = managerName;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PetStore{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", managerName='" + managerName + '\'' +
                ", products=" + products +
                ", animals=" + animals +
                ", address=" + address +
                '}';
    }
}
