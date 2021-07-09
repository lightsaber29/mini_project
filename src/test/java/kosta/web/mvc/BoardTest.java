package kosta.web.mvc;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Commit;

import kosta.web.mvc.domain.Board;
import kosta.web.mvc.domain.Member;
import kosta.web.mvc.domain.Reply;
import kosta.web.mvc.repository.BoardRepository;
import kosta.web.mvc.repository.ReplyRepository;

@SpringBootTest 
@Transactional
@Commit
public class BoardTest {

	@Autowired
	private BoardRepository bRep;
	
	@Autowired
	private ReplyRepository rRep;
	
	//글 등록
	@Test
	public void insert() {
		bRep.save(new Board(null, "제목", "내용", null, 0, 0, new Member(21070701L)));
	}
	//글 수정
	@Test
	public void update() {
		Board b = bRep.findById(2L).orElse(null);
		b.setContent("updatecontent");
		b.setSubject("updatesubject");
	}
	
	//글 전체검색
	@Test
	public void selectAll() {
		List<Board>list =bRep.findAll();
		System.out.println("개수 : "+ list.size());
		list.forEach(b->System.out.println(b));
	}
	//글 조건검색
	//작성자
	@Test
	public void selectByMember() {
		List<Board>list = bRep.findByMemberMno(21070701L);
		System.out.println("개수 : "+ list.size());
		list.forEach(b->System.out.println(b));
	}
	//제목
	@Test
	public void selectBySub() {
		Collection<Board> bb = bRep.findBySubjectContaining("up");
		bb.forEach(b->System.out.println(b));
	}
	//내용
	@Test
	public void selectByContent() {
		Collection<Board> bb = bRep.findByContentContaining("내");
		bb.forEach(b->System.out.println(b));
	}
	
	//글 삭제
	
	////////////////////////////////////////////
	//답변등록
	@Test
	public void aa() {
		rRep.save(new Reply(null, new Board(3L), new Member(21070701L), "content3", null));
	}
	//답변수정
	@Test
	public void bb() {
		Reply re = rRep.findById(1L).orElse(null);
		re.setReplyContent("content111");
	}
	//답변삭제
	
	//글에 해당하는 답변목록
	@Test
	public void replyList() {
		List<Reply> list = rRep.findByBoardBno(2L);
		System.out.println("개수 : "+list.size());
		list.forEach(re->System.out.println(re));
	}
	
	//////////////////////////////////////////
	//추천을 누르면 추천수 +1 그리고 추천테이블에 추천인이랑 글번호가 등록
}
