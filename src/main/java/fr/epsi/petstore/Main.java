package fr.epsi.petstore;

import fr.epsi.petstore.bo.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Address address = new Address("5", "Rue Voltaire", "44000", "Nantes");
        em.persist(address);
        PetStore petStore = new PetStore("Hariet & Rosie", "Arthur", address);

        Product productFood = new Product("CRO001", "Croquette", ProdType.FOOD, 14.95);
        Product productAccessory = new Product("ARB001", "Arbre à chat", ProdType.ACCESSORY, 50);
        Product productCleaning = new Product("BRO001", "Brosse", ProdType.CLEANNING, 4.50);

        Animal animalCat = new Cat(LocalDate.now(), "Roux", "007");
        Animal animalFishFresh = new Fish(LocalDate.now(), "Rouge", FishLivEnv.FRESH_WATER);
        Animal animalFishSea = new Fish(LocalDate.now(), "Vert", FishLivEnv.SEA_WATER);




        petStore.getProducts().add(productFood);
        petStore.getProducts().add(productAccessory);
        petStore.getProducts().add(productCleaning);

        petStore.getAnimals().add(animalCat);
        petStore.getAnimals().add(animalFishFresh);
        petStore.getAnimals().add(animalFishSea);


        PetStore petStore1 = em.find(PetStore.class, 1);
        if(petStore1 != null){
            System.out.println(petStore1);
        }



        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}