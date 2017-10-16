package com.tmtu.repositories;


import com.tmtu.models.Tbllogin;

public interface TmtuTblloginRepositoryCustom {
public Tbllogin save(String userName,String password,String displayName,String email,long craetedby,long roleId);
public Tbllogin updateRole(long loginid,long roleid,long modifiedby);

}
