package com.tmtu.repositories;

import java.util.Calendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.tmtu.models.Tbllogin;
import com.tmtu.models.Tblrole;

public class TmtuTblloginRepositoryImpl implements TmtuTblloginRepositoryCustom  {


	@Autowired
	TmtuTblloginRepository  tmtuTblloginRepository;
	
	@Autowired
	TmtuTblroleRepository tmtuTblroleRepository;
	/*
	 * Logger for User creation and login
	 * */
	private static final Logger logger = LoggerFactory.getLogger("Login Repository ");
	
	@Override
	public Tbllogin save(String userName, String password, String displayName, String email, long createdby,long roleId) {
		Tblrole trole=null;
		/*
		 * For first user Only
		 */
		if(createdby==0) {
		trole=tmtuTblroleRepository.findByRoleId(1);
		}
		else
		{
		trole=tmtuTblroleRepository.findByRoleId(roleId);
		if(trole==null) {
			logger.error("Role Not found");
			return null;	
		}
		}
		Tbllogin tbllogin=new Tbllogin();
		tbllogin.setCreatedBy(createdby);
		tbllogin.setDisplayName(displayName);
		tbllogin.setEmail(email);
		tbllogin.setUserName(userName);
		tbllogin.setPassword(password);
		tbllogin.setCreatedOn(Calendar.getInstance());
		tbllogin.setIsActive("1");
		tbllogin.setFlag(0);
		tbllogin.setTblrolem(trole);
		/*
		 * adding dependency foreign keys
		*/
		trole.addUser(tbllogin);
		try {
			tbllogin=tmtuTblloginRepository.save(tbllogin);
			logger.info("User successfully added- UserId="+tbllogin.getTblloginId());
			return tbllogin;
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
			return null;
	}

	@Override
	public Tbllogin updateRole(long loginid, long roleid, long modifiedby) {
		Tblrole trole=null;		
		trole=tmtuTblroleRepository.findByRoleId(roleid);
		if(trole==null) {
			logger.error("Role Not found");
			return null;	
		}
		
		try {
			Tbllogin tbllogin=tmtuTblloginRepository.findOne(loginid);
			tbllogin.setLastModifiedBy(modifiedby);
			tbllogin.setLastModifiedOn(Calendar.getInstance());
			tbllogin.setTblrolem(trole);
			/*
			 * adding dependency foreign keys
			*/
			trole.addUser(tbllogin);
			tbllogin=tmtuTblloginRepository.save(tbllogin);
			logger.info("User role successfully updated- UserId="+tbllogin.getTblloginId());
			return tbllogin;
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
			return null;
	}

	
}
