package com.kkb.task010205;

import bean.Express;

import java.util.Scanner;

public class Views {
    private Scanner input = new Scanner(System.in);

    public void welcome(){
        System.out.println("Welcome to use this system!");
    }
    public void bye(){
        System.out.println("Welcome to use again!");
    }

    public int menu(){
        System.out.println("Please input an order according to the reminder:");
        System.out.println("1. Manager");
        System.out.println("2. User");
        System.out.println("0. Exit");
        String text = input.nextLine();
        int num = -1;
        num = Integer.parseInt(text);
        if (num >= 0 && num <= 2) {
            int num1 = num;
            return num1;
        }
        System.out.println("Something's worry!Please input again.");
        return menu();
    }

    //menu of manager
    public int mMenu(){
        System.out.println("Please input an order according to the reminder:");
        System.out.println("1. Recording the package information.");
        System.out.println("2. Edit package information.");
        System.out.println("3. Delete package.");
        System.out.println("4. Check up package information.");
        System.out.println("0. Back");
        String text = input.nextLine();
        int num = -1;
        try{
            num = Integer.parseInt(text);
        }catch (NumberFormatException e){

        }
        if(num<0||num>4){
            System.out.println("Something's worry!Please input again.");
            return mMenu();
        }
        return num;

    }
    public Express insert(){
        System.out.println("Please input the package information:");
        System.out.println("Please input the number of package:");
        String number = input.nextLine();
        System.out.println("Please input the company of package:");
        String company = input.nextLine();
        Express e = new Express();
        e.setCompany(company);
        e.setNumber(number);
        return e;
    }

    public String findByNumber(){
        System.out.println("Please take the package according to the reminder:");
        System.out.println("Please input the number to take package:");
        String number = input.nextLine();
        return number;
    }

    public void printExpress(Express e){
        System.out.println("package information:");
        System.out.println("Company of package:"+e.getCompany());
        System.out.println("Number of package:"+e.getNumber());
        System.out.println("Code of package:"+e.getCode());
    }

    public void printNull(){
        System.out.println("The package is not exist!");
    }
    public Express update(Express e){
        System.out.println("Please input the new package number:");
        String number = input.nextLine();
        System.out.println("Please input the new package company:");
        String company = input.nextLine();
        e.setNumber(number);
        e.setCompany(company);
        return e;
    }

    public int delete(){
        System.out.println("Do you make sure to delete？");
        System.out.println("1.Yes");
        System.out.println("2.No");
        String text = input.nextLine();
        int num = -1;
        num = Integer.parseInt(text);
        if(num<1||num>2){
            System.out.println("Something's worry!Please input again.");
            return delete();
        }
        return num;

    }

    public void printAll(Express[][] e){
        int count = 0;
        for(int i=0;i<10;i++){
            for (int j=0;j<10;j++){
                if (e[i][j] != null){
                    System.out.print("No.["+i+"]["+j+"]:");
                    System.out.println(e[i][j]);
                    count++;
                }
            }
        }
        if(count==0){
            System.out.println("No this package information.");
        }

    }

    //menu of user
    public int uMenu(){
        System.out.println("Please take the package according to the reminder:");
        System.out.println("Please input the code to take package:");
        String code = input.nextLine();
        int num = -1;
        num = Integer.parseInt(code);
        if (num >= 100000 && num <= 999999) {
            return num;
        }
        System.out.println("Something's worry!Please input again.");
        return uMenu();
    }

    public void expressExist(){
        System.out.println("The package is exist!");
    }
    public void success(){
        System.out.println("Successful!");
    }

}
