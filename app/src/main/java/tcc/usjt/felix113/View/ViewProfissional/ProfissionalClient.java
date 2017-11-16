package tcc.usjt.felix113.View.ViewProfissional;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;
import tcc.usjt.felix113.Model.Profissional;
import tcc.usjt.felix113.Present.UsuarioProfissional;

/**
 * Created by alan0 on 22/10/2017.
 */

public interface ProfissionalClient {

    @POST("/api/profissional/")
    Call<Profissional> create(@Body Profissional profissional);

}
