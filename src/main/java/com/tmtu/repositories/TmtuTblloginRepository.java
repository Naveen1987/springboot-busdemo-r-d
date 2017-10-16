package com.tmtu.repositories;

import java.util.Calendar;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tmtu.models.Tbllogin;
import com.tmtu.models.Tblrole;


/**
 * This Repository Class for Tbllogin Model
 *
 */

@Repository
public interface TmtuTblloginRepository extends CrudRepository<Tbllogin,Long>,TmtuTblloginRepositoryCustom {

/*
 *Selection on the base of individual Value
 */
public Tbllogin findByuserName(String userName);
public List<Tbllogin> findBycreatedBy(long createdBy);
public List<Tbllogin> findBycreatedOn(Calendar createdOn);
public List<Tbllogin> findBydisplayName(String displayName);
public List<Tbllogin> findByemail(String email);
public List<Tbllogin> findByflag(long flag);
public List<Tbllogin> findByisActive(String isActive);
public List<Tbllogin> findBylastModifiedBy(long lastModifiedBy);
public List<Tbllogin> findBylastModifiedOn(Calendar lastModifiedOn);
public List<Tbllogin> findBytblrole(Tblrole tblrole);

/*
 * For finding username and password 
 * login authenticate on the base of username and Password  and IsActive (1 (yes)/0 (no))
 * */
public List<Tbllogin> findByUserNameAndPasswordAndIsActive(String userName,String password,String isActive);

/*
 * Deletion on the base of userName
 * and email
 */
public void deleteByemail(String email);
public void deleteByuserName(String userName);
}
