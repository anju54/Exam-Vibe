package project.exam.vibe.service;

import java.util.List;

import project.exam.vibe.dto.ContestDTO;
import project.exam.vibe.model.Contest;
import project.exam.vibe.util.Response;

public interface ContestService {
	
	List<Contest> allContest();
	Contest getByContestId(int id);
	Response<Contest> createContest(ContestDTO contestDTO);
//	Contest updateContest(ContestDTO contestDTO);
//	Contest DeleteContest(int id);
//	Contest getContestById(int id);
}
