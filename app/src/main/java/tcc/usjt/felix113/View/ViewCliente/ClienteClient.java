package tcc.usjt.felix113.View.ViewCliente;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import tcc.usjt.felix113.Model.Cliente;

/**
 * Created by alan0 on 22/10/2017.
 */

public interface ClienteClient {

    @POST("/api/cliente/")
    Call<Cliente> create(@Body Cliente cliente);

    @GET("/api/cliente/{email}/{senha}")
    Call<Cliente> findByEmailAndSenha(@Path("email") String email,@Path("senha") String senha);
}
