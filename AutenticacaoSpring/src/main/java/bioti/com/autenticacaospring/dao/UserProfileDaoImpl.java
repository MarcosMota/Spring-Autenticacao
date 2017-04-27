package bioti.com.autenticacaospring.dao;

import bioti.com.autenticacaospring.model.seguranca.Perfil;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;



@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Integer, Perfil>implements UserProfileDao{

	public Perfil findById(int id) {
		return getByKey(id);
	}

	public Perfil findByType(String type) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("descricao", type));
		return (Perfil) crit.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Perfil> findAll(){
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("descricao"));
		return (List<Perfil>)crit.list();
	}
	
}
