// 150117051 Metehan ERTAN
	import java.util.Scanner;
public class Pro4_150117051 {
	public static void main(String[] args) {
	//Program takes a String and option then does the wanted option	
		
	int letterCount=0;					//Program counts the letter and word for stats option
	int wordCount=0;

		while(true){
			Scanner input = new Scanner(System.in);
			System.out.print("Please enter an input string: ");				//Program takes a String
			String str =input.nextLine();
			
			if(str.toLowerCase().equals("exit")||str.toLowerCase().equals("quit"))				//Closing words					
					break;
			
			if(str.toLowerCase().equals("stat"))									//Showing stats
				printStat(wordCount,letterCount);
			
			else{														//If the string isnt exit, quit or stat program continous
				for(int i=0;i<=str.length()-1;i++){					//Program counts the word that string has
					if(str.charAt(i)==' ' && str.charAt(i+1)!=' ')
						wordCount++ ;
				}
				wordCount++;
	
					
				letterCount = updateLetterCount(letterCount, str);			//Program counts the letter
							
				
				System.out.print("1. Change Case\n2. Count vowels and consonants\n3. Capitalize the first letter\n4. Encrypt or Decrypt\n\n"); //Program give options
				System.out.print("Please select an option:");
				int option =input.nextInt();					//Program takes the given option
				
				if(option==1){
					System.out.println(changeCase(str)+"\n\n");
				}
				
				if(option==2){
					countVC(str);
				}
				
				if(option==3){
					System.out.println(capitalize(str)+"\n\n");
				}
				
				if(option==4){
					System.out.print("Enter an offset value: -");						//Program takes an offset for encrypting
					int offset = input.nextInt();
					if(offset>25)
						System.out.println("Invalid offset.\n\n");
					else{
						System.out.println(str.substring(0,str.length()).toUpperCase());
						System.out.println(encryptOrDecrypt (str,offset)+"\n\n");
					}
				}
				
			}
		}
		System.out.print("Program ends. Bye");
	}
	
	public static int updateLetterCount(int letterCount, String str){
		for(int i =0;i<str.length();i++){										//Program counts the Letter that string has
			if(str.toUpperCase().charAt(i)>64 && str.toUpperCase().charAt(i)<91){
				letterCount++;
				}
		}
		return letterCount;
	}
	
	public static void printStat (int wordCount, int letterCount){			//Program outputs the Count of words and letters
		System.out.println("The number of words: "+wordCount);
		System.out.println("The number of alphabetic letters:"+letterCount+"\n\n");
	}
	
	public static String changeCase (String str){						//Program changes lower cases to upper cases and upper cases to lower cases
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==Character.toLowerCase(str.charAt(i))){
				str = str.substring(0,i)+str.substring(i,i+1).toUpperCase()+str.substring(i+1);
			}
			else if(str.charAt(i)==Character.toUpperCase(str.charAt(i))){
				str = str.substring(0,i)+str.substring(i,i+1).toLowerCase()+str.substring(i+1);
			}
			else if(str.charAt(i)==' '){}
		}
		return str;
	}
	
	public static void countVC (String str){								//Program outputs the number of vowels and consonants
		int countVowels=0;
		int countConsonants=0;
		String str1=str.toLowerCase();
			for(int i=0; i<str.length(); i++)
				if(str1.charAt(i)=='a' ||str1.charAt(i)=='e'||str1.charAt(i)=='i' ||str1.charAt(i)=='o' ||str1.charAt(i)=='u')
					countVowels++;
				else if(str1.charAt(i)==' '){}
				else
					countConsonants++;
					
		System.out.println("The number of vowels is "+countVowels);
		System.out.println("The number of consonants is "+countConsonants+"\n\n");
	}
	
	public static String capitalize(String str){							//Program outputs the String with first letters of the words capitilazed
		for(int i=0; i<str.length();i++){
			char ch =str.charAt(i);
			if(ch==' ')
				str = str.substring(0,i+1)+str.substring(i+1,i+2).toUpperCase()+str.substring(i+2);			
		}
		str= str.substring(0,1).toUpperCase() +str.substring(1);
		return str;
	}
	
	public static String encryptOrDecrypt (String str, int offset){			//Program encrypts the string with given input
		str=str.toUpperCase();
		char ch =' ';
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)+offset>90){					//If int of char plus offset is greater than (int)'Z' we - 26 to make it in 'A' to 'Z'
				int chInt = str.charAt(i)-26+offset ;
				ch = (char) chInt;
			}			
			else if(str.charAt(i)+offset<91 && str.charAt(i)+offset>64){		//If int of char plus offset is less than (int)'Z' there isnt a problem
				int chInt =str.charAt(i)+offset;
				ch = (char) chInt;
			}
			else if(str.charAt(i)+offset<65){
				int chInt=str.charAt(i)+26+offset;
				ch = (char) chInt;
			}
			else{													//This part is for non-letter characters
				ch=str.charAt(i);
			}
			str=str.substring(0, i)+ch+str.substring(i+1);	
		}
		return str;		
	}
}