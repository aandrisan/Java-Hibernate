package validators;

import exception.InvalidParameterException;
import messages.ErrorMessages;

public class UserValidator {

    public static void validateGetUserByEmail(String email){
        validateGeneric();
        if(email==null || email.equals("")){
            throw new InvalidParameterException(ErrorMessages.INVALID_ID);
        }
    }


    private static void validateGeneric(){

    }
}
