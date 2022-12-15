package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.validator.ValueValidator;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static String readFunctionSelection(){
        String input = Console.readLine();
        ValueValidator.validateFunctionSelection(input);
        return input;
    }

    public static String readRematchingSelection(){
        String input = Console.readLine();
        ValueValidator.validateRematchingSelection(input);
        return input;
    }

    public static List<String> readCourseAndLevelAndMissionSelections(){
        String line = Console.readLine();
        List<String> inputs = parse(line);
        ValueValidator.validateNumberOfInputs(inputs);
        ValueValidator.validateCourse(inputs.get(0));
        ValueValidator.validateLevelAndMission(inputs.get(1), inputs.get(2));
        return inputs;
    }

    private static List<String> parse(String line){
        List<String> words = new ArrayList<>();
        String[] array = line.split(",");
        for(int i = 0; i < array.length; i++){
            words.add(array[i].trim());
        }
        return words;
    }


}
