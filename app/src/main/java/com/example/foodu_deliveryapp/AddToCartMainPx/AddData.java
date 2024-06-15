package com.example.foodu_deliveryapp.AddToCartMainPx;


public class AddData {
    private String ProductName;
    private String ProductSize;
    private String category;

    public AddData(String productName, String productSize, String Category) {
        this.ProductName = productName;
        this.ProductSize = productSize;
        this.category = Category;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        this.ProductName = productName;
    }

    public String getProductSize() {
        return ProductSize;
    }

    public void setProductSize(String productSize) {
        this.ProductSize = productSize;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
