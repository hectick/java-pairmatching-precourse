package pairmatching.controller;

import pairmatching.constant.Course;
import pairmatching.constant.Level;
import pairmatching.constant.OutputMessage;
import pairmatching.model.*;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class PairMatchingController {
    private List<String> backendCrewNames;
    private List<String> frontendCrewNames;
    private PairMatcher matcher;
    private List<MatchingResult> matchingResults;

    public PairMatchingController(){
        setCrewNamesList();
        matcher = new PairMatcher();
        matchingResults = new ArrayList<>();
    }

    private void setCrewNamesList(){
        FileReader reader = new FileReader();
        backendCrewNames = reader.readCrewNames("./src/main/resources/backend-crew.md");
        frontendCrewNames = reader.readCrewNames("./src/main/resources/frontend-crew.md");
    }

    public void execute(InputInformation inputs){
        String sign = "네";
        try{
            if(isAlreadyMatched(inputs)){
                OutputView.printRematchingMessage();
                sign = InputView.readRematchingSelection();
            }
            if(sign.equals("아니오")){
                return;
            }
            runPairMatcher(inputs);
        }catch(IllegalArgumentException e){
            OutputView.printErrorMessage(e.getMessage());
            execute(inputs);
        }
    }

    private void runPairMatcher(InputInformation inputs){
        int duplication = 0;
        List<String> crewNames = getBackOrFrontCrewNameList(inputs.getCourse());
        List<Pair> pairs;
        while(true){
            pairs = matcher.match(crewNames);
            if(pairs.size() == 0){
                OutputView.printErrorMessage(OutputMessage.NO_MORE_MATCHING_MESSAGE);
                return;
            }
            if(!isDuplicatedPairInSameLevel(pairs, inputs)){
                break;
            }
            duplication++;
            if(duplication >= 3){
                OutputView.printErrorMessage(OutputMessage.NO_MORE_MATCHING_MESSAGE);
                return;
            }
        }
        MatchingResult result = new MatchingResult(pairs, inputs.getCourse(), inputs.getLevel(), inputs.getMission());
        matchingResults.add(result);
        OutputView.printPairMatchingResult(result.getPairs());
    }

    private List<String> getBackOrFrontCrewNameList(Course course){
        if(Course.BACKEND.equals(course)){
            return backendCrewNames;
        }
        return frontendCrewNames;
    }
    private boolean isDuplicatedPairInSameLevel(List<Pair> pairs, InputInformation inputs){
        for(int i = 0; i < matchingResults.size(); i++){
            if(!matchingResults.get(i).isLevelEqual(inputs.getLevel())){
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

    private boolean isAlreadyMatched(InputInformation inputs){
        if(searchMatchingResult(inputs) == null){
            return false;
        }
        return true;
    }

    public MatchingResult searchMatchingResult(InputInformation inputs){
        for(int i = 0; i < matchingResults.size(); i++){
            MatchingResult tmp = matchingResults.get(i);
            if(tmp.isCourseEqual(inputs.getCourse()) && tmp.isLevelEqual(inputs.getLevel()) && tmp.isMissionEqual(inputs.getMission())){
                return tmp;
            }
        }
        return null;
    }

    public void reset(){
        matchingResults = new ArrayList<>();
    }
}
