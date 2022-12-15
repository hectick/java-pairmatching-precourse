package pairmatching.constant;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Level {
    LEVEL1("레벨1", Arrays.asList("자동차경주", "로또", "숫자야구게임")),
    LEVEL2("레벨2", Arrays.asList("장바구니", "결제", "지하철노선도")),
    LEVEL3("레벨3", Collections.EMPTY_LIST),
    LEVEL4("레벨4", Arrays.asList("성능개선", "배포")),
    LEVEL5("레벨5", Collections.EMPTY_LIST);

    private String name;
    private List<String> missions;
    private static final Level[] list = Level.values();
    private static final int size = list.length;

    Level(String name, List<String> missions) {
        this.name = name;
        this.missions = missions;
    }

    public static Level get(int index){
        return list[index];
    }

    public static int size(){
        return size;
    }

    public String getName(){
        return name;
    }

    public List<String> getMissions(){
        return missions;
    }

    public boolean contains(String mission){
        if(this.missions.contains(mission)){
            return true;
        }
        return false;
    }
}
