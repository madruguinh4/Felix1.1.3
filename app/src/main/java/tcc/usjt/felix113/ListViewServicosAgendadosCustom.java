package tcc.usjt.felix113;

/**
 * Created by alan0 on 23/08/2017.
 */

public class ListViewServicosAgendadosCustom {

    private String Profissao;
    private int imagem; // vai armazenar o identificador do recurso
    private String descricao;
    private int nota;

    public ListViewServicosAgendadosCustom(String Profissao, String descricao, int imagem, int nota) {
        this.Profissao= Profissao;
        this.descricao= descricao;
        this.imagem= imagem;
        this.nota = nota;
    }

    public String getProfissao() {
        return Profissao;
    }

    public void setProfissao(String profissao) {
        Profissao = profissao;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
