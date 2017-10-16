package com.tmtu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.tmtu.models.Tblmenutask;
import com.tmtu.repositories.TmtuTblmenutaskRepository;

@Service
public class TmtuTblmenutaskService {

	@Autowired
	TmtuTblmenutaskRepository tmtuTblmenutaskRepositor;
	
	public Tblmenutask save(String menuName,long groupId,long createdBy) {
		Tblmenutask tmt=tmtuTblmenutaskRepositor.save(menuName, groupId, createdBy);
		return tmt;
	}
	
	public List<Object[]> getMenuTaskWithRole(@Param("roleid")long roleId){
		return tmtuTblmenutaskRepositor.getMenuTaskWithRole(roleId);
	}
}
