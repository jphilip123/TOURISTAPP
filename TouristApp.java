package com.example.mylovelyfxapp;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class TouristApp extends Application {

    // Map to store the destination details
    private Map<String, Destination> destinations;

    @Override
    public void start(Stage primaryStage) {
        // Initialize the destinations
        initializeDestinations();

        // Create the main layout
        BorderPane mainLayout = new BorderPane();

        // Create the list view to display the destinations
        ListView<String> destinationListView = new ListView<>();
        destinationListView.getItems().addAll(destinations.keySet());

        // Create the details area to display destination information
        VBox detailsVBox = new VBox();
        detailsVBox.setAlignment(Pos.TOP_CENTER);
        detailsVBox.setPadding(new Insets(10));

        // Add event listener to update details when a destination is selected
        destinationListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                updateDetailsView(newValue, detailsVBox);
            }
        });

        // Create the scroll pane for the details area
        ScrollPane detailsScrollPane = new ScrollPane(detailsVBox);
        detailsScrollPane.setFitToWidth(true);

        // Create the main split pane
        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(destinationListView, detailsScrollPane);
        splitPane.setDividerPositions(0.3);

        // Set the main layout
        mainLayout.setCenter(splitPane);

        // Create the scene
        Scene scene = new Scene(mainLayout, 800, 600);

        // Set up the stage
        primaryStage.setTitle("Georgia Tourist App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void updateDetailsView(String destinationName, VBox detailsVBox) {
        // Clear the previous details
        detailsVBox.getChildren().clear();

        // Get the destination details
        Destination destination = destinations.get(destinationName);

        // Create the title label
        Label titleLabel = new Label(destinationName);
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        // Create the description label
        Label descriptionLabel = new Label(destination.getDescription());

        // Create the image view for the pictures
        HBox picturesHBox = new HBox(10);
        picturesHBox.setAlignment(Pos.CENTER);
        for (String picturePath : destination.getPictures()) {
            try {
                FileInputStream inputStream = new FileInputStream(picturePath);
                Image image = new Image(inputStream);
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(200);
                imageView.setPreserveRatio(true);
                picturesHBox.getChildren().add(imageView);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        // Add the components to the details view
        detailsVBox.getChildren().addAll(titleLabel, descriptionLabel, picturesHBox);
    }

    private void initializeDestinations() {
        destinations = new HashMap<>();

        // Destination 1: Atlanta
        Destination atlanta = new Destination("Atlanta");
        atlanta.setDescription("Atlanta is the capital of Georgia and a vibrant city with a rich history. Must-see attractions include the Georgia Aquarium, World of Coca-Cola, and the Atlanta Botanical Garden.");
        atlanta.addPicture("atlanta1.jpg");
        atlanta.addPicture("atlanta2.jpg");
        atlanta.addPicture("atlanta3.jpg");
        atlanta.addPicture("atlanta4.jpg");
        atlanta.addPicture("atlanta5.jpg");
        destinations.put("Atlanta", atlanta);

        // Destination 2: Savannah
        Destination savannah = new Destination("Savannah");
        savannah.setDescription("Savannah is known for its charming historic district and beautiful architecture. Don't miss visiting Forsyth Park, River Street, and the Cathedral of St. John the Baptist.");
        savannah.addPicture(" ");
        savannah.addPicture("savannah2.jpg");
        savannah.addPicture("savannah3.jpg");
        savannah.addPicture("savannah4.jpg");
        savannah.addPicture("savannah5.jpg");
        destinations.put("Savannah", savannah);

        // Destination 3: Jekyll Island
        Destination jekyllIsland = new Destination("Jekyll Island");
        jekyllIsland.setDescription("Jekyll Island is a peaceful retreat with pristine beaches and a rich history. Explore Driftwood Beach, visit the Georgia Sea Turtle Center, and take a bike ride along the island's scenic trails.");
        jekyllIsland.addPicture("jekyll1.jpg");
        jekyllIsland.addPicture("jekyll2.jpg");
        jekyllIsland.addPicture("jekyll3.jpg");
        jekyllIsland.addPicture("jekyll4.jpg");
        jekyllIsland.addPicture("jekyll5.jpg");
        destinations.put("Jekyll Island", jekyllIsland);

        // Destination 4: Tybee Island
        Destination tybeeIsland = new Destination("Tybee Island");
        tybeeIsland.setDescription("Tybee Island is a popular beach destination near Savannah. Enjoy the sandy shores, visit the historic Tybee Island Light Station, and explore the Tybee Marine Science Center.");
        tybeeIsland.addPicture("tybee1.jpg");
        tybeeIsland.addPicture("tybee2.jpg");
        tybeeIsland.addPicture("tybee3.jpg");
        tybeeIsland.addPicture("tybee4.jpg");
        tybeeIsland.addPicture("tybee5.jpg");
        destinations.put("Tybee Island", tybeeIsland);

        // Destination 5: Athens
        Destination athens = new Destination("Athens");
        athens.setDescription("Athens is known for its vibrant music scene and rich cultural heritage. Visit the University of Georgia, explore the State Botanical Garden, and catch a live show at the historic 40 Watt Club.");
        athens.addPicture("athens1.jpg");
        athens.addPicture("athens2.jpg");
        athens.addPicture("athens3.jpg");
        athens.addPicture("athens4.jpg");
        athens.addPicture("athens5.jpg");
        destinations.put("Athens", athens);

        // Destination 6: Cumberland Island
        Destination cumberlandIsland = new Destination("Cumberland Island");
        cumberlandIsland.setDescription("Cumberland Island is a pristine wilderness and a perfect destination for nature lovers. Explore the island's beautiful beaches, hike through the maritime forest, and visit the ruins of Dungeness Mansion.");
        cumberlandIsland.addPicture("cumberland1.jpg");
        cumberlandIsland.addPicture("cumberland2.jpg");
        cumberlandIsland.addPicture("cumberland3.jpg");
        cumberlandIsland.addPicture("cumberland4.jpg");
        cumberlandIsland.addPicture("cumberland5.jpg");
        destinations.put("Cumberland Island", cumberlandIsland);

        // Destination 7: Macon
        Destination macon = new Destination("Macon");
        macon.setDescription("Macon is a city with a rich musical heritage and beautiful architecture. Visit the Ocmulgee National Monument, explore the historic Hay House, and enjoy the annual Cherry Blossom Festival.");
        macon.addPicture("macon1.jpg");
        macon.addPicture("macon2.jpg");
        macon.addPicture("macon3.jpg");
        macon.addPicture("macon4.jpg");
        macon.addPicture("macon5.jpg");
        destinations.put("Macon", macon);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

