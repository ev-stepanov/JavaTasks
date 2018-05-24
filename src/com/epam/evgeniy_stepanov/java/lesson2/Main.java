package com.epam.evgeniy_stepanov.java.lesson2;

import java.util.Scanner;

public class Main {
    ElectricalAppliance [] setOfHouseholdElectricalAppliances;
    public static void main(String[] args) {
        new Main().run();
    }

    public void run()
    {
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
        int minPower = in.nextInt();
        int maxPower = in.nextInt();

        System.out.println("Appiliance is  " + getElectricalApplianceByParams(minPower, maxPower).toString());

        ElectricalAppliance[] someAppiliance = getByCountry("USA");
        for (int i = 0; i < someAppiliance.length; i++) {
            System.out.println(someAppiliance[i].toString());
        }

        System.out.println("general power = " + countGeneralPower());
   }

   public ElectricalAppliance getElectricalApplianceByParams(int minPower, int maxPower){
       for (int i = 0; i < setOfHouseholdElectricalAppliances.length; i++) {
           if (setOfHouseholdElectricalAppliances[i] == null)
               break;
           if (setOfHouseholdElectricalAppliances[i].power >= minPower && setOfHouseholdElectricalAppliances[i].power <= maxPower)
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
            if (setOfHouseholdElectricalAppliances[i].origin.equals(country))
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
           if (setOfHouseholdElectricalAppliances[i].state)
               generalPower += setOfHouseholdElectricalAppliances[i].getPower();
       }
        return  generalPower;
   }
}
