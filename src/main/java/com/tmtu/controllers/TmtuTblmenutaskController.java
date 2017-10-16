package com.tmtu.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.List;


import com.tmtu.models.Tblmenutask;
import com.tmtu.services.TmtuTblmenutaskService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/tmtu")
public class TmtuTblmenutaskController {

	@Autowired
	TmtuTblmenutaskService tmtuTblmenutaskService;
	
	@PostMapping("/savemenu")
	public ResponseEntity<Map<String,String>> saveMenuTask(
			@RequestParam("menuname") String menuName,
			@RequestParam("groupid") long groupId,
			@RequestParam("createdby") long createdBy
			){
		Map<String,String>json=new HashMap<String, String>();
		Tblmenutask tmt=tmtuTblmenutaskService.save(menuName, groupId, createdBy);
		if(tmt==null) {
			json.put("msg", "Not saved");
			return new ResponseEntity<Map<String,String>>(json, HttpStatus.BAD_REQUEST);
		}
		else
		{
			json.put("msg", "Saved successfully");
			return new ResponseEntity<Map<String,String>>(json, HttpStatus.OK);
		}
		
		
	}
	
	@GetMapping("/getMenu")
	public ResponseEntity<List<Object[]>> saveMenuTask(
			@RequestParam("roleid") long roleId
			){
		List<Object[]> tmt=tmtuTblmenutaskService.getMenuTaskWithRole(roleId);
		if(tmt==null) {
			
			return new ResponseEntity<List<Object[]>>(tmt, HttpStatus.BAD_REQUEST);
		}
		else
		{
			return new ResponseEntity<List<Object[]>>(tmt, HttpStatus.OK);
		}
		
		
	}
	
}
