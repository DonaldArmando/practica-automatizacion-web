package co.com.ceiba.model.enums;

public enum Visibility {

    PRIVATE("private"),
    INTERNAL("internal"),
    PUBLIC("public");

    private final String nameVisibility;

    Visibility(String nameVisibility) {
        this.nameVisibility = nameVisibility;
    }

}
