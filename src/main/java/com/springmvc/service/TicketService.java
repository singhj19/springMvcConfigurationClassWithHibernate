package com.springmvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springmvc.model.Ticket;

@Service
public interface TicketService {
	List<Ticket> list();

	void save(Ticket ticket);

	Ticket getById(long ticketId);

	void deleteById(long ticketId);

	List<Ticket> searchByCreatedOnEmpty(String contentORdescription);
}