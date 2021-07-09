package kosta.web.mvc.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString
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
	
	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
	private List<Reply> replyList;
	
	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
	private List<Recommend> recommendList;
	
	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
	private List<Image> imageList;
	
	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
	private List<Report> reportList;


	public Board(Long bno) {
		this.bno = bno;
	}
	
	public Board(Long bno, String subject, String content, LocalDateTime regdate, int readnum, int recommend,
			Member member) {
		this.bno = bno;
		this.subject = subject;
		this.content = content;
		this.regdate = regdate;
		this.readnum = readnum;
		this.recommend = recommend;
		this.member = member;
	}


	
}
