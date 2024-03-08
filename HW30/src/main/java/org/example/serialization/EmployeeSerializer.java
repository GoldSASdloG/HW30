package org.example.serialization;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.example.Employee;

import java.lang.reflect.Type;

public class EmployeeSerializer implements JsonSerializer<Employee> {
    @Override
    public JsonElement serialize(Employee employee, Type type, JsonSerializationContext context) {
        JsonObject emplObject = new JsonObject();
        emplObject.addProperty("name", employee.getEmployeeName());
        emplObject.addProperty("position", employee.getPosition());
        emplObject.add("cases", context.serialize(employee.getCases()));
        return emplObject;
    }
}
