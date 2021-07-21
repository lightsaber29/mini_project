package kosta.web.mvc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.web.mvc.domain.Reply;
import kosta.web.mvc.repository.ReplyRepository;
@Service
@Transactional
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyRepository rRep;
	
	@Override
	public void insert(Reply reply) {
		rRep.save(reply);
	}

	@Override
	public Reply update(Reply reply) {
		Reply dbReply = rRep.findById(reply.getRno()).orElse(null);
		dbReply.setReplyContent(reply.getReplyContent().replace("<", "&lt;"));
		return dbReply;
	}

	@Override
	public void delete(Long rno) {
		rRep.deleteById(rno);
	}

	@Override
	public Reply selectBy(Long rno) {
		// TODO Auto-generated method stub
		return rRep.findById(rno).orElse(null);
	}

	
}
