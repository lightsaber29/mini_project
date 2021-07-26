package kosta.web.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kosta.web.mvc.domain.Board;
import kosta.web.mvc.domain.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

	@Query("delete from Image i where i.board.bno = ?1")
	@Modifying
	void deleteImage(Long bno);
	
	List<Image> findByBoardBno(Long bno);
	
}
