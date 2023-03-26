package Servlets;
import DataBase.ConnectionDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import BusinessLayer.GestionCommande;
import BusinessLayer.GestionUsers;
import DataBase.DataProduit;
import Models.Produit;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class HomeServlet
 */

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataProduit DP=new DataProduit();
	GestionCommande GC = new GestionCommande();
	GestionUsers GU = new GestionUsers();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Produit> ProduitsRec = new ArrayList<Produit>();
		ArrayList<Produit> TopSelling = new ArrayList<Produit>();
		Cookie ck1[] = request.getCookies();
		Produit p = new Produit();
		ArrayList<Integer> ids=new ArrayList<Integer>();
		ids=GC.topSelling();
		int j=0;
		int taille=0;
		if(ck1.length-9>0) {
			taille=ck1.length-9;
		}else {
			taille=0;
		}
		System.out.println("length: "+ck1.length+" Taille:"+taille);
		for(int i=ck1.length-1;i>=taille;i--) {
			if(ck1[i].getName().contains("produit")) {
				j++;
				p=DP.getProduit(ck1[i].getValue());
				ProduitsRec.add(p);
				if(j>=8) {
					break;
				}
			}
		}
		request.setAttribute("ProduitsRec", ProduitsRec);
		String log=request.getParameter("logout");
		HttpSession session = request.getSession(false);
		if(session!=null && session.getAttribute("id")!=null) {
			request.setAttribute("session", session.getAttribute("id"));
			session.setAttribute("cart", GC.getCart(GU.getUserByEmail(session.getAttribute("id").toString())).size());
		}	
		if(log!=null) {
			session.invalidate();
			session = request.getSession(false);
		}
		for(int k=0;k<ids.size();k++) {
			TopSelling.add(DP.getProduit(ids.get(k).toString()));
		}
		request.setAttribute("TopSelling", TopSelling);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		try{  
			   Class.forName("com.mysql.cj.jdbc.Driver");
			    
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");  

			   Statement stmt=con.createStatement();
			    
			   ResultSet rs=stmt.executeQuery("select * from user"); 

			   while(rs.next())  
			    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			     
			   con.close();  
			   
			   }catch(Exception e){
			    System.out.println(e);
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
