package BdProy.jpa;

import BdProy.jpa.entidad.Alumno;
import BdProy.jpa.entidad.Alumno_Asignatura;
import BdProy.jpa.entidad.Asignatura;

import javax.persistence.*;
import java.util.List;

public class MainConsultaJPQL {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("colegio");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            Query pq = em.createQuery("Select a From Alumno a");
            List<Alumno> alu = pq.getResultList();
//            System.out.println(alu.toString());



            Query pq2 = em.createQuery("SELECT al FROM Alumno_Asignatura al JOIN al.asignatura a JOIN al.alumno alu");
            List<Alumno_Asignatura> alu2 = pq2.getResultList();
//            System.out.println(alu2.toString());


            //Inciso 7
            String info_for = "Informatica Forense";
            Query ej7 = em.createQuery("SELECT a FROM Alumno a JOIN a.al aluasig JOIN aluasig.asignatura asig WHERE asig.nombre = :nombreAsignatura");
            ej7.setParameter("nombreAsignatura", info_for);
            List<Alumno> alumnoList = ej7.getResultList();
//            System.out.println(alumnoList.toString());

            //Inciso 8
            String id_profesor = "dbb2811c-d0b8-4235-b6fa-544609792f2f";
            Query ej8 = em.createQuery("SELECT a FROM Asignatura a JOIN a.profe prof WHERE prof.id = :idProf");
            ej8.setParameter("idProf", id_profesor);
            List<Asignatura> asignaturaList = ej8.getResultList();
            System.out.println(asignaturaList.toString());


            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            em.close();
            emf.close();
        }
    }
}
