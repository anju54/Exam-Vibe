package project.exam.vibe.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
	
	public static final String UPLOAD_LOCATION = "..//upload//";
	void uploadFile(MultipartFile file) throws IOException;

}
