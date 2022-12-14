package pairmatching.controller;

import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.model.FileReader;
import pairmatching.model.MatchingResult;
import pairmatching.model.Pair;
import pairmatching.model.PairMatcher;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private InputView inputView;
    private OutputView outputView;
    private List<String> backendCrewNames;
    private List<String> frontendCrewNames;
    private List<MatchingResult> matchingResults;
    private PairMatcher matcher;
    private boolean isContinued;

    public Controller(){
        setCrewNamesList();
        matcher = new PairMatcher();
        inputView = new InputView();
        outputView = new OutputView();
        matchingResults = new ArrayList<>();
        isContinued = true;
    }

    private void setCrewNamesList(){
        FileReader reader = new FileReader();
        backendCrewNames = reader.readCrewNames("./src/main/resources/backend-crew.md");
        frontendCrewNames = reader.readCrewNames("./src/main/resources/frontend-crew.md");
    }

    public void execute(){
        String selection = getFunctionSelection();
        if(selection.equals("1")){
            matchPairs();
            return;
        }
        if(selection.equals("2")){
            lookUpPairs();
            return;
        }
        if(selection.equals("3")){
            initialize();
            return;
        }
        if(selection.equals("Q")){
            isContinued = false;
        }
    }

    private String getFunctionSelection(){
        String selection = "";
        try{
            outputView.printFunctions();
            selection = inputView.readFunctionSelection();
        }catch(IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            getFunctionSelection();
        }
        return selection;
    }

    private void matchPairs(){
        List<String> selection;
        try{
            outputView.printCourseAndMission();
            selection = inputView.readCourseAndLevelAndMissionSelections();
            if(checkAlreadyPairMatching(selection)){
                outputView.printRematchingMessage();
                String input = inputView.readRematchingSelection();
                if(input.equals("아니오")){
                    return;
                }
            }
            List<Pair> pairs = new ArrayList<>();
            while(true){
                if(Course.BACKEND.isNameEqual(selection.get(0))){
                    pairs = matcher.match(backendCrewNames);
                }else {
                    pairs = matcher.match(frontendCrewNames);
                }
                if(!checkDuplicatedPairInSameLevel(pairs, selection)){
                    break;
                }
            }
            MatchingResult result = new MatchingResult(pairs, Course.getCourse(selection.get(0)), Level.getLevel(selection.get(1)), selection.get(2));
            matchingResults.add(result);
            outputView.printPairMatchingResult(result.getPairs());
        }catch(IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            matchPairs();
        }
    }

    private boolean checkDuplicatedPairInSameLevel(List<Pair> pairs, List<String> selection){
        for(int i = 0; i < matchingResults.size(); i++){
            if(!matchingResults.get(i).isLevelEqual(Level.getLevel(selection.get(0)))){
                continue;
            }
            for(int j = 0; j < pairs.size(); j++){
                if(matchingResults.get(i).havePair(pairs.get(j))){
                    return true;
                }
            }
        }
        return false;
    }

    private void lookUpPairs(){
        List<String> selection;
        try{
            outputView.printCourseAndMission();
            selection = inputView.readCourseAndLevelAndMissionSelections();
            MatchingResult result = findMatchingResult(selection);
            if(result == null){
                outputView.printNoMatchingHistoryMessage();
            }
            outputView.printPairMatchingResult(result.getPairs());
        }catch(IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
            lookUpPairs();
        }
    }

    private boolean checkAlreadyPairMatching(List<String> selection){
        if(findMatchingResult(selection) != null){
            return true;
        }
        return false;
    }

    private MatchingResult findMatchingResult(List<String> selection){
        for(int i = 0; i < matchingResults.size(); i++){
            MatchingResult tmp = matchingResults.get(i);
            if(tmp.isCourseEqual(Course.getCourse(selection.get(0))) && tmp.isLevelEqual(Level.getLevel(selection.get(1))) && tmp.isMissionEqual(selection.get(2))){
                return tmp;
            }
        }
        return null;
    }

    private void initialize(){
        matchingResults = new ArrayList<>();
        outputView.printInitializeMessage();
    }

    public boolean isContinued(){
        return isContinued;
    }


}
