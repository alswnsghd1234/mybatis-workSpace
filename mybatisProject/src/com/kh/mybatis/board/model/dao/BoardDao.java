package com.kh.mybatis.board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.model.vo.PageInfo;

public class BoardDao {

	public int selectListCount(SqlSession sqlSession) {
		
		return sqlSession.selectOne("boardMapper.selectListCount");
	}

	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi) {
		
		//sqlSession.selectList("boardMapper.selectList",pi)
		
		//마이바티스에서는 페이징 처리를 위해 RowBounds 라는 클래스를 제공한다
		
		//offset : 몇개의 게시글을 건너뛰고 조회할것인지 정하는 값
		/*
		 * boardLimit : 5 일 경우
		 * 								offset 건너뛸 값               limit (조회할 숫자)
		 * currentPage : 1 -> 1~5         	0					5
		 * currentPage : 2 -> 6~10		  	5  					5
		 * currentPage : 3 -> 11~15		  	10					5
		 * 
		 * 현재 페이지 - 1 * boardLimit : offset(건너 뛸 값)
		 * 
		 * */
		
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage() - 1) * limit;
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		ArrayList<Board> list = (ArrayList)sqlSession.selectList("boardMapper.selectList",null,rowBounds);
		
		return list;
	}

}
