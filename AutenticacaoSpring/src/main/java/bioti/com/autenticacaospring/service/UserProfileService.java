package bioti.com.autenticacaospring.service;

import bioti.com.autenticacaospring.model.seguranca.Perfil;
import java.util.List;


public interface UserProfileService {

	Perfil findById(int id);

	Perfil findByType(String type);
	
	List<Perfil> findAll();
	
}
