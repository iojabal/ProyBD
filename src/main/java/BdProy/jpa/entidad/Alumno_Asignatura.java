package BdProy.jpa.entidad;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
public class Alumno_Asignatura implements Entidad {
    @Id
    private String id = UUID.randomUUID().toString();

    @ManyToOne
    private Alumno alumnos;

    @ManyToOne
    private Asignatura asignatura;

    public Alumno_Asignatura(Alumno alumnos, Asignatura asignatura) {
        this.alumnos = alumnos;
        this.asignatura = asignatura;
        this.alumnos.agregarInscripcion(this);
        this.asignatura.agregarInscripcion(this);
    }

    public Alumno_Asignatura() {
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Alumno getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumno alumnos) {
        this.alumnos = alumnos;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
}
