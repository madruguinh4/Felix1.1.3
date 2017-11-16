package tcc.usjt.felix113.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tcc.usjt.felix113.Model.Profissional;
import tcc.usjt.felix113.View.ViewProfissional.ProfissionalClient;

/**
 * Created by caiquecoelho on 11/15/17.
 */

public class APICaller {

    private static final String BASE_URL = "http://192.168.1.33:8888";


    public boolean call(final Profissional body) throws IOException, InterruptedException {

        final boolean[] success = {false};
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();

                ProfissionalClient profissionalClient = retrofit.create(ProfissionalClient.class);

                Call<Profissional> call = profissionalClient.create(body);

                try {
                    Response<Profissional> execute = call.execute();
                    Profissional profissional = execute.body();
                    success[0] = profissional != null && profissional.getId() != null;
                    System.out.println("id = " + profissional.getId());
                    System.out.println(success[0]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        thread.join();

        return success[0];
    }
}
