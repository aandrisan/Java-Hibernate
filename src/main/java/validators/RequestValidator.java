package validators;

import dto.RequestUserDto;
import entity.Request;
import exception.InvalidParameterException;
import messages.ErrorMessages;

import java.util.List;

public class RequestValidator {

    public static void validateStatus(String id){
        if(id==null || id.equals("")){
            throw new InvalidParameterException(ErrorMessages.INVALID_ID);
        }
    }

    public static void validateRequest(RequestUserDto requestUserDto, List<Request> list){
        for(Request r : list){
            if(r.getIdrequest().equals(requestUserDto.getIdRequest())){
                return;
            }
        }
        throw new InvalidParameterException(ErrorMessages.INVALID_ID);
    }
}
