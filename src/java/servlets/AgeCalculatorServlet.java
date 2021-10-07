package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Character.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bdavi
 */
public class AgeCalculatorServlet extends HttpServlet {

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        //have the servlet call upon the JSP to be loaded by client browser
        getServletContext().getRequestDispatcher("/WEB-INF/ageCalculator.jsp").forward(request,response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String ageString = request.getParameter("age");
        int ageNum;
        
        //catch if text box is left empty. Must check for null first, since .equals() requires a string be present
        if(ageString == null || ageString.equals(""))
        {
            request.setAttribute("result", "You must give your current age.");
            getServletContext().getRequestDispatcher("/WEB-INF/ageCalculator.jsp").forward(request, response);
            return;
        }
        //checks if entry is greater than 3 characters long, i.e. not a number or feasible age
        if(ageString.length() > 3)
        {
            request.setAttribute("result", "You must enter a number");
            getServletContext().getRequestDispatcher("/WEB-INF/ageCalculator.jsp").forward(request, response);
            return;
        }
        //try to parse the string into an int. If it doesn't work, catch the exception and reload the page with the error message
        try
        {
            ageNum = Integer.parseInt(ageString);
        } catch (NumberFormatException e)
        {
            request.setAttribute("result", "Please enter a valid number");
            getServletContext().getRequestDispatcher("/WEB-INF/ageCalculator.jsp").forward(request, response);
            return;
        }
        
        ageNum++;
        String outputMessage = "Your age next birthday will be " + ageNum;
        
        //create and set an attribute of the request object
        request.setAttribute("result", outputMessage);
        getServletContext().getRequestDispatcher("/WEB-INF/ageCalculator.jsp").forward(request, response);
        return;
    }
}
