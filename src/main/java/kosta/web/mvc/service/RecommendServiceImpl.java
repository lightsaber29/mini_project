package kosta.web.mvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kosta.web.mvc.domain.Recommend;
import kosta.web.mvc.repository.BoardRepository;
import kosta.web.mvc.repository.RecommendRepository;
@Service
@Transactional
public class RecommendServiceImpl implements RecommendService {

	@Autowired
	private RecommendRepository rcRep;
	
	@Autowired
	private BoardRepository bRep;
	
	@Override
	public void insert(Recommend recommend) {
		if(rcRep.findByMemberMnoAndBoardBno(recommend.getMember().getMno(), recommend.getBoard().getBno())!=null) {
			throw new RuntimeException("좋아요는 한번밖에 안된다.");
		}else {
			rcRep.save(recommend);
			bRep.recommendIncrease(recommend.getBoard().getBno());
		}
		
	}

	@Override
	public void delete(Recommend recommend) {
		Recommend dbRecommend = rcRep.findByMemberMnoAndBoardBno(recommend.getMember().getMno(), recommend.getBoard().getBno());
		if(dbRecommend==null) {
			throw new RuntimeException("좋아요 안눌러서 취소안됨");
		}
		rcRep.deleteById(dbRecommend.getRecommendNo());
		bRep.recommendDecrease(dbRecommend.getBoard().getBno());
	}

	@Override
	public List<Recommend> recommendList(Long bno) {
		return rcRep.findByBoardBno(bno);
	}

	@Override
	public Page<Recommend> selectAll(Pageable pageable) {
		return rcRep.findAll(pageable);
	}

}
