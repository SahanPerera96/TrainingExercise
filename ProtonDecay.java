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
    static  int delayTime = 500;

    static final String space = " ";
    static final String electron = "n";
    static final String proton = "p";
    static final String dash = "|";
    static final String slash = "_";

    static final String printDigits = "PrintNeutronAndProton";
    static final String printSlash = "PrintSlash";
    static final String printBottomLine = "Print|Bottom";
    static final String printTopLine = "Print|Top";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("How many Protons are Available : ");
        int protonNumber = scanner.nextInt(); // get input from console

        int minus = 0;
//        int protonNumber = 16;

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

//                totalProtoneSpace = drawTypeSet(space,proton,totalProtoneSpace,minus,protonNumber);
                totalProtoneSpace = drawTypeSet(space,proton,totalProtoneSpace,minus,protonNumber,dash,printDigits);
                // dash
//                totalProtoneDashSpace = drawTypeDashSet(space,proton,totalProtoneDashSpace,minus,protonNumber,"|");
                firstElectrons = false;
            }else {
                // slash (_) on top of electron
//                int dontForward = drawTypeSlashUpSet(space,electron,totalElectronSpace,minus,protonNumber);
                int dontForward = drawTypeSet(space,electron,totalElectronSpace,minus,protonNumber,dash,printSlash);
                // dash on top of electron
//                int dontForward2 = drawTypeDashUpSet(space,electron,totalElectronSpace,minus,protonNumber);
                int dontForward2 = drawTypeSet(space,electron,totalElectronSpace,minus,protonNumber,dash,printTopLine);


//                totalElectronSpace = drawTypeSet(space,electron,totalElectronSpace,minus,protonNumber);
                totalElectronSpace = drawTypeSet(space,electron,totalElectronSpace,minus,protonNumber,dash,printDigits);

                // dash
                if(minus <= protonNumber){
                    int replay = totalElectronDashSpace;
//                    totalElectronDashSpace = drawTypeDashSet(space,electron,totalElectronDashSpace,minus,protonNumber,"|");
                    totalElectronDashSpace = drawTypeSet(space,electron,totalElectronDashSpace,minus,protonNumber,dash,printBottomLine);

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

    public static int calculateRightSpacing(int pNumber){ // calculate right side space when printing the neutrons and protons
        int leftSpacing ,rightSpacing = 0;
        leftSpacing = pNumber/2;
        rightSpacing = leftSpacing+1;
//        System.out.println(rightSpacing);
        return rightSpacing;
    }

    public static int calculateLeftSpacing(int pNumber){ // calculate left side space when printing the neutrons and protons
        int leftSpacing ,rightSpacing = 0;
        leftSpacing = pNumber/2;
//        System.out.println(leftSpacing);
        return leftSpacing;
    }

    public  static  void setTimeDelay(){ //    delay timer
        try
        {
            Thread.sleep(delayTime);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public  static  void printSpaceOrSlash(int totalSpace){ // print space of left side and right side and also _ if enabled
        for(int sp = 1; sp<= totalSpace;sp ++){ // totalSpace == left or right side space
//            System.out.print(space); // print left side space
            if(startSlash){
                System.out.print("_"); // start printing _ only if slash enabled
            }else {
                System.out.print(space);
            }
        }
    }

    public static void drawSpace( String valuePassed, int totalSpace, int protonNumber, String task){
        // print value inside a single line
        printSpaceOrSlash(calculateLeftSpacing(totalSpace)); // print left side space or slash "_"
//        for(int sp = 1; sp<= calculateLeftSpacing(totalSpace);sp ++){
////            System.out.print(space); // print left side space
//            if(startSlash){
//                System.out.print("_"); // start printing _ only if slash enabled
//            }else {
//                System.out.print(space);
//            }
//        }

        switch(task)
        {
            case printDigits:
                if(valuePassed.equals(proton)){
                    if(protonCount < protonNumber){ // as long as proton count is less than proton no start printing
                        System.out.print(valuePassed);

                    }else {
                        System.out.print(space);
                    }
                }else {
                    if(electronCount < (protonNumber*2)+1){
                        System.out.print(valuePassed);

                    }else {
                        System.out.print(space);
                    }
                }
                break;
            case printSlash:
                if(valuePassed.equals(proton))
                {
                    if(protonDashCount < protonNumber){
                        System.out.print(slash);

                    }else {
                        System.out.print(space);
                    }
                }else {
                    if(electronSlashUpCount < (protonNumber*2)+1){
                        if( electronSlashUpCount == 0){ // remove the excess dashes on the first neutron on top
                            System.out.print(space);

                        }else {
                            if(startSlash){
                                System.out.print(slash);
                                startSlash = false;
                            }else {

                                System.out.print(slash);
                                startSlash = true;
                            }

                        }


                    }else {
                        System.out.print(" ");
                    }
                }
                break;
            case printBottomLine:
                if(valuePassed.equals(proton)){
                    if(protonDashCount < protonNumber){
                        System.out.print(dash);
                    }else {
                        System.out.print(space);
                    }
                }else {
                    if(electronDashCount < (protonNumber*2)+1){
                        if(electronDashCount > protonNumber-1 ){ // remove the excess dashes when 4  is added in the neutrons
                            System.out.print(space);
                        }else {
                            System.out.print(dash);
                        }
                    }else {
                        System.out.print(space);
                    }
                }
                break;
            case printTopLine:
                if(valuePassed.equals(proton)){
                    if(protonDashCount < protonNumber){
                        System.out.print(dash);
                    }else {
                        System.out.print(space);
                    }
                }else {
                    if(electronDashUpCount < (protonNumber*2)+1){
                        if( electronDashUpCount == 0){ // remove the excess dashes on the first neutron on top
                            System.out.print(space);
                        }else {
                            System.out.print(dash);
                        }
                    }else {
                        System.out.print(space);
                    }
                }
                break;

            default:
                System.out.println();
        }
//        if(valuePassed.equals(proton)){
//            if(protonCount < protonNumber){ // as long as proton count is less than proton no start printing
//                System.out.print(valuePassed);
//
//            }else {
//                System.out.print(space);
//            }
//        }else {
////            System.out.print(valuePassed);
//            if(electronCount < (protonNumber*2)+1){
//                System.out.print(valuePassed);
//
//            }else {
//                System.out.print(space);
//            }
//        }

        printSpaceOrSlash(calculateRightSpacing(totalSpace)); // print right side space or slash "-"
//        for(int sp = 1; sp<= calculateRightSpacing(totalSpace);sp ++){
//            System.out.print(space);
//        }


    }

    // draw values line by line for the chart
    public static int drawTypeSet(String space, String valuePassed, int totalSpace, int minus, int protonNumber, String dash, String task ){
        if(isPowerOfTwo(minus)){ // make sure minus is a power of 2
            for(int j = minus;j >0 ; j--){ // start printing values
                switch(task)
                {

                    case printDigits: // print n and p in the diagram
                        drawSpace(valuePassed,totalSpace,protonNumber,task);

                        if(valuePassed.equals(proton)){ // do the increment to keep track of how much protons and neutrons drawn
                            protonCount ++;
                        }else {
                            electronCount ++;
                        }
                        break;
                    case printSlash: // print _  on the diagram
//                        drawSlashUpSpace(space,valuePassed,totalSpace,protonNumber);
                        drawSpace(valuePassed,totalSpace,protonNumber,task);

                        if(valuePassed.equals(proton)){
                            protonDashCount ++;
                        }else {
                            electronSlashUpCount ++;
                        }
                        break;
                    case printBottomLine: // print | on bottom of digits
//                        drawDashSpace(space,valuePassed,totalSpace,protonNumber,dash);
                        drawSpace(valuePassed,totalSpace,protonNumber,task);

                        if(valuePassed.equals(proton)){
                            protonDashCount ++;
                        }else {
                            electronDashCount ++;
                        }
                        break;
                    case printTopLine: // print | on top of digits
//                        drawDashUpSpace(space,valuePassed,totalSpace,protonNumber);
                        drawSpace(valuePassed,totalSpace,protonNumber,task);

                        if(valuePassed.equals(proton)){
                            protonDashCount ++;
                        }else {
                            electronDashUpCount ++;
                        }
                        break;

                    default:
                        System.out.println();
                }

            }
            // timer to wait
            setTimeDelay(); // set time delay
            System.out.println(); // once all the details per line is print start a new line
            totalSpace = calculateLeftSpacing(totalSpace);  // calculate he space left on the left side

        }
        return totalSpace; // since total space is going to be iterated used it must be returned and assigned on the new methods called
    }

//    public static int drawTypeSet(String space, String valuePassed, int totalSpace, int minus, int protonNumber){
//        if(isPowerOfTwo(minus)){ // make sure minus is a power of 2
//            for(int j = minus;j >0 ; j--){ // start printing values
//                drawSpace(space,valuePassed,totalSpace,protonCount,protonNumber);
//
//                if(valuePassed.equals("p")){ // do the increment to keep track of how much protons and neutrons drawn
//                    protonCount ++;
//                }else {
//                    electronCount ++;
//                }
//
//
//            }
//
//            // timer to waid for 1 sec
//            setTimeDelay(); // set time delay
//
//            System.out.println(); // once all the details per line is print start a new line
//            totalSpace = calculateLeftSpacing(totalSpace);  // calculate he space left on the left side
//
//
//        }
//        return totalSpace; // since total space is going to be iterated used it must be returned and assigned on the new methods called
//    }

    // dash draw
//    public static int drawTypeDashSet(String space, String valuePassed, int totalSpace, int minus, int protonNumber, String dash){
//        if(isPowerOfTwo(minus)){
//            for(int j = minus;j >0 ; j--){
//                drawDashSpace(space,valuePassed,totalSpace,protonNumber,dash);
//
//                if(valuePassed.equals("p")){
//                    protonDashCount ++;
//                }else {
//                    electronDashCount ++;
//                }
//
//
//            }
//            setTimeDelay(); // set time delay
//
//            System.out.println();
//            totalSpace = calculateLeftSpacing(totalSpace);
//
//
//        }
//        return totalSpace;
//    }


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
//    public static int drawTypeDashUpSet(String space, String valuePassed, int totalSpace, int minus, int protonNumber){
//        if(isPowerOfTwo(minus)){
//            for(int j = minus;j >0 ; j--){
//                drawDashUpSpace(space,valuePassed,totalSpace,protonNumber);
//
//                if(valuePassed.equals("p")){
//                    protonDashCount ++;
//                }else {
//                    electronDashUpCount ++;
//                }
//
//
//            }
//            setTimeDelay(); // set time delay
//
//            System.out.println();
//            totalSpace = calculateLeftSpacing(totalSpace);
//
//
//        }
//        return totalSpace;
//    }

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
//    public static int drawTypeSlashUpSet(String space, String valuePassed, int totalSpace, int minus, int protonNumber){
//        if(isPowerOfTwo(minus)){
//            for(int j = minus;j >0 ; j--){
//                drawSlashUpSpace(space,valuePassed,totalSpace,protonNumber);
//
//                if(valuePassed.equals("p")){
//                    protonDashCount ++;
//                }else {
//                    electronSlashUpCount ++;
//                }
//
//
//            }
//            setTimeDelay(); // set time delay
//
//            System.out.println();
//            totalSpace = calculateLeftSpacing(totalSpace);
//
//
//        }
//        return totalSpace;
//    }

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