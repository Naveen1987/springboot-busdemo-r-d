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

import com.tmtu.models.Tblroletask;
import com.tmtu.services.TmtuTblroletaskService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/tmtu")
public class TmtuTblroletaskController {

	@Autowired
	TmtuTblroletaskService tmtuTblroletaskService;
	
	@PostMapping("saveroletask")
	public ResponseEntity<Map<String,String>> saveroleTask(
			@RequestParam("roleid") long roleId,
			@RequestParam("menuid") long menutaskId,
			@RequestParam("createdby") long createdBy
			){
		Map<String,String> json=new HashMap<String,String>();
		Tblroletask trt=tmtuTblroletaskService.save(roleId, menutaskId, createdBy);
		if(trt==null) {
			json.put("msg",	"Not saved");
			return new ResponseEntity<Map<String,String>>(json,HttpStatus.BAD_REQUEST);
		}
		else {
			json.put("msg",	"Saved Successfully");
			return new ResponseEntity<Map<String,String>>(json,HttpStatus.BAD_REQUEST);
		}
		
	}
}
