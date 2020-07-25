package project.exam.vibe.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import project.exam.vibe.model.Questions;

public class QuestionItemProcessor implements ItemProcessor<Questions, Questions>  {
	
	private static final Logger logger = LoggerFactory.getLogger(QuestionItemProcessor.class);

	@Override
	public Questions process(final Questions item) throws Exception {
		
//		final Questions transformedQuestion = new Questions();
//		transformedQuestion.setAnswer(item.getAnswer().toUpperCase());
		
		logger.info("ItemProcessor called....");
		return item;
	}

}
