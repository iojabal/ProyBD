package BdProy.jpa.repositorio;

import BdProy.jpa.entidad.Alumno;
import BdProy.jpa.entidad.Alumno_Asignatura;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class Repositorio<E> {
    private EntityManager em;
    private EntityTransaction tx;

    public Repositorio(EntityManagerFactory emf){
        this.em = emf.createEntityManager();
        this.tx = em.getTransaction();
    }

    public void insertar(E entidad) {
        tx.begin();
        em.persist(entidad);
        tx.commit();
    }

    public void eliminar(String id) {
        tx.begin();
        Alumno alumno = em.find(Alumno.class, id);
        em.remove(alumno);
        tx.commit();
    }


    public void actualizarNombre(String id, String nombre) {
        tx.begin();
        Alumno alumno = em.find(Alumno.class, id);
        alumno.setNombre(nombre);
        tx.commit();
    }
    public void terminar(){
        em.close();
    }
}
