package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    List<String> pairCrewNames;

    public Pair(){
        pairCrewNames = new ArrayList<>();
    }

    public List<String> getPairCrewNames(){
        return pairCrewNames;
    }

    public int size(){
        return pairCrewNames.size();
    }

    public void add(String crewName){
        pairCrewNames.add(crewName);
    }

    public String getPairStatement(){
        String pairStatement = "";
        for(int i = 0; i < size(); i++){
            pairStatement += pairCrewNames.get(i);
            if(i < size() - 1){
                pairStatement += " : ";
            }
        }
        return pairStatement;
    }

    public boolean contains(String crewName){
        for(int i = 0; i < pairCrewNames.size(); i++){
            if(pairCrewNames.get(i).equals(crewName)){
                return true;
            }
        }
        return false;
    }



}
