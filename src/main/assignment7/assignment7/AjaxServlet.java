package assignment7;

import java.io.IOException;
import java.io.PrintWriter;

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
    		System.out.println(operation);
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
//		JSONObject combined = new JSONObject();
//		combined.put("exam", new JSONObject(uploadRqst));
//		combined.put("app-instance", conf.getAppInsStatus());
//		return combined.toString();
		return "prova daniele";
	}
    	
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
