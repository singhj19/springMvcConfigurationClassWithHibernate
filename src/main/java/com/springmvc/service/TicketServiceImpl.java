package com.springmvc.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.model.Ticket;
import com.springmvc.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	private TicketRepository ticketRepository;

	@Autowired
	public void setTicketRepository(TicketRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}

	@Override
	public List<Ticket> list() {
		return ticketRepository.getTickets();
	}

	@Override
	public void save(Ticket ticket) {

		LocalDate currentDate = LocalDate.now();
		java.sql.Date sqlDate = java.sql.Date.valueOf(currentDate);

		ticket.setCreatedOn(sqlDate);
		ticketRepository.saveTicket(ticket);
	}

	@Override
	public Ticket getById(long ticketId) {
		return ticketRepository.getTicket(ticketId);
	}

	@Override
	public void deleteById(long ticketId) {
		ticketRepository.deleteTicket(ticketId);
	}

	@Override
	public List<Ticket> searchByCreatedOnEmpty(String contentORdescription) {
		List<Ticket> tickets = ticketRepository.findByTitleOrDescription(contentORdescription);
		return tickets;
	}
}