package com.epam.evgeniy_stepanov.java.lesson6;

import com.epam.evgeniy_stepanov.java.lesson6.exceptions.CountryException;
import com.epam.evgeniy_stepanov.java.lesson6.exceptions.MinMaxException;
import com.epam.evgeniy_stepanov.java.lesson6.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
    private final String prefixOfFiles = "src/com/epam/evgeniy_stepanov/java/lesson6/";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Main().run();
    }

    public void run() throws IOException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Select action:");
        System.out.println("1 - serialize electrical appliances");
        System.out.println("2 - deserialize electrical appliances");

        int action = in.nextInt();
        switch (action) {
            case 1: {
                this.serialize();
                break;
            }
            case 2: {
                this.deserialize();
                break;
            }
            default: {
                System.out.println("Not correct operation!");
            }
        }
   }

    private String parseCounty(String country) throws CountryException {
        if (country.isEmpty()) {
            throw new CountryException();
        }
        return country;
    }

    private Boolean checkPower(int minPower, int maxPower) throws MinMaxException {
        if (minPower > maxPower) {
            throw new MinMaxException();
        }
        return true;
    }

    private ElectricalAppliance getElectricalApplianceByParams(ArrayList<ElectricalAppliance> setOfHouseholdElectricalAppliances, int minPower, int maxPower){
       for (ElectricalAppliance appiliance: setOfHouseholdElectricalAppliances) {
           if (appiliance.getPower() >= minPower && appiliance.getPower() <= maxPower) {
               return appiliance;
           }
       }

       return  null;
   }

    private ArrayList<ElectricalAppliance> getByCountry(ArrayList<ElectricalAppliance> setOfHouseholdElectricalAppliances, String country){
        ArrayList <ElectricalAppliance> electricalApplianceByCountry = new ArrayList<>();
        for (ElectricalAppliance appiliance: setOfHouseholdElectricalAppliances) {

            if (appiliance.getOrigin().equals(country))
                electricalApplianceByCountry.add(appiliance);
        }

        return  electricalApplianceByCountry;
    }

    private int countGeneralPower(ArrayList<ElectricalAppliance> setOfHouseholdElectricalAppliances){
        int generalPower = 0;
       for (ElectricalAppliance appiliance: setOfHouseholdElectricalAppliances) {

           if (appiliance.isState())
               generalPower += appiliance.getPower();
       }
        return  generalPower;
   }

    private ArrayList<ElectricalAppliance> createElectricalAppliances() {
        ArrayList<ElectricalAppliance> setOfHouseholdElectricalAppliances = new ArrayList<>();
        ElectricalAppliance bosh = new Kettle(true, "kettle", "UK", "red", "kitchen", 2400, 10, 20, 15, 2);
        setOfHouseholdElectricalAppliances.add(bosh);

        ElectricalAppliance supra = new Microwave(true, "microwave", "USA", "black", "kitchen", 3250, 30, 45, 20, 45);
        setOfHouseholdElectricalAppliances.add(supra);

        ElectricalAppliance philips = new Flatiron(true, "flatiron", "USA", "gray", "bedroom", 1200, 15, 12, 15, 85);
        setOfHouseholdElectricalAppliances.add(philips);

        return setOfHouseholdElectricalAppliances;
    }

    private void serialize() throws IOException {
        ArrayList<ElectricalAppliance> appliances = this.createElectricalAppliances();
        this.serializeElectricalAppliances(appliances);
    }

    private void deserialize() throws IOException, ClassNotFoundException {
        ArrayList<ElectricalAppliance> appliances = this.deserializeElectricalAppliances("ElectricalAppliance.txt");
        System.out.println("Electrical appliances:");
        this.printVegetables(appliances);
    }

    private void serializeElectricalAppliances(ArrayList<ElectricalAppliance> appliances) throws IOException {
        File fileOfElectricalAppliances = new File(this.prefixOfFiles + "ElectricalAppliance.txt");
        Connector.printObject(fileOfElectricalAppliances, appliances);
    }

    private ArrayList<ElectricalAppliance> deserializeElectricalAppliances(String fileName) throws IOException, ClassNotFoundException {
        File fileOfElectricalAppliances = new File(this.prefixOfFiles + fileName);
        return (ArrayList<ElectricalAppliance>) Connector.readObject(fileOfElectricalAppliances);
    }

    private void printVegetables(ArrayList<ElectricalAppliance> ElectricalAppliances) {
        for (ElectricalAppliance appliance: ElectricalAppliances) {
            System.out.println(appliance.toString());
        }
    }
}
