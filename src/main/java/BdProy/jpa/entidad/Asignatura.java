package BdProy.jpa.entidad;

import org.apache.ibatis.annotations.One;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Asignatura implements Entidad {
    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "nro_horas", nullable = false)
    private int nro_horas;

    @OneToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @OneToMany(mappedBy = "asignatura")
    private List<Profesor> profes = new ArrayList<>();

    @ManyToMany
    private List<Alumno_Asignatura> al;

    public List<Profesor> getProfes() {
        return profes;
    }

    public void setProfes(List<Profesor> profes) {
        this.profes = profes;
    }

    public Asignatura() {
    }

    public Asignatura(String nombre, int nro_horas) {
        this.nombre = nombre;
        this.nro_horas = nro_horas;
    }

    public void agregarInscripcion(Alumno_Asignatura ala) {
        if (al == null) {
            al = new ArrayList<>();
        }
        al.add(ala);
    }

    @Override
    public String getId() {
        return this.id;
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

    public int getNro_horas() {
        return nro_horas;
    }

    public void setNro_horas(int nro_horas) {
        this.nro_horas = nro_horas;
    }
}
