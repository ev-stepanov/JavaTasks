package com.epam.evgeniy_stepanov.java.lesson8;

import com.epam.evgeniy_stepanov.java.lesson8.model.ElectricalAppliance;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class XMLParser {

    public void writeObjectToXMLFile(ArrayList<ElectricalAppliance> electricalAppliances) throws ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();

            Document doc = builder.newDocument();
            Element rootElement =
                    doc.createElementNS("com.epam.evgeniy_stepanov.java.lesson8.model", "ElectricalAppliances");

            doc.appendChild(rootElement);

            for (ElectricalAppliance appliance: electricalAppliances) {
                rootElement.appendChild(getElectricalAppliance(doc, appliance));
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            StreamResult file = new StreamResult(new File("ElectricalAppliances.xml"));

            transformer.transform(source, file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Node getElectricalAppliance(Document doc, ElectricalAppliance electricalAppliance) {

        Element appliance = doc.createElement("Appliance");
        appliance.setAttribute("nameElectricalAppliance", electricalAppliance.getName());

        appliance.appendChild(getElectricalApplianceElements(doc, "state", Boolean.toString(electricalAppliance.isState())));
        appliance.appendChild(getElectricalApplianceElements(doc, "name", electricalAppliance.getName()));
        appliance.appendChild(getElectricalApplianceElements(doc, "locationOfTheApartment", electricalAppliance.getLocationOfTheApartment()));
        appliance.appendChild(getElectricalApplianceElements(doc, "color", electricalAppliance.getColor()));
        appliance.appendChild(getElectricalApplianceElements(doc, "origin", electricalAppliance.getOrigin()));
        appliance.appendChild(getElectricalApplianceElements(doc, "power", String.valueOf(electricalAppliance.getPower())));
        appliance.appendChild(getElectricalApplianceElements(doc, "power", String.valueOf(electricalAppliance.getPower())));

        return appliance;
    }

    private static Node getElectricalApplianceElements(Document doc, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }

    public ArrayList<ElectricalAppliance> readXMLFile(String fileName) {
        ArrayList<ElectricalAppliance> electricalAppliances = new ArrayList<>();
        try {
            final File xmlFile = new File(System.getProperty("user.dir")
                    + File.separator + fileName);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("Appliance");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                ElectricalAppliance electricalAppliance = null;
                if (Node.ELEMENT_NODE == node.getNodeType()) {
                    Element element = (Element) node;
                    String nameElectricalAppliance = element.getAttribute("nameElectricalAppliance");
                    Boolean state = Boolean.parseBoolean(element.getElementsByTagName("state").item(0).getTextContent());
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String locationOfTheApartment = element.getElementsByTagName("locationOfTheApartment").item(0).getTextContent();
                    String color = element.getElementsByTagName("color").item(0).getTextContent();
                    String origin = element.getElementsByTagName("origin").item(0).getTextContent();
                    int power = Integer.parseInt(element.getElementsByTagName("power").item(0).getTextContent());

                    String electricalAppliancePack = getPathToClass(nameElectricalAppliance);
                    Class electricalApplianceClass = Class.forName(electricalAppliancePack);
                    Constructor[] a = electricalApplianceClass.getConstructors();

                    electricalAppliance = (ElectricalAppliance)a[0].newInstance(state, name, origin, color, locationOfTheApartment, power);
                    electricalAppliances.add(electricalAppliance);
                }
            }
        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException | ClassNotFoundException
                | IllegalAccessException | InstantiationException | InvocationTargetException e) {

            e.printStackTrace();
        }

        return electricalAppliances;
    }

    public static String getPathToClass(String className) {
        return "com.epam.evgeniy_stepanov.java.lesson8.model." + className;
    }
}
