package edu.utfpr.cursos.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API de Cursos UTFPR",
                version = "1.0",
                description = """
                        #
                        API para gerenciamento de:
                        
                        - Alunos
                        - Cursos
                        - Matrículas
                        
                        Instruções:
                        
                        1. Cadastre alunos primeiro
                        2. Cadastre cursos
                        3. Crie matrículas vinculando aluno e curso
                        
                        A API suporta:
                        
                        - Paginação
                        - Ordenação
                        - Validações automáticas
                        
                        #
                        #
                        #
                        URL Base:
                        http://localhost:8080
                        
                        Documentação:
                        http://localhost:8080/docs
                        """,
                contact = @Contact(
                        name = "Matheus Felipe",
                        email = "contato@seudominio.com"
                ),
                license = @License(
                        name = "MIT"
                )
        )
)
public class OpenApiConfig {
}

