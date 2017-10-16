package com.tmtu.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.tmtu.models.Tblmenugroup;

/**
 * This Repository Class for Tblmenugroup Model
 *
 */
@Repository
public interface TmtuTblmenugroupRepository extends CrudRepository<Tblmenugroup, Long>,TmtuTblmenugroupRepositoryCustom {
public Tblmenugroup findBygroupName(String groupName);

//Insert Query by @query for test purpose
/*@Modifying
@Query(value="INSERT INTO Tblmenugroup (groupName) VALUES(:groupName)", nativeQuery = true)
@Transactional
public int save(@Param ("groupName")String groupName);*/
}
