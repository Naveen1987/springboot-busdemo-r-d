package com.tmtu.repositories;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmtu.models.Tblmenugroup;

public class TmtuTblmenugroupRepositoryImpl implements TmtuTblmenugroupRepositoryCustom{

	@Autowired
	TmtuTblmenugroupRepository tmtuTblmenugroupRepository; 
	
	@Override
	public Tblmenugroup save(String groupName) {
		Tblmenugroup tmenu=new Tblmenugroup();
		tmenu.setGroupName(groupName);
		tmenu=tmtuTblmenugroupRepository.save(tmenu);
		return tmenu;
	}

}
