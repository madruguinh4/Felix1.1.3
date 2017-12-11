package tcc.usjt.felix113;

import java.util.ArrayList;

public class ProfissionalCustom extends ArrayList<ProfissionalCustom>{


    private int imagem; // vai armazenar o identificador do recurso
    private String nome;
    private String telefone;
    private String nota;



    public ProfissionalCustom(int imagem, String nome, String telefone, String nota) {
        this.imagem = imagem;
        this.nome = nome;
        this.telefone = telefone;
        this.nota = nota;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
