package com.example.lab_5;

import org.json.JSONException;
import org.json.JSONObject;

public class Parser {

    public static String parseCurrencyRate(String jsonData, String targetCurrency) {
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONObject targetCurrencyObject = jsonObject.getJSONObject(targetCurrency);
            return targetCurrencyObject.getString("rate");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
