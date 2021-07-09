package kosta.web.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kosta.web.mvc.domain.Recommend;

public interface RecommendRepository extends JpaRepository<Recommend, Long> {

}
