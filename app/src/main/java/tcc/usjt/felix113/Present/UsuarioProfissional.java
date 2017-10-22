package tcc.usjt.felix113.Present;

/**
 * Created by alan0 on 21/10/2017.
 */

public class UsuarioProfissional {

    private int id;
    private String nome;
    private String sobrenome;
    private String email;
    private String telefone;
    private String senha;
    private String confirmeSenha;
    private int tipoUsuario;

    public int getServicos() {
        return servicos;
    }

    public void setServicos(int servicos) {
        this.servicos = servicos;
    }

    private int servicos;



    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmeSenha() {
        return confirmeSenha;
    }

    public void setConfirmeSenha(String confirmeSenha) {
        this.confirmeSenha = confirmeSenha;
    }

}
