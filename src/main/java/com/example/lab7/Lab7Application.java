package com.example.lab7;

import com.example.lab7.repositories.IStudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Lab7Application {
    public static void main(String[] args)
    {
        SpringApplication.run(Lab7Application.class, args);
//        System.out.println("ok");
//        ApplicationContext context = SpringApplication.run(Lab7Application.class, args);
//        IStudentRepository iStudentRepository = context.getBean(IStudentRepository.class);
//        System.out.println(iStudentRepository.countStudentsByIeltsScoreEquals(6.5));
//        iStudentRepository.readAll().forEach(System.out::println);
//        MainApplication.UpdateStudent update = new MainApplication().update();
//        System.out.println(update);

    }

}
