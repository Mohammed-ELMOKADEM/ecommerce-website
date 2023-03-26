package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import BusinessLayer.GestionCommande;
import BusinessLayer.GestionUsers;
import DataBase.DataUser;
import Models.User;

/**
 * Servlet implementation class InscriptionServlet
 */
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       DataUser dataUser = new DataUser();
       GestionUsers gestion = new GestionUsers();
       GestionCommande GC = new GestionCommande();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubHttpSession session = request.getSession(true);
		String action=request.getParameter("action").toString();
		if(action.equals("signup")) {
			String name=request.getParameter("register-name").toString();
			String email=request.getParameter("register-email").toString();
			String pwd=request.getParameter("register-password").toString();
			String tele=request.getParameter("telephone").toString();
			String add=request.getParameter("adresse").toString();
			User u = new User();
			u.setEmail(email);
			u.setNom(name);
			u.setPwd(pwd);
			u.setAdresse(add);
			u.setTelephone(tele);
			dataUser.saveUser(u);
		}
		else if(action.equals("signin")) {
			String email=request.getParameter("singin-email").toString();
			String pwd=request.getParameter("singin-password").toString();
			
			Integer v =gestion.existUser(email, pwd);
			
			if(v!=0) {
				HttpSession session = request.getSession(true);
				session.setAttribute("id", email);
				session.setAttribute("cart", GC.getCart(gestion.getUserByEmail(email)).size());	
				response.sendRedirect("Home");
				return;
			}
			else {
				request.setAttribute("errorMessage", "Email ou Mot de Passe incorrecte!!");
			}
				HttpSession session = request.getSession(false); 
				request.setAttribute("session", session.getAttribute("id"));
		}

		request.getRequestDispatcher("/index.jsp").forward(request, response);;
	}

}
