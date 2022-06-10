package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	/*
	 * 기존 JDBC
	 * public static Connection getConnection(){
	 * 		
	 *		driver.properties 파일 읽기
	 *		해당 db와 접속된 Connection 객체 생성 및 반환 	
	 * }
	 *
		public static void close(JDBC용 객체) {
	
		}
		public static void commit/rollback(객체){
			
		}
	 * */
	
	//마이바티스
	public static SqlSession getSqlSession() {
		//mybatis-config.xml 파일을 읽어서
		//해당 DB에 접속 SqlSession 객체 생성 및 반환
		SqlSession sqlSession = null;
			
		//sqlSession 객체를 생성하기 위해서는 SqlSessionFactory 객체가 필요
		//SqlSessionFactory 객체를 생성하기 위해서는 SqlSessionFactoryBuilder 객체가 필요
		
		String resource = "/mybatis-config.xml"; // /는 최상위 폴더를 의미 (resources,src)
		
			try {
				InputStream stream = Resources.getResourceAsStream(resource); //자원으로부터 통로를 얻겠다.
				//SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
				//SqlSession session = sqlSessionFactory.openSession();
				
				//1단계) new SqlSessionFactoryBuilder() : SqlSessionFactoryBuilder 객체 생성
				//2단계) .build(stream) : 통로로부터 mybatis-config.xml파일을 읽어들이면서 sqlSessionFactory 객체를 만들겠다.
				//3단계) .openSession() : SqlSession 객체 생성  
				
				sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession();
			
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return sqlSession;
	}
	
	
	
	
}
