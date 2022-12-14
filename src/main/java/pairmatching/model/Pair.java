package pairmatching.model;

import java.util.ArrayList;
import java.util.List;

public class Pair {
    List<String> pairCrewNames;

    public Pair(){
        pairCrewNames = new ArrayList<>();
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


}
