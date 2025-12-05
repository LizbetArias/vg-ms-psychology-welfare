package pe.edu.vallegrande.vg_ms_psychology_welfare.application.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.edu.vallegrande.vg_ms_psychology_welfare.application.service.impl.UserServiceImpl;
import reactor.test.StepVerifier;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    private UUID studentId;
    private UUID classroomId;
    private UUID institutionId;
    private UUID evaluatorId;

    @BeforeEach
    void setUp() {
        studentId = UUID.fromString("550e8400-e29b-41d4-a716-446655440001");
        classroomId = UUID.fromString("550e8400-e29b-41d4-a716-446655440002");
        institutionId = UUID.fromString("550e8400-e29b-41d4-a716-446655440003");
        evaluatorId = UUID.fromString("550e8400-e29b-41d4-a716-446655440004");
    }

    @Test
    void getStudentName_ShouldReturnCorrectName() {
        StepVerifier.create(userService.getStudentName(studentId))
                .expectNext("Juan Carlos Pérez López")
                .verifyComplete();
    }

    @Test
    void getClassroomName_ShouldReturnCorrectClassroom() {
        StepVerifier.create(userService.getClassroomName(classroomId))
                .expectNext("Aula 1A - Inicial 3 años")
                .verifyComplete();
    }

    @Test
    void getInstitutionName_ShouldReturnCorrectInstitution() {
        StepVerifier.create(userService.getInstitutionName(institutionId))
                .expectNext("I.E. San Martín de Porres")
                .verifyComplete();
    }

    @Test
    void getEvaluatorName_ShouldReturnCorrectEvaluator() {
        StepVerifier.create(userService.getEvaluatorName(evaluatorId))
                .expectNext("Dra. Patricia Gonzales - Psicóloga")
                .verifyComplete();
    }

    @Test
    void getStudentName_WithNonExistentId_ShouldReturnErrorMessage() {
        UUID nonExistentId = UUID.randomUUID();

        StepVerifier.create(userService.getStudentName(nonExistentId))
                .expectNext("Student not found")
                .verifyComplete();
    }

    @Test
    void getAllStudents_ShouldReturnEightStudents() {
        StepVerifier.create(userService.getAllStudents())
                .expectNextCount(8)
                .verifyComplete();
    }

    @Test
    void getAllClassrooms_ShouldReturnFiveClassrooms() {
        StepVerifier.create(userService.getAllClassrooms())
                .expectNextCount(5)
                .verifyComplete();
    }
}