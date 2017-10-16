package com.tmtu.repositories;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmtu.models.Tblrole;

public class TmtuTblroleRepositoryImpl implements TmtuTblroleRepositoryCustom {
	@Autowired 
	TmtuTblroleRepository tmtuTblroleRepository;
	
	/*
	 * Logger for Role Repository
	 * */
	private static final Logger logger = LoggerFactory.getLogger("Role Repository");
	
	
	@Override
	public Tblrole save(String roleName, long createdBy) {
		Tblrole tblrole=null;
		try {
		Tblrole role=new Tblrole();
		role.setCreatedBy(createdBy);
		role.setCreatedOn(Calendar.getInstance());
		role.setRoleName(roleName);
		tblrole=tmtuTblroleRepository.save(role);
		logger.info("Role successfully created - Id="+tblrole.getRoleId());
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
	return	tblrole;
	}

}
