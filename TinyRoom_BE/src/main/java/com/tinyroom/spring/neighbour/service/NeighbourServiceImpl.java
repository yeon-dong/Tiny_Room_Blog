package com.tinyroom.spring.neighbour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tinyroom.spring.blog.dto.PostPageDto;
import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.neighbour.dao.NeighbourDao;
import com.tinyroom.spring.neighbour.domain.Neighbour;
import com.tinyroom.spring.neighbour.dto.NeighbourDto;
import com.tinyroom.spring.neighbour.dto.NeighbourPageDto;
import com.tinyroom.spring.post.service.PostServiceImpl;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class NeighbourServiceImpl implements NeighbourService{
	@Autowired
	private NeighbourDao neighbourDao;

	@Override
	public void sendApprove(NeighbourDto neighbourDto) {
		Neighbour neighbour = dtoToEntity(neighbourDto);
		neighbourDao.save(neighbour);
	}

	@Override
	public Neighbour getNeighbour(int neighbour_id) {
		Neighbour neighbour = neighbourDao.getById(neighbour_id);
		return neighbour;
	}

	@Override
	public void modifyStatus(NeighbourDto neighbourDto) {
		Neighbour neighbour = dtoToEntity(neighbourDto);
		neighbourDao.save(neighbour);
	}

	@Override
	public void deleteNeighbour(int neighbour_id) {
		neighbourDao.deleteById(neighbour_id);
	}

	@Override
	public List<Neighbour> getSendNeighbourList(Member member) {
		return neighbourDao.findByToMember(member);
	}

	@Override
	public List<Neighbour> getNeighbourList(Member member) {
		return neighbourDao.findByMember(member);
	}

	@Override
	public List<NeighbourPageDto> getSendNeighbourList(Member member, int page) {
		Pageable pageable = PageRequest.of(page, 4, Sort.Direction.DESC, "neighbour_id");
		org.springframework.data.domain.Page<NeighbourPageDto> neighbourPage = neighbourDao.findByConditions(member, pageable);
		return null;
	}

	@Override
	public int countSendNeighbour(Member member) {
		// TODO Auto-generated method stub
		return neighbourDao.countByConditions(member);
	}
}
