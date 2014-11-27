package com.isabel.coursera.potlatch.server;

/**
 * Created by Isabel on 11/25/2014.
 */

public interface TaskCallback<T> {

    public void success(T result);

    public void error(Exception e);

}