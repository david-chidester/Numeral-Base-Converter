import java.lang.*;

public class TwosCompliment {
    public static void main(String args[]){
        for (int i = 0; i < 100; i++){
            String twos = twosCompliment((long)(i));
            String ones = onesCompliment((long)(i));
            System.out.print("Twos Compliment of "+i+"= ");
            parseBytes(twos);
            System.out.print("\nOnes Compliment of "+i+"= ");
            parseBytes(ones);
            System.out.println("");
        }
    }

    private static String onesCompliment(long input){
        StringBuilder sb = new StringBuilder();
        sb.append(Long.toBinaryString(~input));
        sb = sb.reverse();
        while (sb.length() < 64)
            sb.append('0');
        return sb.reverse().toString();
    }

    private static String twosCompliment(long input){
        StringBuilder sb = new StringBuilder();
        sb.append(Long.toBinaryString((~input)+1));
        sb = sb.reverse();
        while (sb.length() < 64)
            sb.append('0');
        return sb.reverse().toString();
    }

    // Prints out string byte by byte for testing
    private static void parseBytes(String input){
      char output[] = input.toCharArray();
      for (int i = 0; i < output.length; i++){
          if (i != 0 && i % 8 == 0)
              System.out.print(" ");
          System.out.print(output[i]);
      }
      System.out.println("");
    }

}
