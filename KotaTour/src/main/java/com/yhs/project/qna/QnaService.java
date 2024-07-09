package com.yhs.project.qna;

import java.util.List;

import com.yhs.project.dto.AqnaDTO;
import com.yhs.project.dto.QnaDTO;

public interface QnaService {

	List<QnaDTO> getQnaList(String id);

	QnaDTO getQnaDetail(int qnaNum);

	QnaDTO insertQna(QnaDTO qnaDTO);
	
	QnaDTO updateQna(QnaDTO qnaDTO);
	
	QnaDTO deleteQna(int qnaNum);
	
	QnaDTO qnaAnswer(QnaDTO qnaDTO);
	
	
	List<AqnaDTO> getAqnaList(String name);

	AqnaDTO getAQnaDetail(int aqnaNum);
	
	AqnaDTO insertAqna(AqnaDTO aqnaDTO);
	
	AqnaDTO updateAqna(AqnaDTO aqnaDTO);
	
	AqnaDTO deleteAqna(int aqnaNum);
	
	
	List<QnaDTO> getMemberQnaList();
	
	
}
