package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import BusinessLayer.GestionCommande;
import BusinessLayer.GestionUsers;
import DataBase.DataProduit;
import Models.Commande;
import Models.Produit;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GestionUsers GU=new GestionUsers();
	GestionCommande GC = new GestionCommande();
	DataProduit DP = new DataProduit();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String cartPr=request.getParameter("addTocart");
		if(cartPr!=null) {
			HttpSession session= request.getSession(false);
			if(session.getAttribute("id") != null) {
				Commande c=new Commande();
				String email=session.getAttribute("id").toString();
				Integer id=GU.getUserByEmail(email);
				c.setIdClient(id.toString());
				Produit p = new Produit();
				p=DP.getProduit(cartPr);
				if(p.getQuantite() == 0) {
					request.setAttribute("errorMessage", "Rupture de produit");
					request.getRequestDispatcher("/index.jsp").forward(request, response);
					return ;
				}
				ArrayList<Integer> Commandes1 = new ArrayList<Integer>();
				Commandes1=GC.getCart(id);
				if(Commandes1.contains(Integer.parseInt(cartPr))) {
					GC.updateQte(cartPr,id.toString());
				}
				else{
					Cookie ck=new Cookie("produit"+cartPr, cartPr);
				    ck.setValue(cartPr);
				    ck.setMaxAge(60 * 60 * 24 * 30 * 12);
				    response.addCookie(ck);
					GC.ajouterAuPanier(c,Integer.parseInt(cartPr));	
					session.setAttribute("cart", GC.getCart(GU.getUserByEmail(email)).size());
				
				}
			}else {
				request.setAttribute("errorMessage", "Connectez-vous");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}
		HttpSession session= request.getSession(false);
		float total=0;
		if(session.getAttribute("id") != null) {
			ArrayList<Integer> Commandes = new ArrayList<Integer>();
			ArrayList<Produit> cart = new ArrayList<Produit>();
			Commandes=GC.getCart(GU.getUserByEmail(session.getAttribute("id").toString()));
			for(int i=0;i<Commandes.size();i++) {
				cart.add(DP.getProduitForCart(Commandes.get(i).toString()));
			}
			request.setAttribute("cart", cart);
			request.setAttribute("total", total);
			String cartIdP=request.getParameter("delCart");
			Integer idClient =GU.getUserByEmail(session.getAttribute("id").toString());
			if(cartIdP!=null) {
				GC.removeFromCart(cartIdP,idClient.toString());
				session.setAttribute("cart", GC.getCart(GU.getUserByEmail(session.getAttribute("id").toString())).size());	
				response.sendRedirect("Cart");
				return ;
			}
		}
		
		
		request.getRequestDispatcher("WEB-INF/Cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
