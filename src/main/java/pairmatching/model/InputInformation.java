package pairmatching.model;

import pairmatching.constant.Course;
import pairmatching.constant.Level;

import java.util.List;

public class InputInformation {
    private Course course;
    private Level level;
    private String mission;

    public InputInformation(List<String> inputs){
        setCourse(inputs.get(0));
        setLevel(inputs.get(1));
        setMission(inputs.get(2));
    }

    private void setCourse(String input){
        if(Course.FRONTEND.getName().equals(input)){
            this.course = Course.FRONTEND;
            return;
        }
        this.course = Course.BACKEND;
    }
    private void setLevel(String input){
        for(int i = 0; i < Level.size(); i++){
            if(Level.get(i).getName().equals(input)){
                this.level = Level.get(i);
                return;
            }
        }
    }
    private void setMission(String input){
        this.mission = input;
    }

    public Course getCourse(){
        return course;
    }

    public Level getLevel(){
        return level;
    }

    public String getMission(){
        return mission;
    }
}
