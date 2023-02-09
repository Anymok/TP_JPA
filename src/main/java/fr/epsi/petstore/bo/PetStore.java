package fr.epsi.petstore.bo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class PetStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String managerName;
    @ManyToMany
    @JoinTable(name = "STO_PRO",
        joinColumns = @JoinColumn(name = "ID_STO", referencedColumnName = "ID"),
        inverseJoinColumns = @JoinColumn(name = "ID_PRO", referencedColumnName = "ID")
    )
    private Set<Product> products;
    @OneToMany(mappedBy = "petStore")
    private Set<Animal> animals;
    @OneToOne
    private Address address;

    public PetStore() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
