package bioti.com.autenticacaospring.service;

import bioti.com.autenticacaospring.dao.UserProfileDao;
import bioti.com.autenticacaospring.model.Perfil;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService{
	
	@Autowired
	UserProfileDao dao;
	
	public Perfil findById(int id) {
		return dao.findById(id);
	}

	public Perfil findByType(String type){
		return dao.findByType(type);
	}

	public List<Perfil> findAll() {
		return dao.findAll();
	}
}
