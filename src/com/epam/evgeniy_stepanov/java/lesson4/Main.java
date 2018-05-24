package com.epam.evgeniy_stepanov.java.lesson4;

import com.epam.evgeniy_stepanov.java.lesson4.exceptions.CountryException;
import com.epam.evgeniy_stepanov.java.lesson4.exceptions.MinMaxException;
import com.epam.evgeniy_stepanov.java.lesson4.model.ElectricalAppliance;
import com.epam.evgeniy_stepanov.java.lesson4.model.Flatiron;
import com.epam.evgeniy_stepanov.java.lesson4.model.Kettle;
import com.epam.evgeniy_stepanov.java.lesson4.model.Microwave;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    ElectricalAppliance[] setOfHouseholdElectricalAppliances;
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        setOfHouseholdElectricalAppliances = new ElectricalAppliance[200];
        int countAppliance = 0;
        ElectricalAppliance bosh = new Kettle(true, "kettle", "UK", "red", "kitchen", 2400, 10, 20, 15, 2);
        setOfHouseholdElectricalAppliances[countAppliance++] = bosh;

        ElectricalAppliance supra = new Microwave(true, "microwave", "USA", "black", "kitchen", 3250, 30, 45, 20, 45);
        setOfHouseholdElectricalAppliances[countAppliance++] = supra;

        ElectricalAppliance philips = new Flatiron(true, "flatiron", "USA", "gray", "bedroom", 1200, 15, 12, 15, 85);
        setOfHouseholdElectricalAppliances[countAppliance++] = philips;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter minimal and maximal power");
        int minPower = Integer.parseInt(in.nextLine());
        int maxPower = Integer.parseInt(in.nextLine());

        try {
            if (checkPower(minPower, maxPower)) {
                System.out.println("Appiliance is " + getElectricalApplianceByParams(minPower, maxPower).toString());
            }
        }
        catch (MinMaxException e) {
            System.err.println(e.message());
        }

        System.out.println("Enter country");

        try {
            String country = parseCounty(in.nextLine());
            ElectricalAppliance[] someAppiliance = getByCountry(country);
            for (int i = 0; i < someAppiliance.length; i++) {
                System.out.println(someAppiliance[i].toString());
            }
        }
        catch (CountryException e) {
            System.err.println(e.message());
        }

        System.out.println("General power = " + countGeneralPower());
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

   public ElectricalAppliance getElectricalApplianceByParams(int minPower, int maxPower){
       for (int i = 0; i < setOfHouseholdElectricalAppliances.length; i++) {
           if (setOfHouseholdElectricalAppliances[i] == null)
               break;
           if (setOfHouseholdElectricalAppliances[i].getPower() >= minPower && setOfHouseholdElectricalAppliances[i].getPower() <= maxPower)
               return setOfHouseholdElectricalAppliances[i];
       }

       return  null;
   }

    public ElectricalAppliance[] getByCountry(String country){
        ElectricalAppliance[] ElectricalApplianceByCountry = new ElectricalAppliance[200];
        int idx = 0;
        for (int i = 0; i < setOfHouseholdElectricalAppliances.length; i++) {
            if (setOfHouseholdElectricalAppliances[i] == null)
                break;
            if (setOfHouseholdElectricalAppliances[i].getOrigin().equals(country))
                ElectricalApplianceByCountry[idx++] = setOfHouseholdElectricalAppliances[i];
        }
        ElectricalAppliance[] result = new ElectricalAppliance[idx];
        for (int i = 0; i < idx; i++) {
            result[i] = ElectricalApplianceByCountry[i];
        }

        return  result;
    }

   public int countGeneralPower(){
        int generalPower = 0;
       for (int i = 0; i < setOfHouseholdElectricalAppliances.length; i++) {
           if (setOfHouseholdElectricalAppliances[i] == null)
               break;
           if (setOfHouseholdElectricalAppliances[i].isState())
               generalPower += setOfHouseholdElectricalAppliances[i].getPower();
       }
        return  generalPower;
   }
}
