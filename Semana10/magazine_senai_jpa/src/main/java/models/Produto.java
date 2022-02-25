package models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@ToString
@Getter
@Setter
@Entity
@Table(name = "produtos") // como o nome da classe não é o nome da tabela precisa indicar o nome da tabela
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private double preco;
    @Column(name = "qtd_estoque") // nome na tabela
    private int qtdEstoque;
    @Column(name = "data_cadastro")
    private LocalDate dataCadastro = LocalDate.now();
    @Enumerated(EnumType.STRING) // sem isso salvaria como inteiro
    private StatusProduto status;
    @ManyToOne
    private Categoria categoria;

}
