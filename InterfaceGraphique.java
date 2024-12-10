package examen_paralel;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class InterfaceGraphique extends Application {
    private GestionnaireColis gestionnaireColis;
    private TextArea affichageColis;
    private TextField idField, descriptionField, destinationField;

    public InterfaceGraphique() {
        gestionnaireColis = new GestionnaireColis();
    }

    @Override
    public void start(Stage primaryStage) {
        // Création de la fenêtre principale
        primaryStage.setTitle("Gestion des Colis");

        // Champs de saisie
        idField = new TextField();
        idField.setPromptText("ID du colis");
        descriptionField = new TextField();
        descriptionField.setPromptText("Description");
        destinationField = new TextField();
        destinationField.setPromptText("Destination");

        // Zone d'affichage des colis
        affichageColis = new TextArea();
        affichageColis.setEditable(false);
        affichageColis.setPrefHeight(200);
        affichageColis.setStyle("-fx-border-color: lightgray; -fx-border-radius: 5; -fx-background-color: #f9f9f9;");

        // Boutons pour ajouter, mettre en transit et livrer un colis
        Button addButton = new Button("Ajouter Colis");
        addButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");
        addButton.setOnAction(e -> ajouterColis());

        Button transitButton = new Button("Mettre en Transit");
        transitButton.setStyle("-fx-background-color: #FFC107; -fx-text-fill: white; -fx-font-weight: bold;");
        transitButton.setOnAction(e -> mettreEnTransit());

        Button deliverButton = new Button("Livrer Colis");
        deliverButton.setStyle("-fx-background-color: #F44336; -fx-text-fill: white; -fx-font-weight: bold;");
        deliverButton.setOnAction(e -> livrerColis());

        // Groupement des champs de saisie
        VBox inputFields = new VBox(10,
                new Label("Champs de saisie :"),
                idField,
                descriptionField,
                destinationField
        );
        inputFields.setPadding(new Insets(10));
        inputFields.setStyle("-fx-border-color: #ddd; -fx-border-radius: 5; -fx-padding: 10;");

        // Groupement des boutons
        HBox buttonBox = new HBox(10, addButton, transitButton, deliverButton);
        buttonBox.setPadding(new Insets(10));

        // Disposition principale
        VBox mainLayout = new VBox(15,
                inputFields,
                buttonBox,
                new Label("Liste des Colis :"),
                affichageColis
        );
        mainLayout.setPadding(new Insets(15));
        mainLayout.setStyle("-fx-font-family: 'Arial'; -fx-background-color: #f5f5f5; -fx-border-radius: 10;");

        Scene scene = new Scene(mainLayout, 450, 450);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void ajouterColis() {
        try {
            int id = Integer.parseInt(idField.getText());
            String description = descriptionField.getText();
            String destination = destinationField.getText();

            Colis colis = new Colis(id, description, destination);
            gestionnaireColis.ajouterColis(colis);
            mettreAJourAffichage();
        } catch (NumberFormatException e) {
            afficherMessage("Erreur : L'ID doit être un entier.");
        }
    }

    private void mettreEnTransit() {
        try {
            int id = Integer.parseInt(idField.getText());
            gestionnaireColis.mettreEnTransit(id);
            mettreAJourAffichage();
        } catch (NumberFormatException e) {
            afficherMessage("Erreur : L'ID doit être un entier.");
        }
    }

    private void livrerColis() {
        try {
            int id = Integer.parseInt(idField.getText());
            gestionnaireColis.livrerColis(id);
            mettreAJourAffichage();
        } catch (NumberFormatException e) {
            afficherMessage("Erreur : L'ID doit être un entier.");
        }
    }

    private void afficherMessage(String message) {
        affichageColis.appendText(message + "\n");
    }

    private void mettreAJourAffichage() {
        affichageColis.clear();
        for (Colis colis : gestionnaireColis.afficherColis()) {
            affichageColis.appendText(colis.toString() + "\n");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
