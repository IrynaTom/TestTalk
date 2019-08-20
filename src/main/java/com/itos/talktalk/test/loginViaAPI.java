package com.itos.talktalk.test;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.net.*;
import java.io.*;

public class loginViaAPI {

    public static void main(String[] args) throws Exception {


        @Given("I have Construct data")
        public void сonstructData() {


        }

        String data = URLEncoder.encode("key1", "UTF-8") + "=" + URLEncoder.encode("value1", "UTF-8");
        data += "&" + URLEncoder.encode("key2", "UTF-8") + "=" + URLEncoder.encode("value2", "UTF-8");

        URL apiAuth = new URL("https://localhost:8080/api/v1/auth");
        URLConnection auth = apiAuth.openConnection();
        auth.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(auth.getOutputStream());
        wr.write(data);
        wr.flush();

        // Get the response
        BufferedReader in = new BufferedReader(new InputStreamReader(auth.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);

        wr.close();
        in.close();

    }

}
