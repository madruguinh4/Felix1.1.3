package tcc.usjt.felix113.View.ViewProfissional;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import tcc.usjt.felix113.Model.SubcategoriaCasa;

/**
 * Created by alan0 on 22/10/2017.
 */

public interface SubcategoriaCasaClient {

    @POST("/api/subcategoria-casa/")
    Call<SubcategoriaCasa> create(@Body SubcategoriaCasa subcategoriaCasa);

    @PUT("/api/subcategoria-casa/")
    Call<SubcategoriaCasa> update(@Body SubcategoriaCasa subcategoriaCasa);

    @GET("/api/subcategoria-casa/{idProfissional}")
    Call<SubcategoriaCasa> findById(@Path("idProfissional") Long idProfissional);
}
