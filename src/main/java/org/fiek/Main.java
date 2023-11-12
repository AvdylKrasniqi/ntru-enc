package org.fiek;

import net.sf.ntru.encrypt.EncryptionKeyPair;
import net.sf.ntru.encrypt.EncryptionParameters;
import net.sf.ntru.encrypt.NtruEncrypt;
import net.sf.ntru.sign.NtruSign;
import net.sf.ntru.sign.SignatureKeyPair;
import net.sf.ntru.sign.SignatureParameters;

import java.util.Arrays;

public class Main {

    private static void encrypt(String msg) {
        NtruEncrypt ntru = new NtruEncrypt(EncryptionParameters.EES1087EP2_FAST);
        EncryptionKeyPair keyPair = ntru.generateKeyPair();

        System.out.println("Mesazhi plain: " + msg);

        // encrypt the message with the public key created above
        byte[] enc = ntru.encrypt(msg.getBytes(), keyPair.getPublic());

        System.out.println("Mesazhi i enkriptuar [byte data]: " + Arrays.toString(enc));
        System.out.print("Mesazhi i enkriptuar [HEX data]: ");
        for(byte b: enc) {
            System.out.printf("%02X", b);
        }
    }
    public static void main(String[] args) {

        encrypt("Hello From FIEK!");
    }
}