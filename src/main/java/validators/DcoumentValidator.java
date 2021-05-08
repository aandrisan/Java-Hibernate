package validators;

import exception.InvalidParameterException;
import messages.ErrorMessages;

public class DcoumentValidator {

    public static void validateDocuemntName (String name){
        if(name == null || name.equals("")){
            throw new InvalidParameterException(ErrorMessages.INVALID_ID);
        }
    }


}
