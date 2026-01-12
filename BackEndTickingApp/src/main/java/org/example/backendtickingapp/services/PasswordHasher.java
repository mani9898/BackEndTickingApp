package org.example.backendtickingapp.services;

public interface PasswordHasher {

    String hashPassword(String password);
    boolean checkPassword(String password, String hashedPassword);
}
