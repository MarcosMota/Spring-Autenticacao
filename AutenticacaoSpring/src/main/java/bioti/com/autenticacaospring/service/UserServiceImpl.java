package bioti.com.autenticacaospring.service;

import bioti.com.autenticacaospring.dao.UserDao;
import bioti.com.autenticacaospring.model.seguranca.Usuario;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;

	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public Usuario findById(int id) {
		return dao.findById(id);
	}

	public Usuario findBySSO(String sso) {
		Usuario user = dao.findBySSO(sso);
		return user;
	}

	public void saveUser(Usuario user) {
		user.setSenha(passwordEncoder.encode(user.getSenha()));
		dao.save(user);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	public void updateUser(Usuario user) {
		Usuario entity = dao.findById(user.getId());
		if(entity!=null){
			entity.setUsuario(user.getUsuario());
			if(!user.getSenha().equals(entity.getSenha())){
				entity.setSenha(passwordEncoder.encode(user.getSenha()));
			}
			entity.setNome(user.getNome());
			//entity.setLastName(user.getLastName());
			entity.setEmail(user.getEmail());
			entity.setUsuarioPerfils(user.getUsuarioPerfils());
		}
	}

	
	public void deleteUserBySSO(String sso) {
		dao.deleteBySSO(sso);
	}

	public List<Usuario> findAllUsers() {
		return dao.findAllUsers();
	}

	public boolean isUserSSOUnique(Integer id, String sso) {
		Usuario user = findBySSO(sso);
		return ( user == null || ((id != null) && (user.getId() == id)));
	}
	
}
