package BdProy.jpa;

import BdProy.jpa.entidad.Aula;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ControlConcurrencia9_1 {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("colegio");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            Aula aula = em.find(Aula.class, "29b44750-c55d-4398-b333-4e9c2572dddb");

            aula.setCapacidad(10);

            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            em.close();
            emf.close();
        }
    }
}
