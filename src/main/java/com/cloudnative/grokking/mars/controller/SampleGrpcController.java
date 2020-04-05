package com.cloudnative.grokking.mars.controller;

import com.cloudnative.grokking.mars.grpc.service.MercuryGrpcService;
import com.cloudnative.grokking.mars.service.SampleKafkaProducer;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import com.cloudnative.grokking.mars.api.PingRequest;
import com.cloudnative.grokking.mars.api.PingResponse;
import com.cloudnative.grokking.mars.api.SampleGrpcServiceGrpc;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author vietdv272
 */
@GRpcService
public class SampleGrpcController extends SampleGrpcServiceGrpc.SampleGrpcServiceImplBase {

    @Autowired
    MercuryGrpcService mercuryGrpcService;

    @Autowired
    SampleKafkaProducer kafkaProducer;

    @Override
    public void ping(PingRequest request, StreamObserver<PingResponse> responseObserver) {
        mercuryGrpcService.ping();
        kafkaProducer.sendMessage(System.currentTimeMillis() + "");

        responseObserver.onNext(PingResponse.newBuilder()
                .setResponse("pong")
                .build());
        responseObserver.onCompleted();
    }
}
