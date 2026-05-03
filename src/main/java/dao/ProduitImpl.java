package dao;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * 
 * @Transactional
 */
@Transactional
public class ProduitImpl implements ProduitDAO {

	// Injecte par Spring via spring-beans.xml
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addProduit(Produit p) {
		sessionFactory.getCurrentSession().save(p);
	}

	@Override
	public void deleteProduit(Long id) {
		Produit p = getProduitById(id);
		if (p != null) {
			sessionFactory.getCurrentSession().delete(p);
		}
	}

	@Override
	public Produit getProduitById(Long id) {
		return sessionFactory.getCurrentSession().get(Produit.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Produit> getAllProduits() {
		return sessionFactory.getCurrentSession().createQuery("FROM Produit").list();
	}

	@Override
	public void updateProduit(Produit p) {
		sessionFactory.getCurrentSession().update(p);
	}
}