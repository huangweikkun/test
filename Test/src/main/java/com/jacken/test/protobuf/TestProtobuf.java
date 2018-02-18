package com.jacken.test.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author jacken
 * @date 2017/12/24
 */
public class TestProtobuf {

    private static byte[] encode(Test.helloworld req) {
        return req.toByteArray();
    }

    private static Test.helloworld decode(byte[] body) throws InvalidProtocolBufferException {
        return Test.helloworld.parseFrom(body);
    }

    public static Test.helloworld createHelloWorld() {
        Test.helloworld.Builder builder = Test.helloworld.newBuilder();
        builder.setId(1);
        builder.setStr("hello world");
        builder.setOpt(2);

        return builder.build();
    }

    public static void main(String[] args) {
        Test.helloworld helloworld = createHelloWorld();
        System.out.println("before encode:" + helloworld.toString());
        try {
            Test.helloworld helloworld1 = decode(encode(helloworld));
            System.out.println("after encode:" + helloworld1.toString());
            System.out.println("Assert Equal:" + helloworld.equals(helloworld1));
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }


    }
}
