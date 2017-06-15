name := "scalapb-example"

version := "1.0"

scalaVersion := "2.12.2"

PB.targets in Compile := Seq(
  scalapb.gen(
    grpc = true
  ) -> (sourceManaged in Compile).value
)
PB.pythonExe := "C:\\Python27\\Python.exe"


// (optional) If you need scalapb/scalapb.proto or anything from
// google/protobuf/*.proto
libraryDependencies += "com.trueaccord.scalapb" %% "scalapb-runtime" % com.trueaccord.scalapb.compiler.Version.scalapbVersion % "protobuf"

libraryDependencies ++= Seq(
  "io.grpc" % "grpc-netty" % com.trueaccord.scalapb.compiler.Version.grpcJavaVersion,
  "com.trueaccord.scalapb" %% "scalapb-runtime-grpc" % com.trueaccord.scalapb.compiler.Version.scalapbVersion
)

