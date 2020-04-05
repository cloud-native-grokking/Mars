package com.cloudnative.grokking.mars.grpc.service;

import com.cloudnative.grokking.mars.config.YAMLConfig;
import com.cloudnative.grokking.mercury.proto.api.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MercuryGrpcService {

    @Autowired
    YAMLConfig yamlConfig;

    public void ping() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(yamlConfig.getMercury().getUrl(), yamlConfig.getMercury().getPort())
                .usePlaintext()
                .build();

        PingGRpcServiceGrpc.PingGRpcServiceBlockingStub stub
                = PingGRpcServiceGrpc.newBlockingStub(channel);

        PingResponse response = stub.ping(PingRequest.newBuilder().build().newBuilder()
                .setRequest("gRPCsd")
                .build());

        channel.shutdown();
    }

}
