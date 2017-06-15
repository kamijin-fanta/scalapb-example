// package: kinyo
// file: hello.proto

import * as hello_pb from "./hello_pb";
export class Greeter {
  static serviceName = "kinyo.Greeter";
}
export namespace Greeter {
  export class SayHello {
    static methodName = "SayHello";
    static service = Greeter;
    static requestStream = false;
    static responseStream = false;
    static requestType = hello_pb.HelloRequest;
    static responseType = hello_pb.HelloReply;
  }
}
