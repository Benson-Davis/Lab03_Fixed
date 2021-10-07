package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bdavi
 */
public class ArithmeticCalculatorServlet extends HttpServlet
{
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
        request.setAttribute("answer", "---");
        //have the servlet call upon the JSP to be loaded by client browser
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticCalculator.jsp").forward(request,response);
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
        
        //get attributes from user fields and prepare int variables for doing math
        String firstString = request.getParameter("first");
        String secondString = request.getParameter("second");
        
        int firstNum;
        int secondNum;
        int result;
        
        //get atttributes for the buttons
        String add = request.getParameter("add");
        String subtract = request.getParameter("subtract");
        String multiply = request.getParameter("multiply");
        String modulo = request.getParameter("modulo");
        
        request.setAttribute("first", firstString);
        request.setAttribute("second", secondString);
        
        //check that neither user field is empty
        if(firstString == null || firstString.equals("") || secondString == null || secondString.equals(""))
        {
            request.setAttribute("answer", "invalid");
            //request.setAttribute("first", "");
            //request.setAttribute("second", "");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticCalculator.jsp").forward(request,response);
            return;
        }
        
        //check that both fields contain numbers. If so, convert the string to int, otherwise reload page with error message
        try
        {
            firstNum = Integer.parseInt(firstString);
            secondNum = Integer.parseInt(secondString);
        } catch (NumberFormatException e)
        {
            request.setAttribute("answer", "invalid");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticCalculator.jsp").forward(request, response);
            return;
        }
        
        //this section checks which button was pressed by checking which attribute isn't null. Learned from: https://stackoverflow.com/questions/1054543/how-to-find-out-which-html-button-was-pushed-in-my-servlet
        if(add != null && subtract == null && multiply == null && modulo == null)
        {
            result = firstNum + secondNum;
        } else if(subtract != null && add == null && multiply == null && modulo == null)
        {
            result = firstNum - secondNum;
        } else if(multiply != null && add == null && subtract == null && modulo == null)
        {
            result = firstNum * secondNum;
        } else if(modulo != null && add == null && subtract == null && multiply == null)
        {
            result = firstNum % secondNum;
        } else
        {
            request.setAttribute("answer", "something has gone horribly wrong. Please try again");
            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticCalculator.jsp").forward(request, response);
            return;
        }
        
        request.setAttribute("answer", result);
        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticCalculator.jsp").forward(request,response);
        return;
    }
}
