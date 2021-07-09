package kosta.web.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.web.mvc.domain.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

	List<Reply> findByBoardBno(Long bno);
}
