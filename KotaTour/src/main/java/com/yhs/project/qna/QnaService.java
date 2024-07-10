package com.yhs.project.qna;

import java.util.List;

import com.yhs.project.dto.AqnaDTO;
import com.yhs.project.dto.QnaDTO;

public interface QnaService {

	List<QnaDTO> getQnaList(String id);

	QnaDTO getQnaDetail(int qnaNum);

	void insertQna(QnaDTO qnaDTO);
	
	void updateQna(QnaDTO qnaDTO);
	
	void deleteQna(int qnaNum);
	
	void qnaAnswer(QnaDTO qnaDTO);
	
	
	List<AqnaDTO> getAqnaList(String name);

	AqnaDTO getAQnaDetail(int aqnaNum);
	
	void insertAqna(AqnaDTO aqnaDTO);
	
	void updateAqna(AqnaDTO aqnaDTO);
	
	void deleteAqna(int aqnaNum);
	
	
	List<QnaDTO> getMemberQnaList();
	
	
}
