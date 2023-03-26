package Servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BusinessLayer.GestionProduit;
import DataBase.DataProduit;
import Models.Produit;

/**
 * Servlet implementation class ProduitServlet
 */
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataProduit dp=new DataProduit();
	GestionProduit GP = new GestionProduit();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Produit p = new Produit();
		ArrayList<Produit> produits = new ArrayList<Produit>();
		ResultSet rs;
		String idProduit=request.getParameter("id");
		if(idProduit!=null) {
			String categ=GP.getCategory(idProduit);
			rs=dp.getCategorie(categ);
			try {
				while(rs.next()) {
					Produit p2 = new Produit();
					p2.setName(rs.getString("nomProduit"));
					p2.setPrix(rs.getFloat("prix"));
					p2.setDescription(rs.getString("description"));
					p2.setCategorie(rs.getString("categorie"));
					p2.setQuantite(rs.getInt("quantite"));
					p2.setImagePath(rs.getString("imagePath"));
					p2.setImageName(rs.getString("imageName"));
					p2.setId(rs.getInt("idProduit"));
					produits.add(p2);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    Cookie ck=new Cookie("produit"+idProduit, idProduit);
		    ck.setValue(idProduit);
		    ck.setMaxAge(60 * 60 * 24 * 30 * 12);
		    response.addCookie(ck);
			p=dp.getProduit(idProduit);
			request.setAttribute("produit", p);
			request.setAttribute("produits", produits);
			request.getRequestDispatcher("WEB-INF/Produit.jsp").forward(request, response);		
		}else {
			request.getRequestDispatcher("WEB-INF/Categories.jsp").forward(request, response);
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
