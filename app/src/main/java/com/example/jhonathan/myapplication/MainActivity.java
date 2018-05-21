package com.example.jhonathan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.jhonathan.myapplication.adaptadores.AdaptadorApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    //private final String baseUrl="http://0.0.0.1:8000/";
    private final String baseUrl="https://reqres.in/";

    List<Auditorio>listaAuditorio= new ArrayList<>();
    List<Evento> items = new ArrayList<>();
    /*
    Declarar instancias globales
    */
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);


        // Inicializar Animes
        items = new ArrayList();

        // retrofit
        /*Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AuditorioService auditorioService = retrofit.create(AuditorioService.class);
        Call<List<Evento>> lista= auditorioService.getExample();

        //para hacer que sea una llamada asincrona

        lista.enqueue(new Callback<List<Evento>>() {
            @Override
            public void onResponse(Call<List<Evento>> call, Response<List<Evento>> response) {
                //validamos si la respuesta es exitosa
                System.out.println("Entra");
                if(response.isSuccessful()) {
                    items = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<Evento>> call, Throwable t) {
                System.out.println("Falla");
            }
        });*/

        /*items.add(new Evento(R.drawable.angel, "Angel Beats", 230));
        items.add(new Evento(R.drawable.death, "Death Note", 456));
        items.add(new Evento(R.drawable.fate, "Fate Stay Night", 342));
        items.add(new Evento(R.drawable.nhk, "Welcome to the NHK", 645));
        items.add(new Evento(R.drawable.suzumiya, "Suzumiya Haruhi", 459));*/
        getFindEvents();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void getFindEvents() {

        Call<EventoResponse> call = AdaptadorApi.getApiService().getEventos();
        call.enqueue(new eventoCodeCallback());
    }

    class eventoCodeCallback implements Callback<EventoResponse> {

        @Override
        public void onResponse(Call<EventoResponse> call, Response<EventoResponse> response) {

            if (response.isSuccessful()) {
                if (response.code() == 200) {
                    // Obtener el Recycler
                    recycler = (RecyclerView) findViewById(R.id.reciclador);
                    //recycler.setHasFixedSize(true);

                    // Usar un administrador para LinearLayout
                    lManager = new LinearLayoutManager(getApplicationContext());
                    recycler.setLayoutManager(lManager);

                    // Crear un nuevo adaptador
                    adapter = new EventoAdapter(response.body().getEventos(), getBaseContext());
                    recycler.setAdapter(adapter);
                    /*progressDialog.cancel();
                    ClientResponse clientResponse = response.body();
                    CommunicatorClient.setClientResponse(clientResponse);
                    String clientDocument = clientResponse.getDocument();
                    tvDataClientMain.setText(getResources().getString(R.string.tvRequestClient) + " *****" + clientDocument.substring(clientDocument.length() - 4, clientDocument.length()) + " | " +
                            clientResponse.getName() + " " + clientResponse.getLastName());*/
                } else {

                }
            } else {
                /*try {
                    //JSONObject jObjError = new JSONObject(response.errorBody().string());
                    //JSONObject jObjError1 = jObjError.getJSONObject("error");
                    String[] strError = jObjError1.getString("message").split("\\|");
                    if (response.code() == 409) {
                        //progressDialog.cancel();
                        //DialogMessage.createDialog(MainActivity.this, getResources().getString(R.string.alertError), strError[2], strError[1]).show();
                    } else if (response.code() == 401) {
                        //progressDialog.cancel();
                        //DialogMessage.createDialog(MainActivity.this, getResources().getString(R.string.alertError), strError[2], strError[1]).show();
                    }

                } catch (Exception e) {
                    //progressDialog.cancel();
                    //DialogMessage.createDialog(MainActivity.this, getResources().getString(R.string.alertError), e.getMessage(), Constants.STATUS_OPERATION_ERROR).show();
                }*/
            }

        }

        @Override
        public void onFailure(Call<EventoResponse> call, Throwable t) {
        }
    }
}
