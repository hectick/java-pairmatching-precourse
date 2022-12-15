package pairmatching.constant;

public enum Function {
    PAIR_MATCH("1"),
    PAIR_DISPLAY("2"),
    PAIR_INITIALIZE("3"),
    QUIT("Q"),

    private String option;

    Function(String option) {
        this.option = option;
    }

    public String getOption(){
        return this.option;
    }

}
