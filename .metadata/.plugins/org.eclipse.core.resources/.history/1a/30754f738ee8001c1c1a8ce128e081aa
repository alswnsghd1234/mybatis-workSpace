package com.kh.mybatis.member.model.dao;


import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {

	public int insertMember(SqlSession sqlSession, Member m) {
		
//		int result = 0;
//		PreparedStatement pstmt = null;
//		String sql = prop.getProperty("키값")
//		
//		pstmt=conn.pre ~~
//		pstmt.setString(1, ?);
//		
//		
//		
//		return result;
		
		/*
		 * sqlSession에서 제공하는 메소드를 통해서 sql문을 찾아서 실행하고 결과를 받을 수 있다.
		 * 
		 * sqlSession.sql문종류에맞는메소드("매퍼파일namespace.해당sql의 id",sql문을완성시킬객체);
		 * ->해당 sql문이 완성상태(위치홀더 없을때)이면 sql문을완성시킬객체는 생략 가능
		 * 
		 * return = sqlSession.insert("mapper.insertMember",m);
		 * 
		 * */
		
		return sqlSession.insert("memberMapper.insertMember", m);
		
		
	}

	public Member loginMember(SqlSession sqlSession, Member m) {
		
//		Member loginUser = null;
		//selectOne 메소드 : 조회결과가 없다면 null을 반환
		
//		Member loginUser = sqlSession.selectOne("memberMapper.loginMember",m);
//		
//		return loginUser;
		
		
		return sqlSession.selectOne("memberMapper.loginMember", m);
	}

}
