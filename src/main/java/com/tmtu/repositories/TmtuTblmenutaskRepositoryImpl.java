package com.tmtu.repositories;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;

import com.tmtu.models.Tblmenugroup;
import com.tmtu.models.Tblmenutask;

public class TmtuTblmenutaskRepositoryImpl implements TmtuTblmenutaskRepositoryCustom  {

	@Autowired
	TmtuTblmenutaskRepository tmtuTblmenutaskRepository;
	@Autowired
	TmtuTblmenugroupRepository tmtuTblmenugroupRepository; 
	
	
	@Override
	public Tblmenutask save(String menuName, long groupId, long createdBy) {
		Tblmenugroup tmg=tmtuTblmenugroupRepository.findOne(groupId);
		Tblmenutask tmt=new Tblmenutask();
		tmt.setMenuName(menuName);
		tmt.setCreatedBy(createdBy);
		tmt.setTblmenugroup(tmg);
		tmt.setCreatedOn(Calendar.getInstance());
		tmg.addMenu(tmt);
		tmt=tmtuTblmenutaskRepository.save(tmt);
		return tmt;
	}

}
