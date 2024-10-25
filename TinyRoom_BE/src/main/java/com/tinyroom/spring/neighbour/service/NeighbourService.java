package com.tinyroom.spring.neighbour.service;

import java.util.List;

import com.tinyroom.spring.member.domain.Member;
import com.tinyroom.spring.neighbour.domain.Neighbour;
import com.tinyroom.spring.neighbour.dto.NeighbourDto;
import com.tinyroom.spring.neighbour.dto.NeighbourPageDto;
import com.tinyroom.spring.neighbour.dto.NeighbourPageDto2;
import com.tinyroom.spring.post.domain.Post;
import com.tinyroom.spring.post.dto.PostDto;

public interface NeighbourService {

	void sendApprove(NeighbourDto neighbourDto);

	default NeighbourDto entityNeighbourDto(Neighbour neighbour) {
		NeighbourDto neighbourDto = NeighbourDto.builder()
				.neighbour_id(neighbour.getNeighbour_id())
				.from_member(neighbour.getFromMember())
				.to_member(neighbour.getToMember())
				.status(neighbour.getStatus())
				.build();
		return neighbourDto;
	}
	
	default Neighbour dtoToEntity(NeighbourDto neighbourDto) {
		Neighbour neighbour = Neighbour.builder()
				.neighbour_id(neighbourDto.getNeighbour_id())
				.fromMember(neighbourDto.getFrom_member())
				.toMember(neighbourDto.getTo_member())
				.status(neighbourDto.getStatus())
				.build();
		return neighbour;
	}

	Neighbour getNeighbour(int neighbour_id);

	void modifyStatus(NeighbourDto neighbourDto);

	void deleteNeighbour(int neighbour_id);

	List<Neighbour> getSendNeighbourList(Member member);

	List<Neighbour> getNeighbourList(Member member);

	List<NeighbourPageDto> getSendNeighbourList(Member member, int page);

	int countSendNeighbour(Member member);

	List<NeighbourPageDto2> getNeighbourList2(Member member, int page);

	int countNeighbour(Member member);
}
