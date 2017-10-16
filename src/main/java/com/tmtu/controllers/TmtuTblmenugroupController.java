package com.tmtu.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import com.tmtu.models.Tblmenugroup;
import com.tmtu.services.TmtuTblmenugroupService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/tmtu")
public class TmtuTblmenugroupController {

	@Autowired
	TmtuTblmenugroupService tmtuTblmenugroupService;
	
	@PostMapping("/addmenugroup")
	public ResponseEntity<Map<String,String>> saveMenu(
			@RequestParam("groupname") String groupName
			){
		Map<String,String> json=new HashMap<String,String>();
		Tblmenugroup tblm=tmtuTblmenugroupService.save(groupName);
		if(tblm==null) {
			json.put("msg", "Not saved");
			return new ResponseEntity<Map<String,String>>(json, HttpStatus.BAD_REQUEST);
		}
		else {
			json.put("msg", "Successfully saved");
			json.put("menugroupid", tblm.getMenugroupId()+"");
			json.put("menugroupname", tblm.getGroupName());
			return new ResponseEntity<Map<String,String>>(json, HttpStatus.OK);
		}
	}
}
