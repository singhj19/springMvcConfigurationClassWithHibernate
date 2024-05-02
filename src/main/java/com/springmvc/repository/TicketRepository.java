package com.springmvc.repository;

import java.util.List;

import com.springmvc.model.Ticket;

public interface TicketRepository {

	public List<Ticket> getTickets();

	public Ticket getTicket(long theId);

	public void deleteTicket(long theId);

	public void saveTicket(Ticket ticket);

	public List<Ticket> findByTitleOrDescription(String contentORdescription);
}