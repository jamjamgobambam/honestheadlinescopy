package com.codedotorg;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HonestHeadlines {

    /** The text box that displays the results */
    private TextArea results;

    /** The list of words that could indicate a fake news headline */
    private ArrayList<String> sensationalWords;

    /** The label to tell the user where to type */
    private Label inputLabel;

    /** The text box for the user to enter their response */
    private TextField inputField;

    /**
     * Constructor for the HonestHeadlines class.
     * Initializes the TextArea for results with word wrap enabled, the
     * Label for input instructions, the TextField for user input, and
     * the list of sensational words.
     */
    public HonestHeadlines() {
        results = new TextArea();
        results.setWrapText(true);

        sensationalWords = createWordsList();
        inputLabel = new Label("Enter the headline:");
        inputField = new TextField();
    }
    
    /**
     * Starts the application.
     * It sets the title of the primary stage and shows the main screen.
     *
     * @param primaryStage The primary stage of the application.
     */
    public void startApp(Stage primaryStage) {
        primaryStage.setTitle("Honest Headlines");
        showMainScreen(primaryStage);
    }

    /**
     * Displays the main screen of the application.
     * It sets the action for the input field, creates the layout for the screen,
     * and sets the scene for the primary stage.
     *
     * @param primaryStage The primary stage on which the scene is set and shown.
     */
    public void showMainScreen(Stage primaryStage) {
        setInputFieldAction();

        HBox inputLayout = new HBox(inputLabel, inputField);
        VBox layout = new VBox(results, inputLayout);
        Scene mainScene = new Scene(layout, 300, 200);

        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    /**
     * Classifies a given headline as "Fake!" or "Real!".
     * It first converts the input headline to lowercase.
     * Then it checks if the headline contains any sensational words.
     * If it does, the headline is classified as "Fake!".
     * If it doesn't, the headline is classified as "Real!".
     *
     * @param input The headline to be classified.
     * @return "Fake!" if the headline contains any sensational words, "Real!" otherwise.
     */
    public String classifyHeadline(String input) {
        
        return "";
    }

    /**
     * Creates an ArrayList of sensational words or phrases often used in fake headlines.
     *
     * @return ArrayList<String> This returns an ArrayList of sensational words or phrases.
     */
    private ArrayList<String> createWordsList() {
        ArrayList<String> temp = new ArrayList<String>();

        temp.add("shocking");
        temp.add("you won't believe");
        temp.add("unbelievable");
        temp.add("miracle");
        temp.add("secret");
        temp.add("conspiracy");

        return temp;
    }

    /**
     * Sets an action on the input field. When an action is performed on the input
     * field (typically when the user presses Enter), the method gets the text from
     * the input field and appends it as a headline to the results. It then classifies
     * the headline using the classifyHeadline method and appends the classification
     * to the results. Finally, it clears the input field for the next input.
     */
    private void setInputFieldAction() {
        inputField.setOnAction(event -> {
            String input = inputField.getText();
            results.appendText("Headline: " + input + "\n");
            String classification = classifyHeadline(input);
            results.appendText("Classification: " + classification + "\n");
            inputField.clear();
        });
    }

}
