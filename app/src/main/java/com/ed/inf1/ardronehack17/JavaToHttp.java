package com.ed.inf1.ardronehack17;

/**
 * Created by kali on 11/03/17.
 */
import java.io.*;
import java.net.*;
import java.net.URLConnection;
import java.util.Arrays;

public class JavaToHttp {
        public void init(){

        String lengthangle = null;
            try {
            lengthangle = URLEncoder.encode(Arrays.toString(SpyStart.getDirections().toArray()), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        URL url = null;
        try {
            url = new URL("http://10.99.154.94:3000");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URLConnection connection = null;
        try {
            connection = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        connection.setDoOutput(true);
        OutputStreamWriter out = null;
        try {
            out = new OutputStreamWriter(connection.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.write("path=" + lengthangle);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
