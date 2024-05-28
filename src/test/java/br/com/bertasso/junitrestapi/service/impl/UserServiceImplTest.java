package br.com.bertasso.junitrestapi.service.impl;

import br.com.bertasso.junitrestapi.domain.User;
import br.com.bertasso.junitrestapi.domain.dto.UserDTO;
import br.com.bertasso.junitrestapi.repository.UserRepository;
import br.com.bertasso.junitrestapi.service.exception.DataIntegratyViolationException;
import br.com.bertasso.junitrestapi.service.exception.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    public static final Integer ID = 1;
    public static final String NAME = "Pedro";
    public static final String MAIL = "pedro@pedro.com";
    public static final String PASSWORD = "123";
    @InjectMocks private UserServiceImpl service;
    @Mock private UserRepository repository;
    @Mock private ModelMapper mapper;

    private User user;
    private UserDTO userDTO;
    private Optional<User> optionalUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenFindByIdThenReturnUserInstance() {
        when(repository.findById(anyInt())).thenReturn(optionalUser);

        User response = service.findById(ID);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
    }

    @Test
    void whenFindByIDThenReturnObjectNotFoundException() {
        when(repository.findById(anyInt())).thenThrow(new ObjectNotFoundException("Objeto não encontrado."));

        try {
            service.findById(ID);
        } catch (Exception e) {
            assertEquals(ObjectNotFoundException.class, e.getClass());
            assertEquals("Objeto não encontrado.", e.getMessage());
        }
    }

    @Test
    void whenFindAllThenReturnListOfUserInstance() {
        when(repository.findAll()).thenReturn(List.of(user));

        List<User> response = service.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(User.class, response.get(0).getClass());

        assertEquals(ID, response.get(0).getId());
    }

    @Test
    void whenAddThenReturnSucess() {
        when(repository.save(any())).thenReturn(user);

        User response = service.addUser(userDTO);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
    }

    @Test
    void whenAddThenReturnDataIntegrityViolationException() {
        when(repository.findByEmail(anyString())).thenReturn(optionalUser);

        try {
            optionalUser.get().setId(2);
            service.addUser(userDTO);
        } catch (Exception ex) {
            assertEquals(DataIntegratyViolationException.class, ex.getClass());
        }
    }

    @Test
    void whenUpdateThenReturnSucess() {
        when(repository.save(any())).thenReturn(user);

        User response = service.updateUser(userDTO);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
    }
    @Test
    void deleteUser() {
    }

    private void startUser() {

        user = new User(ID, NAME, MAIL, PASSWORD);
        userDTO = new UserDTO(ID, NAME, MAIL, PASSWORD);
        optionalUser = Optional.of(new User(ID, NAME, MAIL, PASSWORD));

    }
}