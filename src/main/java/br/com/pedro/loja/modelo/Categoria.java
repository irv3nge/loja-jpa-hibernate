package br.com.pedro.loja.modelo;

import javax.persistence.*;

@Entity
@Table(name = "Categorias")
public class Categoria {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria(){

    }
}
