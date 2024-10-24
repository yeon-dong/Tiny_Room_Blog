package com.tinyroom.spring.neighbour.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tinyroom.spring.neighbour.dao.NeighbourDao;
import com.tinyroom.spring.neighbour.domain.Neighbour;
import com.tinyroom.spring.neighbour.dto.NeighbourDto;
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
}
