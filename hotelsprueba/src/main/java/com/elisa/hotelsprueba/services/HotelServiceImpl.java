package com.elisa.hotelsprueba.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.elisa.hotelsprueba.models.entities.Hotel;

@Service
public class HotelServiceImpl implements HotelService{
	
	private static List<Hotel> hotel = new ArrayList<>();
	static {
		hotel.add(new Hotel("0102", "Hotel Bendicion de Dios",  "Avenida Quetzal", 			"2278-9011", 5, 30));
		hotel.add(new Hotel("5155", "Hotel La Manzana", 	    "5ta Calle Poniente",  		"2843-0103", 3, 10));
		hotel.add(new Hotel("0001", "Hotel UCA", 				"Boulevard los Proceres", 	"2210-6600", 5, 100));
		hotel.add(new Hotel("1739", "Hotel de Mario", 		    "Calle los Rodeos", 		"2703-9481", 2, 15));
		hotel.add(new Hotel("7392", "Hotel de Oro", 			"Autopista de Oro",			"2946-5218", 4, 25));
    
	}

	@Override
	public void insert(Hotel h) {
		hotel.add(h);
		System.out.println("Hotel guardado!");
	}

	@Override
	public void delete(String nombre) {
		hotel = hotel.stream()
				.filter(h -> !h.getNombre().equals(nombre))
				.toList();
	}
	
	@Override
	public Hotel getOneByName(String nombre) {
		Hotel foundH = hotel.stream()
				 .filter((h) -> h.getNombre().equals(nombre))
				 .findAny()
				 .orElse(null);
		
		return foundH;
	}

	@Override
	public List<Hotel> getAll() {
		return new ArrayList<>(hotel);
	}

	@Override
	public List<String> getAllNames() {
		List<String> nombres = hotel
				.stream()
				.map((hotel) -> {
					return hotel.getNombre();
				})
				.toList();
		
		return nombres;
	}

}
