package BdProy.jpa;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import BdProy.jpa.entidad.*;
import BdProy.jpa.repositorio.Repositorio;
import BdProy.jpa.repositorio.Repositorio_Generico;
import org.joda.time.LocalDate;
public class MainBasico {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("colegio");


    public static void main(String[] args) {

//        Repositorio<Alumno> repositorio = new Repositorio<Alumno>(emf);

        Repositorio_Generico<Asignatura> repositorioAsig = new Repositorio_Generico<>(emf, Asignatura.class);
        Repositorio_Generico<Profesor> repositorioP = new Repositorio_Generico<>(emf, Profesor.class);
        Repositorio_Generico<Aula> repositorioAula = new Repositorio_Generico<>(emf, Aula.class);
        Repositorio_Generico<Alumno> repositorioAlu = new Repositorio_Generico<>(emf, Alumno.class);
        Repositorio_Generico<Curso> repositorioC = new Repositorio_Generico<>(emf, Curso.class);
        Repositorio_Generico<Alumno_Asignatura> repositorioal = new Repositorio_Generico<>(emf, Alumno_Asignatura.class);

        try {
            Alumno alumno1 = new Alumno("Fabrizio Iojhan", "Balderrama Herrera");
            Alumno alumno2 = new Alumno("Angel", "Noe Muñoz");
            Alumno alumno3 = new Alumno("Cristian", "Ojalvo Revollo");
            Alumno alumno4 = new Alumno("Luis", "Zambrana Castillo");

            Aula aula1 = new Aula(12, 4);
            Aula aula2 = new Aula(11, 10);
            Aula aula3 = new Aula(14, 9);

            Curso cur1 = new Curso(aula1, "Tarde", 23);
            Curso cur2 = new Curso(aula2, "Tarde", 22);
            Curso cur3 = new Curso(aula3, "Tarde", 21);

            Profesor prof1 = new Profesor("Juan Miguel", "LaVieja");
            Profesor prof2 = new Profesor("Kinto", "Galvacho");
            Profesor prof3 = new Profesor("Manolo", "Ruiz");

            Asignatura asig1 = new Asignatura("Investigacion Operativa", 5, cur1, prof1);
            Asignatura asig2 = new Asignatura("Informatica Forense", 3, cur2, prof2);
            Asignatura asig3 = new Asignatura("Auditoria de sistemas", 9, cur3, prof3);



            repositorioAula.guardar(aula1);
            repositorioAula.guardar(aula2);
            repositorioAula.guardar(aula3);

            repositorioP.guardar(prof1);
            repositorioP.guardar(prof2);
            repositorioP.guardar(prof3);

            repositorioAlu.guardar(alumno1);
            repositorioAlu.guardar(alumno2);
            repositorioAlu.guardar(alumno3);
            repositorioAlu.guardar(alumno4);

            repositorioC.guardar(cur3);
            repositorioC.guardar(cur2);
            repositorioC.guardar(cur1);

            repositorioAsig.guardar(asig1);
            repositorioAsig.guardar(asig2);
            repositorioAsig.guardar(asig3);

            Alumno_Asignatura al1 = new Alumno_Asignatura(alumno1, asig1);
            Alumno_Asignatura al2 = new Alumno_Asignatura(alumno1, asig2);
            Alumno_Asignatura al3 = new Alumno_Asignatura(alumno1, asig3);

            Alumno_Asignatura al11 = new Alumno_Asignatura(alumno2, asig1);
            Alumno_Asignatura al12 = new Alumno_Asignatura(alumno2, asig2);
            Alumno_Asignatura al13 = new Alumno_Asignatura(alumno2, asig3);

            Alumno_Asignatura al21 = new Alumno_Asignatura(alumno3, asig1);
            Alumno_Asignatura al22 = new Alumno_Asignatura(alumno3, asig2);
            Alumno_Asignatura al23 = new Alumno_Asignatura(alumno3, asig3);

            Alumno_Asignatura al31 = new Alumno_Asignatura(alumno4, asig1);
            Alumno_Asignatura al32 = new Alumno_Asignatura(alumno4, asig2);
            Alumno_Asignatura al33 = new Alumno_Asignatura(alumno4, asig3);

            repositorioal.guardar(al1);
            repositorioal.guardar(al2);
            repositorioal.guardar(al3);

            repositorioal.guardar(al11);
            repositorioal.guardar(al12);
            repositorioal.guardar(al13);

            repositorioal.guardar(al21);
            repositorioal.guardar(al22);
            repositorioal.guardar(al23);

            repositorioal.guardar(al31);
            repositorioal.guardar(al32);
            repositorioal.guardar(al33);


        }
        finally{
            repositorioC.terminar();
            repositorioAula.terminar();
            repositorioal.terminar();
            repositorioAsig.terminar();
            repositorioAlu.terminar();
            repositorioP.terminar();
            emf.close();
        }

    }

}
