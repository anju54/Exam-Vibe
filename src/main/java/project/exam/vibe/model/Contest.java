/**
 * 
 */
package project.exam.vibe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * @author anju
 *
 */
@Entity
@Table(name = "Contest")
public class Contest {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="contest_id")
	 private int id;	
	 
	 @NotNull
	 @Column(name = "title")
	 private String title;

	 @NotNull
	 @Column(name = "description")
	 private String description;
	 
	 @NotNull
	 @Column(name = "date")
	 private String date;
	 
	 @Column(name = "category")
	 private String category;
	 
	 @Column(name = "duration")
	 private String duration;
	 
	 @Column(name = "rule_id")
	 private int ruleId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getRuleId() {
		return ruleId;
	}

	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}
}
