package kosta.web.mvc.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bno_seq")
	@SequenceGenerator(sequenceName = "bno_seq", allocationSize = 1, name = "bno_seq")
	private Long bno;
	
	private String subject;
	private String content;
	@CreationTimestamp
	private LocalDateTime regdate;
	private int readnum;
	private int recommend;
	
	@ManyToOne
	@JoinColumn(name = "mno")
	private Member member;

	
	
	
}
