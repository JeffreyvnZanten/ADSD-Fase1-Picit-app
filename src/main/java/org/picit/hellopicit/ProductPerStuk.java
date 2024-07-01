package org.picit.hellopicit;

public class ProductPerStuk extends Product {
    private float productPricePerStuk;

    public ProductPerStuk(String title, String description, String url, float quanitity, float price, String countryOrigin) {

        super(title, description, url, quanitity, countryOrigin);
        productPricePerStuk = price;
    }

    public void setPricePerStuk(float amount) {
        productPricePerStuk = amount;
    }

    public float getProductPrice() {
        return productPricePerStuk;
    }

    public String getProductInfo() {
        return "Naam: " + getProductName() + "\n" +
                "Beschrijving: " + getProductDescription() + "\n" +
                "Photo url: " + getProductPhotoURL() + "\n" +
                "Hoeveelheid: " + getProductQuantity() + "\n" +
                "Prijs per stuk: " + productPricePerStuk + "\n" +
                "Land van herkomst: " + getProductCountryOrigin() + "\n";
    }
}