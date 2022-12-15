package pairmatching;

import pairmatching.controller.MainController;

public class Application {
    public static void main(String[] args) {
        // TODO 구현 진행
        MainController controller = new MainController();
        while(controller.isContinued()){
            controller.execute();
        }
    }
}
