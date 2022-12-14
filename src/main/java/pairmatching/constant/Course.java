package pairmatching.constant;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public boolean isNameEqual(String name){
        if(this.name.equals(name)){
            return true;
        }
        return false;
    }

    // 추가 기능 구현
}
