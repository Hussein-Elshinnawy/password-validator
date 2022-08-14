package passwordvalidator;

import java.util.Scanner;

public class password {

	public static void main(String[] args) {
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
            if(passwordconstrant(password))
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
    public static boolean passwordconstrant(String password)
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



}
