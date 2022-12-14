package pairmatching.model;

import pairmatching.constant.Course;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
public class PairMatcher {

    public PairMatcher(){

    }

    public List<Pair> match(List<String> crewNames){
        List<Pair> pairs = new ArrayList<>();
        crewNames = shuffle(crewNames);
        for(int i = 0; i < crewNames.size(); i++){
            if(i%2 == 1){ //i가 홀수
                continue;
            }
            Pair pair = new Pair();
            pair.add(crewNames.get(i));
            pair.add(crewNames.get(i+1));
            if(i == crewNames.size()-3){
                pair.add(crewNames.get(i+2));
                pairs.add(pair);
                break;
            }
            pairs.add(pair);
        }
        return pairs;
    }

    private List<String> shuffle(List<String> crewNames){
        return Randoms.shuffle(crewNames);
    }
}
