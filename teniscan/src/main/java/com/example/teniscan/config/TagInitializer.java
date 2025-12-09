package com.example.teniscan.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.teniscan.model.Tag;
import com.example.teniscan.repository.TagRepository;

@Configuration
public class TagInitializer {

    @Bean
    @SuppressWarnings("unused")
    CommandLineRunner initTags(TagRepository repository) {
        return args -> {
            if (repository.count() == 0) {

                Tag t1 = new Tag();
                t1.setNome("Basquete");
                t1.setTipo("uso");

                Tag t2 = new Tag();
                t2.setNome("Corrida");
                t2.setTipo("uso");

                Tag t3 = new Tag();
                t3.setNome("Caminhada");
                t3.setTipo("uso");
                
                Tag t4 = new Tag();
                t4.setNome("Chato");
                t4.setTipo("pe");
                
                Tag t5 = new Tag();
                t5.setNome("Normal");
                t5.setTipo("pe");
                
                Tag t6 = new Tag();
                t6.setNome("Curvo");
                t6.setTipo("pe");

                Tag t7 = new Tag();
                t7.setNome("Pronada");
                t7.setTipo("pisada");

                Tag t8 = new Tag();
                t8.setNome("Neutra");
                t8.setTipo("pisada");
                
                Tag t9 = new Tag();
                t9.setNome("Supinada");
                t9.setTipo("pisada");

                Tag t10 = new Tag();
                t10.setNome("Feminino");
                t10.setTipo("genero");
                
                Tag t11 = new Tag();
                t11.setNome("Masculino");
                t11.setTipo("genero");

                Tag t12 = new Tag();
                t12.setNome("Unissex");
                t12.setTipo("genero");

                repository.saveAll(List.of(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12));
            }
        };
    }
}
