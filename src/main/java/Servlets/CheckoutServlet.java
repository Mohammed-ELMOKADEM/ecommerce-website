package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import BusinessLayer.GestionCommande;
import BusinessLayer.GestionUsers;
import DataBase.DataProduit;
import Models.Produit;

/**
 * Servlet implementation class CheckoutServlet
 */
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GestionUsers GU=new GestionUsers();
	GestionCommande GC = new GestionCommande();
	DataProduit DP = new DataProduit();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
				float total = 0;
				String email = request.getParameter("id");
			if(session!=null) {
				if(session.getAttribute("id")!=null) {
					if(email!=null) {
						ArrayList<Integer> Commandes = new ArrayList<Integer>();
						ArrayList<Produit> cart = new ArrayList<Produit>();
						Commandes=GC.getCart(GU.getUserByEmail(email));
						System.out.println("size= "+Commandes.size());
						for(int i=0;i<Commandes.size();i++) {
							cart.add(DP.getProduitForCart(Commandes.get(i).toString()));
						}
						request.setAttribute("cart", cart);
						request.setAttribute("total", total);
					}
				request.getRequestDispatcher("WEB-INF/Checkout.jsp").forward(request, response);
			}
				else {
					request.setAttribute("errorMessage", "Connectez-vous");
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
		}
		else {
			request.setAttribute("errorMessage", "Connectez-vous");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		if(session!=null) {
			String address=request.getParameter("adresse");
			String city=request.getParameter("ville");
			String add=address.concat(" "+city);
			String idClient=GU.getUserByEmail(session.getAttribute("id").toString()).toString();
			GC.ConfirmerCommande(GC.getIdCommande(idClient).toString(),add);
			session.setAttribute("cart", GC.getCart(GU.getUserByEmail(session.getAttribute("id").toString())).size());
			request.setAttribute("Success", "Votre commande est confirmé");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
