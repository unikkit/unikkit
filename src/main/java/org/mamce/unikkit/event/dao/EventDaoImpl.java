package org.mamce.unikkit.event.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.mamce.unikkit.dao.support.UnikkITDaoSupport;
import org.mamce.unikkit.model.event.Event;

/**
 * @author Ramesh
 *
 */
public class EventDaoImpl extends UnikkITDaoSupport<Event> implements EventDao {

	@Override
	public List<Event> findAllEvents() {
		Criteria criteria = getSession().createCriteria(Event.class);
		criteria.add(Expression.eq("active", true));
		return criteria.list();
	}

	@Override
	public Event findEventById(long id) {
		return (Event) getHibernateTemplate().get(Event.class, id);
	}

	@Override
	public void saveEvent(Event event) {
		saveObject(event);
	}

	@Override
	public void saveAllEvents(List<Event> events) {
		saveAll(events);		
	}

	@Override
	public List<Event> findLatestEvents() {
		Criteria criteria = getSession().createCriteria(Event.class);
		criteria.addOrder(Order.asc("startDate"));
		criteria.add(Expression.eq("active", true));
		
		return criteria.list();
	}

	@Override
	public List<Event> findLatestEvents(int maxLatestEvents) {
		Criteria criteria = getSession().createCriteria(Event.class);
		criteria.addOrder(Order.asc("startDate"));
		criteria.add(Expression.eq("active", true));
		criteria.setMaxResults(maxLatestEvents);
		criteria.setCacheable(true);
		
		return criteria.list();
	}

}
