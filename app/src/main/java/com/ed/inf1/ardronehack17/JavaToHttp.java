package com.ed.inf1.ardronehack17;

/**
 * Created by kali on 11/03/17.
 */
import java.io.*;
import java.net.*;
import java.net.URLConnection;
import java.util.Arrays;

public class JavaToHttp {
    {
        try

        {
            String lengthangle = URLEncoder.encode(Arrays.toString(SpyStart.getDirections().toArray()), "UTF-8");
            URL url = new URL("http://10.99.154.94:3000");
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            out.write("path=" + lengthangle);
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