package middleProject.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import middleProject.dao.JudaDAO;
import middleProject.domain.BoardVO;
import middleProject.domain.GoodsTypeVO;
import middleProject.domain.GoodsVO;
import middleProject.domain.LoginVO;
import middleProject.domain.MemberVO;

@Service("judaService")
public class JudaServiceImpl implements JudaService {
	
	@Autowired
	private JudaDAO judaDAO;
	
	// 구경하기
	public List<GoodsVO> getGoodsList(GoodsTypeVO vo) {
		return judaDAO.getGoodsList(vo);
	}

	// 가입하기
	public Integer insertMember(MemberVO vo) {
		return judaDAO.insertMember(vo);
	}
	
	//	아이디 중복 체크 sql + 로그인 기능 sql
	public Integer selectAllLogin(LoginVO vo) {
		return judaDAO.selectAllLogin(vo);
	} // end of selectAllLogin()
	
	// 로그인???
	public Integer selectAllLogin(LoginVO vo, HttpSession session) {
		Integer name = judaDAO.selectAllLogin(vo);
		if(name != null) { // 세션 변수 저장
			session.setAttribute("id", vo.getMember_id());
			session.setAttribute("name", name);
		}
		return name;
	}

	// 상세페이지 (수량 증감)
	public GoodsVO getGoods(String goods_id) {
		return judaDAO.getGoods(goods_id);
	}

	@Override
	public void logout(HttpSession session) {
	}

	@Override
	public boolean loginCheck(LoginVO vo, HttpSession session) {
		return false;
	}

	@Override
	public void insertBoard(BoardVO vo) {
	}

	@Override
	public void updateBoard(BoardVO vo) {
	}

	@Override
	public void deleteBoard(BoardVO vo) {
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return null;
	}

	@Override
	public List<BoardVO> getBoardList(HashMap map) {
		return null;
	}
	
	
	// ##### 게시판 #####
//	public void insertBoard(BoardVO vo) {
//		judaDAO.insertBoard(vo);
//	}
//
//	public void updateBoard(BoardVO vo) {
//		judaDAO.updateBoard(vo);
//	}
//
//	public void deleteBoard(BoardVO vo) {
//		judaDAO.deleteBoard(vo);
//	}
//
//	public BoardVO getBoard(BoardVO vo) {
//		return judaDAO.getBoard(vo);
//	}
//
//	public List<BoardVO> getBoardList(HashMap map) {
//		return judaDAO.getBoardList(map);
//	}
	
}
