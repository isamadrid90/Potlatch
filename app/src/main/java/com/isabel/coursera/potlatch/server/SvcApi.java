package com.isabel.coursera.potlatch.server;

import com.isabel.coursera.potlatch.Gift;
import com.isabel.coursera.potlatch.User;

import java.util.Collection;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by Isabel on 11/25/2014.
 */
public interface SvcApi {

    //region Config
    public static final String PASSWORD_PARAMETER = "password";

    public static final String USERNAME_PARAMETER = "username";

    public static final String TOKEN_PATH = "/oauth/token";

    //endregion

    //region Const Gift
    public static final String GIFT_SVC_PATH = "/gift";

    public static final String VIDEO_TITLE_SEARCH_PATH = GIFT_SVC_PATH + "/search/findByName";

    public static final String VIDEO_DURATION_SEARCH_PATH = GIFT_SVC_PATH + "/search/findByDurationLessThan";
    //endregion

    //region Const User
    public static final String USER_SVC_PATH = "/user";

    public static final String ADD_USER_PATH =USER_SVC_PATH;

    //endregion

    //region Const Params

    public static final String TITLE_PARAMETER = "title";

    public static final String DURATION_PARAMETER = "duration";

    //endregion

    //region Methods Gift

    @GET(GIFT_SVC_PATH)
    public Collection<Gift> getGiftList();

    @POST(GIFT_SVC_PATH)
    public Void addGift(@Body Gift v);

    @GET(VIDEO_TITLE_SEARCH_PATH)
    public Collection<User> findByTitle(@Query(TITLE_PARAMETER) String title);

    @GET(VIDEO_DURATION_SEARCH_PATH)
    public Collection<User> findByDurationLessThan(@Query(DURATION_PARAMETER) String title);

    //endregion

    //region Methods User

    @POST(ADD_USER_PATH)
    public Void addUser(@Body User v);

    //endregion
}
