package com.example.toffrengteam8;

import java.util.ArrayList;
import java.util.HashMap;

public class Translator {
    HashMap<String, HashMap<String, ArrayList<HashMap<String, String>>>> translation_execution_master_map= null;

    public Translator() {
        CustomParser xmlParser = new CustomParser();
        engTotur = xmlParser.parseDictionary(Dictionary.eng_tur, Dictionary.Language.TURKISH);
        engTofra = xmlParser.parseDictionary(Dictionary.eng_fra, Dictionary.Language.FRENCH);
        engToita = xmlParser.parseDictionary(Dictionary.eng_ita, Dictionary.Language.ITALIAN);
        engToswe = xmlParser.parseDictionary(Dictionary.eng_swe, Dictionary.Language.SWEDISH);
        engToell = xmlParser.parseDictionary(Dictionary.eng_ell, Dictionary.Language.GREEK);
        engTodeu = xmlParser.parseDictionary(Dictionary.eng_deu, Dictionary.Language.GERMAN);
        deuToita = xmlParser.parseDictionary(Dictionary.deu_ita, Dictionary.Language.ITALIAN);
        deuTofra = xmlParser.parseDictionary(Dictionary.deu_fra, Dictionary.Language.FRENCH);
        deuTotur = xmlParser.parseDictionary(Dictionary.deu_tur, Dictionary.Language.TURKISH);
        deuToeng = xmlParser.parseDictionary(Dictionary.deu_eng, Dictionary.Language.ENGLISH);
        deuToswe = xmlParser.parseDictionary(Dictionary.deu_swe, Dictionary.Language.SWEDISH);
        deuToell = xmlParser.parseDictionary(Dictionary.deu_ell, Dictionary.Language.GREEK);
        ellToeng = xmlParser.parseDictionary(Dictionary.ell_eng, Dictionary.Language.ENGLISH);
        ellTofra = xmlParser.parseDictionary(Dictionary.ell_fra, Dictionary.Language.FRENCH);
        ellToita = xmlParser.parseDictionary(Dictionary.ell_ita, Dictionary.Language.ITALIAN);
        ellTotur = xmlParser.parseDictionary(Dictionary.ell_tur, Dictionary.Language.TURKISH);
        ellTodeu = xmlParser.parseDictionary(Dictionary.ell_deu, Dictionary.Language.GERMAN);
        ellToswe = xmlParser.parseDictionary(Dictionary.ell_swe, Dictionary.Language.SWEDISH);
        fraTodeu = xmlParser.parseDictionary(Dictionary.fra_deu, Dictionary.Language.GERMAN);
        fraToell = xmlParser.parseDictionary(Dictionary.fra_ell, Dictionary.Language.GREEK);
        fraToeng = xmlParser.parseDictionary(Dictionary.fra_eng, Dictionary.Language.ENGLISH);
        fraToita = xmlParser.parseDictionary(Dictionary.fra_ita, Dictionary.Language.ITALIAN);
        fraToswe = xmlParser.parseDictionary(Dictionary.fra_swe, Dictionary.Language.SWEDISH);
        fraTotur = xmlParser.parseDictionary(Dictionary.fra_tur, Dictionary.Language.TURKISH);
        itaTodeu = xmlParser.parseDictionary(Dictionary.ita_deu, Dictionary.Language.GERMAN);
        itaToell = xmlParser.parseDictionary(Dictionary.ita_ell, Dictionary.Language.GREEK);
        itaToeng = xmlParser.parseDictionary(Dictionary.ita_eng, Dictionary.Language.ENGLISH);
        itaToswe = xmlParser.parseDictionary(Dictionary.ita_swe, Dictionary.Language.SWEDISH);
        itaTotur = xmlParser.parseDictionary(Dictionary.ita_tur, Dictionary.Language.TURKISH);
        itaTofra = xmlParser.parseDictionary(Dictionary.ita_fra, Dictionary.Language.FRENCH);
        sweTodeu = xmlParser.parseDictionary(Dictionary.swe_deu, Dictionary.Language.GERMAN);
        sweToell = xmlParser.parseDictionary(Dictionary.swe_ell, Dictionary.Language.GREEK);
        sweToeng = xmlParser.parseDictionary(Dictionary.swe_eng, Dictionary.Language.ENGLISH);
        sweTofra = xmlParser.parseDictionary(Dictionary.swe_fra, Dictionary.Language.FRENCH);
        sweToita = xmlParser.parseDictionary(Dictionary.swe_ita, Dictionary.Language.ITALIAN);
        sweTotur = xmlParser.parseDictionary(Dictionary.swe_tur, Dictionary.Language.TURKISH);
        turTodeu = xmlParser.parseDictionary(Dictionary.tur_deu, Dictionary.Language.GERMAN);
        turToeng = xmlParser.parseDictionary(Dictionary.tur_eng, Dictionary.Language.ENGLISH);

        translation_execution_master_map = new HashMap<>();
        HashMap<String, ArrayList<HashMap<String, String>>> LanguageBridge_execution_map;
        ArrayList<HashMap<String, String>> Bridge_list_of_executions;


        // Turkish Start
        LanguageBridge_execution_map = new HashMap<>();

        Bridge_list_of_executions = new ArrayList<>();
        LanguageBridge_execution_map.put("Turkish", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getTurToeng());
        LanguageBridge_execution_map.put("English", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getTurTodeu());
        LanguageBridge_execution_map.put("German", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getTurToeng());
        Bridge_list_of_executions.add(getEngTofra());
        LanguageBridge_execution_map.put("French", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getTurToeng());
        Bridge_list_of_executions.add(getEngToswe());
        LanguageBridge_execution_map.put("Swedish", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getTurToeng());
        Bridge_list_of_executions.add(getEngToita());
        LanguageBridge_execution_map.put("Italian", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getTurToeng());
        Bridge_list_of_executions.add(getEngToell());
        LanguageBridge_execution_map.put("Modern Greek", Bridge_list_of_executions);

        translation_execution_master_map.put("Turkish", LanguageBridge_execution_map);

        // German Start
        LanguageBridge_execution_map = new HashMap<>();

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getDeuTotur());
        LanguageBridge_execution_map.put("Turkish", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getDeuToeng());
        LanguageBridge_execution_map.put("English", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        LanguageBridge_execution_map.put("German", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getDeuTofra());
        LanguageBridge_execution_map.put("French", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getDeuToswe());
        LanguageBridge_execution_map.put("Swedish", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getDeuToita());
        LanguageBridge_execution_map.put("Italian", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getDeuToell());
        LanguageBridge_execution_map.put("Modern Greek", Bridge_list_of_executions);

        translation_execution_master_map.put("German", LanguageBridge_execution_map);

        // French Start
        LanguageBridge_execution_map = new HashMap<>();

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getFraTotur());
        LanguageBridge_execution_map.put("Turkish", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getFraToeng());
        LanguageBridge_execution_map.put("English", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getFraTodeu());
        LanguageBridge_execution_map.put("German", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        LanguageBridge_execution_map.put("French", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getFraToswe());
        LanguageBridge_execution_map.put("Swedish", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getFraToita());
        LanguageBridge_execution_map.put("Italian", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getFraToell());
        LanguageBridge_execution_map.put("Modern Greek", Bridge_list_of_executions);

        translation_execution_master_map.put("French", LanguageBridge_execution_map);

        //Swedish Start
        LanguageBridge_execution_map = new HashMap<>();

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getSweTotur());
        LanguageBridge_execution_map.put("Turkish", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getSweToeng());
        LanguageBridge_execution_map.put("English", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getSweTodeu());
        LanguageBridge_execution_map.put("German", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getSweTofra());
        LanguageBridge_execution_map.put("French", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        LanguageBridge_execution_map.put("Swedish", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getSweToita());
        LanguageBridge_execution_map.put("Italian", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getSweToell());
        LanguageBridge_execution_map.put("Modern Greek", Bridge_list_of_executions);

        translation_execution_master_map.put("Swedish", LanguageBridge_execution_map);

        // Italian Start
        LanguageBridge_execution_map = new HashMap<>();

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getItaTotur());
        LanguageBridge_execution_map.put("Turkish", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getItaToeng());
        LanguageBridge_execution_map.put("English", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getItaTodeu());
        LanguageBridge_execution_map.put("German", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getItaTofra());
        LanguageBridge_execution_map.put("French", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getItaToswe());
        LanguageBridge_execution_map.put("Swedish", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        LanguageBridge_execution_map.put("Italian", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getItaToell());
        LanguageBridge_execution_map.put("Modern Greek", Bridge_list_of_executions);

        translation_execution_master_map.put("Italian", LanguageBridge_execution_map);


        // Modern Greek Start
        LanguageBridge_execution_map = new HashMap<>();

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getEllTotur());
        LanguageBridge_execution_map.put("Turkish", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getEllToeng());
        LanguageBridge_execution_map.put("English", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getEllTodeu());
        LanguageBridge_execution_map.put("German", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getEllTofra());
        LanguageBridge_execution_map.put("French", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getEllToswe());
        LanguageBridge_execution_map.put("Swedish", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getEllToita());
        LanguageBridge_execution_map.put("Italian", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        LanguageBridge_execution_map.put("Modern Greek", Bridge_list_of_executions);

        //  English Start
        LanguageBridge_execution_map = new HashMap<>();

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getEngTotur());
        LanguageBridge_execution_map.put("Turkish", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        LanguageBridge_execution_map.put("English", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getEngTodeu());
        LanguageBridge_execution_map.put("German", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getEngTofra());
        LanguageBridge_execution_map.put("French", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getEngToswe());
        LanguageBridge_execution_map.put("Swedish", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getEngToita());
        LanguageBridge_execution_map.put("Italian", Bridge_list_of_executions);

        Bridge_list_of_executions = new ArrayList<>();
        Bridge_list_of_executions.add(getEngToell());
        LanguageBridge_execution_map.put("Modern Greek", Bridge_list_of_executions);

        translation_execution_master_map.put("English", LanguageBridge_execution_map);
    }


    private HashMap<String,String> engTotur;
    private HashMap<String,String> engTofra;
    private HashMap<String,String> engToita;
    private HashMap<String,String> engToswe;
    private HashMap<String,String> engToell;
    private HashMap<String,String> engTodeu;
    private HashMap<String,String> deuToita;
    private HashMap<String,String> deuTofra;
    private HashMap<String,String> deuToeng;
    private HashMap<String,String> deuTotur;
    private HashMap<String,String> deuToswe;
    private HashMap<String,String> deuToell;
    private HashMap<String,String> ellToeng;
    private HashMap<String,String> ellTofra;
    private HashMap<String,String> ellToita;
    private HashMap<String,String> ellToswe;
    private HashMap<String,String> ellTotur;
    private HashMap<String,String> ellTodeu;
    private HashMap<String,String> fraTodeu;
    private HashMap<String,String> fraToell;
    private HashMap<String,String> fraToeng;
    private HashMap<String,String> fraToita;
    private HashMap<String,String> fraToswe;
    private HashMap<String,String> fraTotur;
    private HashMap<String,String> itaTodeu;
    private HashMap<String,String> itaToell;
    private HashMap<String,String> itaToeng;
    private HashMap<String,String> itaTofra;
    private HashMap<String,String> itaToswe;
    private HashMap<String,String> itaTotur;
    private HashMap<String,String> sweTodeu;
    private HashMap<String,String> sweToell;
    private HashMap<String,String> sweToeng;
    private HashMap<String,String> sweTofra;
    private HashMap<String,String> sweToita;
    private HashMap<String,String> sweTotur;
    private HashMap<String,String> turTodeu;
    private HashMap<String,String> turToeng;

    public HashMap<String, String> getEngTotur() {
        return engTotur;
    }

    public HashMap<String, String> getEngTofra() {
        return engTofra;
    }

    public HashMap<String, String> getEngToita() {
        return engToita;
    }

    public HashMap<String, String> getEngToswe() {
        return engToswe;
    }

    public HashMap<String, String> getEngToell() {
        return engToell;
    }

    public HashMap<String, String> getEngTodeu() {
        return engTodeu;
    }

    public HashMap<String, String> getDeuToita() {
        return deuToita;
    }

    public HashMap<String, String> getDeuTofra() {
        return deuTofra;
    }

    public HashMap<String, String> getDeuToeng() {
        return deuToeng;
    }

    public HashMap<String, String> getDeuTotur() {
        return deuTotur;
    }

    public HashMap<String, String> getDeuToswe() {
        return deuToswe;
    }
    public HashMap<String, String> getDeuToell() {
        return deuToell;
    }

    public HashMap<String, String> getEllToeng() {
        return ellToeng;
    }
    public HashMap<String, String> getEllTotur() {
        return ellTotur;
    }
    public HashMap<String, String> getEllTodeu() {
        return ellTodeu;
    }

    public HashMap<String, String> getEllTofra() {
        return ellTofra;
    }

    public HashMap<String, String> getEllToita() {
        return ellToita;
    }

    public HashMap<String, String> getEllToswe() {
        return ellToswe;
    }

    public HashMap<String, String> getFraTodeu() {
        return fraTodeu;
    }

    public HashMap<String, String> getFraToell() {
        return fraToell;
    }

    public HashMap<String, String> getFraToeng() {
        return fraToeng;
    }

    public HashMap<String, String> getFraToita() {
        return fraToita;
    }

    public HashMap<String, String> getFraToswe() {
        return fraToswe;
    }

    public HashMap<String, String> getFraTotur() {
        return fraTotur;
    }

    public HashMap<String, String> getItaTodeu() {
        return itaTodeu;
    }

    public HashMap<String, String> getItaToell() {
        return itaToell;
    }
    public HashMap<String, String> getItaTofra() {
        return itaTofra;
    }

    public HashMap<String, String> getItaToeng() {
        return itaToeng;
    }

    public HashMap<String, String> getItaToswe() {
        return itaToswe;
    }

    public HashMap<String, String> getItaTotur() {
        return itaTotur;
    }

    public HashMap<String, String> getSweTodeu() {
        return sweTodeu;
    }

    public HashMap<String, String> getSweToell() {
        return sweToell;
    }

    public HashMap<String, String> getSweToeng() {
        return sweToeng;
    }

    public HashMap<String, String> getSweTofra() {
        return sweTofra;
    }

    public HashMap<String, String> getSweToita() {
        return sweToita;
    }

    public HashMap<String, String> getSweTotur() {
        return sweTotur;
    }

    public HashMap<String, String> getTurTodeu() {
        return turTodeu;
    }

    public HashMap<String, String> getTurToeng() {
        return turToeng;
    }

    public HashMap<String, HashMap<String, ArrayList<HashMap<String, String>>>> getTranslator() {
        return this.translation_execution_master_map;
    }
}