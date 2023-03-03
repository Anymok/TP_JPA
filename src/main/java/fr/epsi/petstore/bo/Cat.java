package fr.epsi.petstore.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "CAT")
public class Cat extends Animal {
    @Column(name = "CHIPID")
    private String chipId;

    public Cat() {
    }

    public Cat(LocalDate birth, String couleur, PetStore petStore, String chipId) {
        super(birth, couleur, petStore);
        this.chipId = chipId;
    }

    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }

    @Override
    public String toString() {
        return "Cat{" +
                super.toString() +
                " chipId='" + chipId + '\'' +
                '}';
    }
}
