import io.grpc.{Server, ServerBuilder}
import kinyo.hello.{HelloReply, HelloRequest, GreeterGrpc}

import scala.concurrent.{ExecutionContext, Future}
import scala.io.StdIn

object Main {
  def main(args: Array[String]): Unit = {
    val server: Server = ServerBuilder
      .forPort(1234)
      .addService(GreeterGrpc.bindService(new GreeterImpl, ExecutionContext.global))
      .build().start()
    sys.addShutdownHook {
      if (server !=null & !server.isShutdown) server.awaitTermination()
    }

    StdIn.readLine()
    server.awaitTermination()
  }
}

class GreeterImpl extends GreeterGrpc.Greeter {
  override def sayHello(request: HelloRequest): Future[HelloReply] = {
    val res = HelloReply(message = s"Hello! ${request.name} ${System.currentTimeMillis()}")
    Future.successful(res)
  }
}
