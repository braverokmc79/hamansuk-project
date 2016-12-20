package com.example.wbe04.model.memo.dao;

import java.util.List;

import com.example.wbe04.model.memo.dto.MemoDTO;

public interface MemoDAO {

	public List<MemoDTO> memoList();

	public void memoAdd(MemoDTO dto);
	
}
