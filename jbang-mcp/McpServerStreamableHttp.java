///usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 25+
//RUNTIME_OPTIONS -Dserver.port=3001 -Dspring.ai.mcp.server.protocol=streamable
//SOURCES springbom@scratches
//DEPS org.springframework.ai:spring-ai-starter-mcp-server-webmvc:2.0.0-M2,
//DEPS org.springframework.boot:spring-boot-starter-webmvc:4.0.2
package habuma;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;

@SpringBootApplication
public class McpServerStreamableHttp {
  @McpTool(name = "get-weather",
      description = "Gets the weather for a zipcode")
  public Weather getWeather(
      @McpToolParam(description = "The zipcode to get weather for") String zipcode) {
    return new Weather("Rainy", "79F");
  }

  void main(String... args) {
    SpringApplication.run(McpServerStreamableHttp.class, args);
  }
}
record Weather(String conditions, String temperature) {}