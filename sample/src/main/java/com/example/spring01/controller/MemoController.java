package com.example.spring01.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import memo.dao.MemoDAO;
import memo.dto.MemoDTO;

//컨트롤러 어노테이션
@Controller
public class MemoController {
	// 객체를 자동으로 생성하여 주입시키는 어노테이션
	// MemoDAO memoDao = new MemoDAOImpl();
	@Inject
	private MemoDAO memoDao;

	// url pattern 연결 어노테이션
	@RequestMapping("/memo.do")
	public ModelAndView memo() {
		// /WEB-INF/views/memo/memo.jsp로 포워딩됨
		return new ModelAndView("memo/memo");
	}

	@RequestMapping("/memo_list.do")
	public ModelAndView memo_list() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MemoDTO> list = memoDao.getMemoList();
		map.put("items", list);
		// new ModelAndView("view의 url", "모델에서 참조하는 변수명", 참조할값)
		return new ModelAndView("memo/memo_list", "map", map);
	}

	// 폼에서 입력한 내용이 MemoDto로 쌓임
	@RequestMapping("/memo_insert.do")
	public String memo_insert(@ModelAttribute("memo") MemoDTO dto) {
		memoDao.memoInsert(dto);
		// memo.do로 리디렉트
		return "redirect:/memo.do";
	}

	@RequestMapping("/memo_view.do")
	public ModelAndView memo_view(@RequestParam("idx") int idx) {
		// service호출 및 모델 저장
		MemoDTO dto = memoDao.getMemoDetail(idx);
		// 포워딩
		return new ModelAndView("memo/memo_view", "dto", dto);
	}

	@RequestMapping("/memo_update.do")
	public String memo_update(@ModelAttribute("memo") MemoDTO dto, BindingResult result) {
		memoDao.memoUpdate(dto);

		return "redirect:/memo.do";
	}

	// @RequestParam("idx") 을 생략해도 됨
	@RequestMapping("/memo_delete.do")
	public String memo_delete(@RequestParam("idx") int idx) {
		memoDao.memoDelete(idx);

		return "redirect:/memo.do";
	}

}
