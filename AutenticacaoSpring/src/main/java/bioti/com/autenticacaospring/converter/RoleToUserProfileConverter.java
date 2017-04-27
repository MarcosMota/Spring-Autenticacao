package bioti.com.autenticacaospring.converter;

import bioti.com.autenticacaospring.model.seguranca.Perfil;
import bioti.com.autenticacaospring.service.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


/**
 * A converter class used in views to map id's to actual userProfile objects.
 */
@Component
public class RoleToUserProfileConverter implements Converter<Object, Perfil>{

	static final Logger logger = LoggerFactory.getLogger(RoleToUserProfileConverter.class);
	
	@Autowired
	UserProfileService userProfileService;

	/**
	 * Gets Perfil by Id
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	public Perfil convert(Object element) {
		Integer id = Integer.parseInt((String)element);
		Perfil profile= userProfileService.findById(id);
		logger.info("Profile : {}",profile);
		return profile;
	}
	
}