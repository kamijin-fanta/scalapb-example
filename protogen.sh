#!/bin/bash

mkdir -p ./web/_proto

protoc \
  --plugin=protoc-gen-ts=./node_modules/.bin/protoc-gen-ts \
  -I ./src/main/protobuf \
  --js_out=import_style=commonjs,binary:./web/_proto \
  --ts_out=service=true:./web/_proto \
  ./src/main/protobuf/hello.proto
