package passwordvalidator;

import java.util.Scanner;
import java.util.Random;

public class password {

	public static void main(String[] args) {
		 System.out.println(passwordGenerator()); 
		//System.out.println(genationValidation(passwordGenerator()));
		Scanner myObj = new Scanner(System.in);
		String input = myObj.nextLine();
			if(validatepassword(input))
			{
				
				System.out.println("MISSION PASSED");
			}
			else {
				System.out.println("WASTED");
			}
		
		        
	}

	public static boolean validatepassword(String password)
    {
        if(password.length()>=8 && password.length()<=12)
        {
            if(passwordConstrant(password))
            {
                System.out.println("good range");
                return true;
            }
            else {
            	System.out.println("the password must contain at leat 1 upper character 1 lower character , 1 digit ,1 special character");
            	return false;
            }
            
            
        }
        else {
        	System.out.println("the password length must be within 8 to 12 characters");
        	return false;
        }
        

    }
    public static boolean passwordConstrant(String password)
    {
        boolean upperChar=false; boolean lowerChar=false; boolean specialChar=false; boolean digitChar=false;
        for(int i=0 ; i<password.length() ; i++)
        {
            char c= password.charAt(i);
            if(Character.isUpperCase(c))
            {
                upperChar=true;
            }
            else if(Character.isLowerCase(c))
            {
                lowerChar=true;
            }
            else if(Character.isDigit(c))
            {
                digitChar=true;
            }
            else if(!Character.isSpaceChar(c) && !Character.isLetter(c))
            {
                specialChar=true;
            }
        }
        if(upperChar && lowerChar && digitChar && specialChar)
        {
        	return true;
        }
        return false;
    }
    
//    public static String passwordGenerator()
//    {
//    	Random r = new Random();
//    	String alphabet = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//    	String temp = "";
//    	int passLength =r.nextInt(12 - 8) + 8; 
//        for (int i = 0; i < passLength; i++) {
//            temp+=alphabet.charAt(r.nextInt(alphabet.length()));
//        } 
//        return temp;
//        
//    }
    public static String passwordGenerator()
    {
    	Random r = new Random();
    	String temp = "";
    	int passLength =r.nextInt(12 - 8) + 8; 
        for (int i = 0; i < passLength; i++) {
            char random_3_Char = (char) (r.nextInt(93) + '!');//48 -122 //  char random_3_Char = (char) (48 + r.nextInt(122));
            temp+=random_3_Char;
        } 
        return temp;
        
    }
    
    //the techique is correct keep generating untill one is correct but it's ineffecient and causes stackoverflowerror
//    public static String genationValidation(String genPassword)
//    {
//    	while(!passwordConstrant(genPassword))
//    	{	
//    		System.out.println(genPassword);
//    		genationValidation(passwordGenerator());
//    	}
//    	return genPassword;
//    }



}
