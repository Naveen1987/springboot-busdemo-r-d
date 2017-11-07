package com.tmtu.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tmtu.models.Tblrole;

import com.tmtu.services.TmtuTblroleService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/tmtu")
public class TmtuTblroleController {

	@Autowired
	TmtuTblroleService tmtuTblroleService; 
	
	@PostMapping("/addrole")
	public ResponseEntity<Map<String, String>> saveRole(
			@RequestParam("rolename") String rolename,
			@RequestParam("createdby") long createdby) {
		
		Tblrole tblrole=tmtuTblroleService.saveRole(rolename,createdby);
		Map<String,String> json=new HashMap<String,String>();
		if(tblrole==null) {
			json.put("msg", "Role is existed.");
			return new ResponseEntity<Map<String, String>>(json, HttpStatus.BAD_REQUEST);
		}
		else {
			json.put("msg", "Role Successfully created");
			json.put("roleid", tblrole.getRoleId()+"");
			json.put("rolename", tblrole.getRoleName());
			return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
		}
		
	}
	
	@PostMapping("/updaterole")
	public ResponseEntity<Map<String, String>> updateRole(
			@RequestParam("rolename") String rolename,
			@RequestParam("roleid") long roleid,
			@RequestParam("modifiedby") long modifiedby) {
	Tblrole tblrole=tmtuTblroleService.update(rolename, roleid, modifiedby);
	Map<String,String> json=new HashMap<String,String>();
	if(tblrole==null) {
		json.put("msg", "Role is not existed or Role name is not unique.");
		return new ResponseEntity<Map<String, String>>(json, HttpStatus.BAD_REQUEST);
	}
	else {
		json.put("msg", "Role Successfully Updated");
		json.put("roleid", tblrole.getRoleId()+"");
		json.put("rolename", tblrole.getRoleName());
		return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
	}
		
	}
	@GetMapping("/role")
	public Tblrole getrole(
			@RequestParam("roleid") long roleid
			){
		Tblrole tbrole=tmtuTblroleService.getRole(roleid);
		return tbrole;
		} 
	
	@GetMapping("/roles")
	public ResponseEntity<List<Map<String,String>>> getAllRoles(){
		List<Map<String,String>> roles=tmtuTblroleService.getAllRoles();		
		return new ResponseEntity<List<Map<String, String>>>(roles, HttpStatus.OK);
	}
	
	@GetMapping("/rolesall")
	public ResponseEntity<Page<Map<String, Object>>> rolesall(Pageable page){
		Page<Map<String, Object>> roles=tmtuTblroleService.findAll(page);
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}
	
	@GetMapping("/rolesallpm")
	public ResponseEntity<Page<Map<String, Object>>> rolesallpm(Pageable page){
		Page<Map<String, Object>> roles=tmtuTblroleService.findAllPm(page);
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}
	
	/*@GetMapping("/rolem")
	public List<Object[]> getrolepm(
			@RequestParam("roleid") long roleid
			){
		List<Object[]> tbrole=tmtuTblroleService.findRole(roleid);
		return tbrole;
		} */
	@GetMapping("/rolem")
	public List<Object[]> getrolepm(){
		List<Object[]> tbrole=tmtuTblroleService.findRole();
		return tbrole;
		} 
	
	/*@PostMapping("/deleterole")
	public  ResponseEntity<Map<String, String>>delete(
			@RequestParam("roleid") long roleid
			){
		Map<String,String> json=new HashMap<String,String>();
		tmtuTblroleService.delete(roleid);
		return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
	}*/
}
