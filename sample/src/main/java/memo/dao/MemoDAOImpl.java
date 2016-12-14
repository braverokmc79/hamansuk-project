package memo.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import memo.dto.MemoDTO;

// dao bean으로 등록시키는 어노테이션
@Repository
public class MemoDAOImpl implements MemoDAO {
	// 스프링에서 sqlSession을 관리하므로 commit(), close() 등의 작업은 하지 말 것
	// mybatis 객체를 자동으로 생성하여 주입시키는 어노테이션
	@Inject
	private SqlSession sqlSession;

	@Override
	public List<MemoDTO> getMemoList() {
		return sqlSession.selectList("memo.memoList");
	}

	@Override
	public void memoInsert(MemoDTO dto) {
		sqlSession.insert("memo.memoInsert", dto);
	}

	@Override
	public MemoDTO getMemoDetail(int idx) {
		return sqlSession.selectOne("memo.memoDetail", idx);
	}

	@Override
	public void memoUpdate(MemoDTO dto) {
		sqlSession.update("memo.memoUpdate", dto);

	}

	@Override
	public void memoDelete(int idx) {
		sqlSession.delete("memo.memoDelete", idx);
	}
}
