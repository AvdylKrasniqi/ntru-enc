package org.fiek;

import net.sf.ntru.encrypt.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Scanner;

public class User {
    private String username;
    private EncryptionKeyPair keyPair;

    public static User registerForm(Scanner scanner) {
        System.out.println("Shkruani emrin");
        String username = scanner.nextLine();
        System.out.println("Ju vendoset username " + username);
        EncryptionKeyPair kp = null;

        do {
            System.out.println("Si të veprohet me qelesat e përdoruesit");
            System.out.println("1) Krijoni një pair të ri");
            System.out.println("2) Vendos private key dhe public key manualisht");
            System.out.println("3) Posedoj vetem public key, vendos vetem ate manualisht");
            String selectedOption = scanner.nextLine().trim();
            if(selectedOption.equals("1")) {
                kp = ntru.generateKeyPair();
            } else if(selectedOption.equals("2")) {
                while (true) {
                    System.out.println("Shkruani private key");
                    String privKey = scanner.nextLine().trim();
                    System.out.println("Shkruani public key");
                    String pubKey = scanner.nextLine().trim();
                    try {
                        kp = new EncryptionKeyPair(
                                new EncryptionPrivateKey(HexUtil.hexStringToByteArray(privKey)),
                                new EncryptionPublicKey(HexUtil.hexStringToByteArray(pubKey))
                        );
                        break;
                    } catch (Exception e) {
                        System.out.println("Ju lutem vendosni qelesa valid");
                    }
                }
            } else if(selectedOption.equals("3")) {
                while (true) {
                    System.out.println("Shkruani public key key");
                    String privKey = null;
                    String pubKey = scanner.nextLine().trim();
                    try {
                        kp = new EncryptionKeyPair(
                                null,
                                new EncryptionPublicKey(HexUtil.hexStringToByteArray(pubKey))
                        );
                        break;
                    } catch (Exception e) {
                        System.out.println("Ju lutem vendosni qelesa valid");
                        String _continue = scanner.nextLine().trim();
                        if(_continue.equalsIgnoreCase("no")) {
                            return null;
                        }
                    }
                }
            } else {
                System.err.println("Ju lutem zgjidhni nje nga opcionet e ofruara");
            }
        } while (kp == null || username == null || username.equals(""));

        System.out.println("Ju vendoset username " + username);

        return new User(username, kp);
    }
    static NtruEncrypt ntru = new NtruEncrypt(EncryptionParameters.EES1087EP2_FAST);

    public User(String username, EncryptionKeyPair keyPair) {
        this.username = username;
        this.keyPair = keyPair;
    }

    public User(String username, EncryptionPrivateKey privateKey, EncryptionPublicKey publicKey) {
        this.username = username;
        this.keyPair = new EncryptionKeyPair(privateKey, publicKey);
    }

    public EncryptionPublicKey getPublicKey() {
        return this.keyPair.getPublic();
    }

    public String getPublicKeyAsString() {
        return HexUtil.byteArrayToHex(getPublicKey().getEncoded());
    }

    public String encryptMessage(String message) {
        byte[] enc = ntru.encrypt(message.getBytes(), this.keyPair.getPublic());
        return HexUtil.byteArrayToHex(enc);
    }

    public String decryptMessage(String hex_message) {
        byte[] encryptedText = HexUtil.hexStringToByteArray(hex_message);
        return new String(ntru.decrypt(encryptedText, keyPair));
    }


    public String getUsername() {
        return this.username;
    }

    @Override
    public String toString() {
        return  username +
                (keyPair.getPrivate() != null ? " ka qeles privat" : "nuk ka qeles privat") +
                " dhe " +
               ( keyPair.getPublic() != null ? " ka qeles publik"  : " nuk ka qeles publik");
    }
}
