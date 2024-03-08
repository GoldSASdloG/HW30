package org.example.deserialization;

import com.google.gson.*;
import org.example.Case;
import org.example.Employee;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDeserializer implements JsonDeserializer<Employee> {
    @Override
    public Employee deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        Employee employee = new Employee();
        JsonObject emplObj = jsonElement.getAsJsonObject();
        employee.setEmployeeName(emplObj.get("name").getAsString());
        employee.setPosition(emplObj.get("position").getAsString());
        List<Case> cases = new ArrayList<>();
        JsonArray caseArray = emplObj.get("cases").getAsJsonArray();

        return employee;
    }
}
