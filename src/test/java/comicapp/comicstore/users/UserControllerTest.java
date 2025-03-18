package comicapp.comicstore.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllUsers() throws Exception {
        // Simula una lista de usuarios
        List<User> users = List.of(
                new User("John", "Doe", "johndoe"),
                new User("Jane", "Smith", "janesmith"));

        // Simula el comportamiento del servicio (si usas un servicio)
        // when(userService.getAllUsers()).thenReturn(users);

        // Realiza la solicitud GET y verifica la respuesta
        mockMvc.perform(get("/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(users.size()));
    }

    @Test
    void testCreateUser() throws Exception {
        User user = new User("John", "Doe", "johndoe");

        // Simula el comportamiento del servicio (si usas un servicio)
        // when(userService.createUser(any(User.class))).thenReturn(user);

        // Realiza la solicitud POST y verifica la respuesta
        mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.surname").value("Doe"))
                .andExpect(jsonPath("$.username").value("johndoe"));
    }

    @Test
    void testGetUserById() throws Exception {
        User user = new User("John", "Doe", "johndoe");

        // Simula el comportamiento del servicio (si usas un servicio)
        // when(userService.getUserById(1L)).thenReturn(user);

        // Realiza la solicitud GET y verifica la respuesta
        mockMvc.perform(get("/users/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.surname").value("Doe"))
                .andExpect(jsonPath("$.username").value("johndoe"));
    }
}