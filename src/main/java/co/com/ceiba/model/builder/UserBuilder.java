package co.com.ceiba.model.builder;

import co.com.ceiba.model.User;

public class UserBuilder {

    private String username;
    private String password;

    private UserBuilder(String username) {
        this.username = username;
        this.password = "";
    }

    public static UserBuilder conUsername(String username) {
        return new UserBuilder(username);
    }

    public UserBuilder conPassword(String password) {
        this.password = password;
        return this;
    }

    public User build() {
        return new User(this.username, this.password);
    }

}
