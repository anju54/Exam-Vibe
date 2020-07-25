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
	
	
	@Column(name = "question")
	private String question;
	
	
	@Column(name = "answer")
	private String answer;
	
	
	@Column(name = "option_1")
	private String option1;
	
	
	@Column(name = "option_2")
	private String option2;
	
	
	@Column(name = "option_3")
	private String option3;
	
//	@NotNull
	@Column(name = "option_4")
	private String option4;
	
//	@NotNull
	@Column(name = "score")
	private String score;
	
//	@NotNull
	@Column(name = "contest_id")
	private String contestId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getContestId() {
		return contestId;
	}

	public void setContestId(String contestId) {
		this.contestId = contestId;
	}
	
	
}
