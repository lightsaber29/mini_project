package kosta.web.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.web.mvc.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
