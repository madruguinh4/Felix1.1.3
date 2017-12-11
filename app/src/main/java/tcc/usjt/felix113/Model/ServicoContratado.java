package tcc.usjt.felix113.Model;

/**
 * Created by caiquecoelho on 12/10/17.
 */

public class ServicoContratado {
    private Long id;
    private Long idProfissional;
    private Long idCliente;
    private Integer status;
    private String subcategoria;
    private Profissional profissional;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(Long idProfissional) {
        this.idProfissional = idProfissional;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(String subcategoria) {
        this.subcategoria = subcategoria;
    }

    public Profissional getProfissional() { return profissional; }

    public void setProfissional(Profissional profissional) { this.profissional = profissional;}
}
