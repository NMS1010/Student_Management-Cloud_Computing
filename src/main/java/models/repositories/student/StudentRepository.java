package models.repositories.student;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import models.services.AmazonS3.AmazonS3Service;
import models.services.AmazonDynamoDB.AmazonDynamoDBService;
import models.view_models.student.StudentClassCreateRequest;
import models.view_models.student.StudentClassUpdateRequest;
import models.view_models.student.StudentViewModel;

import java.util.ArrayList;

public class StudentRepository implements IStudentRepository{
    private static StudentRepository instance = null;
    public static StudentRepository getInstance(){
        if(instance == null)
            instance = new StudentRepository();
        return instance;
    }
    private final String tableName = "student";
    @Override
    public boolean insert(StudentClassCreateRequest request) {
        Table table = AmazonDynamoDBService.getInstance().getDynamoDB().getTable(tableName);
        try {
            Item item = new Item().withPrimaryKey("studentId", request.getStudentId())
                    .withString("studentClassId",request.getStudentClassId())
                    .withString("studentName", request.getStudentName())
                    .withString("dob", request.getDob())
                    .withString("address", request.getAddress())
                    .withString("gender",request.getGender())
                    .withString("phone",request.getPhone())
                    .withString("image", AmazonS3Service.getInstance().uploadFile(request.getFile().getSubmittedFileName(), request.getFile().getInputStream()))
                    .withString("deleted","0");
            table.putItem(item);
        }catch (){
            return false;
        }
        return true;
    }

    @Override
    public boolean update(StudentClassUpdateRequest request) {
        return false;
    }

    @Override
    public boolean delete(String hashKey, String rangeKey) {
        return false;
    }

    @Override
    public StudentViewModel retrieveById(String hashKey, String rangeKey) {
        return null;
    }

    @Override
    public ArrayList<StudentViewModel> retrieveAll() {
        return null;
    }

    @Override
    public boolean containStudentClass(String studentClassId) {
        return false;
    }
}
