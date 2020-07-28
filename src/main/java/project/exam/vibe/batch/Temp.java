package project.exam.vibe.batch;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;

public class Temp {
	
	public static void main(String args[]) throws IOException {
		String path = new ClassPathResource("/temp/").getURL().getPath();
		System.out.println(path);
	}

}
