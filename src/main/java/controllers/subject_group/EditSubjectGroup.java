package controllers.subject_group;

import models.services.subject_group.SubjectGroupService;
import models.view_models.subject_group.SubjectGroupUpdateRequest;
import models.view_models.subject_group.SubjectGroupViewModel;
import utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditSubjectGroup", value = "/admin/subjectGroup/edit")
public class EditSubjectGroup extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String subjectGroupId = request.getParameter("subjectGroupId");

        SubjectGroupViewModel subjectGroup = SubjectGroupService.getInstance().retrieveById(subjectGroupId,"");

        request.setAttribute("subjectGroup", subjectGroup);

        ServletUtils.forward(request,response,"/admin/subjectGroups");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        SubjectGroupUpdateRequest updateReq = new SubjectGroupUpdateRequest();

        String subjectGroupId = request.getParameter("subjectGroupId");
        String subjectGroupName = request.getParameter("subjectGroupName");
        String lectureId = request.getParameter("lectureId");
        String subjectId = request.getParameter("subjectId");
        updateReq.setSubjectGroupId(subjectGroupId);
        updateReq.setSubjectGroupName(subjectGroupName);
        updateReq.setSubjectId(subjectId);
        updateReq.setLectureId(lectureId);

        boolean isSuccess = SubjectGroupService.getInstance().update(updateReq);
        String error = "";
        if(!isSuccess){
            error = "?error=true";
        }
        ServletUtils.redirect(response, request.getContextPath() + "/admin/subjectGroups" + error);
    }
}
