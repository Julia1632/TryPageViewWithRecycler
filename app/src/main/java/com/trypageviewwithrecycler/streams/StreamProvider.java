package com.trypageviewwithrecycler.streams;


import java.io.IOException;
import java.io.InputStream;

public interface StreamProvider<T> {
    InputStream get(T path) throws IOException;
}
