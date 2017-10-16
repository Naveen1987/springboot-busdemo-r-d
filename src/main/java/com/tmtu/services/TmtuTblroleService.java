package com.tmtu.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tmtu.models.Tbllogin;
import com.tmtu.models.Tblrole;
import com.tmtu.repositories.TmtuTblroleRepository;


@Service
public class TmtuTblroleService {

	@Autowired
	TmtuTblroleRepository tmtuTblroleRepository; 
	private static final Logger logger=LoggerFactory.getLogger("Role Service");
	
	public Tblrole getByroleName(String roleName){
		return tmtuTblroleRepository.findByroleName(roleName);
	}
	public List<Tblrole> getBycreatedBy(long createdBy){
		return tmtuTblroleRepository.findBycreatedBy(createdBy);
		}
	public List<Tblrole> getBycreatedOn(Calendar createdOn){
		return tmtuTblroleRepository.findBycreatedOn(createdOn);
		}
	public List<Tblrole> getBylastModifiedBy(long lastModifiedBy){
		return tmtuTblroleRepository.findBylastModifiedBy(lastModifiedBy);
		}
	public List<Tblrole> getBylastModifiedOn(Calendar lastModifiedOn){
		return tmtuTblroleRepository.findBylastModifiedOn(lastModifiedOn);
		}
	public List<Tblrole> getBytblloginIn(Set<Tbllogin> aTbllogin){
		return tmtuTblroleRepository.findBytblloginIn(aTbllogin);
		}
	public Tblrole saveRole(String tblrole,long createdBy) {
		return tmtuTblroleRepository.save(tblrole,createdBy);
	}
	public List<Map<String, String>> getAllRoles() {
		List<Map<String,String>> roles=new ArrayList<Map<String,String>>();
		Iterable<Tblrole> iteratorm= tmtuTblroleRepository.findAll();
		Stream<Tblrole> targetStream = StreamSupport.stream(iteratorm.spliterator(), false);
		targetStream.forEach(record->{
			Map<String,String> role=new HashMap<String,String>();
			role.put("roleid", record.getRoleId()+"");
			role.put("rolename", record.getRoleName());
			roles.add(role);
		});
		return roles;
	}
	
	public Tblrole update(String rolename,long roleid,long modifiedby) {
		Tblrole tblrole=tmtuTblroleRepository.findOne(roleid);
		if(tblrole==null) {
			logger.error("Role is not exist with id-"+roleid);
			return null;
		}
		else {
			tblrole.setRoleName(rolename);
			tblrole.setLastModifiedBy(modifiedby);
			tblrole.setLastModifiedOn(Calendar.getInstance());
		}
		try {
			tmtuTblroleRepository.save(tblrole);
			logger.info("Role updated successfully roleid-"+roleid);
			return tblrole;
		}catch (Exception e) {
			logger.error("Role can not be update because-"+e.getMessage());
			return null;
		}
	}
	public Tblrole getRole(long roleId) {
		Tblrole tblrole=tmtuTblroleRepository.findOne(roleId);
		return tblrole;
	}
	/*public List<Object[]> findRole(long roleId) {
		List<Object[]> tblrole=tmtuTblroleRepository.findPm();
		return tblrole;
	}*/
	public List<Object[]> findRole() {
		List<Object[]> tblrole=tmtuTblroleRepository.findPm();
		return tblrole;
	}
	
	/*public void delete(long roleid) {
		tmtuTblroleRepository.delete(roleid);
	}*/
	
}
