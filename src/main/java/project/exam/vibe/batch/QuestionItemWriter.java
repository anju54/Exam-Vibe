package project.exam.vibe.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import project.exam.vibe.model.Questions;
import project.exam.vibe.repository.QuestionRepository;

public class QuestionItemWriter implements ItemWriter<Questions>  {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(QuestionItemWriter.class);

	@Override
	public void write(List<? extends Questions> items) throws Exception {
		// TODO Auto-generated method stub
		logger.info("Saving question to the database...");
		questionRepository.saveAll(items);
	}

}
