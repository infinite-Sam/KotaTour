package com.yhs.project.qna.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yhs.project.dto.AqnaDTO;
import com.yhs.project.dto.QnaDTO;
import com.yhs.project.qna.QnaService;

@Service("qnaService")
public class QnaServiceImpl implements QnaService {

	@Override
	public List<QnaDTO> getQnaList(String id) {
		return null;
	}

	@Override
	public QnaDTO getQnaDetail(int qnaNum) {
		return null;
	}

	@Override
	public QnaDTO insertQna(QnaDTO qnaDTO) {
		return null;
	}

	@Override
	public QnaDTO updateQna(QnaDTO qnaDTO) {
		return null;
	}

	@Override
	public QnaDTO deleteQna(int qnaNum) {
		return null;
	}

	@Override
	public QnaDTO qnaAnswer(QnaDTO qnaDTO) {
		return null;
	}

	@Override
	public List<AqnaDTO> getAqnaList(String name) {
		return null;
	}

	@Override
	public AqnaDTO getAQnaDetail(int aqnaNum) {
		return null;
	}

	@Override
	public AqnaDTO insertAqna(AqnaDTO aqnaDTO) {
		return null;
	}

	@Override
	public AqnaDTO updateAqna(AqnaDTO aqnaDTO) {
		return null;
	}

	@Override
	public AqnaDTO deleteAqna(int aqnaNum) {
		return null;
	}

	@Override
	public List<QnaDTO> getMemberQnaList() {
		return null;
	}

}
