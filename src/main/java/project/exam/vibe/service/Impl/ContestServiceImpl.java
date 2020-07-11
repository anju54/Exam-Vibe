package project.exam.vibe.service.Impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import project.exam.vibe.dto.ContestDTO;
import project.exam.vibe.exception.EntityNotFound;
import project.exam.vibe.model.Contest;
import project.exam.vibe.repository.ContestRepository;
import project.exam.vibe.service.ContestService;
import project.exam.vibe.util.Response;

@Service
public class ContestServiceImpl implements ContestService {
	
	@Autowired
	private ContestRepository contestRepository;
	
	private Logger LOG = LoggerFactory.getLogger(ContestServiceImpl.class);
	
	public Response<Contest> createContest(ContestDTO contestDTO) {
		
		Response<Contest> response = new Response<>();
		
		Contest contest = new Contest();
		
		Contest existingContest = getByContestTitle(contestDTO.getTitle());
		
		if(existingContest != null) {
			
			response.setStatusCode(HttpStatus.UNPROCESSABLE_ENTITY); // 422 - Unprocessable Entity
			response.setStatusMsg("Contest with this title already exists");
			
			return response;
		}
		else {		
			contest.setTitle(contestDTO.getTitle());
			contest.setDescription(contestDTO.getDescription());
			contest.setCategory(contest.getCategory());
			contest.setDate(contestDTO.getDate());
			contest.setDuration(contestDTO.getDuration());
					
			try {
				LOG.info("Creating contest...");
				
				contest = contestRepository.save(contest);
				
				response.setStatusCode(HttpStatus.OK);
				response.setStatusMsg("OK");
				response.setT(contest);
				
				return response;
			} catch(Exception e) {
				LOG.error("An error occurred during product saving:" + e.getMessage());
			}
		}
		return null;
	}
	
	public Contest getByContestTitle(String title) {
		
		return contestRepository.findByTitle(title);
	}
	
	@Override
	public Contest getByContestId(int id) {
		try {
			Optional<Contest> opContest = contestRepository.findById(id);
			if( opContest == null )
				throw new EntityNotFound("Contest with id "+id+" is not exists!");
			Contest contest = opContest.get();
			return contest;
		} catch (EntityNotFound e) {
			LOG.info(e.getMessage());
		} catch (Exception e) {
			LOG.info(e.getMessage());
		}
		return null;
	}
	
	public List<Contest> allContest() {
		return null;
	}

}
