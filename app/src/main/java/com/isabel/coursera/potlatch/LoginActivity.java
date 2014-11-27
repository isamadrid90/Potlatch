package com.isabel.coursera.potlatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.isabel.coursera.potlatch.server.CallableTask;
import com.isabel.coursera.potlatch.server.Svc;
import com.isabel.coursera.potlatch.server.SvcApi;
import com.isabel.coursera.potlatch.server.TaskCallback;

import java.util.Collection;
import java.util.concurrent.Callable;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et_user = (EditText) findViewById(R.id.et_username);
                String user = et_user.getText().toString();

                EditText et_pass = (EditText) findViewById(R.id.et_password);
                String pass = et_pass.getText().toString();
                String server = getString(R.string.server);
                final SvcApi svc = Svc.init(server, user, pass);

                CallableTask.invoke(new Callable<Collection<Gift>>() {

                    @Override
                    public Collection<Gift> call() throws Exception {
                        return svc.getGiftList();
                    }
                }, new TaskCallback<Collection<Gift>>() {

                    @Override
                    public void success(Collection<Gift> result) {
                        // OAuth 2.0 grant was successful and we
                        // can talk to the server, open up the video listing
                        startActivity(new Intent(
                                LoginActivity.this,
                                MainActivity.class));
                    }

                    @Override
                    public void error(Exception e) {
                        Log.e(LoginActivity.class.getName(), "Error logging in via OAuth.", e);

                        Toast.makeText(
                                LoginActivity.this,
                                "Login failed, check your Internet connection and credentials.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        Button btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });

    }


}
