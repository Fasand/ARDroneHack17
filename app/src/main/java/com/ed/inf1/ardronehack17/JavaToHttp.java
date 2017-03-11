package com.ed.inf1.ardronehack17;

/**
 * Created by kali on 11/03/17.
 */
import android.util.Log;

import java.io.*;
import java.net.*;
import java.net.HttpURLConnection;
import java.util.Arrays;

public class JavaToHttp {

/*
    public void init() throws IOException {
        URL url = new URL("http://10.99.154.94:3000/path");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            urlConnection.setDoOutput(true);
            urlConnection.setChunkedStreamingMode(0);

            OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
           out.write(0xff);
            Log.d("Nie","Hola cikula",null);
            //InputStream in = new BufferedInputStream(urlConnection.getInputStream());
           // readStream(in);
        } finally {
            urlConnection.disconnect();
        }
    }*/




        public String  performPostCall(String requestURL/*,
                HashMap<String, String> postDataParams*/) {

            URL url;
            String response = "";
            try {
                url = new URL(requestURL);

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.setDoOutput(true);

/*
                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(getPostDataString(postDataParams));

                writer.flush();
                writer.close();
                os.close();
                int responseCode=conn.getResponseCode();

                if (responseCode == HttpsURLConnection.HTTP_OK) {
                    String line;
                    BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    while ((line=br.readLine()) != null) {
                        response+=line;
                    }
                }
                else {
                    response="";

                }*/
            } catch (Exception e) {
                e.printStackTrace();
            }

            return response;
        }


}