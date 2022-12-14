package pairmatching.model;

import pairmatching.constant.Course;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
public class PairMatcher {

    public PairMatcher(){

    }

    public List<Pair> match(List<String> crewNames, Course course){
        List<Pair> pairs = new ArrayList<>();
        for(int i = 0; i < crewNames.size(); i++){
            if(i%2 == 1){ //i가 홀수
                continue;
            }
            Pair pair = new Pair();
            pair.add(crewNames.get(i));
            pair.add(crewNames.get(i+1));
            if(i == crewNames.size()-3){
                pair.add(crewNames.get(i+2));
                break;
            }
        }
        return pairs;
    }

    private List<String> shuffle(List<String> crewNames, Course course){
        return Randoms.shuffle(crewNames);
    }
}
