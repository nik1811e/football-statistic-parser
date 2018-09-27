package io.zensoft.neliseenko.football.statistic.parser.api;

import com.google.gson.Gson;
import io.zensoft.neliseenko.football.statistic.parser.to.StatisticTO;
import io.zensoft.neliseenko.football.statistic.parser.utils.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CallToApi {

  public static StatisticTO call(String requestUrl) {
    String output = "";
    try {
      URL url = new URL(requestUrl);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.setRequestProperty("Accept", "application/json");
      conn.setRequestProperty("X-Auth-Token", new Utils().readPropertiesValue("apikey"));

      if (conn.getResponseCode() != 200) {
        throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
      }

      BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

      StatisticTO to = null;
      while ((output = br.readLine()) != null) {
        to = new Gson().fromJson(output, StatisticTO.class);

      }
      conn.disconnect();
      return to;
    } catch (Exception e) {
      return null;
    }
  }
}
