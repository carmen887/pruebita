package com.elisa.hotelsprueba.services;

import java.util.List;

import com.elisa.hotelsprueba.models.entities.Hotel;

public interface HotelService {

	void insert(Hotel hotel);
	void delete(String nombre);
	Hotel getOneByName(String nombre);
	List <Hotel> getAll();
	List <String> getAllNames();
	
}
