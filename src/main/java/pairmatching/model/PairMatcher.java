package pairmatching.model;

import pairmatching.constant.Course;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
public class PairMatcher {

    public PairMatcher(){

    }
    /*
    public List<String> match(List<String> crewNames, Course course){

    }
    */

    private List<String> shuffle(List<String> crewNames, Course course){
        return Randoms.shuffle(crewNames);
    }
}
