package tcc.usjt.felix113.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

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

}
