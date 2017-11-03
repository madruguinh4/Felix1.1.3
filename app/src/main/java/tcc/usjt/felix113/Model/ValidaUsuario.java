package tcc.usjt.felix113.Model;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;
import retrofit2.http.Path;
import tcc.usjt.felix113.Present.Usuario;

/**
 * Created by alan0 on 28/10/2017.
 */

public interface ValidaUsuario {


    @POST("FelixTcc/webresources/felixtcc.tbcadastro/validausuario/{email}/{senha}")
    Call<Usuario> validaemailsenha(@Path("email") String email, @Path("senha") String senha);


    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:55203/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


}
