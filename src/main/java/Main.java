import com.linecorp.armeria.common.logging.LogLevel;
import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.logging.LoggingService;
import com.linecorp.armeria.server.thrift.THttpService;

public class Main {

    public static void main(String[] args) {

        Server server = Server.builder()
                .http(4567)
                .service(
                        "/",
                        THttpService.of(new ThriftTestService()))
                .decoratorUnder(
                        "/",
                        LoggingService.builder()
                                .requestLogLevel(LogLevel.INFO)
                                .successfulResponseLogLevel(LogLevel.INFO)
                                .failureResponseLogLevel(LogLevel.ERROR)
                                .newDecorator())
                .build();

        server.start().join();
    }
}
