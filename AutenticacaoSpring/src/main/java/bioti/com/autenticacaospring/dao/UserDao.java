package bioti.com.autenticacaospring.dao;

import bioti.com.autenticacaospring.model.seguranca.Usuario;
import java.util.List;



public interface UserDao {

	Usuario findById(int id);
	
	Usuario findBySSO(String sso);
	
	void save(Usuario user);
	
	void deleteBySSO(String sso);
	
	List<Usuario> findAllUsers();

}

