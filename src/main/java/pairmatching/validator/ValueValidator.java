package pairmatching.validator;

import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.constant.OutputMessage;
import pairmatching.model.Pair;

import java.util.List;

public class ValueValidator {

    public void validateFunctionSelection(String input){
        if(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("Q")){
            throw new IllegalArgumentException(OutputMessage.INVALID_INPUT_MESSAGE);
        }
    }

    public void validateRematchingSelection(String input){
        if(!input.equals("네") && !input.equals("아니오")){
            throw new IllegalArgumentException(OutputMessage.INVALID_INPUT_MESSAGE);
        }
    }

    public void validateCourse(String input){
        if(Course.BACKEND.isNameEqual(input) || Course.FRONTEND.isNameEqual(input)){
            return;
        }
        throw new IllegalArgumentException(OutputMessage.INVALID_COURSE_MESSAGE);
    }

    public void validateLevelAndMission(String level, String mission){
        for(int i = 0; i < Level.size(); i++){
            if(Level.get(i).isNameEqual(level)){
                break;
            }
            if(i == Level.size()-1){
                throw new IllegalArgumentException(OutputMessage.INVALID_LEVEL_MESSAGE);
            }
        }
        if(!Level.valueOf(level).contains(mission)){
            throw new IllegalArgumentException(OutputMessage.INVALID_MISSION_MESSAGE);
        }
    }

    public void validateNumberOfInputs(List<String> inputs){
        if(inputs.size() != 3){
            throw new IllegalArgumentException(OutputMessage.INVALID_NUMBER_OF_VALUES_MESSAGE);
        }
    }
}
