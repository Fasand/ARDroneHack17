package com.ed.inf1.ardronehack17;

/**
 * Created by kali on 11/03/17.
 */
import java.io.*;
import java.net.*;
import java.net.URLConnection;

public class JavaToHttp {
    {
        try

        {
            String lengthangle = URLEncoder.encode("lol", "UTF-8");
            URL url = new URL("www.example.com");
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            out.write("string=" + lengthangle);
            out.close();
        } catch (MalformedURLException ex1) {
            System.out.println("HOW DID THIS HAPPEN");
        } catch (UnsupportedOperationException ex2) {
            System.out.println("HOW DID THIS HAPPEN");
        } catch (IOException ex3) {
            System.out.println("HOW DID THIS HAPPEN");
        }

    }
}