package com.cloudnative.grokking.mars.controller;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.cloudnative.grokking.mars.api.PingRequest;
import com.cloudnative.grokking.mars.api.PingResponse;
import com.cloudnative.grokking.mars.api.SampleGrpcServiceGrpc;
import com.cloudnative.grokking.mars.test.grpc.GrpcServerTestBase;
import com.cloudnative.grokking.mars.GrpcTestApp;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author vietdv272
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {GrpcTestApp.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE, properties = {
        "grpc.enabled=false",
        "grpc.inProcessServerName='grpcTestServer'"
})
public class SampleGrpcControllerTest extends GrpcServerTestBase {

    @Test
    public void test() {
        // GIVEN
        SampleGrpcServiceGrpc.SampleGrpcServiceBlockingStub stub = SampleGrpcServiceGrpc.newBlockingStub(Optional.ofNullable(channel).orElse(inProcChannel));

        // WHEN
        PingResponse response = stub.ping(PingRequest.newBuilder().build());

        // THEN
        assertThat(response.getResponse(), Is.is("pong"));
    }

}