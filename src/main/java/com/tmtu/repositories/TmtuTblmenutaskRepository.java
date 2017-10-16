package com.tmtu.repositories;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.tmtu.models.Tblmenutask;

/**
 *This Repository Class for Tblmenutask Model
 *
 */
@Repository
public interface TmtuTblmenutaskRepository extends CrudRepository<Tblmenutask, Long>,TmtuTblmenutaskRepositoryCustom {
	public List<Tblmenutask> findBycreatedBy(long createdBy);
	public List<Tblmenutask> findBycreatedOn(Calendar createdOn);
	//public List<Tblmenutask> findBygroupId(long groupId);
	public List<Tblmenutask> findBylastModifiedBy(long ModifiedBy);
	public List<Tblmenutask> findBylastModifiedOn(Calendar ModifiedOn);
	public List<Tblmenutask> findBymenuName(String menuName);
	public List<Tblmenutask> findByredirectPage(String redirectPage);
	//
	@Query("select mt.menuName,rt.tblrole.roleId,mg.groupName from tblmenugroup mg  inner join mg.tblmenutask mt inner join mt.tblroletask rt where rt.tblrole.roleId=:roleid ")
	public List<Object[]> getMenuTaskWithRole(@Param("roleid")long roleId);
	
}
