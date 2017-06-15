import { Greeter } from './../_proto/hello_pb_service';
import { HelloRequest, HelloReply } from './../_proto/hello_pb';
import { grpc, BrowserHeaders } from "grpc-web-client";


function main () {
  let helloReq = new HelloRequest();
  helloReq.setName('tanaka');
  grpc.invoke(Greeter.SayHello, {
    request: helloReq,
    host: 'http://localhost:8080',
    onEnd: (code, message, trailers) => {},
    onMessage: (message: HelloReply) =>{
      let mes = message.getMessage();
      document.write(mes);
    }
  })
}

main();
