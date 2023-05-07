package com.example.toffrengteam8;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TranslationController {

    @FXML
    private ChoiceBox<String> choicebox;

    @FXML
    private Button editButton;

    @FXML
    private TextField ellTrans;

    @FXML
    private TextField englishTrans;

    @FXML
    private Button enterButton;

    @FXML
    private TextField enterWordTextBox;

    @FXML
    private Button exitButton;

    @FXML
    private TextField frenchTrans;

    @FXML
    private TextField germanTrans;

    @FXML
    private TextField italianTrans;

    @FXML
    private TextField swedishTrans;

    @FXML
    private TextField turkishTrans;


    @FXML
    private void showHelp(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Help");
        alert.setHeaderText("How to Use the Translation Application");
        alert.setContentText(
                "1. Enter the word you want to translate in the 'Enter Word' text field.\n" +
                        "2. Select the source language from the 'Language' choice box.\n" +
                        "3. Click the 'Translate' button to translate the word into the available languages.\n" +
                        "4. To edit translations, click the 'Edit' button and modify the text fields.\n" +
                        "5. Click the 'Exit' button to close the application.\n"
        );
        alert.showAndWait();
    }


    private Translator translator;
    private HashMap<String, TextField> languages_tf_map;


    public void initialize() {
        Translator translator = new Translator();
        this.translator = translator;

        this.languages_tf_map = new HashMap<>();
        languages_tf_map.put("Turkish", turkishTrans);
        languages_tf_map.put("English", englishTrans);
        languages_tf_map.put("French", frenchTrans);
        languages_tf_map.put("German", germanTrans);
        languages_tf_map.put("Italian", italianTrans);
        languages_tf_map.put("Swedish", swedishTrans);
        languages_tf_map.put("Modern Greek", ellTrans);
    }


    @FXML
    public void exit1(ActionEvent event) {
        javafx.stage.Stage stage = (javafx.stage.Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void translatorEnter(ActionEvent event) {

        String enteredword = enterWordTextBox.getText();
        enteredword = enteredword.toLowerCase();
        if (enteredword.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please write and select the language of the word!", ButtonType.OK);
            alert.showAndWait();
            enterWordTextBox.clear();
            return;
        }
        String source_lang = choicebox.getSelectionModel().getSelectedItem();
        if (source_lang == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please write and select the language of the word!", ButtonType.OK);
            alert.showAndWait();
            enterWordTextBox.clear();
            return;
        }

        HashMap<String, ArrayList<HashMap<String, String>>> xToy_translation_execution_map = null;
        ArrayList<HashMap<String, String>> xToy_list_of_executions = null;

        HashMap<String, HashMap<String, ArrayList<HashMap<String, String>>>> translator_map = this.translator.getTranslator();

        xToy_translation_execution_map = translator_map.get(source_lang);
        for (Map.Entry<String, ArrayList<HashMap<String, String>>> entry : xToy_translation_execution_map.entrySet()) {
            String target_lang = entry.getKey();
            TextField target_lang_tf = this.languages_tf_map.get(target_lang);
            xToy_list_of_executions = entry.getValue();

            String translated_text = enteredword;
            if (xToy_list_of_executions != null) {
                for (int exec_index = 0; exec_index < xToy_list_of_executions.size(); exec_index++) {
                    System.out.printf("%s", translated_text);
                    HashMap<String, String> dict = xToy_list_of_executions.get(exec_index);
                    if (dict.containsKey(translated_text)) {
                        translated_text = xToy_list_of_executions.get(exec_index).get(translated_text);
                    } else {
                        translated_text = "'NOT FOUND!'";
                        break;
                    }
                }
            } else {
                System.out.printf("%s\n", target_lang);
            }

            target_lang_tf.setText(translated_text);
        }

    }

    @FXML
    public void edit(ActionEvent event) {
        String word = enterWordTextBox.getText().trim();
        String selectedLanguage = choicebox.getValue();
        String[] translations = {
                englishTrans.getText().trim(),
                germanTrans.getText().trim(),
                frenchTrans.getText().trim(),
                italianTrans.getText().trim(),
                swedishTrans.getText().trim(),
                ellTrans.getText().trim(),
                turkishTrans.getText().trim()
        };

        if (word.isEmpty() || translations[0].isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText("Word or translation is empty");
            alert.showAndWait();
            return;
        }

        try {
            String[] languages = {"English", "German", "French", "Italian", "Swedish", "Modern Greek", "Turkish"};
            String[] languageCodes = {"eng", "deu", "fra", "ita", "swe", "ell", "tur"};
            String[] filePaths = {

                    "src/main/resources/Files/eng-fra.tei",
                    "src/main/resources/Files/eng-ita.tei",
                    "src/main/resources/Files/eng-deu.tei",
                    "src/main/resources/Files/eng-swe.tei",
                    "src/main/resources/Files/eng-ell.tei",
                    "src/main/resources/Files/eng-tur.tei",
                    "src/main/resources/Files/deu-fra.tei",
                    "src/main/resources/Files/deu-ita.tei",
                    "src/main/resources/Files/deu-swe.tei",
                    "src/main/resources/Files/deu-ell.tei",
                    "src/main/resources/Files/deu-tur.tei",
                    "src/main/resources/Files/deu-eng.tei",
                    "src/main/resources/Files/fra-eng.tei",
                    "src/main/resources/Files/fra-deu.tei",
                    "src/main/resources/Files/fra-ita.tei",
                    "src/main/resources/Files/fra-swe.tei",
                    "src/main/resources/Files/fra-ell.tei",
                    "src/main/resources/Files/fra-tur.tei",
                    "src/main/resources/Files/ita-eng.tei",
                    "src/main/resources/Files/ita-deu.tei",
                    "src/main/resources/Files/ita-fra.tei",
                    "src/main/resources/Files/ita-swe.tei",
                    "src/main/resources/Files/ita-ell.tei",
                    "src/main/resources/Files/ita-tur.tei",
                    "src/main/resources/Files/swe-eng.tei",
                    "src/main/resources/Files/swe-deu.tei",
                    "src/main/resources/Files/swe-fra.tei",
                    "src/main/resources/Files/swe-ita.tei",
                    "src/main/resources/Files/swe-ell.tei",
                    "src/main/resources/Files/swe-tur.tei",
                    "src/main/resources/Files/ell-eng.tei",
                    "src/main/resources/Files/ell-deu.tei",
                    "src/main/resources/Files/ell-fra.tei",
                    "src/main/resources/Files/ell-ita.tei",
                    "src/main/resources/Files/ell-swe.tei",
                    "src/main/resources/Files/ell-tur.tei",
                    "src/main/resources/Files/tur-eng.tei",
                    "src/main/resources/Files/tur-deu.tei",

            };

            for (int i = 0; i < languages.length; i++) {
                if (selectedLanguage.equals(languages[i])) {
                    for (int j = 0; j < filePaths.length; j++) {
                        File teiFile = new File(filePaths[j]);
                        CustomParser.TEIEditor.modifyTEIFile(teiFile, word, translations[j]);
                    }
                    break;
                }
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Success");
            alert.setContentText("TEI files edited successfully");
            alert.showAndWait();
        } catch (Exception ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText("An error occurred while editing the TEI files");
            alert.showAndWait();
        }
    }

    @FXML
    public void add(ActionEvent event) {
        String word = enterWordTextBox.getText().trim();
        String selectedLanguage = choicebox.getValue();
        String[] translations = {
                englishTrans.getText().trim(),
                germanTrans.getText().trim(),
                frenchTrans.getText().trim(),
                italianTrans.getText().trim(),
                swedishTrans.getText().trim(),
                ellTrans.getText().trim(),
                turkishTrans.getText().trim()
        };

        if (word.isEmpty() || translations[0].isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText("Word or translation is empty");
            alert.showAndWait();
            return;
        }

        try {
            String[] languages = {"English", "German", "French", "Italian", "Swedish", "Modern Greek", "Turkish"};
            String[] filePaths = {
                    "src/main/resources/Files/eng-fra.tei",
                    "src/main/resources/Files/eng-ita.tei",
                    "src/main/resources/Files/eng-deu.tei",
                    "src/main/resources/Files/eng-swe.tei",
                    "src/main/resources/Files/eng-ell.tei",
                    "src/main/resources/Files/eng-tur.tei",
                    "src/main/resources/Files/deu-fra.tei",
                    "src/main/resources/Files/deu-ita.tei",
                    "src/main/resources/Files/deu-swe.tei",
                    "src/main/resources/Files/deu-ell.tei",
                    "src/main/resources/Files/deu-tur.tei",
                    "src/main/resources/Files/deu-eng.tei",
                    "src/main/resources/Files/fra-eng.tei",
                    "src/main/resources/Files/fra-deu.tei",
                    "src/main/resources/Files/fra-ita.tei",
                    "src/main/resources/Files/fra-swe.tei",
                    "src/main/resources/Files/fra-ell.tei",
                    "src/main/resources/Files/fra-tur.tei",
                    "src/main/resources/Files/ita-eng.tei",
                    "src/main/resources/Files/ita-deu.tei",
                    "src/main/resources/Files/ita-fra.tei",
                    "src/main/resources/Files/ita-swe.tei",
                    "src/main/resources/Files/ita-ell.tei",
                    "src/main/resources/Files/ita-tur.tei",
                    "src/main/resources/Files/swe-eng.tei",
                    "src/main/resources/Files/swe-deu.tei",
                    "src/main/resources/Files/swe-fra.tei",
                    "src/main/resources/Files/swe-ita.tei",
                    "src/main/resources/Files/swe-ell.tei",
                    "src/main/resources/Files/swe-tur.tei",
                    "src/main/resources/Files/ell-eng.tei",
                    "src/main/resources/Files/ell-deu.tei",
                    "src/main/resources/Files/ell-fra.tei",
                    "src/main/resources/Files/ell-ita.tei",
                    "src/main/resources/Files/ell-swe.tei",
                    "src/main/resources/Files/ell-tur.tei",
                    "src/main/resources/Files/tur-eng.tei",
                    "src/main/resources/Files/tur-deu.tei",

            };

            for (int i = 0; i < languages.length; i++) {
                if (selectedLanguage.equals(languages[i])) {
                    for (int j = 0; j < languages.length; j++) {
                        if (i != j) {
                            String filePath = "src/main/resources/translations/" + languages[i].toLowerCase().substring(0, 3)
                                    + "-" + languages[j].toLowerCase().substring(0, 3) + ".tei";
                            WordAdd.addWordToXML(filePath, word, translations[j]);
                        }
                    }
                    break;
                }
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Success");
            alert.setContentText("TEI files edited successfully");
            alert.showAndWait();
        } catch (Exception ex) {
            ex.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText("An error occurred while editing the TEI files");
            alert.showAndWait();
        }
    }
}