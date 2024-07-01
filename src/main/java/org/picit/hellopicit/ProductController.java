package org.picit.hellopicit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import java.util.*;
import java.io.FileInputStream;
import javafx.stage.Popup;
import javafx.scene.text.Text;
import java.io.IOException;

public class ProductController {

    //creating imageviews for all the products to be visualised 
    @FXML
    private Button myButton;

    //label for the product information
    @FXML 
    private Label productBeschrijving;

    @FXML 
    private ListView listView;

    @FXML
    private TilePane productListContainer;

    @FXML
    private List<Product> listOfProducts;
    //creating different buttons so you can add products

    /*
>>>>>>> ProductOverzicht
    @FXML
    private ImageView bramenView, appelView, banaanView, mangoView;

    @FXML
    private Button bramenKnop, appelKnop, banaanKnop, mangoKnop;
    */

    //function for adding an imageview and path as a parameter
    @FXML
    public static void setImage(String imagePath, ImageView imageView) {
        try {
            FileInputStream inputstream = new FileInputStream(imagePath);
            Image image = new Image(inputstream);
            imageView.setImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // function for creating a button which adds the product as a label in the winkelwagen.fxml file
    @FXML
    public void setButtonAction(Button button, String labelText, Float labelPrice) throws IOException {
        button.setOnAction(event -> {
                try {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("winkelwagen.fxml"));
                        Parent root = loader.load();
            
                        WinkelwagenController winkelwagenController = loader.getController();
                        winkelwagenController.addLabel1(labelText, labelPrice);
                        winkelwagenController.returnScene(event);
            
                        // Stage stage = (Stage) button.getScene().getWindow();
                        // stage.setScene(new Scene(root));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
        });
    }

    // // function for creating a button which adds the product as a label in the winkelwagen.fxml file
    // @FXML
    // public void setButtonAction(Button button, Product product) throws IOException {
    //     button.setOnAction(event -> {
    //             try {
    //                     FXMLLoader loader = new FXMLLoader(getClass().getResource("winkelwagen.fxml"));
    //                     Parent root = loader.load();
            
    //                     WinkelwagenController winkelwagenController = loader.getController();
    //                     winkelwagenController.addProductToCart(product);
            
    //                     Stage stage = (Stage) button.getScene().getWindow();
    //                     stage.setScene(new Scene(root));
    //                 } catch (IOException e) {
    //                     e.printStackTrace();
    //                 }
    //     });
    // }

    // function to switch between winkelwagen scene
    @FXML
    public void cartScene(ActionEvent actionEvent) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("winkelwagen.fxml"));
        Scene scene = new Scene(pane, 480, 960);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    //initializing all the images and buttons 
    @FXML
    public void initialize() throws Exception {

        /*
        setImage("src/main/resources/org/picit/hellopicit/images/bramen.jpg", bramenView);
        setImage("src/main/resources/org/picit/hellopicit/images/appel.jpg", appelView);
        setImage("src/main/resources/org/picit/hellopicit/images/banaan.jpg", banaanView);
        setImage("src/main/resources/org/picit/hellopicit/images/mango.jpg", mangoView);

        setButtonAction(bramenKnop, "Bramen");
        setButtonAction(appelKnop, "Appels");
        setButtonAction(banaanKnop, "Bananen");
        setButtonAction(mangoKnop, "Mango's");
        */

        listOfProducts = new ArrayList<Product>();

        // Maak dummy data aan
        createDummyProducts();

        // Laat dummy data zien op het scherm
        addProductsToScene();

        // Print dummy data in console
        // printListOfProducts();
    }

    //producten toevoegen
    private void createDummyProducts() {
        listOfProducts.add(new ProductPerKG("Aardbeien",
        "Nu nog Aardbeien in het algemeen",
        "src/main/resources/org/picit/hellopicit/images/aardbeien.jpg",
        1f,
        3.19f,
        "Nederland"
        ));

        listOfProducts.add(new ProductPerKG("Appels",
                "Nu nog appels in het algemeen",
                "src/main/resources/org/picit/hellopicit/images/appel.jpg",
                1.5f,
                2.50f,
                "Nederland"
        ));

        listOfProducts.add(new ProductPerStuk("Bananen",
                "Nu nog Bananen in het algemeen",
                "src/main/resources/org/picit/hellopicit/images/banaan.jpg",
                1f,
                1.99f,
                "Brazile"
        ));
        listOfProducts.add(new ProductPerKG("Blauwe Bessen",
                "Blauwe bessen zijn beter dan bosbessen",
                "src/main/resources/org/picit/hellopicit/images/blauwebessen.jpg",
                0.250f,
                2.74f,
                "Nederland"
        ));
        listOfProducts.add(new ProductPerKG("Bramen",
                "Beste bramen van de wereld",
                "src/main/resources/org/picit/hellopicit/images/bramen.jpg",
                0.750f,
                2.21f,
                "Nederland"
        ));
        listOfProducts.add(new ProductPerKG("Citroen",
                "Nu nog Citroen in het algemeen",
                "src/main/resources/org/picit/hellopicit/images/Citroen.jpg",
                1f,
                2.50f,
                "Nederland"
        ));
        listOfProducts.add(new ProductPerKG("Drake fruit",
                "Nu nog Drake fruit in het algemeen",
                "src/main/resources/org/picit/hellopicit/images/DrakeFruit.jpg",
                0.5f,
                1.99f,
                "Nieuw-Zeeland"
        ));
        listOfProducts.add(new ProductPerStuk("Galia Meloen",
                "Nu nog Galia Meloen in het algemeen",
                "src/main/resources/org/picit/hellopicit/images/GaliaMeloen.jpg",
                1f,
                2.80f,
                "Nieuw-Zeeland"
        ));
        listOfProducts.add(new ProductPerKG("Kiwi",
                "KiwiFruit",
                "src/main/resources/org/picit/hellopicit/images/KiwiFruit.jpg",
                0.2f,
                2.24f,
                "Nederland"
        ));
        listOfProducts.add(new ProductPerKG("Lychee",
                "Beste Lychee van de wereld",
                "src/main/resources/org/picit/hellopicit/images/Lychee.jpg",
                0.2f,
                2.89f,
                "Nederland"
        ));
        listOfProducts.add(new ProductPerKG("Mango",
                "Nu nog mango in het algemeen",
                "src/main/resources/org/picit/hellopicit/images/mango.jpg",
                1f,
                2.49f,
                "Nederland"
        ));
        listOfProducts.add(new ProductPerKG("Passie Fruit",
                "Nu nog passieFruit in het algemeen",
                "src/main/resources/org/picit/hellopicit/images/passieFruit.jpg",
                1f,
                1.02f,
                "Nieuw-Zeeland"
        ));
        listOfProducts.add(new ProductPerStuk("Sinnasappel",
                "Nu nog Sinnasappels in het algemeen",
                "src/main/resources/org/picit/hellopicit/images/Sinnasappel.jpg",
                1f,
                0.99f,
                "Nieuw-Zeeland"
        ));
        listOfProducts.add(new ProductPerKG("Sterfruit",
                "Blauwe Sterfruit zijn beter dan bosbessen",
                "src/main/resources/org/picit/hellopicit/images/Sterfruit.jpg",
                0.2f,
                1.22f,
                "Nederland"
        ));
        listOfProducts.add(new ProductPerKG("Watermeloen",
                "Beste watermeloen van de wereld",
                "src/main/resources/org/picit/hellopicit/images/watermeloen.jpg",
                2.5f,
                3.99f,
                "Nederland"
        ));
    }

    public void printListOfProducts() {
        for (Product product : listOfProducts) {
            System.out.println(product.toString());        
            System.out.println(product.getProductInfo());        }
    }

    public void addProductsToScene() throws Exception {
        // Voor elk product in de lijst van producten
        for (Product product : listOfProducts) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("product-card.fxml"));
            Node node = loader.load();

            ProductCardController productCardController = loader.getController();
            productCardController.setProductCardData(product);
            setButtonAction(productCardController.getAddToCartButton(), productCardController.getProductNameLabel().getText() , product.getProductPrice());

            productListContainer.getChildren().add(node);

        }
    }
}