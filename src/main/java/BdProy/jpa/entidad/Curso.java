package BdProy.jpa.entidad;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="curso", uniqueConstraints = @UniqueConstraint(columnNames = {"codigo"}))
public class Curso implements Entidad{
    @Version
    private Integer version;
    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name="turno", nullable = false)
    private String turno;

    @Column(name="codigo", nullable = false, unique = true)
    private int codigo;

    @OneToOne
    @JoinColumn(name="id_aula")
    private Aula aula;

    @OneToOne(mappedBy = "curso")
    @JoinColumn(name="id_asignatura")
    private Asignatura asignatura;

    public Curso() {
    }

    public Curso(Aula aula, Asignatura asignatura){
        this.aula = aula;
        this.asignatura = asignatura;
    }

    @Override
    public String getId() {
        return this.id;
    }
    public void setId(String id) { this.id = id;}
    public String getTurno() { return this.turno;}

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
}
