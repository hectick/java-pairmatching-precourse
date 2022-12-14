package pairmatching.controller;

import pairmatching.constant.Course;
import pairmatching.model.FileReader;
import pairmatching.model.Pair;
import pairmatching.model.PairMatcher;
import pairmatching.view.OutputView;

import java.util.List;

public class Controller {
    OutputView outputView;
    List<String> backendCrewNames;
    List<String> frontendCrewNames;
    PairMatcher matcher;

    public Controller(){
        setCrewNamesList();
        matcher = new PairMatcher();
        outputView = new OutputView();
    }

    private void setCrewNamesList(){
        FileReader reader = new FileReader();
        backendCrewNames = reader.readCrewNames("./src/main/resources/backend-crew.md");
        frontendCrewNames = reader.readCrewNames("./src/main/resources/frontend-crew.md");
    }

    public void execute(){
        List<Pair> pairs = matchPairs(frontendCrewNames, Course.FRONTEND);
        outputView.printPairMatchingResult(pairs);
    }

    private List<Pair> matchPairs(List<String> backendCrewNames, Course course){
        List<Pair> pairs = matcher.match(backendCrewNames, course);
        return pairs;
    }


}
