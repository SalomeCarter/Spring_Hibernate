package by.tms.controller;

import by.tms.dto.LoginUserDto;
import by.tms.entity.User;
import by.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/reg")
    public String reg(Model model) {
        model.addAttribute("newUser", new User());
        return "reg";
    }

    @PostMapping("/reg")
    public String reg(@ModelAttribute("newUser") @Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "reg";
        }
        userService.save(user);
        return "redirect:/";
    }


    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("newLogin", new LoginUserDto());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("newLogin") @Valid LoginUserDto loginUserDto,
                        BindingResult bindingResult,
                        HttpSession session,
                        Model model) {
        Optional<User> byUsername = userService.findByUsername(loginUserDto);
        if (bindingResult.hasErrors()) {
            setValidationErrors(bindingResult, model);
            model.addAttribute("newUser", loginUserDto);
            return "login";
        }
        if (byUsername.isPresent()) {
            User user = byUsername.get();
            session.setAttribute("user", user);
            return "redirect:/";
        }
        else {
            model.addAttribute("errorLogin", "Wrong username or password");
            return "login";
        }
    }


    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }

    private void setValidationErrors(BindingResult bindingResult, Model model) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            model.addAttribute(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }
}