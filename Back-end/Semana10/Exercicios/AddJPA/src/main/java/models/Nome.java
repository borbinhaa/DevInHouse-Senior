package models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "exercicio3")
public class Nome {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;

    public Nome() {

    }

    public Nome(String nome) {
        this.nome = nome;
    }
}
