package com.tinyroom.spring.post.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tinyroom.spring.category.domain.Category;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.member.service.MemberServiceImpl;
import com.tinyroom.spring.post.dao.PostDao;
import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.post.dto.PageRequestDto;
import com.tinyroom.spring.post.dto.PageResponseDto;
import com.tinyroom.spring.post.dto.PostDto;

import lombok.extern.log4j.Log4j2;
@Log4j2
@Service
public class PostServiceImpl implements PostService {
	   // 프로필 이미지를 저장할 경로
	   private final String FOLDER_PATH = "c:\\profile_images\\";
	
	@Autowired
	private PostDao postDao;
	
	@Override
	public PostDto get(int post_id) {
		
		Optional<Post> result = postDao.findById(post_id);
		Post post = result.orElseThrow();

		return entityPostDto(post);
	}

	@Override
	public void remove(int post_id) {
		System.out.println("postService -> remove");
		postDao.deleteById(post_id);		
	}


	@Override
	public PageResponseDto<PostDto> getList(PageRequestDto pageRequestDto) {
		Page<Post> result = postDao.search1(pageRequestDto);
		
		List<PostDto> dtoList = result.get().map(post -> entityPostDto(post)).collect(Collectors.toList());
		
		PageResponseDto<PostDto> responseDto = PageResponseDto.<PostDto>withAll()
				.dtoList(dtoList)
				.pageRequestDto(pageRequestDto)
				.total(result.getTotalElements())
				.build();
		
		return responseDto;
	}

	@Override
	public int postWrite(Post post, List<MultipartFile> post_img_files) {
	    List<String> filePaths = new ArrayList<>(); // 파일 경로를 저장할 리스트
	    
	      // 업로드할 폴더 확인 및 생성
        File folder = new File(FOLDER_PATH);
        if (!folder.exists()) {
            folder.mkdirs(); // 폴더가 존재하지 않으면 생성
        }

        for (MultipartFile post_img_file : post_img_files) {
            if (post_img_file.isEmpty()) {
                System.out.println("Empty file: " + post_img_file.getOriginalFilename());
                continue; // 비어있는 파일은 건너뜁니다.
            }

            String filePath = FOLDER_PATH + post_img_file.getOriginalFilename();
            try {
                // 파일을 지정한 경로에 저장
                post_img_file.transferTo(new File(filePath));
                filePaths.add(filePath); // 저장한 파일 경로 추가
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
                throw new RuntimeException("파일 업로드 중 오류 발생");
            }
        }

        // 모든 이미지 경로를 문자열로 연결하여 하나의 필드에 저장
        post.setPost_img(String.join(",", filePaths)); // 파일 경로를 쉼표로 구분하여 저장

	    // 포스트 저장
	    postDao.save(post);
	    return post.getPost_id();
	}

	@Override
	public void modify(PostDto postDto, List<MultipartFile> post_img_files) {
		Optional<Post> result = postDao.findById(postDto.getPost_id());
		Post post = result.orElseThrow();
		
		 List<String> filePaths = new ArrayList<>(); // 파일 경로를 저장할 리스트
		    
	      // 업로드할 폴더 확인 및 생성
        File folder = new File(FOLDER_PATH);
        if (!folder.exists()) {
            folder.mkdirs(); // 폴더가 존재하지 않으면 생성
        }

        for (MultipartFile post_img_file : post_img_files) {
            if (post_img_file.isEmpty()) {
                System.out.println("Empty file: " + post_img_file.getOriginalFilename());
                continue; // 비어있는 파일은 건너뜁니다.
            }

            String filePath = FOLDER_PATH + post_img_file.getOriginalFilename();
            try {
                // 파일을 지정한 경로에 저장
                post_img_file.transferTo(new File(filePath));
                filePaths.add(filePath); // 저장한 파일 경로 추가
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
                throw new RuntimeException("파일 업로드 중 오류 발생");
            }
        }

        // 모든 이미지 경로를 문자열로 연결하여 하나의 필드에 저장
        post.setPost_img(String.join(",", filePaths)); // 파일 경로를 쉼표로 구분하여 저장
		
		post.changeCategory(postDto.getCategory());
		post.changeContent(postDto.getContent());
		post.changeDate(postDto.getDate());
		post.changeTitle(postDto.getTitle());
		
		postDao.save(post);
	}

	@Override
	public void modifyForDelete(PostDto postDto) {
		Optional<Post> result = postDao.findById(postDto.getPost_id());
		Post post = result.orElseThrow();
		
		post.setIs_active(0);
		postDao.save(post);
	}
	
    public Optional<Post> findById(int post_id) {
        return postDao.findById(post_id); // Optional<Post> 반환
    }
	

}
