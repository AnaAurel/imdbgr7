package login;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static login.EmailSender.*;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String u = request.getParameter("u");
        String p = request.getParameter("p");

        DBOper d = new DBOper();

        d.register(u, p);
        int value = d.login(u,p);

        if(value!=-1) { // user logat
            HttpSession session = request.getSession();
            session.setAttribute("userid", value);
            System.out.println("LoginServlet: bravoooo  ");

//            send email

            try {
                EmailSender.send("flaviu@fasttrack.org", "Welcome", "Welcome to our app.");
            } catch (MessagingException e) {
                e.printStackTrace();
            }

            response.sendRedirect("index.jsp");

        }
        else
        {

            System.out.println("LoginServlet:registration not done correctly ");
            String back = "/register.html";
            HttpSession session = request.getSession();
            session.removeAttribute("userid");
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(back);
            dispatcher.forward(request, response);
        }

    }

}
