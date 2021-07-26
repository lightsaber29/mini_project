package kosta.web.mvc.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_seq")
	@SequenceGenerator(sequenceName = "image_seq", allocationSize = 1, name = "image_seq")
	private Long imageNo;

	@ManyToOne
	@JoinColumn(name = "bno")
	private Board board;
	
	private String imagePath;

	public Image(String imagePath) {
		super();
		this.imagePath = imagePath;
	}
	
	
}
