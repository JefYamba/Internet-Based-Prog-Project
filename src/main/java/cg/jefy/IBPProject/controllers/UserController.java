package cg.jefy.IBPProject.controllers;

import cg.jefy.IBPProject.dtos.AppUserDTO;
import cg.jefy.IBPProject.entities.Role;
import cg.jefy.IBPProject.services.AppUserService;
import cg.jefy.IBPProject.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author: JefYamba
 */
@Controller
@AllArgsConstructor
@RequestMapping("users")
public class UserController {

    private final AppUserService userService;
    private final RoleService roleService;

    @GetMapping({"","/"})
    public String getUsersPage(Model model){
        model.addAttribute("users", userService.getAllUsers());

        return "pages/user-list";
    }


    @GetMapping("/new")
    public String getEditUserPage(Model model){
        model.addAttribute("user", new AppUserDTO());

        String[] roles = roleService.getAllRoles().stream().map(Role::getRole).toArray(String[]::new);
        model.addAttribute("roles", roles);

        return "pages/add-user";
    }



    @PostMapping("/add")
    public String addNewUser(@ModelAttribute("user") AppUserDTO appUserDTO){
        userService.addUser(appUserDTO);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String getUpdateUserPage(@PathVariable("id") Long id, Model model){

        model.addAttribute("user", userService.getUserById(id));

        String[] roles = roleService.getAllRoles().stream().map(Role::getRole).toArray(String[]::new);
        model.addAttribute("roles", roles);

        return "pages/edit-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") AppUserDTO appUserDTO){

        userService.updateUser(id, appUserDTO);
        return "redirect:/users";
    }

    @GetMapping("/view/{id}")
    public String getUserDetailsPage(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "pages/user-details";
    }


    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return  "redirect:/users";
    }

    @GetMapping("/profile")
    public String getProfilePage(Model model){

        // TODO get the current user object class and send to the profile page
        model.addAttribute("user", new AppUserDTO());
        return "pages/user-profile";
    }

    @GetMapping("/profile/update")
    public String getProfileUpdatePage(Model model){

        // TODO get the current user object class and send to the update profile page
        model.addAttribute("user", new AppUserDTO());

        return "pages/update-profile";
    }
    @PostMapping("/profile/update/{id}")
    public String profileUpdate(@PathVariable("id") Long id, @ModelAttribute("user") AppUserDTO appUserDTO){

        // TODO update operation of the current user

        return "redirect:/users/profile";
    }

    @GetMapping("/profile/update-password")
    public String getUpdatePasswordPage(){

        return "pages/update-password";
    }
    @GetMapping("/profile/update-password/register")
    public String updatePassword(){

        // TODO update operation of the current user

        return "redirect:/users/profile";
    }

}
