package validators;

import exception.InvalidParameterException;
import messages.ErrorMessages;

public class AdministratorValidator {
    public static void validateGetAdminByEmail(String email){
        validateGeneric();
        if(email==null || email.equals("")){
            throw new InvalidParameterException(ErrorMessages.INVALID_ID);
        }
    }


    private static void validateGeneric(){

    }
}
