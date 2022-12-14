package pairmatching.controller;

import pairmatching.constant.Course;
import pairmatching.model.FileReader;
import pairmatching.model.PairMatcher;

import java.util.List;

public class Controller {
    List<String> backendCrewNames;
    List<String> frontendCrewNames;
    PairMatcher matcher;

    public Controller(){
        setCrewNamesList();
        matcher = new PairMatcher();
    }

    private void setCrewNamesList(){
        FileReader reader = new FileReader();
        backendCrewNames = reader.readCrewNames("./src/main/resources/backend-crew.md");
        frontendCrewNames = reader.readCrewNames("./src/main/resources/frontend-crew.md");
    }

    public void execute(){

    }

    private void matchPairs(List<String> backendCrewNames, Course course){
        matcher.match(backendCrewNames, course);
    }


}
