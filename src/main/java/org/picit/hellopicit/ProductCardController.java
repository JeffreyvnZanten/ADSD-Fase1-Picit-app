package org.picit.hellopicit;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ProductCardController {
    @FXML private ImageView productImageView;
    @FXML private Label productNameLabel, productPriceLabel, productQuantity;
    @FXML private Button addToCartButton;

    public void setProductCardData(Product product) {
        ProductController.setImage(product.getProductPhotoURL(), productImageView);
        productNameLabel.setText(product.getProductName());
        productQuantity.setText("Per " + product.getProductQuantity() + " kg");
        productPriceLabel.setText("€" + product.getProductPrice());

        // Dit kan weg als het in css is gedaan
        productImageView.setFitHeight(100);
        productImageView.setFitWidth(100);
    }

    public Button getAddToCartButton() {
        return addToCartButton;
    }

    public Label getProductPriceLabel() {
        return productPriceLabel;
    }

    public Label getProductNameLabel() {
        return productNameLabel;
    }
}
