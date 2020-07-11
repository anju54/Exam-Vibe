package project.exam.vibe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.exam.vibe.dto.ContestDTO;
import project.exam.vibe.model.Contest;
import project.exam.vibe.service.ContestService;
import project.exam.vibe.util.Response;

@RestController
@RequestMapping(path = "/api/exam")
public class ContestController {
	
	@Autowired
	ContestService contestService;
	
	@PostMapping("/add")
	public Response<Contest> createContest(@RequestBody ContestDTO contestDTO){
		return contestService.createContest(contestDTO);
	}
	

}
