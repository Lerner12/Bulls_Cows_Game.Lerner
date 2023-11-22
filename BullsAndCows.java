import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BullsAndCows {
	static Scanner id=new Scanner(System.in);
	
	public static void main(String[] args) {
		int unique=generateUniqueNumber();
		//System.out.println(unique);
		
		System.out.println("Hello,What file would you like to write the game history to?");
		String forFile=id.nextLine();
		
		System.out.println("enter a 4 digit number to get started");
		 String str=id.nextLine();
		
		
		writeInFile(forFile, str, unique);
		
		System.out.println("Congratulations");

	}
	
	public static void writeInFile(String nameFile,String str,int unique) {

		
		
		try (BufferedWriter out=new BufferedWriter(new FileWriter(new File(nameFile),true))){
			do {
				String newStr=countCowsBulls(str, unique);
				System.out.println(newStr);
				
				out.write(newStr);
				str=id.nextLine();
				} while (!(countCowsBulls(str,unique).equals("(0 cows, 4 bulls)")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String countCowsBulls(String str,int number) {
		 int numCows = 0;
		    int numBulls = 0;
		    String str1=Integer.toString(number);
		    while((!str.matches("\\d{4}")) ) {
				System.out.println("Wrong way");
				str=id.nextLine();
			}

		    for (int i = 0; i < 4; i++) {
		        char c = str.charAt(i);
		        if (str1.charAt(i) == c) {
		            numBulls++;
		        }
		        else if (str1.indexOf(c) != -1) {
		            numCows++;
		        }
		    }

		    return "Your number is "+str+ "\n(" + numCows + " cows, " + numBulls + " bulls)";
		}
		
	
	 public static int generateUniqueNumber() {
	        Set<Integer> usedDigits = new HashSet<>();
	        int result = 0;

	        while (usedDigits.size() < 4) {
	            int digit = (int) (Math.random() * 10);
	            if (!usedDigits.contains(digit)) {
	                usedDigits.add(digit);
	                result = result * 10 + digit;
	            }
	        }

	        return result;
	    }
	
	

}
