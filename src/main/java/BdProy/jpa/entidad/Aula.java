package BdProy.jpa.entidad;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Aula implements Entidad {
    @Id
    private String id = UUID.randomUUID().toString();
    @Column(nullable = false)
    private int numero;
    @Column(nullable = false)
    private int capacidad;

    @OneToOne(mappedBy = "aula")
    @JoinColumn(name="id_curso")
    private Curso curso;

    Aula(){

    }
    @Version
    private Integer version;

    public Aula(int numero, int capacidad){
        this.capacidad = capacidad;
        this.numero = numero;
    }

    @Override
    public String getId() { return id; }
    public void setId(String Id) { this.id = Id; }
    public void setNumero(int numero) { this.numero = numero; }
    public int getNumero() { return this.numero; }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Aula{" +
                "id='" + id + '\'' +
                ", numero=" + numero +
                ", capacidad=" + capacidad +
                '}';
    }
}
