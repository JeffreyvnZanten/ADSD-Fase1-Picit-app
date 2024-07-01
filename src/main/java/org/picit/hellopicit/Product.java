package org.picit.hellopicit;

import javafx.scene.image.Image;

public class Product {

    private String productName;
    private String productDescription;
    private String productPhotoURL;
    private float productPrice;
    private String productCountryOrigin;
    private float productQuantity;

    public Product(String title, String description, String url, float quantity, String countryOrigin) {

        productName = title;
        productDescription = description;
        productPhotoURL = url;
        productQuantity = quantity;
        productCountryOrigin = countryOrigin;
    }

    public void setProductName(String name) {
        productName = name;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductDescription(String description) {
        productDescription = description;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductPhotoURL() {
        return productPhotoURL;
    }

    public void setProductPhotoURL(String photoURL) { productPhotoURL = photoURL; }

    public float getProductPrice() {
        return productPrice;
    }

    public String getProductCountryOrigin() {
        return productCountryOrigin;
    }

    public void setProductCountryOrigin(String productCountryOrigin) {
        this.productCountryOrigin = productCountryOrigin;
    }

    public float getProductQuantity() { return productQuantity; }

    public void setProductQuantity(float quantity) { productQuantity = quantity; }

    public String getProductInfo() {
        return "Naam: " + productName + "\n" +
                "Beschrijving: " + productDescription + "\n" +
                "Photo url" + productPhotoURL + "\n" +
                "Hoeveelheid" + productQuantity + "\n" +
                "Prijs" + productPrice + "\n" +
                "Land van herkomst" + productCountryOrigin + "/n";
    }
}
