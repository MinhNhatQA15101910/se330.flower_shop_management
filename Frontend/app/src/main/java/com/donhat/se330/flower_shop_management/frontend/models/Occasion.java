package com.donhat.se330.flower_shop_management.frontend.models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Occasion {
    private final int id;
    private final String name;
    private final String imageUrl;

    public Occasion(int id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }

    Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("image_url", imageUrl);
        return map;
    }

    public static Occasion fromMap(Map<String, Object> map) {
        int id = map.get("id") != null ? (int) map.get("id") : 0;
        String name = map.get("name") != null ? (String) map.get("name") : "";
        String imageUrl = map.get("image_url") != null ? (String) map.get("image_url") : "";
        return new Occasion(id, name, imageUrl);
    }

    String toJson() {
        return (new JSONObject(toMap())).toString();
    }

    public static Occasion fromJson(String source) {
        Map<String, Object> map = new HashMap<>();

        try {
            JSONObject jsonObject = new JSONObject(source);
            Iterator<String> keys = jsonObject.keys();

            while (keys.hasNext()) {
                String key = keys.next();
                String value = jsonObject.getString(key);
                map.put(key, value);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return fromMap(map);
    }
}
