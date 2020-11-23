package action;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import dao.Dao;
import dto.Dto;

/**
 * Servlet implementation class SelectAction
 */
@WebServlet("/SelectAction")
public class SelectAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		String dept=req.getParameter("dept");
		String check=req.getParameter("check");
		System.out.println(id);
		System.out.println(dept);
		System.out.println(check);
		Dao dao=Dao.getInstance();
		if(check.equals("id")){List<Dto> list=dao.getIdList(id);req.setAttribute("list",list);}
		if(check.equals("dept")){List<Dto> list=dao.getDeptList(dept);req.setAttribute("list",list);}
		RequestDispatcher dis=req.getRequestDispatcher("result.jsp");
		dis.forward(req, res);
	}

}