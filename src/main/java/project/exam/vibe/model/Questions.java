package project.exam.vibe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Questions")
public class Questions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="question_id")
	private int id;
	
	@NotNull
	@Column(name = "question")
	private String question;
	
	@NotNull
	@Column(name = "answer")
	private String answer;
	
	@NotNull
	@Column(name = "option_1")
	private String option1;
	
	@NotNull
	@Column(name = "option_2")
	private String option2;
	
	@NotNull
	@Column(name = "option_3")
	private String option3;
	
	@NotNull
	@Column(name = "option_4")
	private String option4;
	
	@NotNull
	@Column(name = "score")
	private String score;
	
	@NotNull
	@Column(name = "contest_id")
	private String contestId;
}
