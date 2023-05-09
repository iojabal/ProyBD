package BdProy.jpa.entidad;

import javax.persistence.*;
import java.util.UUID;
@Entity
public class Profesor implements Entidad {

    @Id
    private String id = UUID.randomUUID().toString();


    @ManyToOne
    @JoinColumn(name="id_asignatura")
    private Asignatura asignatura;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="apellido", nullable = false)
    private String apellido;

    public Profesor() {
    }

    public Profesor(Asignatura asignatura) {
        this.asignatura = asignatura;
        this.asignatura.getProfes().add(this);
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
