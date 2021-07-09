package kosta.web.mvc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Authority implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name = "mno")
	private Member member; // id 식별관계 가져옴
	
	private String mauth;
}
