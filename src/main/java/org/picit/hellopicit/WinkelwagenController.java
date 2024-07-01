package org.picit.hellopicit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WinkelwagenController {

    @FXML
    private ImageView wagenView;

    @FXML
    private Button returnScene;

    //ListView to display items in the cart
    @FXML
    private ListView<String> cartListView;

    @FXML
    private ListView<Float> cartListPriceView;

    //Clear Cart Button
    @FXML
    private Button clearCartButton; 

    //Delete Selected Item Button
    @FXML
    private Button deleteItemButton; 

    @FXML
    private Label totalPriceLabel;

    // Make cartItems static to persist across all instances
    // List to hold items added to the cart
    private static List<String> cartItems = new ArrayList<>();
    private static List<Float> cartPrice = new ArrayList<>(); 

    public void initialize() throws Exception {
        // FileInputStream inputstream = new FileInputStream("src/main/resources/org/picit/hellopicit/images/shoppingCart.png");
        // Image image = new Image(inputstream);
        // wagenView.setImage(image);
        //Update the ListView when the controller initializes
        updateCartListView();

        //Disable delete button if no item is selected
        deleteItemButton.setDisable(true);

        //Add a listener to enable the delete button when an item is selected
        cartListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            deleteItemButton.setDisable(newValue == null);
        });
    }

    //Add the item to the list
    //Update the ListView
    @FXML
    public void addLabel1(String text, Float price) {
        cartItems.add(text);
        cartPrice.add(price);
        updateCartListView(); 
    }

    @FXML
    private void calculateTotalPrice() {
        float total = 0f;

        for (float price : cartPrice) {
            total += price;
        }
        totalPriceLabel.setText("Total Price: €" + String.format("%.2f", total));
    }


    //Updating all of the carlistview items
    @FXML
    private void updateCartListView() {
        ObservableList<String> items = FXCollections.observableArrayList(cartItems);
        cartListView.setItems(items);
        ObservableList<Float> prices = FXCollections.observableArrayList(cartPrice);
        cartListPriceView.setItems(prices);
        calculateTotalPrice();

    }

    //Clear the cart items
    //Update the ListView
    @FXML
    public void clearCart() {
        cartItems.clear(); 
        cartPrice.clear();
        updateCartListView(); 
    }

    //Remove the selected item from the list
    //Update the ListView
    @FXML
    public void deleteSelectedItem() {
        int selectedIndex = cartListView.getSelectionModel().getSelectedIndex();
        
        if (selectedIndex != -1) {
            // Remove the selected item and its price
            cartItems.remove(selectedIndex);
            cartPrice.remove(selectedIndex);
            // Update the ListView and total price
            updateCartListView();
        }
    }

    //function to switch between scene product.fxml
    @FXML
    public void returnScene(ActionEvent actionEvent) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("layout.fxml"));
        Scene scene = new Scene(pane);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}
