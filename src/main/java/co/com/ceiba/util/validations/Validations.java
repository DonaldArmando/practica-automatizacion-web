package co.com.ceiba.util.validations;


import java.util.Objects;

public class Validations {

    private Validations() {
    }

    public static boolean isNotEmptyOrNull(String value) {
        return !isEmptyOrNull(value);
    }

    public static boolean isEmptyOrNull(String value) {
        return value == null || value.isEmpty();
    }

    public static boolean isNull(Object object) {
        return Objects.isNull(object);
    }

}
