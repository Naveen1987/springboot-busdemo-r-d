package com.tmtu.repositories;

import com.tmtu.models.Tblmenutask;

public interface TmtuTblmenutaskRepositoryCustom {

	public Tblmenutask save(String menuName,long groupId,long createdBy);
	
	
}
