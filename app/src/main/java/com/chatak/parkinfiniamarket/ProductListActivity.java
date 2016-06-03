package com.chatak.parkinfiniamarket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class ProductListActivity extends AppCompatActivity {

    private ListView lvProducts;
    private ProductAdapter productAdapter;
    private ProductClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        lvProducts = (ListView) findViewById(R.id.lvProducts);
        ArrayList<Product> products = new ArrayList<Product>();
        productAdapter = new ProductAdapter(this, products);
        lvProducts.setAdapter(productAdapter);
        fetchProducts();
    }

    private void fetchProducts() {
        client = new ProductClient();
        client.getProducts("search string will go here", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray docs = null;
                    if(response != null) {
                        docs = new JSONArray(response);
                        final ArrayList<Product> products = Product.fromJson(docs);
                        productAdapter.clear();
                        for (Product product : products) {
                            productAdapter.add(product);
                        }
                        productAdapter.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
