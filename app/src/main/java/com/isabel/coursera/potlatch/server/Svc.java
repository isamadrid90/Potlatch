package com.isabel.coursera.potlatch.server;

/**
 * Created by Isabel on 11/25/2014.
 */

import android.content.Context;
import android.content.Intent;

import com.isabel.coursera.potlatch.LoginActivity;
import com.isabel.coursera.potlatch.server.oauth.SecuredRestBuilder;
import com.isabel.coursera.potlatch.server.unsafe.EasyHttpClient;

import retrofit.RestAdapter.LogLevel;
import retrofit.client.ApacheClient;


public class Svc {

    public static final String CLIENT_ID = "mobile";

    private static SvcApi Svc_;

    public static synchronized SvcApi getOrShowLogin(Context ctx) {
        if (Svc_ != null) {
            return Svc_;
        } else {
            Intent i = new Intent(ctx, LoginActivity.class);
            ctx.startActivity(i);
            return null;
        }
    }

    public static synchronized SvcApi init(String server, String user,
                                                String pass) {

        Svc_ = new SecuredRestBuilder()
                .setLoginEndpoint(server + SvcApi.TOKEN_PATH)
                .setUsername(user)
                .setPassword(pass)
                .setClientId(CLIENT_ID)
                .setClient(
                        new ApacheClient(new EasyHttpClient()))
                .setEndpoint(server).setLogLevel(LogLevel.FULL).build()
                .create(SvcApi.class);

        return Svc_;
    }
}