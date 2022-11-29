package controllers.role;

import models.services.role.RoleService;
import models.view_models.role.RoleViewModel;
import utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GetRoles", value = "/admin/roles")
public class GetRoles extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<RoleViewModel> roles = RoleService.getInstance().retrieveAll();

        String error = request.getParameter("error");
        if(error != null && !error.equals("") || (roles == null)){
            request.setAttribute("error",error);
            roles = new ArrayList<>();
        }
        request.setAttribute("roles",roles);

        ServletUtils.forward(request,response,"/views/admin/role/role.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
