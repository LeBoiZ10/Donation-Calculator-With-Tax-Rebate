/**
 * Provincw class for the rebate calculator. This will help change the calculator from an Ontario-wide program to all of Canada
 * Takes in the province name, and then allows me to get the tax rate for that particular province
 * Date: 2/15/2023
 * Author: LeBoiZ
 */

//class
public class Province {

    //federal tax rebate is constant. 
    public static final float fedLess = 0.15f, fedMore = 0.29f;

    //instance variables for province and lower and higher tax rebates.
    private String prov;
    private float less, more;

    //constructor. 
    public Province(String p){
        this.prov = p;
        this.less = Less(this.prov);
        this.more = More(this.prov);
    }

    //calculates lower rebate rate. 
    public float Less(String prov){
        float[] rates = {0.1f, 0.05f, 0.11f, 0.1f, 0.09f, 0.09f, 0.06f, 0.04f, 0.05f, 0.1f, 0.2f, 0.11f, 0.06f};
        String[] provs = {"AB", "BC", "MB", "NB", "NL", "NS", "NT", "NU", "ON", "PE", "QC", "SK", "YT"};

        for(int i = 0; i < 13; i++){
            if(prov.equals(provs[i])){
                return rates[i] + fedLess;
            }
        }

        return 0;
    }
    
    //calculates higher rebate rate. 
    public float More(String prov){
        float[] rates = {0.21f, 0.15f, 0.17f, 0.18f, 0.18f, 0.21f, 0.14f, 0.115f, 0.11f, 0.17f, 0.24f, 0.15f, 0.13f};
        String[] provs = {"AB", "BC", "MB", "NB", "NL", "NS", "NT", "NU", "ON", "PE", "QC", "SK", "YT"};

        for(int i = 0; i < 13; i++){
            if(prov.equals(provs[i])){
                return rates[i] + fedMore;
            }
        }

        return 0;
    }

    //returns lower rate
    public float getLess(){
        return this.less;
    }

    //returns higher rate. 
    public float getMore(){
        return this.more;
    }

}
