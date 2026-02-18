///usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 25+
//RUNTIME_OPTIONS -Dspring.main.web-application-type=none
//RUNTIME_OPTIONS -Dlogging.level.root=ERROR
//RUNTIME_OPTIONS -Dspring.ai.mcp.client.streamable-http.connections.weather.url=http://localhost:3001/mcp
//RUNTIME_OPTIONS -Dspring.ai.ollama.chat.model=gpt-oss
//SOURCES springbom@scratches
//DEPS org.springframework.ai:spring-ai-starter-model-ollama:2.0.0-M2
//DEPS org.springframework.boot:spring-boot-starter-webmvc:4.0.2
//DEPS org.springframework.ai:spring-ai-starter-mcp-client:2.0.0-M2
package habuma;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;

@SpringBootApplication
public class McpClientStreamableHttp {
  @Bean
  ApplicationRunner go(ChatClient.Builder builder, ToolCallbackProvider tools) {
    return args -> {
      var answer = builder.build().prompt()
          .user("What is the weater in Denver?")
          .toolCallbacks(tools).call().content();
      System.out.println("ANSWER: " + answer);
    };
  }

  void main(String... args) {
    SpringApplication.run(McpClientStreamableHttp.class, args);
  }
}
