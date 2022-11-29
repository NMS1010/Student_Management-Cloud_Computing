package controllers.role;

import models.services.role.RoleService;
import utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveRole", value = "/admin/role/remove")
public class RemoveRole extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roleId = request.getParameter("roleId");

        boolean isSuccess = RoleService.getInstance().delete(roleId, "");
        String error = "";
        if(!isSuccess){
            error = "?error=true";
        }
        ServletUtils.redirect(response, request.getContextPath() + "/admin/roles" +error);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
