package main.java.mvc.controllers;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import main.java.dao.PagingProps;
import main.java.entities.User;
import main.java.service.BadAgeException;
import main.java.service.BadUsernameException;
import main.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

@Controller
@Configuration
@ComponentScan(basePackages = "main.java.service")
public class HomeController {

    private UserService userService;

    @Autowired
    public  HomeController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/search", method = GET)
    public String search()
    {
        return "search";
    }

    @RequestMapping(value = "/search_results", method = GET)
    public ModelAndView searchResults(@RequestParam(value = "sort_by", required = false, defaultValue = "id") String sortBy,
                                      @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                      @RequestParam(value = "users_per_page", required = false, defaultValue = "10") int usersPerPage,
                                      @RequestParam(value = "order", required = false, defaultValue = "asc") String order,
                                      @RequestParam(value = "username", required = false, defaultValue ="")String username)
            throws Exception
    {
        page = Math.max(1, page);
        PagingProps props = new PagingProps(usersPerPage, sortBy, order);
        User user = new User();
        user.setUsername(username);
        List<User> userList = userService.searchUserNameLike(user, page, props);
        if(userList.isEmpty() && page != 1) {
            page = 1;
            userList = userService.searchUserNameLike(user, page, props);
        }
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("title", "Search results")
                .addAttribute("user_list", userList)
                .addAttribute("page", page)
                .addAttribute("sort_by", sortBy)
                .addAttribute("usersPerPage", usersPerPage)
                .addAttribute("order", order)
                .addAttribute("username", username)
                .addAttribute("request", "search_results");
        return new ModelAndView("users", modelMap);
    }

    @RequestMapping(value = "/users", method = GET)
    public ModelAndView users(@RequestParam(value = "sort_by", required = false, defaultValue = "id") String sortBy,
                              @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                              @RequestParam(value = "users_per_page", required = false, defaultValue = "10") int usersPerPage,
                              @RequestParam(value = "order", required = false, defaultValue = "asc") String order)
    {
        page = Math.max(1, page);
        PagingProps props = new PagingProps(usersPerPage, sortBy, order);
        List<User> userList = userService.selectAllUsers(page, props);
        if(userList.isEmpty() && page != 1) {
            page = 1;
            userList = userService.selectAllUsers(page, props);
        }
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("title", "All users")
                .addAttribute("user_list", userList)
                .addAttribute("page", page)
                .addAttribute("sort_by", sortBy)
                .addAttribute("usersPerPage", usersPerPage)
                .addAttribute("order", order)
                .addAttribute("request", "users");

        return new ModelAndView("users", modelMap);
    }

    @RequestMapping(value = "/new", method = GET)
    public ModelAndView addUserForm() {
        return new ModelAndView("/user_form", (new ModelMap())
                .addAttribute("user", new User())
                .addAttribute("form", "create")
                .addAttribute("action", "new"));
    }

    @RequestMapping(value = "/new", method = POST)
    public String addUser(@ModelAttribute User user) throws Exception{
        userService.createUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/update", method = GET)
    public ModelAndView updateUserForm(@RequestParam("user_ID") long user_ID)
    {
        User user = userService.getUserByID(user_ID);
        return new ModelAndView("/user_form", (new ModelMap())
                .addAttribute("user", user)
                .addAttribute("form", "update")
                .addAttribute("action", "update"));
    }

    @RequestMapping(value = "/update", method = POST)
    public String updateUser(@ModelAttribute User user) throws Exception{
        userService.updateUser(user);
        return"redirect:/users";
    }

    @RequestMapping(value = "/delete", method = GET)
    public String deleteUser(@RequestParam("user_ID") long user_ID)
    {
        userService.deleteUser(user_ID);
        return "redirect:/users";
    }

    @ExceptionHandler(SQLException.class)
    public String handleSQLException() {
        return "error";
    }

    @ExceptionHandler(BadUsernameException.class)
    public String handleBadUsernameException() {
        return "error";
    }

    @ExceptionHandler(BadAgeException.class)
    public String handleBadAgeException() {
        return "error";
    }
}
