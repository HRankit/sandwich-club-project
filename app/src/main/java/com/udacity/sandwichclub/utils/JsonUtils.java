package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
//        return null;

        Sandwich sw = new Sandwich();

        JSONObject main_jsonObj = null;
        try {
            main_jsonObj = new JSONObject(json);

            String name = main_jsonObj.getString("name");
            JSONObject name_jsonObj = new JSONObject(name);

            String mainName = name_jsonObj.getString("mainName");
            if (mainName.isEmpty()) {
                mainName = "Not Available";
            }
            sw.setMainName(mainName);


            JSONArray akaArray = name_jsonObj.getJSONArray("alsoKnownAs");
            List<String> list_aka = new ArrayList<String>();
            if (akaArray != null) {
                for (int i = 0; i < akaArray.length(); i++) {
                    list_aka.add(akaArray.getString(i));
                }
            }
            if (list_aka.isEmpty()) {
                list_aka.add("Not Available");
            }
            sw.setAlsoKnownAs(list_aka);


            String placeOfOrigin = main_jsonObj.getString("placeOfOrigin");
            if (placeOfOrigin.isEmpty()) {
                placeOfOrigin = "Not Available";
            }
            sw.setPlaceOfOrigin(placeOfOrigin);

            String description = main_jsonObj.getString("description");
            if (description.isEmpty()) {
                description = "Not Available";
            }
            sw.setDescription(description);


            String image = main_jsonObj.getString("image");
            sw.setImage(image);


            JSONArray ingredientsArray = main_jsonObj.getJSONArray("ingredients");
            List<String> list_ingredients = new ArrayList<String>();
            if (ingredientsArray != null) {
                for (int i = 0; i < ingredientsArray.length(); i++) {
                    list_ingredients.add(ingredientsArray.getString(i));
                }
            }
            if (list_ingredients.isEmpty()) {
                list_ingredients.add("Not Available");
            }

            sw.setIngredients(list_ingredients);


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return sw;
    }
}
