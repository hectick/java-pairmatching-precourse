package pairmatching.model;

import pairmatching.constant.Course;
import pairmatching.constant.Level;

import java.util.List;

public class MatchingResult {
    private Course course;
    private Level level;
    private String mission;
    private List<Pair> pairs;

    public MatchingResult(List<Pair> pairs, Course course, Level level, String mission){
        this.pairs = pairs;
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

    public boolean isCourseEqual(Course course){
        if(this.course.equals(course)){
            return true;
        }
        return false;
    }

    public boolean isLevelEqual(Level level){
        if(this.level.equals(level)){
            return true;
        }
        return false;
    }

    public boolean isMissionEqual(String mission){
        if(this.mission.equals(mission)){
            return true;
        }
        return false;
    }

    public List<Pair> getPairs(){
        return pairs;
    }

    public boolean havePair(Pair pair){
        for(int i = 0; i < pairs.size(); i++){
            int count = 0;
            if(pairs.get(i).contains(pair.getPairCrewNames().get(0))){
                count ++;
            }
            if(pairs.get(i).contains(pair.getPairCrewNames().get(1))){
                count ++;
            }
            if(pair.getPairCrewNames().size() == 3 && pairs.get(i).contains(pair.getPairCrewNames().get(2))){
                count ++;
            }
            if(count >= 2){
                return true;
            }
        }
        return false;
    }


}
