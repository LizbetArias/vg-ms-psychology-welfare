package pe.edu.vallegrande.vg_ms_psychology_welfare.application.service.impl;

import org.springframework.stereotype.Service;
import pe.edu.vallegrande.vg_ms_psychology_welfare.application.service.UserService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    
    // Datos simulados guardados en memoria
    private final Map<UUID, String> estudiantes = Map.of(
        UUID.fromString("550e8400-e29b-41d4-a716-446655440001"), "Juan Carlos Pérez López",
        UUID.fromString("550e8400-e29b-41d4-a716-446655440011"), "María Elena Rodríguez Silva", 
        UUID.fromString("550e8400-e29b-41d4-a716-446655440021"), "Carlos Alberto Mendoza Torres",
        UUID.fromString("550e8400-e29b-41d4-a716-446655440031"), "Ana Sofía Vargas Morales",
        UUID.fromString("550e8400-e29b-41d4-a716-446655440041"), "Diego Fernando Castro Ruiz",
        UUID.fromString("550e8400-e29b-41d4-a716-446655440051"), "Lucía Fernanda Quispe Mamani",
        UUID.fromString("550e8400-e29b-41d4-a716-446655440061"), "Sebastián Andrés Huamán Vega",
        UUID.fromString("550e8400-e29b-41d4-a716-446655440071"), "Valentina Isabel Cruz Paredes"
    );
    
    private final Map<UUID, String> aulas = Map.of(
        UUID.fromString("550e8400-e29b-41d4-a716-446655440002"), "Aula 1A - Inicial 3 años",
        UUID.fromString("550e8400-e29b-41d4-a716-446655440012"), "Aula 2B - Inicial 4 años",
        UUID.fromString("550e8400-e29b-41d4-a716-446655440022"), "Aula 3C - Inicial 5 años",
        UUID.fromString("550e8400-e29b-41d4-a716-446655440032"), "Aula 1° Primaria",
        UUID.fromString("550e8400-e29b-41d4-a716-446655440042"), "Aula 2° Primaria"
    );
    
    private final Map<UUID, String> instituciones = Map.of(
        UUID.fromString("550e8400-e29b-41d4-a716-446655440003"), "I.E. San Martín de Porres",
        UUID.fromString("550e8400-e29b-41d4-a716-446655440013"), "I.E. María Auxiliadora", 
        UUID.fromString("550e8400-e29b-41d4-a716-446655440023"), "I.E. José Carlos Mariátegui",
        UUID.fromString("550e8400-e29b-41d4-a716-446655440033"), "I.E. Cesar Vallejo"
    );
    
    private final Map<UUID, String> evaluadores = Map.of(
        UUID.fromString("550e8400-e29b-41d4-a716-446655440004"), "Dra. Patricia Gonzales - Psicóloga",
        UUID.fromString("550e8400-e29b-41d4-a716-446655440014"), "Lic. Roberto Martinez - Psicólogo",
        UUID.fromString("550e8400-e29b-41d4-a716-446655440024"), "Dra. Carmen Flores - Psicóloga Educativa",
        UUID.fromString("550e8400-e29b-41d4-a716-446655440034"), "Lic. Miguel Herrera - Psicólogo Clínico"
    );
    
    @Override
    public Mono<String> getStudentName(UUID studentId) {
        String nombre = estudiantes.get(studentId);
        return nombre != null ? Mono.just(nombre) : Mono.just("Student not found");
    }
    
    @Override
    public Mono<String> getClassroomName(UUID classroomId) {
        String aula = aulas.get(classroomId);
        return aula != null ? Mono.just(aula) : Mono.just("Classroom not found");
    }
    
    @Override
    public Mono<String> getInstitutionName(UUID institutionId) {
        String institucion = instituciones.get(institutionId);
        return institucion != null ? Mono.just(institucion) : Mono.just("Institution not found");
    }
    
    @Override
    public Mono<String> getEvaluatorName(UUID evaluatorId) {
        String evaluador = evaluadores.get(evaluatorId);
        return evaluador != null ? Mono.just(evaluador) : Mono.just("Evaluator not found");
    }
    
    @Override
    public Flux<Map.Entry<UUID, String>> getAllStudents() {
        return Flux.fromIterable(estudiantes.entrySet());
    }
    
    @Override
    public Flux<Map.Entry<UUID, String>> getAllClassrooms() {
        return Flux.fromIterable(aulas.entrySet());
    }
    
    @Override
    public Flux<Map.Entry<UUID, String>> getAllInstitutions() {
        return Flux.fromIterable(instituciones.entrySet());
    }
    
    @Override
    public Flux<Map.Entry<UUID, String>> getAllEvaluators() {
        return Flux.fromIterable(evaluadores.entrySet());
    }
}