package kosta.web.mvc.dto;

import kosta.web.mvc.domain.Member;
import lombok.Getter;

@Getter
public class MemberDTO {

	private Long mno;
	
	private String mid;
	private String mpwd;
	private String mname;
	private int mstate;
	private String mtel;
	
	public MemberDTO(Member member) {
		mno = member.getMno();
		mid = member.getMid();
		mpwd = member.getMpwd();
		mname = member.getMname();
		mstate = member.getMstate();
		mtel = member.getMtel();
	}
}
