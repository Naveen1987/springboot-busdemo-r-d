package com.tmtu.repositories;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmtu.models.Tblmenutask;
import com.tmtu.models.Tblrole;
import com.tmtu.models.Tblroletask;

public class TmtuTblroletaskRepositoryImpl implements TmtuTblroletaskRepositoryCustom {

	@Autowired
	TmtuTblroletaskRepository tmtuTblroletaskRepository;
	@Autowired
	TmtuTblmenutaskRepository tmtuTblmenutaskRepository;
	@Autowired
	TmtuTblroleRepository tmtuTblroleRepository; 
	
	@Override
	public Tblroletask save(long roleId, long menutaskId, long createdBy) {
		Tblrole tblrole;
		Tblmenutask tblmenutask;
		tblrole=tmtuTblroleRepository.findByRoleId(roleId);
		tblmenutask=tmtuTblmenutaskRepository.findOne(menutaskId);
		Tblroletask trt=new Tblroletask();
		trt.setCreatedBy(createdBy);
		trt.setCreatedOn(Calendar.getInstance());
		trt.setTblmenutask(tblmenutask);
		trt.setTblrole(tblrole);
		
		/*trt.setTaskId(menutaskId);
		trt.setRoleId(roleId);*/
		//
		tblrole.addMenuTask(trt);
		tblmenutask.addMenutask(trt);
		trt =tmtuTblroletaskRepository.save(trt);
		return trt;
	}

}
