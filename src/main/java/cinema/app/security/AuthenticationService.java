package cinema.app.security;

import cinema.app.exception.AuthenticationException;
import cinema.app.exception.RegistrationException;
import cinema.app.model.User;

public interface AuthenticationService {
    User login(String email, String password) throws AuthenticationException;

    User register(String email, String password) throws RegistrationException;
}
