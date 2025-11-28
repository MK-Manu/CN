import java.util.*;

public class rsa {


    static int gcd(int m, int n) {
        while (n != 0) {
            int r = m % n;
            m = n;
            n = r;
        }
        return m;
    }

    public static void main(String args[]) {

        int p, q, n, e = 0, d = 0, phi;
        int nummes[] = new int[100];
        int encrypted[] = new int[100];
        int decrypted[] = new int[100];
        int i, j, nofelem;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Message to be encrypted:");
        String message = sc.nextLine();

        System.out.println("Enter values of p and q:");
        p = sc.nextInt();
        q = sc.nextInt();

        n = p * q;
        phi = (p - 1) * (q - 1);


        for (i = 2; i < phi; i++) {
            if (gcd(i, phi) == 1) {
                e = i;
                break;
            }
        }


        for (i = 2; i < phi; i++) {
            if ((e * i - 1) % phi == 0) {
                d = i;
                break;
            }
        }


        for (i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            nummes[i] = c - 96;  // 'a' = 1, 'b' = 2, ...
        }

        nofelem = message.length();

        
        for (i = 0; i < nofelem; i++) {
            encrypted[i] = 1;
            for (j = 0; j < e; j++) {
                encrypted[i] = (encrypted[i] * nummes[i]) % n;
            }
        }

        System.out.println("\nEncrypted message:");
        for (i = 0; i < nofelem; i++) {
            System.out.print(encrypted[i] + " ");
        }

   
        for (i = 0; i < nofelem; i++) {
            decrypted[i] = 1;
            for (j = 0; j < d; j++) {
                decrypted[i] = (decrypted[i] * encrypted[i]) % n;
            }
        }

        System.out.println("\n\nDecrypted message:");
        for (i = 0; i < nofelem; i++) {
            System.out.print((char) (decrypted[i] + 96));
        }

        sc.close();
    }
}
