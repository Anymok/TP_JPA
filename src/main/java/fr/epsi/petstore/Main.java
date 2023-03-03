package fr.epsi.petstore;

import fr.epsi.petstore.bo.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Animalerie Nantes
        Address adr_Nantes = new Address("7", "Bd Lelasseur", "44000", "Nantes");
        em.persist(adr_Nantes);
        PetStore petStore_Nantes = new PetStore("Clochette & Cie", "Martine", adr_Nantes);
        em.persist(petStore_Nantes);

        // Animalerie Paris
        Address adr_Paris = new Address("91", "Rue de la Pompe", "75116", "Paris");
        em.persist(adr_Paris);
        PetStore petStore_Paris = new PetStore("Les Animaux de Paris", "René", adr_Paris);
        em.persist(petStore_Paris);

        // Animalerie Le Havre
        Address adr_LeHavre = new Address("83", "Rue Louis Brindeau", "76600", "Le Havre");
        em.persist(adr_LeHavre);
        PetStore petStore_LeHavre = new PetStore("Oscar et Ogustine", "Arthur", adr_LeHavre);
        em.persist(petStore_LeHavre);

        // Produit
        Product product1 = new Product("528297.0", "Souris Aumüller Baldi Édition de Noël",ProdType.ACCESSORY, 3.49);
        Product product2 = new Product("47497.13", "Royal Canin Sterilised 37",ProdType.FOOD, 6.19);
        Product product3 = new Product("472234.16", "Friandises Pedigree Dentastix 100",ProdType.FOOD, 30.29);
        Product product4 = new Product("178103.4", "Litière minérale Catsan Hygiène plus pour chat",ProdType.CLEANNING, 15.49);

        // Persit product
        em.persist(product1);
        em.persist(product2);
        em.persist(product3);
        em.persist(product4);

        // Animal
        Animal cat = new Cat(LocalDate.now(), "Roux", petStore_Nantes,"007");
        Animal cat1 = new Cat(LocalDate.now(), "Noir", petStore_Nantes, "008");
        Animal cat2 = new Cat(LocalDate.now(), "Blanc", petStore_Nantes, "009");
        Animal fishFresh = new Fish(LocalDate.now(), "Rouge", petStore_Paris, FishLivEnv.FRESH_WATER);
        Animal fishSea = new Fish(LocalDate.now(),"Jaune", petStore_LeHavre, FishLivEnv.SEA_WATER);
        Animal fishSea1 = new Fish(LocalDate.now(),"Violet", petStore_LeHavre, FishLivEnv.SEA_WATER);

        // Persist Animal
        em.persist(cat);
        em.persist(cat1);
        em.persist(cat2);
        em.persist(fishFresh);
        em.persist(fishSea);
        em.persist(fishSea1);

        // Nantes
        petStore_Nantes.getProducts().add(product1);
        petStore_Nantes.getProducts().add(product4);
        petStore_Nantes.getAnimals().add(cat);
        petStore_Nantes.getAnimals().add(cat1);
        petStore_Nantes.getAnimals().add(cat2);

        // Paris
        petStore_Paris.getProducts().add(product2);
        petStore_Paris.getProducts().add(product4);
        petStore_Paris.getAnimals().add(fishFresh);

        // Le Havre
        petStore_LeHavre.getProducts().add(product3);
        petStore_LeHavre.getProducts().add(product4);
        petStore_LeHavre.getAnimals().add(fishSea);
        petStore_LeHavre.getAnimals().add(fishSea1);

        // Persist
        em.persist(petStore_Nantes);
        em.persist(petStore_Paris);
        em.persist(petStore_LeHavre);

        // Fermer la transaction
        em.getTransaction().commit();

        // Affiche les produits et animaux de l'animalerie Nantes
        PetStore petStoreNantes = em.find(PetStore.class, 1);
        if(petStoreNantes != null) {
            System.out.println("=============== Liste des produits et animaux dans l'animalerie de " + petStoreNantes.getName() +" à " + petStoreNantes.getAddress().getCity() + "  ================");
            for(Product item : petStoreNantes.getProducts()) {
                System.out.println(item.toString());
            }
            for(Animal item : petStoreNantes.getAnimals()) {
                System.out.println(item.toString());
            }
        }

        // Affiche les produits et animaux de l'animalerie Paris
        PetStore petStoreParis = em.find(PetStore.class, 2);
        if(petStoreParis != null) {
            System.out.println("=============== Liste des produits et animaux dans l'animalerie de " + petStoreParis.getName() +" à " + petStoreParis.getAddress().getCity() + "  ================");
            for(Product item : petStoreParis.getProducts()) {
                System.out.println(item.toString());
            }
            for(Animal item : petStoreParis.getAnimals()) {
                System.out.println(item.toString());
            }
        }

        // Affiche les produits et animaux de l'animalerie Le Havre
        PetStore petStoreLeHavre = em.find(PetStore.class, 3);
        if(petStoreLeHavre != null) {
            System.out.println("=============== Liste des produits et animaux dans l'animalerie de " + petStoreLeHavre.getName() +" à " + petStoreLeHavre.getAddress().getCity() + "  ================");
            for(Product item : petStoreLeHavre.getProducts()) {
                System.out.println(item.toString());
            }
            for(Animal item : petStoreLeHavre.getAnimals()) {
                System.out.println(item.toString());
            }
        }

        em.close();
        emf.close();
    }
}