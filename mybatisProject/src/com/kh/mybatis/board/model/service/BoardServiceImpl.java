package com.kh.mybatis.board.model.service;

import static com.kh.mybatis.common.template.Template.getSqlSession;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.dao.BoardDao;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;

public class BoardServiceImpl implements BoardService{

	private BoardDao boardDao = new BoardDao();
		
	
	@Override
	public int selectListCount() {
		SqlSession sqlSession = getSqlSession();
		int listCount = boardDao.selectListCount(sqlSession);
		
		sqlSession.close();
		
		return listCount;
	}

	@Override
	public ArrayList<Board> selectList(PageInfo pi) {
		
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Board> list = boardDao.selectList(sqlSession,pi);
		
		sqlSession.close();
		
		return list;
	}

	@Override
	public int increaseCount(int boardNo) {

		SqlSession sqlSession = getSqlSession();
		
		int result = boardDao.increaseCount(sqlSession,boardNo);
		
		if(result>0) {
			sqlSession.commit();
		}else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	@Override
	public Board selectBoard(int boardNo) {

		SqlSession sqlSession = getSqlSession();
		
		Board b = boardDao.selectBoard(sqlSession,boardNo);
		
		sqlSession.close();
		
		return b;
	}

	@Override
	public ArrayList<Reply> selectReply(int boardNo) {

		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Reply> list = boardDao.selectReplyList(sqlSession,boardNo);
		
		sqlSession.close();
						
		return list;
	}

	@Override
	public ArrayList<Board> selectBoard(PageInfo pi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectSearchCount(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Board> selectsearchBoard(HashMap<String, String> map,PageInfo pi) {

		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Board> list = boardDao.selectsearchBoard(sqlSession,map,pi);
		
		sqlSession.close();
		
		return list;
	}
	

}
