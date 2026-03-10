package com.example.springaiuserquestions;

import java.util.Scanner;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;

@SpringBootApplication
public class SpringAiUserQuestionsApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringAiUserQuestionsApplication.class, args);
  }

  @Bean
  ApplicationRunner go(ChatClient chatClient) {
    return args -> {

      Scanner scanner = new Scanner(System.in);

      System.out.println("How can I help?");

      while(true) {
        System.out.print("  >  ");
        String userInput = scanner.nextLine();

        if (!StringUtils.hasText(userInput.trim())) {
          scanner.close();
          System.exit(0);
        }

        var response = chatClient.prompt()
            .user(userInput)
            .call()
            .content();

        System.out.println(response);
        System.out.println();
      }
    };
  }

}
