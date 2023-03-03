package fr.epsi.petstore.bo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "FISH")
public class Fish extends Animal{
    @Enumerated( EnumType.STRING )
    @Column(name = "LIVINGENV")
    private FishLivEnv livingEnv;

    public Fish() {
    }

    public Fish(LocalDate birth, String couleur, PetStore petStore, FishLivEnv livingEnv) {
        super(birth, couleur, petStore);
        this.livingEnv = livingEnv;
    }

    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }

    @Override
    public String toString() {
        return "Fish{" +
                super.toString() +
                " livingEnv=" + livingEnv +
                '}';
    }
}
