package project.exam.vibe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "answered_question")
public class AnsweredQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="answer_id")
	private int id;
	
	@Column(name="user_id")
	private int userId;

	@Column(name="question_id")
	private int questionId;
	
	@Column(name="ans_marked")
	private int ansMarked;
	
	@Column(name="is_correct")
	private boolean isCorrect;
	
	@Column(name="contest_id")
	private int contest_id;
}
