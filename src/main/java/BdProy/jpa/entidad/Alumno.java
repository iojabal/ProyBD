package BdProy.jpa.entidad;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Alumno implements Entidad{

    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="apellido", nullable = false)
    private String apellido;

    @ManyToMany(mappedBy = "alumno")
    private List<Alumno_Asignatura> al;

    public Alumno() {
    }

    public Alumno(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void agregarInscripcion(Alumno_Asignatura ala) {
        if (al == null) {
            al = new ArrayList<>();
        }
        al.add(ala);
    }

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<Alumno_Asignatura> getAl() {
        return al;
    }

    public void setAl(List<Alumno_Asignatura> al) {
        this.al = al;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + " " + apellido +
                '}' + "\n";
    }
}
