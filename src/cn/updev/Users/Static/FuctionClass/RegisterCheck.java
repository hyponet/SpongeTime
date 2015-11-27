package cn.updev.Users.Static.FuctionClass;

import cn.updev.Users.Static.UserOrGroupDAO.UserOrGroupQuery;
import com.sun.org.apache.xml.internal.serialize.Printer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by blf2 on 15-11-27.
 */
@WebServlet(name = "RegisterCheck")
public class RegisterCheck extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String eMail = request.getParameter("eMail");
        PrintWriter pout = response.getWriter();
        if(userName != null){
            if(new UserOrGroupQuery().queryGroupInfoByName(userName) == null){
                pout.print("true");
            }else{
                pout.print("false");
            }
        }else if(eMail != null){
            if(new UserOrGroupQuery().queryUserByEMail(eMail) == null){
                pout.print("true");
            }else{
                pout.print("false");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
