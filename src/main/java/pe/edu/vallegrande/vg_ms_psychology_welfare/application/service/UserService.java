package pe.edu.vallegrande.vg_ms_psychology_welfare.application.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.UUID;

public interface UserService {
    
    // Get individual names by ID
    Mono<String> getStudentName(UUID studentId);
    
    Mono<String> getClassroomName(UUID classroomId);
    
    Mono<String> getInstitutionName(UUID institutionId);
    
    Mono<String> getEvaluatorName(UUID evaluatorId);
    
    // Get all reference data as key-value pairs
    Flux<Map.Entry<UUID, String>> getAllStudents();
    
    Flux<Map.Entry<UUID, String>> getAllClassrooms();
    
    Flux<Map.Entry<UUID, String>> getAllInstitutions();
    
    Flux<Map.Entry<UUID, String>> getAllEvaluators();
}