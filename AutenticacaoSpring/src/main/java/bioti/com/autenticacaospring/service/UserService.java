package bioti.com.autenticacaospring.service;

import bioti.com.autenticacaospring.model.seguranca.Usuario;
import java.util.List;


public interface UserService {
	
	Usuario findById(int id);
	
	Usuario findBySSO(String sso);
	
	void saveUser(Usuario user);
	
	void updateUser(Usuario user);
	
	void deleteUserBySSO(String sso);

	List<Usuario> findAllUsers(); 
	
	boolean isUserSSOUnique(Integer id, String sso);

}