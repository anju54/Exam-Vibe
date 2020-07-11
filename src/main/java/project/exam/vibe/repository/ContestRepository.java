package project.exam.vibe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.exam.vibe.model.Contest;

@Repository
public interface ContestRepository extends JpaRepository<Contest, Integer> {

	//public Contest findById(int id);
	public Contest findByTitle(String title);
}


