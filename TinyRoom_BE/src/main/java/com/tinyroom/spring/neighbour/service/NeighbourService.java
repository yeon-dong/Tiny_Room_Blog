package com.tinyroom.spring.neighbour.service;

import com.tinyroom.spring.neighbour.domain.Neighbour;
import com.tinyroom.spring.neighbour.dto.NeighbourDto;
import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.post.dto.PostDto;

public interface NeighbourService {

	void sendApprove(NeighbourDto neighbourDto);

	default NeighbourDto entityNeighbourDto(Neighbour neighbour) {
		NeighbourDto neighbourDto = NeighbourDto.builder()
				.neighbour_id(neighbour.getNeighbour_id())
				.from_member(neighbour.getFrom_member())
				.to_member(neighbour.getTo_member())
				.status(neighbour.getStatus())
				.build();
		return neighbourDto;
	}
	
	default Neighbour dtoToEntity(NeighbourDto neighbourDto) {
		Neighbour neighbour = Neighbour.builder()
				.neighbour_id(neighbourDto.getNeighbour_id())
				.from_member(neighbourDto.getFrom_member())
				.to_member(neighbourDto.getTo_member())
				.status(neighbourDto.getStatus())
				.build();
		return neighbour;
	}

	Neighbour getNeighbour(int neighbour_id);

	void modifyStatus(NeighbourDto neighbourDto);
}
