package com.math.operations;

abstract class Bank {
    abstract int getInterestRate();
}
class AbcBank extends Bank {
    int getInterestRate() {
        return 6;
    }
} 
class XyzBank extends Bank {
    int getInterestRate() {
        return 7;
    }
}

public class PracticeBank {

	public static void main(String[] args) {
		Bank b1 = new AbcBank();
        Bank b2 = new XyzBank();
        
        System.out.println("Abc bank interest= " + b1.getInterestRate() + "%");
        System.out.println("Xyz bank interest=  " + b2.getInterestRate() + "%");

	}

}
