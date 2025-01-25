package lk.ijse.cmjd108.LibMgmt2025;

import lk.ijse.cmjd108.LibMgmt2025.test.HelloBean;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibMgmt2025Application {
	@Bean
    public HelloBean testTask(){
		return new HelloBean();
	}
	@Bean
	public ModelMapper modelMapper(){
      return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(LibMgmt2025Application.class, args);

	}

}
