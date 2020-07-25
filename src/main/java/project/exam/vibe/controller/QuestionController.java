package project.exam.vibe.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("load")
public class QuestionController {
	
	@Autowired
	public JobLauncher jobLauncher;
	
	@Autowired
	public Job job;
	
	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
	
	@GetMapping(value="/questions", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public BatchStatus uploadQuestion(MultipartFile file) 
			throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		
		String fileName = file.getOriginalFilename();
		
		HashMap<String, JobParameter> maps = new HashMap<>();
		maps.put("Time" ,new JobParameter(System.currentTimeMillis()));
		
		JobParameters jobParameter = new JobParameters(maps);
		
		JobExecution jobExecution = jobLauncher.run(job, jobParameter);
		
		while (jobExecution.isRunning()) {
			logger.info("Running batch service...");
		}
		
		return jobExecution.getStatus();
	}

}
