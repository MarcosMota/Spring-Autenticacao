package bioti.com.autenticacaospring.dao;

import bioti.com.autenticacaospring.model.Perfil;
import java.util.List;



public interface UserProfileDao {

	List<Perfil> findAll();
	
	Perfil findByType(String type);
	
	Perfil findById(int id);
}
