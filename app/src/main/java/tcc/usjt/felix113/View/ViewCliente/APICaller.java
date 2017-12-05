package tcc.usjt.felix113.View.ViewCliente;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tcc.usjt.felix113.Model.Cliente;
import tcc.usjt.felix113.View.Constants;

public class APICaller {

    public boolean call(final Cliente body) throws IOException, InterruptedException {

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

                ClienteClient clienteClient = retrofit.create(ClienteClient.class);

                Call<Cliente> call = clienteClient.create(body);

                try {
                    Response<Cliente> execute = call.execute();
                    Cliente cliente = execute.body();
                    success[0] = cliente != null && cliente.getId() != null;
                    System.out.println("id = " + cliente.getId());
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

    public Cliente call(final String email, final String senha) throws IOException, InterruptedException {

        final Cliente[] success = {null};
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

                ClienteClient clienteClient = retrofit.create(ClienteClient.class);

                Call<Cliente> call = clienteClient.findByEmailAndSenha(email, senha);

                try {
                    Response<Cliente> execute = call.execute();
                    Cliente cliente = execute.body();
                    success[0] = cliente;
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
