package com.tinyroom.spring.member.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tinyroom.spring.member.service.MemberService;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Log4j2
@CrossOrigin(origins = "*")
@RestController
public class ImageController {
	
	// 프로필 이미지를 저장할 경로
	private final String FOLDER_PATH = "c:\\tinyroomImages\\";
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/image/{imageName}")
	public ResponseEntity<byte[]> getImage(@PathVariable("imageName") String imageName) {
		ResponseEntity<byte[]> result = null;
		
		try {
			java.io.File file = new java.io.File(FOLDER_PATH + imageName);
			
			HttpHeaders header = new HttpHeaders();
            header.add("Content-type", Files.probeContentType(file.toPath()));

            result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			
            log.info(FileCopyUtils.copyToByteArray(file));
            
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return result;
	}
	
	@PostMapping("/image/upload")
	public String postMethodName(@RequestParam("img") MultipartFile img) {
		log.info("################################# upload test #######################################");
		String result = memberService.uploadImage(img);
		
		return result;
	}
	
	
	
	
	
	
	
}
