package project.exam.vibe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Rules")
public class Rule {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="rule_id")
	 private int id;	
	 
	 @NotNull
	 @Column(name = "rule_detail")
	 private String ruleDetail;
	 
	 @NotNull
	 @Column(name = "special_case")
	 private String specialCase;
	 
	 @Column(name="contest_id")
	 private int contest_id;
}
