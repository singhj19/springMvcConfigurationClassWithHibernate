package com.springmvc.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.springmvc.model.Ticket;

@Repository
@EnableTransactionManagement
public class TicketRepositoryImpl implements TicketRepository {

	SessionFactory sessionFactory;

	public TicketRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Ticket> getTickets() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Ticket", Ticket.class).list();
	}

	@Override
	@Transactional
	public void saveTicket(Ticket ticket) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(ticket);
	}

	@Override
	@Transactional
	public Ticket getTicket(long theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Ticket theTicket = currentSession.get(Ticket.class, theId);
		return theTicket;
	}

	@Override
	@Transactional
	public void deleteTicket(long theId) {
		Session session = sessionFactory.getCurrentSession();
		Ticket ticket = session.byId(Ticket.class).load(theId);
		session.delete(ticket);
	}

	@Transactional
	@Override
	public List<Ticket> findByTitleOrDescription(String contentORdescription) {
		Session session = sessionFactory.getCurrentSession();
		Query<Ticket> query = session.createQuery(
				"FROM Ticket t WHERE t.content LIKE :keyword OR t.shortDescription LIKE :keyword", Ticket.class);
		query.setParameter("keyword", "%" + contentORdescription + "%");

		List<Ticket> tickets = query.getResultList();
		return tickets;
	}

}