package testing.sora.Rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import testing.sora.Exception.LoginExistException;
import testing.sora.Exception.PasswordExistException;
import testing.sora.Service.LoginService;

@RestController
@RequestMapping("/main")
public class Login {
    private LoginService userService;
    private Login(LoginService userService){
        this.userService = userService;
    }
    @PostMapping("/login")
    public ResponseEntity login(@RequestParam String login, String password) throws PasswordExistException, LoginExistException {
        userService.login(login,password);
        return ResponseEntity.ok("Авторизация выполнена успешно");
    }
}
