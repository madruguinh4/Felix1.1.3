package tcc.usjt.felix113.View.ViewProfissional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tcc.usjt.felix113.Model.Profissional;
import tcc.usjt.felix113.Model.SubcategoriaCasa;


public class APICaller {

    private static final String BASE_URL = "http://192.168.0.90:8888";


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

    public Profissional call(final String email, final String senha) throws IOException, InterruptedException {

        final Profissional[] success = {};
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

                Call<Profissional> call = profissionalClient.findByEmailAndSenha(email, senha);

                try {
                    Response<Profissional> execute = call.execute();
                    Profissional profissional = execute.body();
                    success[0] = profissional;
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

    public SubcategoriaCasa call(final long idProfissional) throws IOException, InterruptedException {

        final SubcategoriaCasa[] success = {};
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

                SubcategoriaCasaClient sub = retrofit.create(SubcategoriaCasaClient.class);

                Call<SubcategoriaCasa> call = sub.findById(idProfissional);

                try {
                    Response<SubcategoriaCasa> execute = call.execute();
                    SubcategoriaCasa body = execute.body();
                    success[0] = body;
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

    public boolean call(final SubcategoriaCasa subcategoriaCasa) throws IOException, InterruptedException {

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

                SubcategoriaCasaClient sub = retrofit.create(SubcategoriaCasaClient.class);

                Call<SubcategoriaCasa> call = sub.create(subcategoriaCasa);

                try {
                    Response<SubcategoriaCasa> execute = call.execute();
                    SubcategoriaCasa body = execute.body();
                    success[0] = body != null;
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

    public boolean callUpdate(final SubcategoriaCasa subcategoriaCasa) throws IOException, InterruptedException {

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

                SubcategoriaCasaClient sub = retrofit.create(SubcategoriaCasaClient.class);

                Call<SubcategoriaCasa> call = sub.update(subcategoriaCasa);

                try {
                    Response<SubcategoriaCasa> execute = call.execute();
                    SubcategoriaCasa body = execute.body();
                    success[0] = body != null;
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
