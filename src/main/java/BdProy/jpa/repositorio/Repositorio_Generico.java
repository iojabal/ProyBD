package BdProy.jpa.repositorio;

import BdProy.jpa.entidad.Entidad;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class Repositorio_Generico <E extends Entidad> {


    private EntityManager em;
    private EntityTransaction tx;
    private Class<E> clase;

    public Repositorio_Generico(EntityManagerFactory emf, Class<E> clase){
        this.em = emf.createEntityManager();
        this.tx = em.getTransaction();
        this.clase = clase;
    }

    public void guardar(E entidad) {
        tx.begin();
        if (null == em.find(clase, entidad.getId()) ){
            em.persist(entidad);
        } else {
            em.merge(entidad);
        }
        tx.commit();
    }

    public void eliminar(String id) {
        tx.begin();
        E entidad = em.find(clase, id);
        em.remove(entidad);
        tx.commit();
    }

    public void terminar(){
        em.close();
    }

}

