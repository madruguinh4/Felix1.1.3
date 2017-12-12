package tcc.usjt.felix113.View;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import tcc.usjt.felix113.Model.ServicoContratado;

/**
 * Created by alan0 on 22/10/2017.
 */

public interface ServicoClient {

    @POST("/api/servico-contratado/")
    Call<ServicoContratado> create(@Body ServicoContratado servicoContratado);

    @GET("/api/servico-contratado/cliente/{idCliente}")
    Call<List<ServicoContratado>> findByCliente(@Path("idCliente") Long idCliente);

    @DELETE("/api/servico-contratado/{id}")
    Call<Boolean> delete(@Path("id") Long id);

    @PUT("/api/servico-contratado/avaliar/{id}/{nota}")
    Call<Boolean> update(@Path("id") Long id,@Path("nota") Integer nota);

    @GET("/api/servico-contratado/profissional/{idProfissional}")
    Call<List<ServicoContratado>> findByProfissional(@Path("idProfissional") Long idProfissional);
}
