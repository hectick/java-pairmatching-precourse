package pairmatching.validator;

import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.constant.OutputMessage;
import pairmatching.model.Pair;

import java.util.List;

public class ValueValidator {

    public static void validateFunctionSelection(String input){
        if(!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("Q")){
            throw new IllegalArgumentException(OutputMessage.INVALID_INPUT_MESSAGE);
        }
    }

    public static void validateRematchingSelection(String input){
        if(!input.equals("네") && !input.equals("아니오")){
            throw new IllegalArgumentException(OutputMessage.INVALID_INPUT_MESSAGE);
        }
    }

    public static void validateCourse(String input){
        if(Course.BACKEND.getName().equals(input) || Course.FRONTEND.getName().equals(input)){
            return;
        }
        throw new IllegalArgumentException(OutputMessage.INVALID_COURSE_MESSAGE);
    }

    public static void validateLevelAndMission(String level, String mission){
        Level tmp = Level.get(0);
        for(int i = 0; i < Level.size(); i++){
            if(Level.get(i).getName().equals(level)){
                tmp = Level.get(i);
                break;
            }
            if(i == Level.size()-1){
                throw new IllegalArgumentException(OutputMessage.INVALID_LEVEL_MESSAGE);
            }
        }
        if(!tmp.contains(mission)){
            throw new IllegalArgumentException(OutputMessage.INVALID_MISSION_MESSAGE);
        }
    }

    public static void validateNumberOfInputs(List<String> inputs){
        if(inputs.size() != 3){
            throw new IllegalArgumentException(OutputMessage.INVALID_NUMBER_OF_VALUES_MESSAGE);
        }
    }
}
