package pairmatching.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public List<String> readCrewNames(String fileName){
        List<String> crewNames = new ArrayList<>();

        File file = new File(fileName);
        try {
            Scanner input = new Scanner(file);
            while(input.hasNext()) {
                String name = input.nextLine();
                crewNames.add(name);
            }
            input.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return crewNames;
    }
}
