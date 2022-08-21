package passwordvalidator;

import java.util.Scanner;
import java.util.Random;

public class password {

	public static void main(String[] args) {
		System.out.println("a suggested password");
		System.out.println(generatorValidation(passGen()));
		System.out.println("please enter a password");
		try (Scanner myObj = new Scanner(System.in)) {
			String input = myObj.nextLine();
				if(validatepassword(input))
				{
					
					System.out.println("MISSION PASSED");
				}
				else {
					System.out.println("WASTED");
				}
		}
		        
	}
	
	//old techique of password generation
//  public static String passwordGenerator()
//  {
//  	Random r = new Random();
//  	String alphabet = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
//  	String temp = "";
//  	int passLength =r.nextInt(12 - 8) + 8; 
//      for (int i = 0; i < passLength; i++) {
//          temp+=alphabet.charAt(r.nextInt(alphabet.length()));
//      } 
//      return temp;
//      
//  }
  
  
  	//old techique of password generation
//  public static String passwordGenerator()
//  {
//  	Random r = new Random();
//  	String temp = "";
//  	int passLength =r.nextInt(12 - 8) + 8; 
//      for (int i = 0; i < passLength; i++) {
//          char random_3_Char = (char) (r.nextInt(93) + '!');
//          temp+=random_3_Char;
//      } 
//      return temp;
//      
//  }

	public static boolean validatepassword(String password){
   
            if(passwordConstrant(password) && passwordRange(password)){
                return true;
            }
            return false;
        
    }
	
	public static boolean passwordRange(String password)
	{
		if(password.length()>=8 && password.length()<=12){
			return true;
		}
		System.out.println("the password length must be within 8 to 12 characters");
		return false;
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
        System.out.println("the password must contain at leat 1 upper character 1 lower character , 1 digit ,1 special character");
        return false;
    }
    
    public static String generatorValidation(String genPassword){
    	while(!passwordConstrant(genPassword))
    	{	
    		genPassword= passGen();
    		generatorValidation(genPassword);
    	}
    	return genPassword;
    }
    
    //each character of password is randomized be one of the options 1-upper-case 2-lower-case 3-digit 4-special character so chances of each option 1/4 
    public static String passGen()
    {
    	
    	Random r = new Random();
    	//int passLength =r.nextInt(12 - 8) + 8; 
    	String genPassword = "";
    	for(int i = 0; i < 12; i++) {
    		
    		int cases =r.nextInt(5 - 1) + 1; 
    		switch(cases)
    		{
    		case 1:{
    			
    			char upper = (char) (r.nextInt(90-65) + 65);//upper-cases
    			genPassword+=upper;
    			break;
    		}
    		
    		case 2:{
    			
    			char lower = (char) (r.nextInt(122-97) + 97);//lower-cases
    			genPassword+=lower;
    			break;
    		}
    		
    		case 3:{
    		
    			char digit = (char) (r.nextInt(57-48) + 48);//lower-cases
    			genPassword+=digit;
    			break;
    		}
    		
    		case 4:{
    			
    			String specialChar = "@#$%&";
    			char special = specialChar.charAt(r.nextInt(specialChar.length()));//special-characters
    			genPassword+=special;
    			break;
    		}
    		}
    	}
		return genPassword;
    	
    }

}
