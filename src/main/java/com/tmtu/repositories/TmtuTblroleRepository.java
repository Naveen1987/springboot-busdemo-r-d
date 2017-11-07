package com.tmtu.repositories;


import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.tmtu.models.Tbllogin;
import com.tmtu.models.Tblrole;

/**
 * This Repository Class for Tblrole Model
 *
 */
@Repository
//public interface TmtuTblroleRepository extends CrudRepository<Tblrole, Long>,TmtuTblroleRepositoryCustom {
public interface TmtuTblroleRepository extends PagingAndSortingRepository<Tblrole, Long>,TmtuTblroleRepositoryCustom {
public Tblrole findByroleName(String roleName);
public List<Tblrole> findBycreatedBy(long createdBy);
public List<Tblrole> findBycreatedOn(Calendar createdOn);
public List<Tblrole> findBylastModifiedBy(long lastModifiedBy);
public List<Tblrole> findBylastModifiedOn(Calendar lastModifiedOn);
public List<Tblrole> findBytblloginIn(Set<Tbllogin> aTbllogin);
public Tblrole findByRoleId(long roleId);

//
/*@Query("select r.roleId,r.roleName from tblrole r where roleid=:roleid")
public  List<Object[]> findPm(@Param("roleid")long roleid);
*/

//Parent to child
@Query("select u.tblloginId,u.userName,u.tblrole.roleId,u.tblrole.roleName from tblrole r inner join r.tbllogin u")
public  List<Object[]> findPm();


@Query("select u.tblloginId,u.userName,u.tblrole.roleId,u.tblrole.roleName from tblrole r inner join r.tbllogin u")
public  Page<Object[]> findPm(Pageable page);
}
