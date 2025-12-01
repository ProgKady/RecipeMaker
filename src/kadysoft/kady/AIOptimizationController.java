package kadysoft.kady;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.collections.FXCollections;
import java.util.HashMap;
import java.util.Map;

public class AIOptimizationController {
    @FXML private ComboBox<String> materialComboBox;
    @FXML private ComboBox<String> stainComboBox;
    @FXML private ComboBox<String> ecoComboBox;
    @FXML private TextArea suggestionsArea;
    @FXML private Button applyButton;
    @FXML private Button clearButton;
    @FXML private Button optimizeButton;

    private Map<String, String> suggestions;

    @FXML
    private void initialize() {
        suggestions = new HashMap<>();
    }

    @FXML
    private void getSuggestions() {
        String material = materialComboBox.getValue();
        String stain = stainComboBox.getValue();
        String eco = ecoComboBox.getValue();

        if (material == null || stain == null || eco == null) {
            suggestionsArea.setText("Please select all options.");
            applyButton.setDisable(true);
            return;
        }

        // Rule-based AI logic
        StringBuilder suggestionText = new StringBuilder();
        suggestions.clear();

        // Base settings by material
        switch (material) {
            case "Cotton":
                suggestions.put("Temperature", eco.equals("Eco-Friendly") ? "30°C" : "40°C");
                suggestions.put("Cycle", "Normal");
                suggestions.put("Detergent", "Standard");
                break;
            case "Wool":
                suggestions.put("Temperature", "30°C");
                suggestions.put("Cycle", "Delicate");
                suggestions.put("Detergent", "Wool-Safe");
                break;
            case "Silk":
                suggestions.put("Temperature", "Cold");
                suggestions.put("Cycle", "Hand Wash");
                suggestions.put("Detergent", "Mild");
                break;
            case "Polyester":
                suggestions.put("Temperature", eco.equals("Eco-Friendly") ? "30°C" : "40°C");
                suggestions.put("Cycle", "Synthetic");
                suggestions.put("Detergent", "Standard");
                break;
        }

        // Adjust for stain
        switch (stain) {
            case "Grease":
                suggestions.put("Pre-Treatment", "Apply stain remover");
                suggestions.put("Temperature", suggestions.get("Temperature").equals("Cold") ? "30°C" : suggestions.get("Temperature"));
                break;
            case "Wine":
                suggestions.put("Pre-Treatment", "Soak in cold water");
                break;
            case "Grass":
                suggestions.put("Pre-Treatment", "Apply enzyme-based detergent");
                break;
        }

        // Eco-friendly adjustments
        if (eco.equals("Eco-Friendly")) {
            suggestions.put("Cycle Time", "Short");
            suggestions.put("Water Usage", "Low");
        } else {
            suggestions.put("Cycle Time", "Standard");
            suggestions.put("Water Usage", "Normal");
        }

        // Build suggestion text
        suggestions.forEach((key, value) -> suggestionText.append(key).append(": ").append(value).append("\n"));
        suggestionsArea.setText(suggestionText.toString());
        applyButton.setDisable(false);
    }

    @FXML
    private void applySuggestions() {
        // Pass suggestions to your existing recipe form
        // Example: Update your main app's recipe fields
        // This is a placeholder; replace with your actual recipe form logic
        System.out.println("Applying suggestions: " + suggestions);
        // Example: recipeForm.setTemperature(suggestions.get("Temperature"));
    }

    @FXML
    private void clearInputs() {
        materialComboBox.setValue(null);
        stainComboBox.setValue(null);
        ecoComboBox.setValue(null);
        suggestionsArea.clear();
        applyButton.setDisable(true);
    }

    // Getter for suggestions to integrate with HTML table generation
    public Map<String, String> getSuggestionsMap() {
        return suggestions;
    }
}