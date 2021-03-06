package com.kh.mybatis.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.mybatis.board.model.service.BoardService;
import com.kh.mybatis.board.model.service.BoardServiceImpl;
import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.model.vo.PageInfo;
import com.kh.mybatis.common.template.Pagination;

/**
 * Servlet implementation class BoardSearchController
 */
@WebServlet("/search.bo")
public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("type");
		String keyword = request.getParameter("keyword");
		
		HashMap<String,String> map = new HashMap<>();
		
		map.put("type", type);
		map.put("keyword", keyword);
		
		BoardService boardService = new BoardServiceImpl();
		
		int searchCount = boardService.selectSearchCount(map); //검색 결과 개수
		int currentPage = Integer.parseInt(request.getParameter("cPage"));
		int pageLimit = 10;
		int boardLimit = 5;
		
		int maxPage; //가장 마지막 페이지가 몇번페이지인지 (총 페이지수)
		int startPage; //페이지 하단에 보여질 페이징 시작 수 
		int endPage; //페이지 하단에 보여질 페이징 끝 수 
		
		
		maxPage = (int)(Math.ceil((double)searchCount/boardLimit));
		
		startPage = (currentPage-1)/pageLimit * pageLimit + 1;
		
		endPage = startPage+pageLimit - 1;
		
		if(endPage>maxPage) {
			endPage=maxPage;
		}
		
		PageInfo pi = Pagination.getPageInfo(searchCount, currentPage, pageLimit, boardLimit);
		
		ArrayList<Board> list = boardService.selectsearchBoard(map,pi);
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		request.getRequestDispatcher("WEB-INF/views/board/boardListView.jsp").forward(request, response);
		
		
		System.out.println(list);
		System.out.println(pi);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
