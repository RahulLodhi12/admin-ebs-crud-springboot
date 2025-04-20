package ebs.management.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    // Hardcoded login credentials
    private final String ADMIN_USERNAME = "admin";
    private final String ADMIN_PASSWORD = "password123";

    @GetMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
            return "Login successful. You can now access customer operations.";
        } else {
            return "Invalid credentials. Access denied.";
        }
    }
}
