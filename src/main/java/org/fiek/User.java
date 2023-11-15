package org.fiek;

import net.sf.ntru.encrypt.*;

public class User {
    private String username;
    private EncryptionKeyPair keyPair;
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

    public String encryptMessage(String message) {
        byte[] enc = ntru.encrypt(message.getBytes(), this.keyPair.getPublic());
        return HexUtil.byteArrayToHex(enc);
    }

    public String decryptMessage(String hex_message) {
        byte[] encryptedText = HexUtil.hexStringToByteArray(hex_message);
        return new String(ntru.decrypt(encryptedText, keyPair));
    }
}
