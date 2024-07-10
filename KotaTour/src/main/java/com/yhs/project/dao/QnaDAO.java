package com.yhs.project.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yhs.project.dto.AqnaDTO;
import com.yhs.project.dto.QnaDTO;

@Repository
public class QnaDAO {

	@Autowired
	private SqlSessionTemplate sst;

	// qna 목록조회
	public List<QnaDTO> getQnaList(String id) {
		return sst.selectOne("QnaDAO.getQnaList", id);
	}

	// qna상세보기
	public QnaDTO getQnaDetail(int qnaNum) {

		return sst.selectOne("QnaDAO.getQnaDetail", qnaNum);
	}

	// qna등록하기
	public void insertQna(QnaDTO qnaDTO) {
		sst.insert("QnaDAO.insertQna", qnaDTO);

	}

	public void updateQna(QnaDTO qnaDTO) {
		sst.update("QnaDAO.updateQna", qnaDTO);
	}

	public void deleteQna(int qnaNum) {
		sst.delete("QnaDAO.deleteQna", qnaNum);
	}

	// 자주묻는질문 목록조회
	public List<AqnaDTO> getAqnaList(String name) {
		return sst.selectList("QnaDAO.getAqnaList", name);
	}

	// 자주묻는질문상세보기
	public AqnaDTO getAqnaDetail(int aqnaNum) {
		return sst.selectOne("QnaDAO.getAqnaDetail", aqnaNum);
	}

	// qna등록하기
	public void insertAqna(AqnaDTO aqnaDTO) {
		sst.insert("QnaDAO.insertAqna", aqnaDTO);
	}

	public void updateAqna(AqnaDTO aqnaDTO) {
		sst.update("QnaDAO.updateAqna", aqnaDTO);
	}

	public void deleteAqna(int aqnaNum) {
		sst.delete("QnaDAO.deleteAqna", aqnaNum);
	}

	public List<QnaDTO> getMemberQnaList() {
		return sst.selectList("QnaDAO.getMemberQnaList");
	}

	public void qnaAnswer(QnaDTO qnaDTO) {
		sst.update("QnaDAO.qnaAnswer", qnaDTO);
	}
}
