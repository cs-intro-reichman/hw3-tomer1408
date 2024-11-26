/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true
	
		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String newString1 = preProcess(str1);
		String newString2 = preProcess(str2);
		if(newString1.length() != newString2.length()){
			return false;
		}
		for (int i = 0; i < newString1.length(); i++) {
			boolean foundMatch = false;
			for (int j = 0; j < newString1.length(); j++) {
				if(newString1.charAt(i)==newString2.charAt(j)){
					newString2.replace(newString2.charAt(j), ' ');
					foundMatch = true;
					break;
				}
			}
			if (!foundMatch) {
				return false; 
			}
		}

		return true;
	}

	
	   

		
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String preprocessedVersion = "";
		int i = 0;
	
		while (i < str.length()) {
			char ch = str.charAt(i);
	
			if (ch >= 97 && ch <= 122) {
				preprocessedVersion = preprocessedVersion + ch;
	
	
			} else if (ch >= 65 && ch <= 90) {
				preprocessedVersion = preprocessedVersion + (char) (ch + 32); 

			}
			i++;
		}
	
		return preprocessedVersion;
	}

	
	

	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		return "";
	}
}
