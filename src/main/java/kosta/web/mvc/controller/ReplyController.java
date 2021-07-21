package kosta.web.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kosta.web.mvc.domain.Board;
import kosta.web.mvc.domain.Member;
import kosta.web.mvc.domain.Reply;
import kosta.web.mvc.service.ReplyService;

@Controller
@RequestMapping("/reply")
public class ReplyController {

	@Autowired
	private ReplyService replyService;
	
	/**
	 * 댓글등록
	 * */ 
	@RequestMapping("/insert")
	public String insert(Reply reply, Long bno) {
		reply.setBoard(new Board(bno));
		//회원정보필요
		reply.setMember(new Member(100L));
		replyService.insert(reply);
		
		return "redirect:/board/detail/"+bno+"?flag=1";
	}
	
	/**
	 * 댓글수정 폼
	 * */
	@RequestMapping("/updateForm/{rno}")
	public ModelAndView updateForm(@PathVariable Long rno) {
		Reply reply = replyService.selectBy(rno);
		return new ModelAndView("reply/update", "reply", reply);
	}
	
	/**
	 * 댓글수정
	 * */
	@RequestMapping("/update")
	public String update(Reply reply) {
		Reply dbReply = replyService.update(reply);
		Long bno = dbReply.getBoard().getBno();
		return "redirect:/board/detail/"+bno+"?flag=1";
	}
	
	/**
	 * 댓글삭제
	 * */
	@RequestMapping("/delete/{rno}/{bno}")
	public String delete(@PathVariable Long rno, @PathVariable Long bno) {
		replyService.delete(rno);
		return "redirect:/board/detail/"+bno+"?flag=1";
	}
}
