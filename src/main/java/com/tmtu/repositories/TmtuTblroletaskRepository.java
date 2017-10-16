package com.tmtu.repositories;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tmtu.models.Tblroletask;
/**
 * This Repository Class for Tblroletask Model
 *
 */
@Repository
public interface TmtuTblroletaskRepository extends CrudRepository<Tblroletask,Long>,TmtuTblroletaskRepositoryCustom {
public List<Tblroletask> findBycreatedBy ( long createdBy);
public List<Tblroletask> findBycreatedOn(Calendar createdOn);
public List<Tblroletask> findBylastModifiedBy(long lastModifiedBy);
public List<Tblroletask> findBylastModifiedOn(Calendar lastModifiedOn);
//public List<Tblroletask> findByroleId(long roleId);
//public List<Tblroletask> findBytaskId(long taskId);
}
