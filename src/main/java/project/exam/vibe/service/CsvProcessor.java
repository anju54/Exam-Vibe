package project.exam.vibe.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import project.exam.vibe.model.Questions;

public interface CsvProcessor {
	
	public List<Questions> readCSVdataLineByLine(MultipartFile file) throws IOException;

}
