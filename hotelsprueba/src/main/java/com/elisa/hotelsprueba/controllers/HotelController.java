package com.elisa.hotelsprueba.controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elisa.hotelsprueba.services.HotelService;
import com.elisa.hotelsprueba.models.dtos.HotelAddDTO;
import com.elisa.hotelsprueba.models.dtos.HotelDeleteDTO;
import com.elisa.hotelsprueba.models.dtos.HotelResponseDTO;
import com.elisa.hotelsprueba.models.dtos.HotelSearchDTO;
import com.elisa.hotelsprueba.models.dtos.MainResponseDTO;
import com.elisa.hotelsprueba.models.entities.Hotel;

@Controller
@RequestMapping("/hotels")
public class HotelController {
	

	@Autowired
	private HotelService hotelService;
	
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getMainPage(Model model) {
			
			List<String> nombres = hotelService.getAllNames();
			
			MainResponseDTO responses = new MainResponseDTO(nombres);
			
			model.addAttribute("search", new HotelSearchDTO(""));
			model.addAttribute("info", responses);
			
			
		return "main";
	}
	
	@PostMapping("/info")
	private String requestHotelPage(@ModelAttribute(name = "search") @Valid HotelSearchDTO search, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "maincopy";
		}
		
		String nombre = search.getNombre();
		Hotel foundH = hotelService.getOneByName(nombre);
		
		if(foundH == null) {
			model.addAttribute("error", "Hotel no encontrado");
			return "maincopy";
		}
		
		
		HotelResponseDTO response = new HotelResponseDTO(foundH.getCodigo(), search.getNombre(), foundH.getDireccion(), foundH.getTelefono(), foundH.getCategoria(), foundH.getHabitaciones());
		
		model.addAttribute("info", response);
		
		return "info";
	}
	
	@GetMapping("info/add")
	public String getAddPage(Model model) {
		model.addAttribute("info", new HotelAddDTO("", "", "", "", 0, 0));
		return "add_hotel";
	}
	
	@PostMapping("/info/add")
	public String addHotel(@ModelAttribute(name="info") @Valid HotelAddDTO hotelInfo, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "add_hotel";
		}
		
		Hotel foundHotel = hotelService.getOneByName(hotelInfo.getNombre());
		
		if(foundHotel != null) {
			model.addAttribute("error", "Este hotel ya existe");
			return "add_hotel";
		}
		
		hotelService.insert(new Hotel(hotelInfo.getCodigo(), hotelInfo.getNombre(), hotelInfo.getDireccion(), hotelInfo.getTelefono(), hotelInfo.getCategoria(), hotelInfo.getHabitaciones()));
		
		return "redirect:/hotels/";
		
	}
	
	@GetMapping("/info/delete")
	public String getDeletePage(Model model) {
		model.addAttribute("info", new HotelDeleteDTO(""));
		return "maineliminate";
	}
	
	@PostMapping("/info/delete")
	public String deleteHotel(@ModelAttribute(name="info") @Valid HotelDeleteDTO hotelI, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "maineliminate";
		}
		
		Hotel foundN = hotelService.getOneByName(hotelI.getNombre());
		
		if(foundN == null) {
			model.addAttribute("error", "Este hotel no existe");
			return "maineliminate";
		}
		
		hotelService.delete(hotelI.getNombre());
		return "redirect:/hotels/";
	}
}

