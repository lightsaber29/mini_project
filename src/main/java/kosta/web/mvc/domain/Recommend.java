package kosta.web.mvc.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recommend {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recommend_seq")
	@SequenceGenerator(sequenceName = "recommend_seq", allocationSize = 1, name = "recommend_seq")
	private Long recommendNo;
	
	@ManyToOne
	@JoinColumn(name = "mno")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "bno")
	private Board board;
	
}
