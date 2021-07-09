package kosta.web.mvc;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import kosta.web.mvc.domain.Board;
import kosta.web.mvc.repository.BoardRepository;

@SpringBootTest 
@Transactional
@Commit
public class BoardTest {

	@Autowired
	private BoardRepository bRep;
	
	//글 등록
	@Test
	public void insert() {
		//bRep.save(new Board(null, "haha", null, null, 0, 0, new mem));
	}
	
	//글 수정
	//글 삭제
	//글 전체검색
}
