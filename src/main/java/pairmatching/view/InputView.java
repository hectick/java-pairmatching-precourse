package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public String readFunctionSelect(){
        String input = Console.readLine();
        return input;
    }

    public String readRematchingSelect(){
        String input = Console.readLine();
        return input;
    }

    public List<String> readCourseAndLevelAndMissionSelects(){
        String line = Console.readLine();
        List<String> inputs = parse(line);
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
