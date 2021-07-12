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
import kosta.web.mvc.domain.Image;
import kosta.web.mvc.domain.Member;
import kosta.web.mvc.domain.Recommend;
import kosta.web.mvc.domain.Reply;
import kosta.web.mvc.domain.Report;
import kosta.web.mvc.repository.BoardRepository;
import kosta.web.mvc.repository.ImageRepository;
import kosta.web.mvc.repository.RecommendRepository;
import kosta.web.mvc.repository.ReplyRepository;
import kosta.web.mvc.repository.ReportRepository;

@SpringBootTest 
@Transactional
@Commit
public class BoardTest {

	@Autowired
	private BoardRepository bRep;
	
	@Autowired
	private ReplyRepository rRep;
	
	@Autowired
	private RecommendRepository rcRep;
	
	@Autowired
	private ReportRepository rpRep;
	
	@Autowired
	private ImageRepository iRep;
	
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
	@Test
	public void delete() {
		bRep.delete(new Board(21L));
	}
	
	//조회수 증가
	@Test
	public void read() {
		bRep.readnumUpdate(2L);
	}
	//추천수 증가
	@Test
	public void reco() {
		bRep.recommendUpdate(2L);
	}
	
	////////////////////////////////////////////
	//답변등록
	@Test
	public void aa() {
		rRep.save(new Reply(null, new Board(21L), new Member(21070701L), "댓글", null));
	}
	//답변수정
	@Test
	public void bb() {
		Reply re = rRep.findById(1L).orElse(null);
		re.setReplyContent("content111");
	}
	//답변삭제
	@Test
	public void aaa() {
		rRep.delete(new Reply(1L));
	}
	
	//글에 해당하는 답변목록
	@Test
	public void replyList() {
		List<Reply> list = rRep.findByBoardBno(2L);
		System.out.println("개수 : "+list.size());
		list.forEach(re->System.out.println(re));
	}
	
	//////////////////////////////////////////
	//추천을 누르면 추천수 +1 그리고 추천테이블에 추천인이랑 글번호가 등록
	
	//추천등록   여기부터!!!!ㄴ
	@Test
	public void recommend() {
		rcRep.save(new Recommend(null, new Member(21070701L), new Board(21L)));
	}
	
	//추천삭제
	@Test
	public void rd() {
		rcRep.delete(new Recommend(1L));
	}
	
	//글에 해당하는 추천목록
	@Test
	public void recommendList() {
		List<Recommend> list = rcRep.findByBoardBno(2L);
		System.out.println("개수 : "+list.size());
		list.forEach(re->System.out.println(re));
	}
	
	
	///////////////////////////////////////////////////
	
	//신고등록
	@Test
	public void report() {
		rpRep.save(new Report(null, new Board(21L), new Member(100L), "노잼글", null, 0));
	}
	
	//신고삭제 -> 신고처리상태가 0일 경우만 가능하게
	@Test
	public void de() {
		rpRep.delete(new Report(1L));
	}
	
	//관리자
	//전체 신고목록
	@Test
	public void list() {
		List<Report> list = rpRep.findAll();
		System.out.println("개수 : "+list.size());
		list.forEach(re->System.out.println(re));
	}
	
	//신고상태 수정
	@Test
	public void up() {
		Report re = rpRep.findById(2L).orElse(null);
		re.setReportState(1);
	}
	
	/////////////////////////////////////////////
	
	//사진등록
	@Test
	public void img() {
		iRep.save(new Image(null, new Board(21L), "경로"));
	}
	
	
	
}
