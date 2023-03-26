package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.google.gson.Gson;

import BusinessLayer.GestionCommande;
import BusinessLayer.GestionProduit;
import BusinessLayer.GestionUsers;
import DataBase.DataProduit;
import Models.Commande;
import Models.Produit;
import Models.User;

/**
 * Servlet implementation class BackOfficeServlet
 */
public class BackOfficeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GestionUsers GU=new GestionUsers();
	GestionProduit GP=new GestionProduit();
	DataProduit PD = new DataProduit();
	GestionCommande GC=new GestionCommande();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackOfficeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<User> users = new ArrayList<User>();
		ArrayList<Produit> produits = new ArrayList<Produit>();
		ArrayList<Commande> commandes = new ArrayList<Commande>();
		String id=request.getParameter("id");
		String idProd=request.getParameter("idEdit");
		String annule=request.getParameter("annule");
		String delete=request.getParameter("delete");
		String livrer=request.getParameter("livrer");
		HttpSession session=request.getSession(false);
		
		if(session!=null) {
			if(id!=null) {
				int row=GP.deleteProduit(id);
				if(row!=0) {
					request.setAttribute("success","Le produit a été bien supprimé");
				}
				else {
					request.setAttribute("errorMessage","Le produit n'est pas supprimé");
				}
				request.getRequestDispatcher("WEB-INF/Dashboard.jsp").forward(request,response);
				return ;
			}
			if(idProd!=null) {
				Produit p = PD.getProduit(idProd);
				request.setAttribute("produitEdit", p);
				request.getRequestDispatcher("WEB-INF/Modifier.jsp").forward(request, response);
				return ;
	
			}
			if(annule!=null) {
				int row=GC.annuleCommandes(annule);
				if(row!=0) {
					request.setAttribute("success","La commande a été bien annulée");
				}
				else {
					request.setAttribute("errorMessage","La commande n'est pas annulée");
				}
				request.getRequestDispatcher("WEB-INF/Dashboard.jsp").forward(request,response);
				return;
			}
			
			if(livrer!=null) {
				int row=GC.livrerCommande(livrer);
				if(row>0) {
					request.setAttribute("success","La commande a été bien livrée");
				}
				else if(row == -1){
					request.setAttribute("errorMessage","La commande n'est pas livrée , il se peut qu'elle n'est pas encore payée");
				}
				else {
					request.setAttribute("errorMessage","La commande n'est pas livrée , essayez ultérieurement");
				}
				request.getRequestDispatcher("WEB-INF/Dashboard.jsp").forward(request,response);
				return;
			}
			
			if(delete!=null) {
				int row=GU.deleteUser(delete);
				if(row != 0) {
					request.setAttribute("success", "L'utilisateur a été bien supprimé");
				}
				else {
					request.setAttribute("errorMessage", "L'utilisateur n'est pas supprimé");
				}
				
				request.getRequestDispatcher("WEB-INF/Dashboard.jsp").forward(request,response);
				return ;
			}
			
			commandes=GC.getAllCommandes();
			produits=PD.getAllProduits();
			users=GU.getAllUsers();
			request.setAttribute("users", users);
			request.setAttribute("commandes", commandes);
			request.setAttribute("produits", produits);
			request.getRequestDispatcher("WEB-INF/Dashboard.jsp").forward(request, response);
			return;
		}
		else {
			request.setAttribute("errorMessage", "Juste l'administrateur peut y'acceder");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("idHolder");
		if(id!=null) {
			int row=0;
			row=GP.deleteProduit(id);
			if(row>0) {
				Cookie ck[] = request.getCookies();
				for(int i=0;i<ck.length;i++) {
					if(ck[i].getName().contains("produit"+id)) {
						 Cookie cookie = new Cookie("produit"+id, "");
						 cookie.setMaxAge(0);
						 response.addCookie(cookie);
					}
				}
				request.setAttribute("success", "Le produit est supprimé");
			}
			else if(row == -1) {
				request.setAttribute("errorMessage", "Vous pouvez pas supprimer ce produit car un client l'a déjà commandé");
			}
			else {
				request.setAttribute("errorMessage", "Vous pouvez pas supprimer ce produit, essayez ultérieurement");
			}
			
			request.getRequestDispatcher("WEB-INF/Dashboard.jsp").forward(request, response);
			return ;
		}
		
		request.getRequestDispatcher("WEB-INF/Dashboard.jsp").forward(request, response);
	}

}
