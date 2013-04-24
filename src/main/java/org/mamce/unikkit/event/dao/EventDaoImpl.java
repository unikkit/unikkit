package org.mamce.unikkit.event.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.mamce.unikkit.dao.support.UnikkITDaoSupport;
import org.mamce.unikkit.model.event.Event;

/**
 * @author IT09B007 - Ganesh
 *
 */
public class EventDaoImpl extends UnikkITDaoSupport<Event> implements EventDao {

	@Override
	public List<Event> findAllEvents() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Event.class);
		criteria.add(Expression.eq("active", true));
		
		return getHibernateTemplate().findByCriteria(criteria);
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
		DetachedCriteria criteria = DetachedCriteria.forClass(Event.class);
		criteria.add(Expression.eq("active", true));
		criteria.addOrder(Order.asc("startDate"));
		
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public List<Event> findLatestEvents(int maxLatestEvents) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Event.class);
		criteria.add(Expression.eq("active", true));
		criteria.addOrder(Order.asc("startDate"));
		
		getHibernateTemplate().setMaxResults(maxLatestEvents);
		return getHibernateTemplate().findByCriteria(criteria);
	}

}
