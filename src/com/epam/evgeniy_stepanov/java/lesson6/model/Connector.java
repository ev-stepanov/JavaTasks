package com.epam.evgeniy_stepanov.java.lesson6.model;

import java.io.*;

public class Connector extends Thread{
    public static void printObject(File file, Object object) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(object);
        }
    }

    public static Object readObject(File file) throws IOException, ClassNotFoundException {
        Object readObject = null;
        try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file))) {
            readObject = oin.readObject();
        }
        return readObject;
    }
}
