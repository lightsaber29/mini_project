package kosta.web.mvc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MEMBER")
public class Member{

	@Id
	private Long mno;
	
	private String mid;
	private String mpwd;
	private String mname;
	private int mstate;
	private String mtel;
	
	public Member(Long mno) {
		this.mno = mno;
	}
}
