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



}
