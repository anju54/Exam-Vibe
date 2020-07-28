package project.exam.vibe.config;

import java.io.IOException;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import project.exam.vibe.batch.QuestionItemProcessor;
import project.exam.vibe.batch.QuestionItemWriter;
import project.exam.vibe.model.Questions;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;				// Builds a batch job

	@Autowired
	public StepBuilderFactory stepBuilderFactory;	
	
	@Value("${project.exam.vibe.filePath}")
	private String filePath;
	
	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
			ItemReader<Questions> itemReader,
			ItemProcessor<Questions,Questions> itemProcessor,
			ItemWriter<Questions> itemWriter) {
		
		Step step = stepBuilderFactory.get("Question-FILE_LOAD")
								.<Questions,Questions>chunk(100)
								.reader(itemReader)
								.processor(itemProcessor)
								.writer(itemWriter)
								.build();
		
		return jobBuilderFactory.get("ETL-LOAD")
				.incrementer(new RunIdIncrementer())
				.start(step)
				.build();
		
	}
	
	@Bean
	@Scope(value = "step", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public FlatFileItemReader<Questions> fileItemReader( @Value("#{jobParameters['fileName']}") String fileName ) throws IOException{
		
		System.out.println("------------------------  "+fileName);
		System.out.println("------------------------  "+filePath);
		
		Resource resource =  new ClassPathResource(filePath+fileName);
		
		//Resource resource =  new ClassPathResource("sheet1.csv");
		FlatFileItemReader<Questions> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource(new FileSystemResource(fileName));
		//flatFileItemReader.setResource(resource);
		flatFileItemReader.setName("Csv_reader");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(lineMapper());
		
		return flatFileItemReader;
	}
	
	@Bean
	public QuestionItemProcessor processor() {
		return new QuestionItemProcessor();
	}
	
	@Bean
	public QuestionItemWriter writer() {
		return new QuestionItemWriter();
	}
	
	@Bean
	public  LineMapper<Questions> lineMapper(){
		
		DefaultLineMapper<Questions> defaultLineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] {"question","option1", "option2","option3","option4"} );
		
		BeanWrapperFieldSetMapper<Questions> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Questions.class);
		

		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		
		return defaultLineMapper;
	}
	
	
	
}
