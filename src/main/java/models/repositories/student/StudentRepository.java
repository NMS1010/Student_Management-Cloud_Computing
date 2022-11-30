package models.repositories.student;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.UpdateItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import models.services.AmazonDynamoDB.AmazonDynamoDBService;
import models.view_models.student.StudentCreateRequest;
import models.view_models.student.StudentUpdateRequest;
import models.view_models.student.StudentViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class StudentRepository implements IStudentRepository{
    private static StudentRepository instance = null;
    public static StudentRepository getInstance(){
        if(instance == null)
            instance = new StudentRepository();
        return instance;
    }
    private final String tableName = "student";
    @Override
    public boolean insert(StudentCreateRequest request) {
        Table table = AmazonDynamoDBService.getInstance().getDynamoDB().getTable(tableName);
        try {
            Item item = new Item().withPrimaryKey("studentId", request.getStudentId())
                    .withString("studentClassId", request.getStudentClassId())
                    .withString("studentName", request.getStudentName())
                    .withString("dob", request.getDob())
                    .withString("address", request.getAddress())
                    .withString("gender", request.getGender())
                    .withString("phone", request.getPhone())
                    .withString("image", "") //chưa có AmazonS3Service
                    .withString("deleted","0");
            table.putItem(item);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(StudentUpdateRequest request) {
        Table table = AmazonDynamoDBService.getInstance().getDynamoDB().getTable(tableName);
        try {
            Map<String, String> expressionAttributeNames = new HashMap<String, String>();
            expressionAttributeNames.put("#P1", "studentClassId");
            expressionAttributeNames.put("#P2", "studentName");
            expressionAttributeNames.put("#P3", "dob");
            expressionAttributeNames.put("#P4", "address");
            expressionAttributeNames.put("#P5", "gender");
            expressionAttributeNames.put("#P6", "phone");
            if (!Objects.equals(request.getFile().getSubmittedFileName(), ""))
                expressionAttributeNames.put("#P7", "image");

            Map<String, Object> expressionAttributeValues = new HashMap<String, Object>();
            expressionAttributeValues.put(":val1", request.getStudentClassId());
            expressionAttributeValues.put(":val2", request.getStudentName());
            expressionAttributeValues.put(":val3", request.getDob());
            expressionAttributeValues.put(":val4", request.getAddress());
            expressionAttributeValues.put(":val5", request.getGender());
            expressionAttributeValues.put(":val6", request.getPhone());
            if(!Objects.equals(request.getFile().getSubmittedFileName(), ""))
                expressionAttributeValues.put(":val7", AmazonS3Service.getInstance().uploadFile(request.getFile().getSubmittedFileName(), request.getFile().getInputStream()));
            String query = "set #P1 = :val1, #P2 = :val2, #P3 = :val3, #P4 = :val4, #P5 = :val5, #P6 = :val6";

            if(!Objects.equals(request.getFile().getSubmittedFileName(), ""))
                query += ", #P7 = :val7";
            UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("studentId", request.getStudentId())
                    .withUpdateExpression(query)
                    .withNameMap(expressionAttributeNames)
                    .withValueMap(expressionAttributeValues);

            UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
        } catch (Exception e){
            return false;
        }
        return true;
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
