import java.security.*;
import java.security.spec.NamedParameterSpec;

public class GenerateKeyPairs {

    public static void main(String[] args) throws NoSuchAlgorithmException,
            InvalidAlgorithmParameterException {

        /**
         * A simple KeyPairGenerator example using the Curve25519 algorithm to generate a key pair.
         */
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("XDH");
        NamedParameterSpec paramSpec = new NamedParameterSpec("X25519");
        kpg.initialize(paramSpec); // equivalent to kpg.initialize(255)
        // alternatively: kpg = KeyPairGenerator.getInstance("X25519")
        KeyPair kp = kpg.generateKeyPair();

        System.out.println("--- Public Key ---");
        PublicKey publicKey = kp.getPublic();

        System.out.println(publicKey.getAlgorithm());   // XDH
        System.out.println(publicKey.getFormat());      // X.509

        // save this public key
        byte[] pubKey = publicKey.getEncoded();

        System.out.println("---");

        System.out.println("--- Private Key ---");
        PrivateKey privateKey = kp.getPrivate();

        System.out.println(privateKey.getAlgorithm());  // XDH
        System.out.println(privateKey.getFormat());     // PKCS#8

        // save this private key
        byte[] priKey = privateKey.getEncoded();
    }
}