package com.me;

//http://www.java2s.com/Code/Java/File-Input-Output/UseRandomAccessFiletosaveanobject.htm

//Use RandomAccessFile to save an object

import java.io.RandomAccessFile;

public class CreateEmployeeFile {
    public static void main(String[] args) throws Exception {

        //field, variables
        String[] fnames = {"Jim", "Jill", "Nora"};

        String[] lnames = {"Dandy", "Marx", "Simms"};

        String[] addresses = {"Bx 100", "55 St.", "6 Lane"};

        byte[] ages = {46, 59, 32};

        double[] salaries = {55, 62, 58};

        RandomAccessFile raf = new RandomAccessFile("employee.dat", "rw");

        EmployeeRecord er = new EmployeeRecord();

        for (int i = 0; i < fnames.length; i++) {
            er.setFirstName(fnames[i]);
            er.setLastName(lnames[i]);
            er.setAddress(addresses[i]);
            er.setAge(ages[i]);
            er.setSalary(salaries[i]);
            er.write(raf);
        }
        raf = new RandomAccessFile("employee.dat", "rw");

        er = new EmployeeRecord();

        int numRecords = (int) raf.length() / er.size();
        //int numRecords = (int) raf.length();

        System.out.println("Name" + "\t " + "\t " + "\t " + "Address" + "\t " + "\t " + "Age" + "\t " + "\t "
                + "Salary");

        System.out.println("----------------------------------------------------");

        for (int i = 0; i < numRecords; i++) {
            er.read(raf);

            System.out.print(er.getFirstName() + " ");
            System.out.print(er.getLastName() + "\t" + "\t ");
            System.out.print(er.getAddress() + "\t" + "\t" + "\t" + " ");
            System.out.print(er.getAge() + "\t" + "\t" + "\t" + " " + " ");
            System.out.println(er.getSalary());
        }
        raf.seek(0);
        for (int i = 0; i < numRecords; i++) {
            er.read(raf);
            if (er.getAge() >= 55) {
                er.setSalary(0.0);
                raf.seek(raf.getFilePointer() - er.size());
                er.write(raf);
                raf.seek(raf.getFilePointer() - er.size());
                er.read(raf);
            }

        }
    }
}

//result;
/*
Name	     Address	 Age	 	 Salary
Jim Dandy    Bx 100      46			  55.0
Jill Marx     55 St.     59			  62.0
Nora Simms   6 Lane      32			  58.0
 */