package tcc.usjt.felix113.Model;

/**
 * Created by caiquecoelho on 12/10/17.
 */

public enum Status {
    AGENDADO(1),
    FINALIZADO(2);

    private Integer id;

    Status(Integer id) {
        this.id = id;
    }

    public Integer value(){
        return this.id;
    }
}
