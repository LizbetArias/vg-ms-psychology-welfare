package pe.edu.vallegrande.vg_ms_psychology_welfare.infrastructure.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.vg_ms_psychology_welfare.application.service.UserService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/reference-data")
@RequiredArgsConstructor
@Tag(name = "Datos de Referencia", description = "API para obtener datos de estudiantes, aulas, etc.")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReferenceDataRest {

    private final UserService userService;

    @Operation(summary = "Obtener nombre de estudiante")
    @GetMapping("/student/{studentId}")
    public Mono<String> getStudentName(@PathVariable UUID studentId) {
        return userService.getStudentName(studentId);
    }

    @Operation(summary = "Obtener nombre de aula")
    @GetMapping("/classroom/{classroomId}")
    public Mono<String> getClassroomName(@PathVariable UUID classroomId) {
        return userService.getClassroomName(classroomId);
    }

    @Operation(summary = "Obtener nombre de institución")
    @GetMapping("/institution/{institutionId}")
    public Mono<String> getInstitutionName(@PathVariable UUID institutionId) {
        return userService.getInstitutionName(institutionId);
    }

    @Operation(summary = "Obtener nombre de evaluador")
    @GetMapping("/evaluator/{evaluatorId}")
    public Mono<String> getEvaluatorName(@PathVariable UUID evaluatorId) {
        return userService.getEvaluatorName(evaluatorId);
    }

    @Operation(summary = "Listar todos los estudiantes")
    @GetMapping("/students")
    public Flux<Map<String, Object>> getAllStudents() {
        return userService.getAllStudents()
                .map(entry -> Map.of(
                        "id", entry.getKey().toString(),
                        "name", entry.getValue()));
    }

    @Operation(summary = "Listar todas las aulas")
    @GetMapping("/classrooms")
    public Flux<Map<String, Object>> getAllClassrooms() {
        return userService.getAllClassrooms()
                .map(entry -> Map.of(
                        "id", entry.getKey().toString(),
                        "name", entry.getValue()));
    }

    @Operation(summary = "Listar todas las instituciones")
    @GetMapping("/institutions")
    public Flux<Map<String, Object>> getAllInstitutions() {
        return userService.getAllInstitutions()
                .map(entry -> Map.of(
                        "id", entry.getKey().toString(),
                        "name", entry.getValue()));
    }

    @Operation(summary = "Listar todos los evaluadores")
    @GetMapping("/evaluators")
    public Flux<Map<String, Object>> getAllEvaluators() {
        return userService.getAllEvaluators()
                .map(entry -> Map.of(
                        "id", entry.getKey().toString(),
                        "name", entry.getValue()));
    }
}