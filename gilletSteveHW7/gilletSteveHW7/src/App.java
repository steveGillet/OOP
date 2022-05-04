import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;
import java.util.Scanner;

class Encryption
{
	static byte[] encrypt(byte s[], Cipher c, SecretKey sk) throws Exception
	{
	    c.init(Cipher.ENCRYPT_MODE, sk);
	    return c.doFinal(s);
	}

	static byte[] decrypt(byte s[], Cipher c, SecretKey sk) throws Exception
	{
	    c.init(Cipher.DECRYPT_MODE, sk);
	    return c.doFinal(s);
	}
}

public class App {
    public static void main(String[] args) throws Exception {
        try{
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            SecretKey keyAB = keygen.generateKey();
            SecretKey keyAC = keygen.generateKey();
            Cipher aesCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
             
            Box boxAB = new Box();
            String msgAB = "We have a meeting tomorrow at 8 am";
            String[] msgABsep = msgAB.split(" ");
            
            Alice al = new Alice(keyAB, aesCipher, boxAB);
            Bob b = new Bob(keyAB, aesCipher, boxAB);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Alice implements Runnable{
    String msgAB = "We have a meeting tomorrow at 8 am";
    String msgAC = "Tomorrow meeting will be held in room 100";
    Thread t;
    String[] msgABsep = msgAB.split(" ");
    SecretKey keyAB, keyAC;
    Cipher aesCipher;
    Box boxAB;

    
    public Alice(SecretKey k, Cipher aes, Box boxB) {
        keyAB = k;
        aesCipher = aes;
        boxAB = boxB;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        try{
            byte[] cleartext = msgABsep[0].getBytes();
            byte[] ciphertext = Encryption.encrypt(cleartext, aesCipher, keyAB);
            boxAB.put(ciphertext);
            // for(int i = 0; i < msgABsep.length; i++){
            //     byte[] cleartext = msgABsep[i].getBytes();
            //     byte[] ciphertext = Encryption.encrypt(cleartext, aesCipher, keyAB);
            //     boxAB.put(ciphertext);
            // }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Bob implements Runnable{
    Thread t;
    SecretKey keyAB;
    Cipher aesCipher;
    Box boxAB;

    
    public Bob(SecretKey k, Cipher aes, Box box) {
        keyAB = k;
        aesCipher = aes;
        boxAB = box;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        try{
            byte[] boxEnc = boxAB.get();
            byte[] plaintext = Encryption.decrypt(boxEnc, aesCipher, keyAB);
            String str = new String(plaintext);
            System.out.println("The data after decryption is: " + str);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Box {
    private byte[] message;
    synchronized void put(byte[] mess){
        message = mess;
    }
    synchronized byte[] get(){
        return message;
    }
}