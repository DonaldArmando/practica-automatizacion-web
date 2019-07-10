package co.com.ceiba.model;


import co.com.ceiba.exceptions.LoginException;
import co.com.ceiba.util.validations.Validations;

public class User {

    private final String USUARIO_VACIO = "El usuario no puede estar vacio o nulo";
    private final String CONTRASENA_VACIA = "La contraseña no puede estar vacia o nula";

    private String username;
    private String password;


    public User(String username, String password) {
        this.usernameNotEmpty(username);
        this.passwordNotEmpty(password);

        this.username = username;
        this.password = password;
    }

    private void usernameNotEmpty(String username) {
        if (Validations.isEmptyOrNull(username)) {
            throw new LoginException(USUARIO_VACIO);
        }
    }

    private void passwordNotEmpty(String password) {
        if (Validations.isEmptyOrNull(password)) {
            throw new LoginException(CONTRASENA_VACIA);
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
