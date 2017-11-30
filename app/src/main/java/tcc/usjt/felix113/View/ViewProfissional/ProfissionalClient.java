package tcc.usjt.felix113.View.ViewProfissional;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import tcc.usjt.felix113.Model.Profissional;

/**
 * Created by alan0 on 22/10/2017.
 */

public interface ProfissionalClient {

    @POST("/api/profissional/")
    Call<Profissional> create(@Body Profissional profissional);

    @GET("/api/profissional/{email}/{senha}")
    Call<Profissional> findByEmailAndSenha(@Path("email") String email, @Path("senha") String senha);


}
