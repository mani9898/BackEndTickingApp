package org.example.backendtickingapp.services;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class Sha256PasswordHasher implements PasswordHasher {


    @Override
    public String hashPassword(String password) {

        return BCrypt.hashpw(password, BCrypt.gensalt());
    }


    @Override
    public boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
