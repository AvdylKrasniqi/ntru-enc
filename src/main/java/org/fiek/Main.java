package org.fiek;

import net.sf.ntru.encrypt.EncryptionKeyPair;
import net.sf.ntru.encrypt.EncryptionParameters;
import net.sf.ntru.encrypt.NtruEncrypt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public ArrayList<User> users;
    static String availableOptions = "1) Listo përdoruesit e regjistruar" +
            "\n2) Krijo një përdorues" +
            "\n3) Shto një përdorues" +
            "\n4) Enkripto një mesazh" +
            "\n5) Dekripto një mesazh" +
            "\n6) Dilni";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("-----------------");
            System.out.println("FIEK ~ MASTER 2023");
            System.out.println("-----------------");
            System.out.println("Mirësevini në FIEK-nTRU, zgjidhni veprimin që dëshironi të veproni");
            System.out.println(availableOptions);
            System.out.println("Opcioni juaj?: ");

            String selectedOption = sc.nextLine();

        }

    }
}