package tcc.usjt.felix113.View;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import tcc.usjt.felix113.Model.ServicoContratado;

/**
 * Created by alan0 on 22/10/2017.
 */

public interface ServicoClient {

    @POST("/api/servico-contratado/")
    Call<ServicoContratado> create(@Body ServicoContratado servicoContratado);
}
