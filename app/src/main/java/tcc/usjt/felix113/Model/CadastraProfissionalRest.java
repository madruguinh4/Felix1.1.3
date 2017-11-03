package tcc.usjt.felix113.Model;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;
import tcc.usjt.felix113.Present.UsuarioProfissional;

/**
 * Created by alan0 on 22/10/2017.
 */

public interface CadastraProfissionalRest {


    @POST("FelixTcc/webresources/felixtcc.tbcadastroprofissional/inserir")
    Call<Void> inserePessoa(@Body UsuarioProfissional usuarioProfissional);


    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:55203/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
