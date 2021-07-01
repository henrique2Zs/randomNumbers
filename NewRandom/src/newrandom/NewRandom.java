/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newrandom;

/**
 *
 * @author Henrique
 */
public class NewRandom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int actualHour = 212252; //Put reference to time in future
        int sizeNumber = 6;
        int numberGenerate = 10;
        int countWhile =0;
        int randomNum;
        
        do {           
            randomNum = takeNewRandom(actualHour,sizeNumber);
            System.out.println(String.valueOf(randomNum));
            actualHour = randomNum;
            countWhile ++;
        } while(countWhile < numberGenerate);
        
    }
    private static int sumCharacters (char[] num) {
        //int numInt = ((int)num);
        int dividend = 0;
        for (int i=0; i < num.length; i++) {
            dividend += ((int)num[i]);
        }
        return dividend;
    }
    private static String chooseNum (char[] largeNum, int sizeNumber) {
        //String divider;
        String sumNum = "";
        int initPos = 0;
    
        for (int i=0; i < largeNum.length; i++) {
            if (largeNum[i]=='.' || largeNum[i]=='-' || largeNum[i]=='E'|| largeNum[i]==','){
                initPos = i+1;
                break;
            }
        }
        char charLargeNum;
        int sizeLargeNum = largeNum.length - initPos;
        for (int i=initPos; i <= sizeNumber; i++)  {
            charLargeNum = i >= (largeNum.length-1) ? 0 : largeNum[i];
            sumNum += Character.toString(charLargeNum);
        }
        //divider = Double.parseDouble(sumNum);      
        return sumNum;
    }
    private static int takeNewRandom (int numBase, int sizeNumber) {
        double numRandomDoub;
        String numberChar = Integer.toString(numBase);
        String dividerStr = chooseNum(numberChar.toCharArray(),sizeNumber);
        int dividend = sumCharacters(dividerStr.toCharArray());
        numRandomDoub = dividend / Double.valueOf(dividerStr);
        String numRandomStr = chooseNum(Double.toString(numRandomDoub).toCharArray(),sizeNumber);
        int numRandomInt = Integer.valueOf(numRandomStr);
       return numRandomInt;        
    }
}
