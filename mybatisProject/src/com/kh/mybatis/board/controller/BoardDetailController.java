package com.kh.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.board.model.service.BoardService;
import com.kh.mybatis.board.model.service.BoardServiceImpl;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;

/**
 * Servlet implementation class BoardDetailController
 */
@WebServlet("/detail.bo")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int boardNo = Integer.parseInt(request.getParameter("bno"));
		//다형성 적용
		BoardService boardService = new BoardServiceImpl();
		
		//조회수를 증가시키는 메소드
		int result = boardService.increaseCount(boardNo); 
		
		//
		if(result>0) {
			//게시글 상세조회 메소드
			Board b = boardService.selectBoard(boardNo);
			
			//게시글에 달려있는 댓글 조회 메소드
			ArrayList<Reply> list = boardService.selectReply(boardNo);
					
			
			
			request.setAttribute("b", b);
			request.setAttribute("list", list);
			request.getRequestDispatcher("WEB-INF/views/board/boardDeatilView.jsp").forward(request, response);
			
		}else {
			request.setAttribute("errorMsg", "조회 실패");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
