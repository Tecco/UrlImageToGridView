package com.tecc0.urlimagetogridview;

import com.tecc0.urlimagetogridview.data.ItemData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by makotonishimoto on 2015/10/11.
 */
public class JsonManager {

    private InputStream inputStream;

    public JsonManager(InputStream inputStream){
        this.inputStream = inputStream;
    }

    public ArrayList<ItemData> getItemDataList () {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ArrayList<ItemData> itemData = new ArrayList<>();

        int ctr;
        try {
            ctr = inputStream.read();
            while (ctr != -1) {
                byteArrayOutputStream.write(ctr);
                ctr = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //TODO; GSON使ってもいいかも
        try {
            JSONObject jObject = new JSONObject(byteArrayOutputStream.toString());
            JSONArray jArray = jObject.getJSONArray("data");

            for (int i = 0; i < jArray.length(); i++) {
                JSONObject obj = jArray.getJSONObject(i);

                itemData.add(new ItemData(obj.getString("price"), obj.getString("num_comments"), obj.getString("num_likes"),
                        obj.getString("photo"), obj.getString("name")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemData;
    }
}
