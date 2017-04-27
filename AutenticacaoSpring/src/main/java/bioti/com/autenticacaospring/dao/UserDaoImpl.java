package bioti.com.autenticacaospring.dao;

import bioti.com.autenticacaospring.model.seguranca.Usuario;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;




@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, Usuario> implements UserDao {

	static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	public Usuario findById(int id) {
		Usuario user = getByKey(id);
		if(user!=null){
			Hibernate.initialize(user.getUsuarioPerfils());
		}
		return user;
	}

	public Usuario findBySSO(String sso) {
		logger.info("SSO : {}", sso);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("usuario", sso));
		Usuario user = (Usuario)crit.uniqueResult();
		if(user!=null){
			Hibernate.initialize(user.getUsuarioPerfils());
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> findAllUsers() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("nome"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Usuario> users = (List<Usuario>) criteria.list();
		
		// No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
		// Uncomment below lines for eagerly fetching of userProfiles if you want.
		/*
		for(Usuario user : users){
			Hibernate.initialize(user.getUserProfiles());
		}*/
		return users;
	}

	public void save(Usuario user) {
		persist(user);
	}

	public void deleteBySSO(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("usuario", sso));
		Usuario user = (Usuario)crit.uniqueResult();
		delete(user);
	}

}
