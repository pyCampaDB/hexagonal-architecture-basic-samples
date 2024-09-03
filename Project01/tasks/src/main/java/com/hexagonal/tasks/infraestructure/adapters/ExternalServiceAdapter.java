package com.hexagonal.tasks.infraestructure.adapters;

import com.hexagonal.tasks.domain.models.AdditionalTaskInfo;
import com.hexagonal.tasks.domain.ports.out.ExternalServicePort;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
//@AllArgsConstructor
public class ExternalServiceAdapter implements ExternalServicePort {
    private final RestTemplate restTemplate;

    public ExternalServiceAdapter(){
        restTemplate = new RestTemplate();
    }
    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        String apiUrl = "https://jsonplaceholder.typicode.com/todos/" + taskId;
        ResponseEntity<JsonPlaceHolderTodo> response = restTemplate.getForEntity(
                apiUrl,
                JsonPlaceHolderTodo.class);
        JsonPlaceHolderTodo todo = response.getBody();
        if (todo == null){
            return null;
        }
        apiUrl = "https://jsonplaceholder.typicode.com/users/" + todo.getUserId();
        ResponseEntity<JsonPlaceHolderUser> userResponse = restTemplate.getForEntity(
                apiUrl,
                JsonPlaceHolderUser.class
        );

        JsonPlaceHolderUser user = userResponse.getBody();
        if (user == null)
            return null;
        return new AdditionalTaskInfo(user.getId(), user.getName(), user.getEmail());
    }

    @Getter
    @Setter
    private static class JsonPlaceHolderTodo{
        private Long id;
        private Long userId;
    }
    @Getter
    @Setter
    private static class JsonPlaceHolderUser{
        private Long id;
        private String name, email;
    }
}
