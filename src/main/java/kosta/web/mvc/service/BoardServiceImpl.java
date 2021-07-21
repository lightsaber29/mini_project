package kosta.web.mvc.service;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kosta.web.mvc.domain.Board;
import kosta.web.mvc.domain.Reply;
import kosta.web.mvc.repository.BoardRepository;
import kosta.web.mvc.repository.ReplyRepository;
@Service
@Transactional
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository bRep;
	
	@Autowired
	private ReplyRepository rRep;
	
	@Override
	public Page<Board> selectAll(Pageable pageable) {
		return bRep.findAll(pageable);
	}

	@Override
	public void insert(Board board) {
		bRep.save(board);
	}

	@Override
	public Board selectBy(Long bno, boolean state) {
		if(state) {
			bRep.readnumUpdate(bno);
		}
		return bRep.findById(bno).orElse(null);
	}

	@Override
	public Board update(Board board) {
		Board dbBoard = bRep.findById(board.getBno()).orElse(null);
		dbBoard.setContent(board.getContent().replace("<", "&lt;"));
		dbBoard.setSubject(board.getSubject());
		return dbBoard;
	}

	@Override
	public void delete(Long bno) {
		bRep.deleteById(bno);
	}

	@Override
	public Page<Board> selectByMem(Long mno, Pageable pageable) {
		return bRep.findByMemberMno(mno, pageable);
	}

	@Override
	public Page<Board> selectByContent(String content, Pageable pageable) {
		return bRep.findByContentContaining(content, pageable);
	}

	@Override
	public Page<Board> selectBySubject(String subject, Pageable pageable) {
		return bRep.findBySubjectContaining(subject, pageable);
	}
	
	@Override
	public Page<Reply> replyList(Long bno, Pageable pageable) {
		return rRep.findByBoardBno(bno, pageable);
	}


	
}
