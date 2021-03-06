package com.rk.sringboot.filehandler.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadDownloadController {

	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		File fileObj = new File("D:\\temp\\" + file.getOriginalFilename());
		fileObj.createNewFile();
		FileOutputStream fos = new FileOutputStream(fileObj);
		fos.write(file.getBytes());
		fos.close();
		return "File has been uploaded successfully";
	}

	@RequestMapping(value = "download", method = RequestMethod.GET)
	public ResponseEntity<Object> downloadFile() throws IOException {
		String fileName = "D:/temp/abc.txt";
		File file = new File(fileName);
	
		InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<Object> responseObj = ResponseEntity.ok()
														   .headers(headers)
														   .contentLength(file.length())
														   .contentType(MediaType.parseMediaType("application/txt"))
														   .body(isr);
		return responseObj;
	}
}
