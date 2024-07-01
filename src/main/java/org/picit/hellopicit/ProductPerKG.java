package org.picit.hellopicit;

public class ProductPerKG extends Product {
    private float productPricePerKG;

    public ProductPerKG(String title, String description, String url, float quanitity, float price, String countryOrigin) {

        super(title, description, url, quanitity, countryOrigin);
        productPricePerKG = price;
    }

    public void setPricePerKG(float amount) {
        productPricePerKG = amount;
    }

    public float getProductPrice() {
        return productPricePerKG;
    }

    public String getProductInfo() {
        return "Naam: " + getProductName() + "\n" +
                "Beschrijving: " + getProductDescription() + "\n" +
                "Photo url: " + getProductPhotoURL() + "\n" +
                "Hoeveelheid: " + getProductQuantity() + "\n" +
                "Prijs per kg: " + productPricePerKG + "\n" +
                "Land van herkomst: " + getProductCountryOrigin() + "\n";
    }
}