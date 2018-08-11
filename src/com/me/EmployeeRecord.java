package com.me;

import java.io.IOException;
import java.io.RandomAccessFile;

class EmployeeRecord {
    private String lastName;

    private String firstName;

    private String address;

    private byte age;

    private double salary;

    void read(RandomAccessFile raf) throws IOException {
        char[] temp = new char[15];
        for (int i = 0; i < temp.length; i++)
            temp[i] = raf.readChar();
        lastName = new String(temp);
        temp = new char[15];
        for (int i = 0; i < temp.length; i++)
            temp[i] = raf.readChar();
        firstName = new String(temp);
        temp = new char[30];
        for (int i = 0; i < temp.length; i++)
            temp[i] = raf.readChar();

        address = new String(temp);
        age = raf.readByte();
        salary = raf.readDouble();
    }

    void write(RandomAccessFile raf) throws IOException {
        StringBuffer sb;
        if (lastName != null)
            sb = new StringBuffer(lastName);
        else
            sb = new StringBuffer();

        sb.setLength(15);
        raf.writeChars(sb.toString());

        if (firstName != null)
            sb = new StringBuffer(firstName);
        else
            sb = new StringBuffer();

        sb.setLength(15);
        raf.writeChars(sb.toString());

        if (address != null)
            sb = new StringBuffer(address);
        else
            sb = new StringBuffer();

        sb.setLength(30);
        raf.writeChars(sb.toString());
        raf.writeByte(age);
        raf.writeDouble(salary);
    }

    void setAge(byte age) {
        this.age = age;
    }

    byte getAge() {
        return age;
    }

    void setAddress(String address) {
        this.address = address;
    }

    String getAddress() {
        return address;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    String getFirstName() {
        return firstName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    String getLastName() {
        return lastName;
    }

    void setSalary(double salary) {
        this.salary = salary;
    }

    double getSalary() {
        return salary;
    }

    int size() {
        return 2 * (15 + 15 + 30) + 9;
    }

}

