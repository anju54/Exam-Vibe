package project.exam.vibe.service.Impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import project.exam.vibe.model.Questions;
import project.exam.vibe.repository.QuestionRepository;
import project.exam.vibe.service.CsvProcessor;

@Service
public class CsvProcessorImpl implements CsvProcessor {
	
	@Autowired
	private QuestionRepository questionRepository;

	public List<Questions> readCSVdataLineByLine(MultipartFile file) throws IOException {
		
		Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
		
		CsvToBean<Questions> csvToBean = new CsvToBeanBuilder<Questions>(reader).withType(Questions.class)
				.withIgnoreLeadingWhiteSpace(true)
				.build();
		
		List<Questions> questions = csvToBean.parse();
		
		return questionRepository.saveAll(questions);
	}
}
