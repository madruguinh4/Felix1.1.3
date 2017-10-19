package tcc.usjt.felix113.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import tcc.usjt.felix113.Present.LogaUsuario;
import tcc.usjt.felix113.Present.Usuario;

/**
 * Created by alan0 on 03/10/2017.
 */

public interface CadastroPessoasRest {



    //http://localhost:8080/Aula/webresources/aula.pessoas/count

    //http://localhost:8080/Felix/webresources/tccfelix.tbcadastro/count

    //http://localhost:55203/Felix/webresources/felix.tbcadastro/count

    @POST("Felix/webresources/felix.tbcadastro/inserir")
    Call<Void> inserePessoa(@Body Usuario usuario);

    @GET("Felix/webresources/tccfelix.tbcadastro")
    Call<List<Usuario>> getUsuario();

    @GET("Felix/webresources/felix.tbcadastro/buscar/{id}")
    Call<Usuario> getUsuarioPorId(@Path("id") String id);

    @GET("Felix/webresources/felix.tbcadastro/buscarUsuario/{email}")
    Call<LogaUsuario> getUsuarioPorEmail(@Path("email") String email);


    @GET("webresources/felix.tbcadastro/buscarUsuario/{emil}/{senha}")
    Call<LogaUsuario>login(@Path("email") String email, @Path("senha") String senha);




    @PUT("Felix/webresources/felix.tbcadastro/editar/{id}")
    Call<Void> alterarUsuario(@Path("id") String id, @Body Usuario usuario);

    @DELETE("Felix/webresources/felix.tbcadastro/remover/{id}")
    Call<Void> removeUsuario(@Path("id") String id);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:55203/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
