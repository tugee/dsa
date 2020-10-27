/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuukk
 */
public class Lucky {
    public boolean check(int n) {
        int sum = 0;
        int number = n;
        while(number>0){
            sum+=number%10;
            number = number/10;
        }
        if(sum%7==0){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Lucky l = new Lucky();
        System.out.println(l.check(14)); // false
        System.out.println(l.check(16)); // true
        System.out.println(l.check(123)); // false
        System.out.println(l.check(777)); // true
        System.out.println(l.check(9999999)); // true
    }
}
