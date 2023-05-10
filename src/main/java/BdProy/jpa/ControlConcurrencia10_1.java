package BdProy.jpa;

import BdProy.jpa.entidad.Asignatura;
import BdProy.jpa.entidad.Aula;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ControlConcurrencia10_1 {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("colegio");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            Asignatura asig = em.find(Asignatura.class, "4e7a0c43-d27e-41e1-a539-57a8b0c6a8b2");
            asig.setNombre("Ethical Hacking");



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
