package pairmatching;

import pairmatching.model.FileReader;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        FileReader reader = new FileReader();
        List<String> list = reader.readCrewNames("./src/main/resources/backend-crew.md");

        System.out.println(list);

    }
}
