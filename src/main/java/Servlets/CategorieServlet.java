package Servlets;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.util.ArrayList;

import BusinessLayer.GestionProduit;
import DataBase.DataProduit;
import Models.Produit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;


/**
 * Servlet implementation class CategorieServlet
 */
@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class CategorieServlet extends HttpServlet {
	static int c=1;
	private static final long serialVersionUID = 1L;
	DataProduit pr = new DataProduit();
	GestionProduit GP = new GestionProduit();
	
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategorieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		c++;
		ArrayList<Produit> produits = new ArrayList<Produit>();
		HttpSession session = request.getSession(false);
		if(session!=null) {
			request.setAttribute("session", session.getAttribute("id"));
		}
		String categorie = (String) request.getParameter("categorie");
		request.setAttribute("categorie", categorie);
		if(categorie!=null) {
			
			try {
				ResultSet rs=pr.getCategorie(categorie);
				while(rs.next()) {
					Produit p = new Produit();
					p.setName(rs.getString("nomProduit"));
					p.setPrix(rs.getFloat("prix"));
					p.setDescription(rs.getString("description"));
					p.setCategorie(rs.getString("categorie"));
					p.setQuantite(rs.getInt("quantite"));
					p.setImagePath(rs.getString("imagePath"));
					p.setImageName(rs.getString("imageName"));
					p.setId(rs.getInt("idProduit"));
					produits.add(p);
					System.out.println(p.getCategorie());
				}
			}
			catch(Exception e) {
				System.out.println(" "+e.getMessage());
			}
			
			request.setAttribute("produits", produits);
			request.getRequestDispatcher("/WEB-INF/Produits.jsp").forward(request, response);
		}
		else if(categorie == null) {
			request.getRequestDispatcher("/WEB-INF/Categories.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String action = request.getParameter("action");
	    if(action.equals("modifier")) {
	    	c++;
	    	String nameE=request.getParameter("nom");
			String prixE=request.getParameter("prix");
			String categorieE=request.getParameter("categorie");
			String quantiteE=request.getParameter("quantite");
			String descripE=request.getParameter("description");
			Part imageE = request.getPart("imageEdit");
			Path pathE = Paths.get(imageE.getSubmittedFileName());
			//System.out.println(pathE.toAbsolutePath());
			OutputStream output = null;
			InputStream input = null;
			if(imageE.getSize()>0) {
				try {
					output = new FileOutputStream(new File("E:/eclipse-workspace/Project/src/main/webapp/images"+File.separator+imageE.getSubmittedFileName().substring(0,imageE.getSubmittedFileName().indexOf("."))+c+".jpg"));
					input = imageE.getInputStream();
					int read=0;
					final byte[] bytes=new byte[1024];
					while((read=input.read(bytes))!=-1) {
						output.write(bytes,0,read);
					}
					
				}
				catch(FileNotFoundException e) {
					System.out.println(e.getMessage());
				}
			}
			Produit p = pr.getProduit(request.getParameter("idPro"));
			p.setCategorie(categorieE);
			p.setName(nameE);
			if(imageE.getSize()>0) {
				p.setImageName(imageE.getSubmittedFileName().substring(0,imageE.getSubmittedFileName().indexOf("."))+c+".jpg");
				p.setImagePath("E:/eclipse-workspace/Project/src/main/webapp/images/"+imageE.getSubmittedFileName().substring(0,imageE.getSubmittedFileName().indexOf("."))+c+".jpg");
			}
			p.setPrix(Float.parseFloat(prixE));
			p.setDescription(descripE);
			p.setQuantite(Integer.parseInt(quantiteE));
			System.out.println(request.getParameter("idPro"));
			GP.updateProduit(request.getParameter("idPro"), p);
	        response.sendRedirect("Dashboard");
	        return ;
	    }else if(action.equals("produit")){
		c++;
		String name=request.getParameter("nom");
		String prix=request.getParameter("prix");
		String categorie=request.getParameter("categorie");
		String quantite=request.getParameter("quantite");
		String descrip=request.getParameter("description");
		Part image = request.getPart("image");
		Path path = Paths.get(image.getSubmittedFileName());
		System.out.println(path.toAbsolutePath());
		
		OutputStream output = null;
		InputStream input = null;
		
		try {
			output = new FileOutputStream(new File("E:/eclipse-workspace/Project/src/main/webapp/images"+File.separator+image.getSubmittedFileName().substring(0,image.getSubmittedFileName().indexOf("."))+c+".jpg"));
			input = image.getInputStream();
			int read=0;
			final byte[] bytes=new byte[1024];
			while((read=input.read(bytes))!=-1) {
				output.write(bytes,0,read);
			}
			
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		
		Produit p = new Produit();
		p.setCategorie(categorie);
		p.setName(name);
		p.setImageName(image.getSubmittedFileName().substring(0,image.getSubmittedFileName().indexOf("."))+c+".jpg");
		p.setImagePath("E:/eclipse-workspace/Project/src/main/webapp/images/"+image.getSubmittedFileName().substring(0,image.getSubmittedFileName().indexOf("."))+c+".jpg");
		p.setPrix(Float.parseFloat(prix));
		p.setDescription(descrip);
		p.setQuantite(Integer.parseInt(quantite));
		int row = pr.addProduit(p);
	    if (row > 0) {
	        System.out.println("File uploaded and saved into database");
	        response.sendRedirect("Dashboard");
	        return ;
	    }
	    }
		
	}

}
