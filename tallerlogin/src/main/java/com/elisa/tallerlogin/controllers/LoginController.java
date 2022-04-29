package com.elisa.tallerlogin.controllers;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elisa.tallerlogin.models.dtos.UserResponseDTO;
import com.elisa.tallerlogin.models.dtos.UserSearchDTO;
import com.elisa.tallerlogin.models.entities.User;

@Controller
@RequestMapping("/login")
public class LoginController {

	private static final List<User> Users = Arrays.asList(
            new User("DE346809", "Alexander", 	"15/03/19", "activo" , 		"admin",	"carmen", 0, 0),
            new User("BC125634", "Carmen ", 		"17/07/20", "inactivo" ,	"user",		"alex", 0, 0),
            new User("LI098823", "Dennys ", 		"15/03/22", "inactivo", 	"user",		"anime", 0, 0),
            new User("RT982345", "Rodrigo ", 		"22/09/21",	"activo", 		"admin",	"sidemen", 0, 0),
            new User("PL129234", "Ernesto ",	"14/12/18", "inactivo", 	"user",		"elisa", 0, 0),
            new User("ED342156", "Elisa ", 		"24/02/21", "activo", 		"user",		"alexander", 0, 0),
            new User("CE912938", "Alberto ", 	"30/01/20", "activo", 		"admin",	"onepiece", 0, 0),
            new User("AE342199", "Antonio ", 		"23/03/22", "inactivo",		"admin",	"formulaone", 0, 0),
            new User("DA001234", "Jonathan ",	"30/03/19", "activo", 		"user",		"rally", 0, 0),
            new User("RA321189", "Alexis ", 		"31/07/17", "activo", 		"admin",	"drifting", 0, 01)
        );
	
	@GetMapping("/")
	public String getLoginPage(Model model) {
		
		return "main";
	}
	
	@PostMapping("/user")
	private String requestUserPage(@ModelAttribute UserSearchDTO search, Model model) {
		
		String time = Calendar.getInstance().getTime().toString();
		model.addAttribute("time", time);
		
		String code = search.getCodigo();
		String contra = search.getContrasena();
		
		User foundUser = Users.stream()
				.filter((user)-> user.getCodigo().equals(code))
				.filter((user)-> user.getContrasena().equals(contra)) 
				.findAny()
				.orElse(new User("", "", "", "", "", "", 0, 0));
		
		List<String> empleadosN = Users
				.stream()
				.map((user) -> {
					
					return user.getNombre();
				})
				.toList();
		
		List<String> empleadosF = Users
				.stream()
				.map((user) -> {
					
					return user.getFecha();
				})
				.toList();
		
		List<String> empleadosR = Users
				.stream()
				.map((user) -> {
					
					return user.getRol();
				})
				.toList();
		
		UserResponseDTO response = 
				new UserResponseDTO(foundUser.getNombre(), empleadosN, empleadosF, empleadosR);
		
		model.addAttribute("u", response);
		
		if(foundUser.getRol().equals("user") && foundUser.getEstado().equals("activo") && !foundUser.getFecha().equals("15/03/22")
				&& !foundUser.getFecha().equals("23/03/22")) {
			return "user";
		}
		else if(foundUser.getRol().equals("admin") && foundUser.getEstado().equals("activo") && !foundUser.getFecha().equals("15/03/22")
				&& !foundUser.getFecha().equals("23/03/22")){
			return "admin";
		}
		else {
			return "error";
		}
	}
}
