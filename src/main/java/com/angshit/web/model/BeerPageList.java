package com.angshit.web.model;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public class BeerPageList extends PageImpl<BeerDto> {

	private static final long serialVersionUID = 4077442469102652591L;

	public BeerPageList(List<BeerDto> content, Pageable pageable, long total) {
		super(content, pageable, total);
	}

	public BeerPageList(List<BeerDto> content) {
		super(content);
	}
	

}
