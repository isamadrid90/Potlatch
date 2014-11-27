package com.isabel.coursera.potlatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.isabel.coursera.potlatch.server.CallableTask;
import com.isabel.coursera.potlatch.server.Svc;
import com.isabel.coursera.potlatch.server.SvcApi;
import com.isabel.coursera.potlatch.server.TaskCallback;

import java.util.concurrent.Callable;

public class RegisterActivity extends Activity {

    public User newUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        newUser = new User();
        newUser.setEmail("test@test.com");
        newUser.setPassword("pass");
        newUser.setUsername("name1");
        newUser.setImagen("http://google.es");
        newUser.setTouchesCount(0);

        Button btn_register = (Button) findViewById(R.id.btn_registration);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final SvcApi svc = Svc.init(getString(R.string.server), getString(R.string.user_admin), getString(R.string.pass_admin));

                CallableTask.invoke(new Callable<Void>() {

                    @Override
                    public Void call() throws Exception {

                        svc.addUser(newUser);

                        return null;
                    }
                }, new TaskCallback<Void>() {

                    @Override
                    public void success(Void v) {
                        // OAuth 2.0 grant was successful and we
                        // can talk to the server, open up the video listing
                        Toast.makeText(
                                RegisterActivity.this,
                                "Register Done.Now you can login",
                                Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(
                                RegisterActivity.this,
                                LoginActivity.class));

                    }

                    @Override
                    public void error(Exception e) {
                        Log.e(LoginActivity.class.getName(), "Error logging in via OAuth.", e);

                        Toast.makeText(
                                RegisterActivity.this,
                                "Register failed, check your Internet connection and credentials.",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
