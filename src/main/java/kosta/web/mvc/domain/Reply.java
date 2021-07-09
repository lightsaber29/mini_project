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
public class Reply {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rno_seq")
	@SequenceGenerator(sequenceName = "rno_seq", allocationSize = 1, name = "rno_seq")
	private Long rno;
	
	@ManyToOne
	@JoinColumn(name = "bno")
	private Board board;
	
	@ManyToOne
	@JoinColumn(name = "mno")
	private Member member;
	
	private String replyContent;
	@CreationTimestamp
	private LocalDateTime replyRegdate;
}
