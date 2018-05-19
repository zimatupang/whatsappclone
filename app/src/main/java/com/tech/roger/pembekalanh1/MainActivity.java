package com.tech.roger.pembekalanh1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tech.roger.pembekalanh1.models.Data;
import com.tech.roger.pembekalanh1.models.User;
import com.tech.roger.pembekalanh1.service.APIservice;
import com.tech.roger.pembekalanh1.tools.Preferences;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView textNama, textStatus,textNomor;
    CircleImageView imgFoto;
    String TAG= "WA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNama = (TextView)findViewById(R.id.txt_nama);
        textStatus = (TextView)findViewById(R.id.txt_status);
        textNomor = (TextView)findViewById(R.id.txt_number);
        imgFoto = (CircleImageView)findViewById(R.id.foto);

        Call<User> userCall = APIservice.service.getUser( "roger");
        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    Log.d("WA", "Berhasil");
                    User userResponse = response.body();
                    if(userResponse.getStatus().equals("succes")){
                        Data user = userResponse.getData();
                        textNama.setText(user.getNama());
                        textStatus.setText(user.getStatus());
                        textNomor.setText(user.getNoTelp());

                        Preferences.setStringPreferences("nama", user.getNama(),getApplicationContext());
                        Preferences.setStringPreferences("status", user.getStatus(),getApplicationContext());
                        Preferences.setStringPreferences("no_telp", user.getNoTelp(), getApplicationContext());
                        Picasso.get()
                                .load(user.getImg())
                                .into(imgFoto);
                    }
                }
                else{
                    Log.e("WA", response.message());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("WA", t.getMessage());
            }
        });

    }
}
