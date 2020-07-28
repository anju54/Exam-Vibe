package project.exam.vibe.service.Impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import project.exam.vibe.service.StorageService;

@Service
public class StorageImpl implements StorageService {

	@Override
	public void uploadFile(MultipartFile file) throws IOException {
		
		// Create a blank new file in the upload location
		File newFile = new File(StorageService.UPLOAD_LOCATION + file.getOriginalFilename());
		newFile.createNewFile();
		
		// Open output stream to new file and write from file to be uploaded
		FileOutputStream fileOutputStream = new FileOutputStream(newFile);
		fileOutputStream.write(file.getBytes());
		fileOutputStream.close();
	}
}
