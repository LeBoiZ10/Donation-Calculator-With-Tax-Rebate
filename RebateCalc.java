/**
 * This program will calculate important donation values for you while factoring in the tax rebate you get from it.
 * If you want to know how much net donations $200 will net you if you keep donating the rebates, it will calculate it for you
 * If you want to know how much you should donate in order to pay a net of $200 of your money, it will calculate that for you as well.
 * Author: LeBoiZ
 * Date: 2/14/2023
 */

import java.util.Scanner;
public class RebateCalc {
    public static void main(String[] args) {
        //FedTax under 200: 15%
        //ProvTax under 200: 5.05%
        //FedTax above 200: 29%
        //ProvTax above 200: 11.16%
        float total, donation;
        byte userIn = 0;
        boolean bolTryCatch = true;

        //welcome message
        System.out.println("\nWelcome to the multi use donation rebate calculator in Ontario!");
        System.out.println("We currently have 2 features: \n");

        do {
            try {
                System.out.println("1. Enter a donation amount and we will calculate how much net donations you can make with it. ");
                System.out.println("(Calculates the rebate on your donation and then donates it and then calculates the rebate on that as well and donates it, and so on.)");
                System.out.println("2. Enter a net amount that you want to donate after tax rebate, as we will calculate how much you should give in order to reach that net amount");
                System.out.print(">> ");
                userIn = new Scanner(System.in).nextByte();

                if(userIn != 1 && userIn != 2){
                    System.out.println("\nError. Please enter 1 or 2.");
                    bolTryCatch = true;
                }
                else{
                    bolTryCatch = false;
                }
            }
            catch(Exception e){
                System.out.println("\nError. Please enter 1 or 2");
                bolTryCatch = true;
            }
        }while(bolTryCatch);

        if (userIn == 1) {
            System.out.println("Enter the donation amount: ");
            donation = new Scanner(System.in).nextFloat();
            total = donation + calc(donation);

            System.out.println("The total donation value that you can give is: " + round(total, 2));
        }
        else {
            System.out.println("Enter the donation amount: ");
            donation = new Scanner(System.in).nextFloat();
            total = equals(donation);

            System.out.println("To have a net donation of $" + donation + ", you should donate $" + round(total, 2));
        }
    }

    public static float calc(float donation) {
        //initializing rebate var.
        float rebate = 0;

        //nonrecursive case.
        if(donation < 1) {
            return 0;
        }

        //calculating rebate.
        if(donation > 200){
            rebate += 40+(0.4*(donation-200));
        }
        else{
            rebate += (0.2 * donation);
        }

        //recursive call to calculate rebate on the rebate until the rebate is less than $1.
        return rebate + calc(rebate);
    }

    //calculating how much you should donate to donate a specific net amount. I.e. if you want to donate $200,
    //you would donate $267, because the tax rebate on 267 is 67, and therefore you would end up paying a net of $200.
    public static float equals(float donation){
        float amount;

        //calculating amounts by solving for the variable x in the linear equation.
        if(donation/0.8 <= 200){
            amount = (float)(donation/0.8);
        }
        else{
            amount = (float)((donation-40)/0.6);
        }

        return amount;
    }

    //rounding method
    public static float round(float f, int i){
        f *= Math.pow(10, i);
        f = Math.round(f);
        f /= Math.pow(10, i);

        return f;
    }

}
