package kosta.web.mvc.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.web.mvc.domain.Image;
import kosta.web.mvc.repository.ImageRepository;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository imgRep;
	
	@Override
	public void insert(Image image) {
		imgRep.save(image);
	}
	
}
