package lms.ui.hackathon.utilities;

import java.util.Random;

public class Utils {

	public static int getRandomNumberWithin(int max) {
		
		return  new Random().nextInt(max) + 1;
		
	}
	
	public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // You can include lowercase or digits if needed
        Random random = new Random();
        StringBuilder result = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            result.append(characters.charAt(index));
        }

        return result.toString().toLowerCase();
    }
	
	public static void main(String[] args) {
		
		System.out.println(generateRandomString(3));;
	}
}
