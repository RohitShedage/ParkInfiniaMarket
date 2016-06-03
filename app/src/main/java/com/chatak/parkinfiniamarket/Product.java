package com.chatak.parkinfiniamarket;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Product {

    private String cakeId;
    private String title;
    private String weight;
    private double price;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCakeId(String cakeId) {
        this.cakeId = cakeId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCakeId() {
        return cakeId;
    }

    public String getTitle() {
        return title;
    }

    /*public String getProductImageUrl() {
        return "http://ec2-54-165-229-42.compute-1.amazonaws.com:3000/api/photo/" + cakeId;
    }*/

    public static Product fromJson(JSONObject jsonObject) {
        Product product = new Product();
        try {
            if (jsonObject.has("cakeId"))  {
                product.setCakeId(jsonObject.getString("cakeId"));
            }
            product.setPrice(jsonObject.getDouble("price"));
            product.setWeight(jsonObject.getString("weight"));
            product.setTitle(jsonObject.getString("title"));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return product;
    }

    public static ArrayList<Product> fromJson(JSONArray jsonArray) {
        ArrayList<Product> products = new ArrayList<Product>(jsonArray.length());
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject productJson = null;
            try {
                productJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            Product product = Product.fromJson(productJson);
            if (product != null) {
                products.add(product);
            }
        }
        return products;
    }
}