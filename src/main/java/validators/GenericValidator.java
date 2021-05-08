package validators;

import exception.InvalidParameterException;
import messages.ErrorMessages;

public class GenericValidator {

    public static void validateGeneric(String name){
        if(name==null || name.equals("")){
            throw new InvalidParameterException(ErrorMessages.INVALID_ID);
        }
    }
}
