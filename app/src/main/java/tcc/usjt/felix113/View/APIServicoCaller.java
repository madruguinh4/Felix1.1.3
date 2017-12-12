package tcc.usjt.felix113.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tcc.usjt.felix113.Model.Cliente;
import tcc.usjt.felix113.Model.ServicoContratado;
import tcc.usjt.felix113.View.ViewCliente.ClienteClient;

public class APIServicoCaller {

    public boolean call(final ServicoContratado body) throws IOException, InterruptedException {

        final boolean[] success = {false};
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Constants.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();

                ServicoClient client = retrofit.create(ServicoClient.class);

                Call<ServicoContratado> call = client.create(body);

                try {
                    Response<ServicoContratado> execute = call.execute();
                    ServicoContratado body = execute.body();
                    success[0] = body != null && body.getId() != null;
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

    public List<ServicoContratado> contratados(final Long idCliente) throws IOException, InterruptedException {

        final List<ServicoContratado>[] success = new List[]{new ArrayList()};
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Constants.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();

                ServicoClient client = retrofit.create(ServicoClient.class);

                Call<List<ServicoContratado>> call = client.findByCliente(idCliente);

                try {
                    Response<List<ServicoContratado>> execute = call.execute();
                    if(execute.body() != null){
                        success[0] = execute.body();
                    }
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

    public boolean delete(final Long id) throws IOException, InterruptedException {

        final boolean[] success = {false};
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Constants.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();

                ServicoClient client = retrofit.create(ServicoClient.class);

                Call<Boolean> call = client.delete(id);

                try {
                    Response<Boolean> execute = call.execute();
                    success[0] = execute.body();
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

    public boolean update(final Long id, final int nota) throws IOException, InterruptedException {

        final boolean[] success = {false};
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Constants.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();

                ServicoClient client = retrofit.create(ServicoClient.class);

                Call<Boolean> call = client.update(id,nota);

                try {
                    Response<Boolean> execute = call.execute();
                    success[0] = execute.body();
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

    public List<ServicoContratado> profissional(final Long idProfssional) throws IOException, InterruptedException {

        final List<ServicoContratado>[] success = new List[]{new ArrayList()};
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Constants.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();

                ServicoClient client = retrofit.create(ServicoClient.class);

                Call<List<ServicoContratado>> call = client.findByProfissional(idProfssional);

                try {
                    Response<List<ServicoContratado>> execute = call.execute();
                    if(execute.body() != null){
                        success[0] = execute.body();
                    }
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

    public List<ServicoContratado> profissional() throws IOException, InterruptedException {

        final List<ServicoContratado>[] success = new List[]{new ArrayList()};
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(Constants.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();

                ServicoClient client = retrofit.create(ServicoClient.class);

                Call<List<ServicoContratado>> call = client.findAll();

                try {
                    Response<List<ServicoContratado>> execute = call.execute();
                    if(execute.body() != null){
                        success[0] = execute.body();
                    }
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
