import java.lang.*;

public class TwosCompliment {
    public static void main(String args[]){
        String test = twosCompliment((long) (10000));
        parseBytes(test);
    }

    private static String onesCompliment(long input){
        char parsedBinary[] = Long.toBinaryString(input).toCharArray();
        char output[] = new char[64];
        // Appending 0s if long doesn't use 64 bits
        for (int i = 0; i < output.length - parsedBinary.length; i++)
            output[i] = '0';

        for (int i = output.length - parsedBinary.length; i < output.length; i++)
            output[i] = parsedBinary[i - (output.length - parsedBinary.length)];

        // flipping bits
        for (int i = 0; i < output.length; i++)
            output[i] = (output[i] == '1'? '0' : '1');

        StringBuilder sb = new StringBuilder();
        sb.append(output);
        return sb.toString();
    }

    private static String twosCompliment(long input){
        char compliment[] = onesCompliment(input).toCharArray();
        StringBuilder sb = new StringBuilder();

        // Incrementing by 1
        if (compliment[compliment.length-1] == '0'){
            compliment[compliment.length-1] = '1';
            sb.append(compliment);
            return sb.toString();
        }
        // If lowest order bit 1 then carry
        boolean carry = true;
        int i = compliment.length-1;
        while (i >= 0 && carry){
            carry = (compliment[i] == '1') && carry;
            compliment[i] = (compliment[i] == '1'? '0' : '1');
            // exit loop when there is nothing to carry
            i--;
        }
        sb.append(compliment);
        return sb.toString();
    }

    // Prints out string byte by byte for testing
    private static void parseBytes(String input){
      char output[] = input.toCharArray();
      for (int i = 0; i < output.length; i++){
          if (i != 0 && i % 8 == 0)
              System.out.print(" ");
          System.out.print(output[i]);
      }
      System.out.println("\n");
    }

}
