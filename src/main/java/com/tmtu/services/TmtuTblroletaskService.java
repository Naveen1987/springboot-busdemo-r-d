package com.tmtu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmtu.models.Tblroletask;
import com.tmtu.repositories.TmtuTblroletaskRepository;

@Service
public class TmtuTblroletaskService {

	@Autowired
	TmtuTblroletaskRepository tmtuTblroletaskRepository;
	
	public Tblroletask save(long roleId,long menutaskId,long createdBy) {
		return tmtuTblroletaskRepository.save(roleId, menutaskId, createdBy);
	}
}
