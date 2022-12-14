package pairmatching.view;

import pairmatching.model.Pair;

import java.util.List;

public class OutputView {

    public void printFunctions(){
        System.out.println("기능을 선택하세요.");
        System.out.println("1. 페어 매칭");
        System.out.println("2. 페어 조회");
        System.out.println("3. 페어 초기화");
        System.out.println("Q. 종료");
    }

    public void printPairMatchingResult(List<Pair> pairs){
        System.out.println("페어 매칭 결과입니다.");
        for(int i = 0; i < pairs.size(); i++){
            System.out.println(pairs.get(i).getPairStatement());
        }
    }
}
