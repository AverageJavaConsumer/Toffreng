package com.example.toffrengteam8;

import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
    public enum Language {
        ENGLISH, TURKISH, FRENCH, ITALIAN, SWEDISH, GREEK, GERMAN
    }
    public static final String eng_tur = "src/main/resources/Files/eng-tur.tei";
    public static final String eng_ita = "src/main/resources/Files/eng-ita.tei";
    public static final String eng_swe = "src/main/resources/Files/eng-swe.tei";
    public static final String eng_deu = "src/main/resources/Files/eng-deu.tei";
    public static final String eng_ell = "src/main/resources/Files/eng-ell.tei";
    public static final String eng_fra = "src/main/resources/Files/eng-fra.tei";
    public static final String deu_ita = "src/main/resources/Files/deu-ita.tei";
    public static final String deu_fra = "src/main/resources/Files/deu-fra.tei";
    public static final String deu_eng = "src/main/resources/Files/deu-eng.tei";
    public static final String deu_swe = "src/main/resources/Files/deu-swe.tei";
    public static final String deu_tur = "src/main/resources/Files/deu-tur.tei";
    public static final String deu_ell = "src/main/resources/Files/deu-ell.tei";
    public static final String ell_eng = "src/main/resources/Files/ell-eng.tei";
    public static final String ell_tur = "src/main/resources/Files/ell-tur.tei";
    public static final String ell_fra = "src/main/resources/Files/ell-fra.tei";
    public static final String ell_ita = "src/main/resources/Files/ell-ita.tei";
    public static final String ell_swe = "src/main/resources/Files/ell-swe.tei";
    public static final String ell_deu = "src/main/resources/Files/ell-deu.tei";
    public static final String fra_deu = "src/main/resources/Files/fra-deu.tei";
    public static final String fra_ell = "src/main/resources/Files/fra-ell.tei";
    public static final String fra_eng = "src/main/resources/Files/fra-eng.tei";
    public static final String fra_ita = "src/main/resources/Files/fra-ita.tei";
    public static final String fra_swe = "src/main/resources/Files/fra-swe.tei";
    public static final String fra_tur = "src/main/resources/Files/fra-tur.tei";
    public static final String ita_deu = "src/main/resources/Files/ita-deu.tei";
    public static final String ita_ell = "src/main/resources/Files/ita-ell.tei";
    public static final String ita_eng = "src/main/resources/Files/ita-eng.tei";
    public static final String ita_swe = "src/main/resources/Files/ita-swe.tei";
    public static final String ita_tur = "src/main/resources/Files/ita-tur.tei";
    public static final String ita_fra = "src/main/resources/Files/ita-fra.tei";
    public static final String swe_deu = "src/main/resources/Files/swe-deu.tei";
    public static final String swe_ell = "src/main/resources/Files/swe-ell.tei";
    public static final String swe_eng = "src/main/resources/Files/swe-eng.tei";
    public static final String swe_fra = "src/main/resources/Files/swe-fra.tei";
    public static final String swe_ita = "src/main/resources/Files/swe-ita.tei";
    public static final String swe_tur = "src/main/resources/Files/swe-tur.tei";
    public static final String tur_deu = "src/main/resources/Files/tur-deu.tei";
    public static final String tur_eng = "src/main/resources/Files/tur-eng.tei";

    private HashMap<Language, HashMap<String, String>> languageDictionaries;

    public Dictionary() {
        languageDictionaries = new HashMap<>();
    }

    public void addLanguageDictionary(Language language, HashMap<String, String> dictionary) {
        languageDictionaries.put(language, dictionary);
    }

    public  String findTranslation(String word, Language targetLanguage) {
        HashMap<String, String> targetDictionary = languageDictionaries.get(targetLanguage);
        if (targetDictionary != null) {
            return targetDictionary.get(word.toLowerCase());
        }
        return null;
    }

    public ArrayList<String> findTranslations(ArrayList<String> words, Language targetLanguage) {
        ArrayList<String> translations = new ArrayList<>();
        for (String word : words) {
            translations.add(findTranslation(word, targetLanguage));
        }
        return translations;
    }
}