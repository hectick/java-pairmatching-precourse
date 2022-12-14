package pairmatching.validator;

import pairmatching.constant.OutputMessage;

public class valueValidator {

    public void validateFunctionSelection(String input){
        if(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("Q")){
            throw new IllegalArgumentException(OutputMessage.INVALID_INPUT_MESSAGE);
        }
    }
}
