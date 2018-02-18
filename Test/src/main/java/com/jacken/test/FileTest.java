package com.jacken.test;

import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jacken
 * @date 2017/11/24
 */
public class FileTest {

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        MessagePack messagePack = new MessagePack();
        byte[] bytes = messagePack.write(list);
        List<String> readList = messagePack.read(bytes, Templates.tList(Templates.TString));
        System.out.println(readList.get(0));
        System.out.println(readList.get(1));
    }
}
