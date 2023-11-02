package com.example.lab7;
import com.example.lab7.model.Student;
import com.example.lab7.repositories.IStudentRepository;
import com.example.lab7.repositories.IStudentRepositoryPagination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class MainApplication {

    private static Logger LOG = LoggerFactory.getLogger(MainApplication.class);

    @Autowired
    IStudentRepository iStudentRepository;

    @Autowired
    IStudentRepositoryPagination iStudentRepositoryPagination;

    public static void main(String[] args)
    {
//        LOG.info("STARTING THE APPLICATION");
        SpringApplication.run(MainApplication.class, args);
//        LOG.info("APPLICATION FINISHED");
    }


//    @Bean
//    public static void print() {
//        System.out.println("Xin chào Huy");
//    }

    @Bean
    public ReadStudentAge applicationStartupRunner() {
        return new ReadStudentAge();
    }

    @Bean
    public UpdateStudent update() {
        return new UpdateStudent();
    }

    @Component
    @Order(value = 1)
    class CreateStudent implements CommandLineRunner {
        @Override
        public void run(String... args) throws Exception {
            iStudentRepository.save(Student.builder().name("xin chao").age(10).email(
                    "xinchao123@gmail.com").ieltsScore(8.5).build());
            iStudentRepository.save(Student.builder().name("xin chao").age(15).email(
                    "xinchao123@gmail.com").ieltsScore(7.5).build());
            iStudentRepository.save(Student.builder().name("hello").age(11).email(
                    "xinchao123@gmail.com").ieltsScore(6.5).build());
            LOG.info("After create students");
        }
    }

    @Component
    @Order(value = 2)
    class ReadStudent implements CommandLineRunner {
        @Override
        public void run(String... args) throws Exception {
            for (Student s : iStudentRepository.findAll()) {
                LOG.info(s.toString());
                System.out.println(s.toString());
            }
        }
    }

    @Component
    @Order(value = 3)
    class UpdateStudent implements CommandLineRunner {
        @Autowired
        private ReadStudent readStudent;
        @Override
        public void run(String... args) throws Exception {
            Student s = iStudentRepository.findById(Long.parseLong("2")).get();
            if (s != null) {
                s.setName("Lee Min Ho");
                iStudentRepository.save(s);
                LOG.info("After update");
                readStudent.run(args);
            }
        }
    }

    @Component
    @Order(value = 4)
    class DeleteStudent implements CommandLineRunner {
        @Autowired
        private ReadStudent readStudent;

        @Override
        public void run(String... args) throws Exception {
            Student s = iStudentRepository.findById(Long.parseLong("3")).get();
            if (s != null) {
                iStudentRepository.delete(s);
                LOG.info("After delete");
                readStudent.run(args);
            }
        }
    }

    @Component
    @Order(value = 5)
    class ReadStudentAge implements CommandLineRunner {
        @Override
        public void run(String... args) throws Exception {
            Pageable pageable = PageRequest.of(2, 3);
            for (Student student : iStudentRepositoryPagination.findAllByOrderByAgeDescIeltsScoreAsc())
            {
                LOG.info(student.toString());
//                System.out.println(student.toString());
            }
        }
    }



}
