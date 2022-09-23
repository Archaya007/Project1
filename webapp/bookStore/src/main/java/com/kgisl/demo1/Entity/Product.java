package com.kgisl.demo1.Entity;

public class Product {
   int  Product_id;
   String Product_name;
   int Product_price;
   float Product_weight;

public Product(int product_id, String product_name, int i, float product_weight) {
    Product_id = product_id;
    Product_name = product_name;
    Product_price = i;
    Product_weight = product_weight;
}
public Product(String product_name2, String product_price2, float product_weight2) {
}
public Product(int product_id2, String product_name2, String product_price2, float product_weight2) {
}
public int getProduct_id() {
    return Product_id;
}
public void setProduct_id(int product_id) {
    Product_id = product_id;
}
public String getProduct_name() {
    return Product_name;
}
public void setProduct_name(String product_name) {
    Product_name = product_name;
}
public int getProduct_price() {
    return Product_price;
}
public void setProduct_price(int product_price) {
    Product_price = product_price;
}
public float getProduct_weight() {
    return Product_weight;
}
public void setProduct_weight(float product_weight) {
    Product_weight = product_weight;
}

   
}
