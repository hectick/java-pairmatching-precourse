package pairmatching.controller;

import pairmatching.constant.Function;
import pairmatching.model.InputInformation;
import pairmatching.model.MatchingResult;
import pairmatching.view.InputView;
import pairmatching.view.OutputView;

import java.util.List;

public class MainController {
    private boolean isContinued;
    private PairMatchingController pairMatchingController;

    public MainController(){
        isContinued = true;
        pairMatchingController = new PairMatchingController();
    }

    public void execute(){
        String option = selectFunction();
        if(option.equals(Function.PAIR_MATCH.getOption())){
            matchPairs();
        }
        if(option.equals(Function.PAIR_DISPLAY.getOption())){
            displayPairs();
        }
        if(option.equals(Function.PAIR_INITIALIZE.getOption())){
            initializePairs();
        }
        if(option.equals(Function.QUIT.getOption())){
            isContinued = false;
        }
    }

    private String selectFunction(){
        try{
            OutputView.printFunctions();
            String input = InputView.readFunctionSelection();
            return input;
        }catch(IllegalArgumentException e){
            OutputView.printErrorMessage(e.getMessage());
            return selectFunction(); //return 써주기!
        }
    }

    private void matchPairs(){
        try{
            OutputView.printCourseAndMission();
            List<String> inputs = InputView.readCourseAndLevelAndMissionSelections();
            pairMatchingController.execute(convert(inputs));
        }catch(IllegalArgumentException e){
            OutputView.printErrorMessage(e.getMessage());
            matchPairs();
        }
    }

    private void displayPairs(){
        try{
            OutputView.printCourseAndMission();
            List<String> inputs = InputView.readCourseAndLevelAndMissionSelections();
            MatchingResult result = pairMatchingController.searchMatchingResult(convert(inputs));
            if(result == null){
                OutputView.printNoMatchingHistoryMessage();
                return;
            }
            OutputView.printPairMatchingResult(result.getPairs());
        }catch(IllegalArgumentException e){
            OutputView.printErrorMessage(e.getMessage());
            displayPairs();
        }
    }

    private void initializePairs(){
        pairMatchingController.reset();
        OutputView.printInitializeMessage();
    }

    public boolean isContinued(){
        return isContinued;
    }

    private InputInformation convert(List<String> inputs){
        return new InputInformation(inputs);
    }



}
