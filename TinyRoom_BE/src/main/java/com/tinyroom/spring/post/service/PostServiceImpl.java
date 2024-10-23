package com.tinyroom.spring.post.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.tinyroom.spring.category.domain.Category;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.post.dao.PostDao;
import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.post.dto.PageRequestDto;
import com.tinyroom.spring.post.dto.PageResponseDto;
import com.tinyroom.spring.post.dto.PostDto;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostDao postDao;
	
	@Override
	public PostDto get(int post_id) {
		
		Optional<Post> result = postDao.findById(post_id);
		Post post = result.orElseThrow();

		return entityPostDto(post);
	}

	@Override
	public void modify(PostDto postDto) {
		System.out.println("modify service");
		Optional<Post> result = postDao.findById(postDto.getPost_id());
		Post post = result.orElseThrow();
		
		post.changeCategory(postDto.getCategory());
		post.changeContent(postDto.getContent());
		post.changeDate(postDto.getDate());
		post.changePost_img(postDto.getPost_img());
		post.changeTitle(postDto.getTitle());
		
		postDao.save(post);
		
	}

	@Override
	public void remove(int post_id) {
		System.out.println("postService -> remove");
		postDao.deleteById(post_id);		
	}

	@Override
	public PageResponseDto<PostDto> getList(PageRequestDto pageRequestDto) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int postWrite(Map<String, Object> map) {		
		Post post = Post.builder()
				.member((Member) map.get("member"))
				.category((Category)map.get("category"))
				.date((LocalDate) map.get("date"))
				.w_date((LocalDate)map.get("w_date"))
				.title((String)map.get("title"))
				.content((String)map.get("content"))
				.post_img((String)map.get("post_imgr"))
				.is_active((int)map.get("is_active"))
				.build();
		
		// 생성한 엔티티를 dao로 넘겨서 데이터 저장
		postDao.save(post);

		return post.getPost_id();
	}

//	@Override
//	public PageResponseDto<PostDto> getList(PageRequestDto pageRequestDto) {
//		Page<Post> result = postDao.search1(pageRequestDto);
//		
//		List<PostDto> dtoList = result.get().map(post -> entityPostDto(post)).collect(Collectors.toList());
//		
//		PageResponseDto<PostDto> responseDto = PageResponseDto.<PostDto>withAll()
//				.dtoList(dtoList)
//				.pageRequestDto(pageRequestDto)
//				.total(result.getTotalElements())
//				.build();
//		
//		return responseDto;
//	}

}
