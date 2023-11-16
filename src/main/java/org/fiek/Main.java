package org.fiek;

import net.sf.ntru.encrypt.EncryptionKeyPair;
import net.sf.ntru.encrypt.EncryptionParameters;
import net.sf.ntru.encrypt.NtruEncrypt;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static ArrayList<User> users = new ArrayList<User>();
    static String availableOptions = "1) Listo përdoruesit e regjistruar" +
            "\n2) Krijo një përdorues" +
            "\n3) Shiko public key të një përdorues" +
            "\n4) Enkripto një mesazh" +
            "\n5) Dekripto një mesazh" +
            "\n5) Shiko qelesin publik te nje perdoruesit" +
            "\n100) Dilni";

    public static User findUserByUsername(String username) {
        for(User user: users) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

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

            if(selectedOption.equals("1")) {
                for(User user : users) {
                    System.out.println(user);
                }
            }
            else if(selectedOption.equals("2")) {
                try {
                    User u = User.registerForm(sc);
                    if(u != null) users.add(u);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            else if(selectedOption.equals("3")) {
                User u = null;
                while (u == null) {

                    if(users.size() == 0) {
                        System.out.println("Nuk ekziston ende ndonje perdorues");
                        break;
                    }

                    System.out.println("Shkrunai emrin e perdoruesit");
                    String username = sc.nextLine().trim();
                    u = findUserByUsername(username);
                    if(u == null) System.out.println("Ky perdorues nuk ekziston!");
                    else System.out.println(u.getPublicKeyAsString());
                }
            }
            else if(selectedOption.equals("4")) {
                User u = null;
                while (u == null) {

                    if(users.size() == 0) {
                        System.out.println("Nuk ekziston ende ndonje perdorues");
                        break;
                    }

                    System.out.println("Shkrunai emrin e perdoruesit me qelësin publik e të cilit do të enkriptoni mesazhin");
                    String username = sc.nextLine().trim();
                    u = findUserByUsername(username);
                    if(u == null) System.out.println("Ky perdorues nuk ekziston!");
                    else {
                        System.out.println("Shkruani mesazhin");
                        String message = sc.nextLine();
                        System.out.println("Mesazhi i enkriptuar: ");
                        System.out.println(u.encryptMessage(message));
                    };
                }
            }
            else if(selectedOption.equals("5")) {
                User u = null;
                while (u == null) {
                    if(users.size() == 0) {
                        System.out.println("Nuk ekziston ende ndonje perdorues");
                        break;
                    }

                    System.out.println("Shkrunai emrin e perdoruesit me qelësat e të cilit do të dekriptoni mesazhin");
                    String username = sc.nextLine().trim();

                    u = findUserByUsername(username);
                    if(u == null) System.out.println("Ky perdorues nuk ekziston!");
                    else {
                        System.out.println("Shkruani mesazhin");
                        String message = sc.nextLine();
                        try {
                            System.out.println("Mesazhi i dekriptuar: ");
                            System.out.println(u.decryptMessage(message));
                        } catch(Exception e) {
                            System.out.println("Dicka shkoi gabim!");
                            System.out.println(e.getMessage());
                        }
                    };
                }
            }
            else if(selectedOption.equals("100")) {
                System.out.println("Faleminderit që zgjodhët FIEKMASTER ~ NTRU");
                break;
            }
        }

    }
}