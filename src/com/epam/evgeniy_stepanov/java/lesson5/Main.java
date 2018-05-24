package com.epam.evgeniy_stepanov.java.lesson5;

import com.epam.evgeniy_stepanov.java.lesson5.exceptions.CountryException;
import com.epam.evgeniy_stepanov.java.lesson5.exceptions.MinMaxException;
import com.epam.evgeniy_stepanov.java.lesson5.model.ElectricalAppliance;
import com.epam.evgeniy_stepanov.java.lesson5.model.Flatiron;
import com.epam.evgeniy_stepanov.java.lesson5.model.Kettle;
import com.epam.evgeniy_stepanov.java.lesson5.model.Microwave;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        ArrayList<ElectricalAppliance> setOfHouseholdElectricalAppliances = new ArrayList<>();
        ElectricalAppliance bosh = new Kettle(true, "kettle", "UK", "red", "kitchen", 2400, 10, 20, 15, 2);
        setOfHouseholdElectricalAppliances.add(bosh);

        ElectricalAppliance supra = new Microwave(true, "microwave", "USA", "black", "kitchen", 3250, 30, 45, 20, 45);
        setOfHouseholdElectricalAppliances.add(supra);

        ElectricalAppliance philips = new Flatiron(true, "flatiron", "USA", "gray", "bedroom", 1200, 15, 12, 15, 85);
        setOfHouseholdElectricalAppliances.add(philips);

        Scanner in = new Scanner(System.in);
        System.out.println("Enter minimal and maximal power");
        int minPower = Integer.parseInt(in.nextLine());
        int maxPower = Integer.parseInt(in.nextLine());

        try {
            if (checkPower(minPower, maxPower)) {
                System.out.println("Appiliance is " + getElectricalApplianceByParams(setOfHouseholdElectricalAppliances, minPower, maxPower).toString());
            }
        }
        catch (MinMaxException e) {
            System.err.println(e.message());
        }

        System.out.println("Enter country");

        try {
            String country = parseCounty(in.nextLine());
            ArrayList<ElectricalAppliance> someAppiliance = getByCountry(setOfHouseholdElectricalAppliances, country);
            for (ElectricalAppliance appiliance: someAppiliance) {
                System.out.println(appiliance.toString());
            }
        }
        catch (CountryException e) {
            System.err.println(e.message());
        }

        System.out.println("General power = " + countGeneralPower(setOfHouseholdElectricalAppliances));
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
}
