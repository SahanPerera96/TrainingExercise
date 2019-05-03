package com.company;
//  Created by Sahan perera

import java.util.Scanner;

public class ProtonDecay {
    static int protonCount = 0;
    static int electronCount = 0;
    // draw lines
    static int protonDashCount = 0;
    static int electronDashCount = 0;

    static int electronDashUpCount = 0;
    static int electronSlashUpCount = 0;
    static boolean startSlash = false; // initiate and end slash(_) printing

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("How many Protons are Available : ");
        int protonNumber = scanner.nextInt(); // get input from console
        String space = " ";
        String electron = "n";
        String proton = "p";

//        int protonNumber = 16;
        int minus = 0;
//        int protonCount = 0;
//        int electronCount = 0;

//        System.out.println(electronsProduced(protonNumber));
//        System.out.println(isCompletTree(protonNumber));
        int electronNumber = electronsProduced(protonNumber);
        int totalElectronSpace = electronNumber;
        int totalProtoneSpace = electronNumber;
        // dash
        int totalElectronDashSpace = electronNumber;
        int totalProtoneDashSpace = electronNumber;

        boolean firstElectrons = false; // used to check if what is first print is an neutron
        for(int i = 1; i <=electronNumber; i++){ //we run a for loop for all the electrons in the diagram

            minus = i - minus; // helps in getting the values on every level of the chart. level 1 = 1 , level 2 = 2, level 3 = 4
            if(firstElectrons){
//                if(isPowerOfTwo(minus)){
//                    for(int j = minus;j >0 ; j--){
//
//                        for(int sp = 1; sp<= calculateLeftSpacing(totalProtoneSpace);sp ++){
//                            System.out.print(space);
//                        }
//                        if(protonCount < protonNumber){
//                            System.out.print(i);
//                        }else {
//                            System.out.print(" ");
//                        }
//
//                        for(int sp = 1; sp<= calculateRightSpacing(totalProtoneSpace);sp ++){
//                            System.out.print(space);
//                        }
//                        protonCount ++;
//                    }
//                    System.out.println();
//                    totalProtoneSpace = calculateLeftSpacing(totalProtoneSpace);
//                }

                totalProtoneSpace = drawTypeSet(space,proton,totalProtoneSpace,minus,protonNumber);
                // dash
//                totalProtoneDashSpace = drawTypeDashSet(space,proton,totalProtoneDashSpace,minus,protonNumber,"|");
                firstElectrons = false;
            }else {
                // slash (_) on top of electron
                int dontForward = drawTypeSlashUpSet(space,electron,totalElectronSpace,minus,protonNumber);
                // dash on top of electron
                int dontForward2 = drawTypeDashUpSet(space,electron,totalElectronSpace,minus,protonNumber);

                totalElectronSpace = drawTypeSet(space,electron,totalElectronSpace,minus,protonNumber);
                // dash
                if(minus <= protonNumber){
                    int replay = totalElectronDashSpace;
                    totalElectronDashSpace = drawTypeDashSet(space,electron,totalElectronDashSpace,minus,protonNumber,"|");
//                    replay = drawTypeDashSet(space,electron,replay,minus,protonNumber,"V");
//                    replay = totalElectronDashSpace;
                }



                firstElectrons = true;
            }

        }

    }
    public  static int electronsProduced(int protonNo){ // calculate the total no of electrons produced for the protons added
        int electronNo = 0;
        for (int i = 0; i <= protonNo; i++) {

            if (Math.pow(2, i) <= protonNo){ // check the nearest power for the proton value but mst be less than the proton no
                electronNo = (int) Math.pow(2, i+2);
                // cast to int since we don't use higher values above 1000
                // new electron no would be 2  powers above the nearest proton value
            }
        }
        return electronNo -1; // minus -1 to get the exact value 2,7,15,31,63
    }

    public static boolean isPowerOfTwo(int num){
        for (int i = 0; i <= num; i++) {

            if (Math.pow(2, i) == num) // check if the power is available and is equal to num
                return true;
        }
        return false;
    }

    public static int calculateRightSpacing(int pNumber){
        int leftSpacing ,rightSpacing = 0;
        leftSpacing = pNumber/2;
        rightSpacing = leftSpacing+1;
//        System.out.println(rightSpacing);
        return rightSpacing;
    }

    public static int calculateLeftSpacing(int pNumber){
        int leftSpacing ,rightSpacing = 0;
        leftSpacing = pNumber/2;
//        System.out.println(leftSpacing);
        return leftSpacing;
    }

    public static void drawSpace(String space, String valuePassed, int totalSpace, int protonCount, int protonNumber){
        // print value inside a single line
        for(int sp = 1; sp<= calculateLeftSpacing(totalSpace);sp ++){
            System.out.print(space); // print left side space
        }
        if(valuePassed.equals("p")){
            if(protonCount < protonNumber){ // as long as proton count is less than proton no start printing
                System.out.print(valuePassed);

            }else {
                System.out.print(" ");
            }
        }else {
//            System.out.print(valuePassed);
            if(electronCount < (protonNumber*2)+1){
                System.out.print(valuePassed);

            }else {
                System.out.print(" ");
            }
        }

        for(int sp = 1; sp<= calculateRightSpacing(totalSpace);sp ++){
            System.out.print(space);
        }


    }

    // draw values line by line for the chart
    public static int drawTypeSet(String space, String valuePassed, int totalSpace, int minus, int protonNumber){
        if(isPowerOfTwo(minus)){ // make sure minus is a power of 2
            for(int j = minus;j >0 ; j--){ // start printing values
                drawSpace(space,valuePassed,totalSpace,protonCount,protonNumber);

                if(valuePassed.equals("p")){ // do the increment to keep track of how much protons and neutrons drawn
                    protonCount ++;
                }else {
                    electronCount ++;
                }


            }

            // timer to waid for 1 sec
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            System.out.println(); // once all the details per line is print start a new line
            totalSpace = calculateLeftSpacing(totalSpace);  // calculate he space left on the left side


        }
        return totalSpace; // since total space is going to be iterated used it must be returned and assigned on the new methods called
    }

    // dash draw
    public static int drawTypeDashSet(String space, String valuePassed, int totalSpace, int minus, int protonNumber, String dash){
        if(isPowerOfTwo(minus)){
            for(int j = minus;j >0 ; j--){
                drawDashSpace(space,valuePassed,totalSpace,protonNumber,dash);

                if(valuePassed.equals("p")){
                    protonDashCount ++;
                }else {
                    electronDashCount ++;
                }


            }
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            System.out.println();
            totalSpace = calculateLeftSpacing(totalSpace);


        }
        return totalSpace;
    }


    public static void drawDashSpace(String space, String valuePassed, int totalSpace, int protonNumber, String dash){

        for(int sp = 1; sp<= calculateLeftSpacing(totalSpace);sp ++){
            System.out.print(space);
        }
        if(valuePassed.equals("p")){
            if(protonDashCount < protonNumber){
                System.out.print(dash);

            }else {
                System.out.print(" ");
            }
        }else {
//            System.out.print(valuePassed);
            if(electronDashCount < (protonNumber*2)+1){
                int count =0;
                if(electronDashCount > protonNumber-1 ){ // remove the excess dashes when 4  is added in the neutrons
                    System.out.print(" ");
                }else {
                    System.out.print(dash);
                }


            }else {
                System.out.print(" ");
            }
        }

        for(int sp = 1; sp<= calculateRightSpacing(totalSpace);sp ++){
            System.out.print(space);
        }


    }

    // dash draw up one
    public static int drawTypeDashUpSet(String space, String valuePassed, int totalSpace, int minus, int protonNumber){
        if(isPowerOfTwo(minus)){
            for(int j = minus;j >0 ; j--){
                drawDashUpSpace(space,valuePassed,totalSpace,protonNumber);

                if(valuePassed.equals("p")){
                    protonDashCount ++;
                }else {
                    electronDashUpCount ++;
                }


            }
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            System.out.println();
            totalSpace = calculateLeftSpacing(totalSpace);


        }
        return totalSpace;
    }

    public static void drawDashUpSpace(String space, String valuePassed, int totalSpace, int protonNumber){

        for(int sp = 1; sp<= calculateLeftSpacing(totalSpace);sp ++){
            System.out.print(space);
        }
        if(valuePassed.equals("p")){
            if(protonDashCount < protonNumber){
                System.out.print("|");

            }else {
                System.out.print(" ");
            }
        }else {
//            System.out.print(valuePassed);
            if(electronDashUpCount < (protonNumber*2)+1){
                int count =0;
                if( electronDashUpCount == 0){ // remove the excess dashes on the firts neutron on top
                    System.out.print(" ");

                }else {
                    System.out.print("|");
                }


            }else {
                System.out.print(" ");
            }
        }

        for(int sp = 1; sp<= calculateRightSpacing(totalSpace);sp ++){
            System.out.print(space);
        }


    }

    // dash lines _ on top
    public static int drawTypeSlashUpSet(String space, String valuePassed, int totalSpace, int minus, int protonNumber){
        if(isPowerOfTwo(minus)){
            for(int j = minus;j >0 ; j--){
                drawSlashUpSpace(space,valuePassed,totalSpace,protonNumber);

                if(valuePassed.equals("p")){
                    protonDashCount ++;
                }else {
                    electronSlashUpCount ++;
                }


            }
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            System.out.println();
            totalSpace = calculateLeftSpacing(totalSpace);


        }
        return totalSpace;
    }

    public static void drawSlashUpSpace(String space, String valuePassed, int totalSpace, int protonNumber){

        for(int sp = 1; sp<= calculateLeftSpacing(totalSpace);sp ++){
            if(startSlash){
                System.out.print("_");
            }else {
                System.out.print(space);
            }

        }
        if(valuePassed.equals("p"))
        {
            if(protonDashCount < protonNumber){
                System.out.print("_");

            }else {
                System.out.print(" ");
            }
        }else {
//            System.out.print(valuePassed);
            if(electronSlashUpCount < (protonNumber*2)+1){
                int count =0;
                if( electronSlashUpCount == 0){ // remove the excess dashes on the firts neutron on top
                    System.out.print(" ");

                }else {
                    if(startSlash){
                        System.out.print("_");
                        startSlash = false;
                    }else {

                        System.out.print("_");
                        startSlash = true;
                    }

                }


            }else {
                System.out.print(" ");
            }
        }

        for(int sp = 1; sp<= calculateRightSpacing(totalSpace);sp ++){
            if(startSlash){
                System.out.print("_");
            }else {
                System.out.print(space);
            }
        }


    }

//    public static boolean isCompletTree(int protonNo){
//        for (int i = 0; i <= protonNo; i++) {
//            double powerValue = Math.pow(2, i) - 1;
//            if ( powerValue == protonNo){
//                return true;
//            }
//        }
//        return false;
//    }

}