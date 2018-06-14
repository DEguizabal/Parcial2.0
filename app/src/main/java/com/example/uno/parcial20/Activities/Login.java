package com.example.uno.parcial20.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.uno.parcial20.Interface.RequestHelper;
import com.example.uno.parcial20.Objects.User;
import com.example.uno.parcial20.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity{

    private EditText userEditText;
    private EditText passEditText;
    private Button signInButton;
    private RequestHelper requestHelper;
    private String baseUrl;
    private Retrofit retrofit;
    private Call<User> call;
    public static String globalToken;
    private Intent toNavDrawer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginProcess();
    }

    private void loginProcess() {

        userEditText = findViewById(R.id.user);
        passEditText = findViewById(R.id.password);
        signInButton = findViewById(R.id.login_btn);

        baseUrl = "http://gamenewsuca.herokuapp.com/";

        if(retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        }

        requestHelper = retrofit.create(RequestHelper.class);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                call = requestHelper.loginRequest(userEditText.getText().toString(), passEditText.getText().toString());

                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.body().getToken() != null){
                            globalToken = response.body().getToken().toString();
                            toNavDrawer = new Intent(Login.this, MainActivity.class);
                            startActivity(toNavDrawer);
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });
            }
        });
    }
}
