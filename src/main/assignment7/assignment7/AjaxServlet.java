package assignment7;

import java.awt.Color;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxServlet
 */
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("op");		
    	String json = "";
    	PrintWriter out = response.getWriter();
    		if (operation == null) operation = "";
    		switch (operation) {
    		case "reload":    			
    			json = createPayload();
    			response.setContentType("application/json");
    			out = response.getWriter();			    
    			out.print(json);  			
    			break;    		
    		default:
    			throw new ServletException("Invalid URI");
    		}
    	}
	
	private String createPayload() {
		Random rand = new Random();
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color randomColor = new Color(r, g, b);
		String hex = Integer.toHexString(randomColor.getRGB() & 0xffffff);
		if (hex.length() < 6) {
		    hex = "0" + hex;
		}
		hex = "#" + hex;
		return "Paiting bottom box from server with color: " + hex;
	}
    	
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
