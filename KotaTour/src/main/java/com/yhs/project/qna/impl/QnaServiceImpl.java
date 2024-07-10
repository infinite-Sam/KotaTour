package com.yhs.project.qna.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhs.project.dao.QnaDAO;
import com.yhs.project.dto.AqnaDTO;
import com.yhs.project.dto.QnaDTO;
import com.yhs.project.qna.QnaService;

@Service("qnaService")
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QnaDAO qnaDAO;

	@Override
	public List<QnaDTO> getQnaList(String id) {
		return qnaDAO.getQnaList(id);
	}

	@Override
	public QnaDTO getQnaDetail(int qnaNum) {
		return qnaDAO.getQnaDetail(qnaNum);
	}

	@Override
	public void insertQna(QnaDTO qnaDTO) {
		qnaDAO.insertQna(qnaDTO);
	}

	@Override
	public void updateQna(QnaDTO qnaDTO) {
		qnaDAO.updateQna(qnaDTO);
	}

	@Override
	public void deleteQna(int qnaNum) {
		qnaDAO.deleteQna(qnaNum);
	}

	@Override
	public void qnaAnswer(QnaDTO qnaDTO) {
		qnaDAO.qnaAnswer(qnaDTO);
	}

	@Override
	public List<AqnaDTO> getAqnaList(String name) {
		return qnaDAO.getAqnaList(name);
	}

	@Override
	public AqnaDTO getAQnaDetail(int aqnaNum) {
		return qnaDAO.getAqnaDetail(aqnaNum);
	}

	@Override
	public void insertAqna(AqnaDTO aqnaDTO) {
		qnaDAO.insertAqna(aqnaDTO);
	}

	@Override
	public void updateAqna(AqnaDTO aqnaDTO) {
		qnaDAO.updateAqna(aqnaDTO);
	}

	@Override
	public void deleteAqna(int aqnaNum) {
		qnaDAO.deleteAqna(aqnaNum);
	}

	@Override
	public List<QnaDTO> getMemberQnaList() {
		return qnaDAO.getMemberQnaList();
	}

}
