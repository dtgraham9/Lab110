/**
 * Creates a detailed print out of cyclic shift of POTS, STOP, and TOPS
 * @author Graham Thompson
 * @version 11/6/18
 */
public class Client {

    static StringBuilder fullOutput = new StringBuilder(); //Strongs the detailed hash code build
    
    /**
     * Takes a string and adds leading zeros to the front until its 
     * 32 characters long to represent a 32 bit binary number
     * @param token
     * @return 
     */
    static String addLeadingZeros(String token){
        StringBuilder hashString = new StringBuilder(token);
        for(int j = 32 - hashString.length(); j>0;j--){
                hashString.insert(0, "0");
            }
        return hashString.toString();
    }
    
    /**
     * Takes a string and creates a hash code by adding the unicode value of 
     * each char and then shifts hash left 5 bits and shifts hash right 27 bits
     * and OR together.  All operations are stored for a detail print out.
     * @param token
     * @return 
     */
    static String hashCode(String token) { 
        int hash=0;
        fullOutput.append("Creating Hash code for ").append(token).append(":\n\n");
        for (int i=0; i<token.length( ); i++) { 
            fullOutput.append("Entering hashCode, pass ").append(i).append("\t\t").append(addLeadingZeros(Integer.toBinaryString(hash))).append("\n");
            int hashLeft = hash<<5;
            int hashRight = hash>>>27;
            fullOutput.append("hash << 5: \t\t\t\t").append(addLeadingZeros(Integer.toBinaryString(hashLeft))).append("\n");
            fullOutput.append("hash << 27: \t\t\t\t").append(addLeadingZeros(Integer.toBinaryString(hashRight))).append("\n");
            hash = (hash << 5) | (hash >>> 27); 
            fullOutput.append("hash << 5 | hash >>> 27: \t\t").append(addLeadingZeros(Integer.toBinaryString(hash))).append("\n");
            fullOutput.append("Adding character ").append(token.charAt(i)).append(":\t\t\t").append(addLeadingZeros(Integer.toBinaryString((int) token.charAt(i)))).append("\n");
            hash += (int) token.charAt(i); 
            fullOutput.append("\nExiting Hashcode: \t\t\t").append(addLeadingZeros(Integer.toBinaryString(hash))).append("\n\n");
        }
        String temp = addLeadingZeros(Integer.toBinaryString(hash));
        fullOutput.append("Final Hash Code for ").append(token).append(":\t\t").append(temp).append("\n\n\n");
        return temp;
    }
    
    /**
     * Calculates the hash code from cyclic shift of POTS, STOP, and TOPS.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String pots = hashCode("POTS");
        String stop = hashCode("STOP");
        String tops = hashCode("TOPS");
        
        System.out.printf("\tPOTS: %s\n\tSTOP: %s\n\tTOPS: %s\n\n\nDetailed Hash code information:\n\n\n",pots,stop,tops);
        System.out.println(fullOutput.toString());
        
    }
    
}
