package co.com.ceiba.model.enums;

public enum Template {

    SPRING("spring"),
    RUBY_ON_RAILS("ruby on rails"),
    NODEJS_EXPRESS("nodejs express"),
    NETCORE("net core");

    private final String templateName;

    Template(String templateName) {
        this.templateName = templateName;
    }
}
