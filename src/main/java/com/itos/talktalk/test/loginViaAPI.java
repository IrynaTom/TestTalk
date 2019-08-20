package com.itos.talktalk.test;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.net.*;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;

public class loginViaAPI {

    public static void main(String[] args) throws Exception {

        String data = URLEncoder.encode("key1", "UTF-8") + "=" + URLEncoder.encode("value1", "UTF-8");
        data += "&" + URLEncoder.encode("key2", "UTF-8") + "=" + URLEncoder.encode("value2", "UTF-8");

        URL apiAuth = new URL("https://localhost:8080/api/v1/auth");
        HttpsURLConnection con = (HttpsURLConnection) apiAuth.openConnection();

        @When("^I send a POST request to the address$")
        public void SendPOST() {
          //  URLConnection auth = apiAuth.openConnection();
            con.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
            wr.write(data);
            wr.flush();
            wr.close();
        }

        @Then("I get a response")
        public void GetResponse() {
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + apiAuth);
            System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null)
                response.append(inputLine);
            in.close();
            System.out.println(response.toString());
        }
    }

}
