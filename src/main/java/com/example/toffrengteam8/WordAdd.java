package com.example.toffrengteam8;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class WordAdd {

    public static void addWordToXML(String path, String word, String newTranslation) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(path);

        Element rootElement = doc.getDocumentElement();

        NodeList entryNodes = doc.getElementsByTagName("entry");
        Element entryElement = null;
        for (int i = 0; i < entryNodes.getLength(); i++) {
            Element currentElement = (Element) entryNodes.item(i);
            NodeList formNodes = currentElement.getElementsByTagName("form");
            for (int j = 0; j < formNodes.getLength(); j++) {
                Element formElement = (Element) formNodes.item(j);
                Element orthElement = (Element) formElement.getElementsByTagName("orth").item(0);
                if (orthElement.getTextContent().equals(word)) {
                    entryElement = currentElement;
                    break;
                }
            }
            if (entryElement != null) {
                break;
            }
        }

        if (entryElement == null) {
            entryElement = doc.createElement("entry");
            Element formElement = doc.createElement("form");
            Element orthElement = doc.createElement("orth");
            orthElement.setTextContent(word);
            formElement.appendChild(orthElement);
            entryElement.appendChild(formElement);

            Element senseElement = doc.createElement("sense");
            entryElement.appendChild(senseElement);

            Element citElement = doc.createElement("cit");
            citElement.setAttribute("type", "trans");
            Element quoteElement = doc.createElement("quote");
            quoteElement.setTextContent(newTranslation);
            citElement.appendChild(quoteElement);
            senseElement.appendChild(citElement);

            rootElement.appendChild(entryElement);
        } else {
            Element senseElement = (Element) entryElement.getElementsByTagName("sense").item(0);
            Element citElement = doc.createElement("cit");
            citElement.setAttribute("type", "trans");
            Element quoteElement = doc.createElement("quote");
            quoteElement.setTextContent(newTranslation);
            citElement.appendChild(quoteElement);
            senseElement.appendChild(citElement);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(path));
        transformer.transform(source, result);
    }
}
