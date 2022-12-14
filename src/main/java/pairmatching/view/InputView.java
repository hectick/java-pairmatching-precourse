package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.validator.ValueValidator;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    ValueValidator validator = new ValueValidator();

    public String readFunctionSelection(){
        String input = Console.readLine();
        validator.validateFunctionSelection(input);
        return input;
    }

    public String readRematchingSelection(){
        String input = Console.readLine();
        validator.validateRematchingSelection(input);
        return input;
    }

    public List<String> readCourseAndLevelAndMissionSelections(){
        String line = Console.readLine();
        List<String> inputs = parse(line);
        validator.validateNumberOfInputs(inputs);
        validator.validateCourse(inputs.get(0));
        validator.validateLevelAndMission(inputs.get(1), inputs.get(2));
        return inputs;
    }

    private List<String> parse(String line){
        List<String> words = new ArrayList<>();
        String[] array = line.split(",");
        for(int i = 0; i < array.length; i++){
            words.add(array[i].trim());
        }
        return words;
    }


}
