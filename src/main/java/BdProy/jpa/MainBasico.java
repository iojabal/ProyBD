package BdProy.jpa;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import BdProy.jpa.entidad.Alumno;
import BdProy.jpa.entidad.Aula;
import BdProy.jpa.repositorio.Repositorio;
import org.joda.time.LocalDate;
public class MainBasico {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("colegio");


    public static void main(String[] args) {

        Repositorio<Alumno> repositorio = new Repositorio<Alumno>(emf);

        try {
            Alumno cliente = new Alumno("Juanqui", "Perez");
            repositorio.insertar(client);
//            repositorio.actualizarNombre(cliente.getId(), "Juanqui");
//			repositorio.eliminar(cliente.getId());

            //repositorio.cicloDeVida(); // gestiona cliente
        }
        finally{
            repositorio.terminar();
            emf.close();
        }

    }

}
