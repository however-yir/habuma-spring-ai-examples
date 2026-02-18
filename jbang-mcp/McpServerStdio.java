///usr/bin/env jbang "$0" "$@" ; exit $?
//JAVA 25+
//SOURCES springbom@scratches
//RUNTIME_OPTIONS -Dlogging.level.root=ERROR
//RUNTIME_OPTIONS -Dspring.main.banner-mode=off
//DEPS org.springframework.ai:spring-ai-starter-mcp-server:2.0.0-M2,
package habuma;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;

@SpringBootApplication
public class McpServerStdio {
  @McpTool(name = "get-weather",
      description = "Gets the weather for a zipcode")
  public Weather getWeather(
      @McpToolParam(description = "The zipcode to get weather for") String zipcode) {
    return new Weather("Rainy", "79F");
  }

  void main(String... args) {
    SpringApplication.run(McpServerStdio.class, args);
  }
}
record Weather(String conditions, String temperature) {}