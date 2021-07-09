package kosta.web.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.web.mvc.domain.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
