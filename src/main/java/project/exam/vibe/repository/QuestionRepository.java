package project.exam.vibe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.exam.vibe.model.Questions;

public interface QuestionRepository extends JpaRepository<Questions, Integer>  {

}
