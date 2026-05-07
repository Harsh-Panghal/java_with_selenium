package practice.oops;

abstract class Hospital {

 void patients() {
     System.out.println("Handling patient records...");
 }

 void documents() {
     System.out.println("Managing hospital documents...");
 }

 abstract void ot();

 abstract void operations();
}

class Nurse extends Hospital {

 @Override
 void ot() {
     System.out.println("prepares ot.");
 }

 @Override
 void operations() {
     System.out.println("assists operations.");
 }
}

class Doctor extends Hospital {

 @Override
 void ot() {
     System.out.println("check equipment...");
 }

 @Override
 void operations() {
     System.out.println("perform surgery...");
 }
}

public class HospitalManagement {
 public static void main(String[] args) {

     Hospital n = new Nurse();
     Hospital d = new Doctor();

     n.patients();
     n.documents();
     n.ot();
     n.operations();

     d.patients();
     d.documents();
     d.ot();
     d.operations();
 }
}

