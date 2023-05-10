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
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor profe;

    @Version
    private Integer version;
    @ManyToMany
    @JoinTable(name = "alumno_asignatura",
            joinColumns = @JoinColumn(name = "asignatura_id"),
            inverseJoinColumns = @JoinColumn(name = "alumno_id"))
    private List<Alumno_Asignatura> al;

    public Profesor getProfe() {
        return profe;
    }

    public void setProfe(Profesor profe) {
        this.profe = profe;
    }

    public Asignatura() {
    }

    public Asignatura(String nombre, int nro_horas, Curso curso, Profesor profe) {
        this.nombre = nombre;
        this.nro_horas = nro_horas;
        this.curso = curso;

        this.profe = profe;
        profe.getAsignatura().add(this);
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

    @Override
    public String toString() {
        return "Asignatura{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", nro_horas=" + nro_horas +
                ", curso=" + curso +
                ", profe=" + profe +
                '}';
    }
}
