package com.example.android.datafrominternet.utilities;

import com.example.android.datafrominternet.model.Repository;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONUtils {

    public static ArrayList<Repository> makeRepositoryList(String jsonResult){
        ArrayList<Repository> repoList = new ArrayList<>();
        try {
            JSONObject mainJSONObject = new JSONObject(jsonResult);
            JSONArray items = mainJSONObject.getJSONArray("items");

            for(int i = 0; i < items.length(); i++){
                JSONObject item = items.getJSONObject(i);
                repoList.add(new Repository(item.getString("name"), item.getString("html_url")));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return repoList;
    }
}
