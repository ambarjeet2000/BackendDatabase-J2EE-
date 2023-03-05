package daodta;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp2 {
    static Scanner sc1 = new Scanner(System.in);

    static MessDAO d1 = new MessDAO();

    public static void main(String[] args) {
        System.out.println("---> RAISONI COLLEGE MESS <---");
        System.out.println("SELECT MODE OF OPERATION");
        System.out.println("1 : ADD CUSTOMER");
        System.out.println("2 : DELETE CUSTOMER");
        System.out.println("3 : SHOW LIST OF CUSTOMERS");
        int choice = sc1.nextInt();

        if (choice==1){
            addCustomer();
        } else if (choice==2) {
            deleteCustomer();
        } else if (choice==3) {
            showList();
        }
    }

    static void addCustomer(){
        System.out.println("ENTER NAME");
        String name = sc1.next();
        System.out.println("ENTER NUMBER");
        int number =sc1.nextInt();
        System.out.println("ENTER SHIFT");
        String shift = sc1.next();

        Mess m1 = new Mess();
        m1.setName(name);
        m1.setNumber(number);
        m1.setShift(shift);

        int count = d1.addDetails(m1);
        System.out.println(count+" MEMBER ADDED SUCCESSFULLY");
    }

    static void deleteCustomer(){
        System.out.println("ENTER CUSTOMER ID");
        int id = sc1.nextInt();

        Mess m1 = new Mess();
        m1.setId(id);

        int count = d1.deleteDetails(m1);
        System.out.println(count+" MEMBER DELETED SUCCESSFULLY");
    }

    static void showList(){

        ArrayList<Mess> data = d1.showList();

        for (Mess m :data){
            System.out.println(m);
        } 
    }
}
