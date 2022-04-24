package com.elisa.hotelsprueba.controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elisa.hotelsprueba.models.dtos.HotelResponseDTO;
import com.elisa.hotelsprueba.models.dtos.HotelSearchDTO;
import com.elisa.hotelsprueba.models.dtos.MainResponseDTO;
import com.elisa.hotelsprueba.models.entities.Hotel;

@Controller
@RequestMapping("/hotels")
public class HotelController {
	

	private static final List<Hotel> hotel = Arrays.asList(
			new Hotel("0102", "Hotel Bendicion de Dios",  "Avenida Quetzal", 			"2278-9011", 5, 30),
			new Hotel("5155", "Hotel La Manzana", 	    "5ta Calle Poniente",  		"2843-0103", 3, 10),
			new Hotel("0001", "Hotel UCA", 				"Boulevard los Proceres", 	"2210-6600", 5, 100),
			new Hotel("1739", "Hotel de Mario", 		    "Calle los Rodeos", 		"2703-9481", 2, 15),
			new Hotel("7392", "Hotel de Oro", 			"Autopista de Oro",			"2946-5218", 4, 25)
			
		);
	

	@GetMapping("/")
	public String getMainPage(Model model) {
		model.addAttribute("search", new HotelSearchDTO(""));
			
			List<String> nombres = hotel
					.stream()
					.map((hotel) -> {
						return hotel.getNombre();
					})
					.toList();
			
			MainResponseDTO responses = new MainResponseDTO(nombres);
			
			model.addAttribute("main", responses);
			
			
		return "main";
	}
	
	@PostMapping("/info")
	private String requestHotelPage(@ModelAttribute(name = "search") @Valid HotelSearchDTO search, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "maincopy";
		}
		
		String nombre = search.getNombre();
		
		Hotel foundH = hotel.stream()
			 .filter((h) -> h.getNombre().equals(nombre))
			 .findAny()
			 .orElse(new Hotel("", "", "", "", 0,0));
		
		
		HotelResponseDTO response = new HotelResponseDTO(foundH.getCodigo(), search.getNombre(), foundH.getDireccion(), foundH.getTelefono(), foundH.getCategoria(), foundH.getHabitaciones());
		
		model.addAttribute("info", response);
		return "info";
	}
}

