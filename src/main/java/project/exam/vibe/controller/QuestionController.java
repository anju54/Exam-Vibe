package project.exam.vibe.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import project.exam.vibe.service.StorageService;

@RestController
@RequestMapping("load")
public class QuestionController {
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;
	
	@Value("${project.exam.vibe.filePath}")
	private String filePath;
	
	@Autowired
	private StorageService storageService;
	
	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);
	
	
	@PostMapping(value="/upload-csv", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public String uploadCSV(MultipartFile file) throws IOException {
		
		logger.info(file.getOriginalFilename());
		
		System.out.println();
		
		Resource res =  file.getResource();
		InputStream ip =  res.getInputStream();
		
		
		
//		logger.info(filePath);
//		
//		storageService.uploadFile(file);
		
		return "done";
	}
	
	@PostMapping(value="/questions", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public BatchStatus uploadQuestion(@RequestParam("file") MultipartFile file) 
			throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, 
			JobParametersInvalidException, IOException {
		
		HashMap<String, JobParameter> maps = new HashMap<>();
		maps.put("Time" ,new JobParameter(System.currentTimeMillis()));
		
		JobExecution jobExecution = jobLauncher.run(job, new JobParametersBuilder()
				.addString("fileName", file.getOriginalFilename())
				.toJobParameters() );
		
		while (jobExecution.isRunning()) {
			logger.info("Running batch service...");
		}
		
		return jobExecution.getStatus();
	}

}
