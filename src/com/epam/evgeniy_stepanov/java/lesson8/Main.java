package com.epam.evgeniy_stepanov.java.lesson8;

import com.epam.evgeniy_stepanov.java.lesson8.model.ElectricalAppliance;
import com.epam.evgeniy_stepanov.java.lesson8.model.Flatiron;
import com.epam.evgeniy_stepanov.java.lesson8.model.Kettle;
import com.epam.evgeniy_stepanov.java.lesson8.model.Microwave;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParserConfigurationException {
        new Main().run();
    }

    public void run() throws IOException, ParserConfigurationException {
        ArrayList<ElectricalAppliance> setOfHouseholdElectricalAppliances = new ArrayList<>();
        ElectricalAppliance bosh = new Kettle(true, "Kettle", "UK", "red", "kitchen", 2400);
        setOfHouseholdElectricalAppliances.add(bosh);

        ElectricalAppliance supra = new Microwave(false, "Microwave", "USA", "black", "kitchen", 3250);
        setOfHouseholdElectricalAppliances.add(supra);

        ElectricalAppliance philips = new Flatiron(true, "Flatiron", "USA", "gray", "bedroom", 1200);
        setOfHouseholdElectricalAppliances.add(philips);

        XMLParser xmlParser = new XMLParser();

        Scanner in = new Scanner(System.in);
        System.out.println("Select action:");
        System.out.println("1 - get XML file");
        System.out.println("2 - get object from XML file");

        int action = in.nextInt();
        switch (action) {
            case 1: {
                xmlParser.writeObjectToXMLFile(setOfHouseholdElectricalAppliances);
                break;
            }
            case 2: {
                setOfHouseholdElectricalAppliances = xmlParser.readXMLFile("ElectricalAppliances.xml");

                for (ElectricalAppliance electricalAppliance: setOfHouseholdElectricalAppliances) {
                    System.out.println(electricalAppliance);
                }
                break;
            }
            default: {
                System.out.println("Not correct operation!");
            }
        }
    }
}
