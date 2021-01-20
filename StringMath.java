import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;
import java.util.stream.IntStream;
import java.time.*;

public class StringMath {

    private StringMath() {
        //infitely large number mathmatics
    }
    public static int stringModulo (String dividend, int divisor){
        //inputs a dividend (String) and a divisor (int)
        //outputs an (int) equal to the remainder after dividend/divisor
        //returns 0 if evenly divisible
        //systematically uses long division to break up dividend into more manageable elements
        //will use place to track the placeholder of each subsection


        List toAdd = Collections.synchronizedList(new ArrayList());
        String number1=dividend;
        int x=1;
        int length=String.valueOf(divisor).length();
        int place=number1.length()-1;

        while (!number1.equals("0")||place>=0){
            if (number1.equals("0")){
                break;
            }
            if (x>number1.length()){
                break;
            }
            int helper= Integer.valueOf(number1.substring(0,x));

            int partial=helper/Integer.valueOf(divisor);

            if (partial>0){

                StringBuilder answer= new StringBuilder();
                StringBuilder adding= new StringBuilder();
                answer.append(partial*divisor);
                adding.append(partial);
                for (int i=0; i<place;i++){
                    answer.append("0");
                    adding.append("0");
                }

                number1=Subtraction(number1, String.valueOf(answer));
                toAdd.add(adding);
                if (place==0){
                    break;
                }
                place=number1.length()-1;
                x=1;

            }else{
                place--;
                x=x+1;

            }}
        if (!number1.equals("0")){
        }
        return Integer.valueOf(number1);
    }

    public static String stringIntDivide(String dividend, int divisor){
        List toAdd = Collections.synchronizedList(new ArrayList());
        String number1=dividend;
        int number2= divisor;
        int x=1;
        int length=String.valueOf(divisor).length();
        int place=number1.length()-1;
        while (!number1.equals("0")&&place>=0){
            if (number1.equals("0")){
                break;
            }

            //System.out.println("number1: "+number1);

            int helper= Integer.valueOf(number1.substring(0,x));
            int partial=helper/Integer.valueOf(divisor);
            if (partial>0){
                StringBuilder answer= new StringBuilder();
                StringBuilder adding= new StringBuilder();
                answer.append(partial*divisor);
                adding.append(partial);
                for (int i=0; i<place;i++){
                    answer.append("0");
                    adding.append("0");
                }
                //adding.append(".");
                number1=Subtraction(number1, String.valueOf(answer));
                toAdd.add(adding);
                if (place==0){
                    break;
                }
                place=number1.length()-1;
                x=1;
                //System.out.println(number1);
            }else{
                place--;
                x=x+1;

        }}
        if (!number1.equals("0")){
            //System.out.println("remainder: "+number1);
        }


        return Addition(toAdd);
    }


    public static String Subtraction(String str1, String str2){
        //str1 principal
        //str2 subtractor
        StringBuilder answer= new StringBuilder();
        StringBuilder helper= new StringBuilder();
        int str1length=str1.length();
        int str2length=str2.length();
        int digits=Math.max(str1length,str2length);
        for (int i=0;i<digits;i++){
            helper.append("9");
        }
        int placeHolder=0;
        int place=0;
        int helperindex= helper.length()-1;
        int str2index=str2.length()-1;
        int x = Integer.valueOf(helper.substring(helperindex,helperindex+1));
        int y = Integer.valueOf(str2.substring(str2index,str2index+1));
        while (helperindex>=0|| str2index>=0) {
            if (helperindex<0){
                x=0;
            }else {
                x = Integer.valueOf(helper.substring(helperindex,helperindex+1));
            }
            if (str2index<0){
                y=0;
            }else {
                y = Integer.valueOf(str2.substring(str2index,str2index+1));
            }

            placeHolder = (x - y);
            answer.insert(0, placeHolder);
            helperindex--;
            str2index--;
        }
        String answerthing=stringAdding(answer.toString(),str1);
        answerthing=stringAdding(answerthing,"1");
        answerthing=answerthing.substring(1);
        if (answerthing.substring(0,1).equals("0")){
            boolean neat=false;
            while (neat==false){
                if (answerthing.equals("0")){
                    break;
                }
                answerthing=answerthing.substring(1,answerthing.length());
                if (answerthing.substring(0,1).equals("0")==false){
                    neat=true;
                    //System.out.println(answerthing.substring(0,1));
                    break;
                }
            }}


        return answerthing;
    }
    public static String stringAdding(String str1, String str2){
        StringBuilder answer= new StringBuilder();
        //int realanswer=Integer.valueOf(str1)+Integer.valueOf(str2);
        int remainder=0;
        int placeHolder=0;
        int place=0;
        int str1index= str1.length()-1;
        int str2index=str2.length()-1;
        int x = Integer.valueOf(str1.substring(str1index,str1index+1));
        int y = Integer.valueOf(str2.substring(str2index,str2index+1));
        while (str1index>=0 || str2index>=0) {
            if (str1index<0){
                x=0;
            }else {
                x = Integer.valueOf(str1.substring(str1index,str1index+1));
            }
            if (str2index<0){
                y=0;
            }else {
                y = Integer.valueOf(str2.substring(str2index,str2index+1));
            }

            placeHolder = (x + y + remainder) % 10;
            remainder = (x + y + remainder) / 10;
            answer.insert(0, placeHolder);
            str1index--;
            str2index--;
        }

        if (remainder>0){answer.insert(0, remainder);}
        //System.out.println(answer);
        //System.out.println("the answer should be : "+realanswer);


        return answer.toString();
    }


    public static String multiply(String str1, String str2){
        if (str1.equals("0")||str2.equals("0")){
            return "0";
        }

        StringBuilder answer= new StringBuilder();
        List toAdd = Collections.synchronizedList(new ArrayList());
        //int realanswer=Integer.valueOf(str1)*Integer.valueOf(str2);
        int remainder=0;
        int placeHolder=0;
        int place=0;
        for (int i=str2.length()-1; i>=0;i=i-1){
            if (place>0){
                for (int q=0;q<place;q++){
                    answer.insert(0,0);}
            }
            place++;

            for (int z=str1.length()-1;z>=0;z=z-1){
                int x=Integer.valueOf(str2.substring(i,i+1));

                int y=Integer.valueOf(str1.substring (z,z+1));

                placeHolder=(x*y+remainder)%10;
                remainder=(x*y+remainder)/10;
                answer.insert(0,placeHolder);
            }
            if (remainder>0){
                answer.insert(0,remainder);
                remainder=0;
            }

            String string=answer.toString();
            toAdd.add(string);

            answer.delete(0, answer.length());
        }
        //System.out.println(toAdd);
        //System.out.println("the answer should be : "+realanswer);


        return Addition(toAdd);
    }
    public static String Addition(List toAdd){
        //helper function
        //System.out.println("My List "+ toAdd);
        StringBuilder answer= new StringBuilder();
        List Adding = toAdd;

        int current=0;
        //limit will slow down original factorial but is necessary for factorial two to be accurate
        int limit=toAdd.size()+toAdd.get(0).toString().length();
        //System.out.println(limit);
        for (int i=0;i<limit;i++){
            for (int q=0;q<Adding.size();q++){

                int length=Adding.get(q).toString().length();

                if (length>0){String strnumber=Adding.get(q).toString().substring(length-1,length);
                    int number=Integer.valueOf(strnumber);

                    current=current+number;
                    Adding.set(q, Adding.get(q).toString().substring(0,length-1));}

            }

            String string= String.valueOf(current%10);
            answer.insert(0,string);
            current=current/10;

        }
        if (answer.substring(0,1).equals("0")){

            boolean neat=false;
            while (neat==false){
                if (!answer.substring(0,1).equals("0")){
                    break;
                }
                answer=answer.delete(0,1);
                if (answer.substring(0,1).equals("0")==false){
                    neat=true;
                    break;
                }


            }}
        String stringanswer=answer.toString();
        //System.out.println("outputing"+ stringanswer);
        return (stringanswer);

    }

    public static String stringGCF(String a, String b) {
        //inputs large string
        //outputs the largest integer that divides evenly into a and b
        while(!isEqual(a,b)){
        while (isGreater(a,b)){
                String c=Subtraction(a,b);
                a=c;
        }
        while (isGreater(b,a)){
            String c=Subtraction(b,a);
            b=c;
        }}

        return a;
    }



    public static boolean isGreater(String a, String b){
        if (a.length()>b.length()){
            return true;
        }else if (a.length()<b.length()){
            return false;
        }else{
            for (int i=0;i<a.length();i++){
                int c=Integer.parseInt(a.substring(i,i+1));
                int d=Integer.parseInt(b.substring(i,i+1));
                if (c>d){
                    return true;
                }else if (c<d){
                    return false;
                }
            }
            return false;
        }
    }
    public static boolean isEqual(String a, String b){
        if (a.length()>b.length()){
            return false;
        }else if (a.length()<b.length()){
            return false;
        }else{
            for (int i=0;i<a.length();i++){
                int c=Integer.parseInt(a.substring(i,i+1));
                int d=Integer.parseInt(b.substring(i,i+1));
                if (c>d){
                    return false;
                }else if (c<d){
                    return false;
                }
            }
            return true;
        }
    }

    public static String createStringNumber(int length){
        //inputs a length and will create a number equal to 10^(length-1)

        String answer="1";
        for (int i=0;i<length-1;i++){
            answer+="0";
        }
        return answer;
    }
    public static String stringSquareRoot(String number){
        //inputs a String number
        //outputs a String equivalent to the square root of that number
        //length of number dictates starting point then bisecting search
        String minimum;
        String maximum;
        if ((number.length()-1)%2==0){
            minimum= createStringNumber(((number.length()-1)/2)+1);
                //String minumum=((length-1)/2)+1
            maximum=multiply("4",createStringNumber(minimum.length()));
                //String maximum= minimum length+1
        }else{
            minimum= multiply("3",createStringNumber(number.length()/2));
                //String minimum=(3 *length/2)
            maximum= (createStringNumber((number.length()/2)+1));
                //String maximum= 3*length/2+1
        }
        System.out.println("realnum: "+number);
        System.out.println("minimum^2: "+multiply(minimum,minimum));
        System.out.println("maximum^2: "+multiply(maximum,maximum));

        //take average of min and max- compare square of average to number
        //if average^2 is less than number- average= minimum
        //if average^2 is greater than number- average= maximum

        String average= stringIntDivide(stringAdding(maximum,minimum),2);
        String averageSquared=multiply(average,average);
        String plusone=stringAdding(average,"1");
        plusone=multiply(plusone,plusone);
        Boolean answer=false;
        if ((isEqual(number,averageSquared)||isGreater(number,averageSquared))&& isGreater(plusone,number)){
            answer=true;
            return average;
        }
       while (answer==false) {

            average = stringIntDivide(stringAdding(maximum, minimum), 2);
            averageSquared = multiply(average, average);
            if (isGreater(averageSquared, number)) {
                //true if average^2 is greater than number
                maximum = average;
            }else if (isEqual(averageSquared, number)) {
                answer=true;
                //return average;
            }else if (isGreater(number, averageSquared)) {
                //true if number is greater than average^2
                minimum = average;
            }

            plusone=stringAdding(average,"1");
            plusone=multiply(plusone,plusone);
            if ((isEqual(number,averageSquared)||isGreater(number,averageSquared))&& isGreater(plusone,number)){
                answer=true;
                //return average;
            }
        }
       System.out.println("realnum: "+number);
       System.out.println("answer= "+ average);
       System.out.println("squared: "+averageSquared);
        return "";
    }
 public static IntStream primeStream(){
        //Sieve of Erasthenes
        int []primes=new int[1000000];
        Boolean[] thing= new Boolean[16000000];
        Arrays.fill(thing,true);
        //for (int i=0;i<thing.length;i++){
        //    thing[i]=true;
        //}
        //while something continuous
        //if thing[index of number]==true;
        // number is a prime
        // scan thing and make all multiples of that prime, false
        int number=2;
        int index=0;
        while (index<primes.length) {
            if (thing[number]) {
                //System.out.println(number);
                primes[index] = number;
                for (int z = number + number; z < thing.length; z = z +number) {
                    thing[z] = false;
                }

                index++;
                number++;
            }else {
                number++;
            }
        }

        //System.out.println(answer);
        return IntStream.of(primes);

 }

    public static String stringDivision(String dividend, String divisor){
        //uses bisecting search to find answer
        //"int" division with no remainder(dividend/divisor)
        //length of dividend- length of divisor +1/-1 will give you min and max to start
        //bisecting search to find answer
        //answer *divisor will be <= dividend. answer+1*divisor will be greater than dividend

        String maximum;
        String minimum;

        int lengthDifference= dividend.length()-divisor.length();
        if (lengthDifference<0){
            return "0";
        }else if (lengthDifference==0){
            minimum="1";
        }else {
            minimum=createStringNumber(lengthDifference);
        }
        maximum=createStringNumber(lengthDifference+1);
        Boolean answer=false;


        String average=stringIntDivide(stringAdding(maximum,minimum),2);
        String check=multiply(average,divisor);

        String plusone=stringAdding(average,"1");
        plusone=multiply(plusone,divisor);

        if ((isEqual(check, dividend)||isGreater(dividend,check))&& isGreater(plusone,dividend)){
            answer=true;
           // System.out.println("triggered");
            //return average;
        }
        while (!answer){
            System.out.println(minimum);
            System.out.println(average);
            System.out.println(maximum);
            average=stringIntDivide(stringAdding(maximum,minimum),2);
            check=multiply(average,divisor);

            if (isGreater(check,dividend)){
                //average is high
                maximum=average;
            }else if (isEqual(check, dividend)){
                //System.out.println("here");
                answer=true;
                break;
                //check is answer
            }else {
                //average is lower than answer
                minimum=average;
            }
            average=stringIntDivide(stringAdding(maximum,minimum),2);
            check=multiply(average,divisor);
            plusone=stringAdding(average,"1");
            plusone=multiply(plusone,divisor);
            if ((isEqual(check, dividend)||isGreater(dividend,check))&& isGreater(plusone,dividend)){
                answer=true;
                break;
                //return average;
            }
        }
        System.out.println("answer: "+average);
        return average;

    }
    public static void main (String[] args){
        /*String str1="99673465352435234354675345699943232234234745634645654678";
        String str2="99345676745689999919999999999846457567657432534238756463454453645";
        String answer= multiply(str1,str2);
        System.out.println(str1+ "  *  "+str2+" = "+answer);
        String answer2=stringDivision(answer,str1);
        System.out.println(answer+ "  /  "+str1+" = "+answer2);
        System.out.println(isEqual(str2,answer2));*/

        fib(BigInteger.valueOf(200));
    }
    public static BigInteger fib(BigInteger n) {
        // fibinacci sequence up to the nth number in sequence
        //(n-2)+(n-1)=(n)
        int converted= Integer.valueOf(n.toString());

        BigInteger nMinus1=BigInteger.ONE;
        BigInteger nMinus2=BigInteger.ONE;
        BigInteger answer=nMinus1.add(nMinus2);
        for (int i=2;i<converted;i++){
            //System.out.println(answer);
            nMinus2=nMinus1;
            nMinus1=answer;
            answer=nMinus1.add(nMinus2);
        }


        System.out.println(answer);
        return answer;
    }

}
//1