package controllers.user;

import models.services.user.UserService;
import models.view_models.user.UserViewModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "CheckAdd", value = "/admin/users/check-add")
public class CheckAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserViewModel user = UserService.getInstance().retrieveById(request.getParameter("username"),"");
        PrintWriter out = response.getWriter();
        ArrayList<String> exists = new ArrayList<>();
        if(user != null){
            exists.add("user");
        }
        out.println(exists);
    }
}
