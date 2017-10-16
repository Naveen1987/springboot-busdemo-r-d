package com.tmtu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtu.models.Tblmenugroup;
import com.tmtu.repositories.TmtuTblmenugroupRepository;

@Service
public class TmtuTblmenugroupService {

	@Autowired
	TmtuTblmenugroupRepository	tmtuTblmenugroupRepository;
	
	public Tblmenugroup save(String groupName) {
		return tmtuTblmenugroupRepository.save(groupName);
	}
}
